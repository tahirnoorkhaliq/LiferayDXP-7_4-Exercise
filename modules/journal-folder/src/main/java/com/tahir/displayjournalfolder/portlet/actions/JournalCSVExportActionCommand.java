/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tahir.displayjournalfolder.portlet.actions;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleDisplay;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalFolderLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.tahir.displayjournalfolder.constants.DisplayJournalFolderPortletKeys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Properties;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + DisplayJournalFolderPortletKeys.DISPLAYJOURNALFOLDER,
		"mvc.command.name=/journal/export/csv" }, service = MVCResourceCommand.class)
public class JournalCSVExportActionCommand extends BaseMVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(JournalCSVExportActionCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		String[] ids = ParamUtil.getParameterValues(resourceRequest, "journalIds");
		System.out.println(Arrays.toString(ParamUtil.getParameterValues(resourceRequest, "journalIds")));
		ThemeDisplay _themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Properties properties = PortalUtil.getPortalProperties();
		String serverHome = properties.getProperty("liferay.home");
		System.out.println(serverHome);
		String filename = serverHome + "/data/exportcontenttree/JournalArticleTree.xls";
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("JournalArticleTree");
		HSSFRow rowhead = sheet.createRow((short) 0);
		rowhead.createCell(0).setCellValue("Article Name");
		rowhead.createCell(1).setCellValue("Article Path");
		rowhead.createCell(2).setCellValue("Article Content");

		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			JournalArticle ja = journalArticleLocalService.getDisplayArticle(_themeDisplay.getScopeGroupId(), id);
			HSSFRow row = sheet.createRow((short) i + 1);
			row.createCell(0).setCellValue(ja.getTitle());
			String[] tree = ja.getTreePath().split("/");
			StringBuilder sb=new StringBuilder();
			for (String folderId : tree) {
				if (folderId.length() > 0 ) {
					JournalFolder folder = journalFolderLocalService.getFolder(Integer.parseInt(folderId));
					sb.append(folder.getName());
					sb.append("/");
				}
			}
			row.createCell(1).setCellValue(sb.toString());
			JournalArticleDisplay jarticleDispaly = JournalArticleLocalServiceUtil
					.getArticleDisplay(_themeDisplay.getScopeGroupId(), id, "", "en_US", null);
			if (Validator.isNotNull(jarticleDispaly)) {
				row.createCell(2).setCellValue(jarticleDispaly.getContent());
			}
		}

		FileOutputStream fileOut = new FileOutputStream(filename);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
		System.out.println("Excel file has been generated successfully.");
		PrintWriter out = resourceResponse.getWriter();
		out.println("Excel file has been generated successfully");
		out.flush();

	}
	@Reference
	JournalFolderLocalService journalFolderLocalService;
	@Reference
	JournalArticleLocalService journalArticleLocalService;
}