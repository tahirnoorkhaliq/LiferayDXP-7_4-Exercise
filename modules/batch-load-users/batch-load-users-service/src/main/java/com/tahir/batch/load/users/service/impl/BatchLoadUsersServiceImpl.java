/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.tahir.batch.load.users.service.impl;

import com.liferay.headless.batch.engine.client.dto.v1_0.ImportTask;
import com.liferay.headless.batch.engine.client.resource.v1_0.ImportTaskResource;
import com.liferay.portal.aop.AopService;
import com.tahir.batch.load.users.service.base.BatchLoadUsersServiceBaseImpl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=batch",
		"json.web.service.context.path=BatchLoadUsers"
	},
	service = AopService.class
)
public class BatchLoadUsersServiceImpl extends BatchLoadUsersServiceBaseImpl {
	
	public String getStatus() {
		return "It is working!!!55";
	}
	
	public String loadUsers() {
		InputStream is = BatchLoadUsersServiceImpl.class.getClassLoader().getResourceAsStream("userloadtest.json");
		String usersJson = printInputStream(is);		
		
		System.out.println("Processing File" + usersJson + "\n");
		ImportTaskResource.Builder builder = ImportTaskResource.builder();
		ImportTaskResource importTaskResource = builder.authentication("test@liferay.com", "test").build();//// .endpoint(host,
																									//// port,
																											//// scheme).builder.build();//

		
		try {
			ImportTask response = importTaskResource.postImportTask(
					String.valueOf("com.liferay.headless.admin.user.dto.v1_0.UserAccount"), null, "INSERT", null, null,
					"IMPORT_STRATEGY_ON_ERROR_CONTINUE", null, usersJson);
			System.out.println(response);
			return response.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		 
		return "Error";
	}
	private static String printInputStream(InputStream is) {

		try {
			String text = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines()
					.collect(Collectors.joining("\n"));
			System.out.println(text.length());
			return text;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}