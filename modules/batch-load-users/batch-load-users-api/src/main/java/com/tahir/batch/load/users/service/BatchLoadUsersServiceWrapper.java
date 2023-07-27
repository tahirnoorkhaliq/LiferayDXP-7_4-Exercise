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

package com.tahir.batch.load.users.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BatchLoadUsersService}.
 *
 * @author Brian Wing Shun Chan
 * @see BatchLoadUsersService
 * @generated
 */
public class BatchLoadUsersServiceWrapper
	implements BatchLoadUsersService, ServiceWrapper<BatchLoadUsersService> {

	public BatchLoadUsersServiceWrapper() {
		this(null);
	}

	public BatchLoadUsersServiceWrapper(
		BatchLoadUsersService batchLoadUsersService) {

		_batchLoadUsersService = batchLoadUsersService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _batchLoadUsersService.getOSGiServiceIdentifier();
	}

	@Override
	public String getStatus() {
		return _batchLoadUsersService.getStatus();
	}

	@Override
	public String loadUsers() {
		return _batchLoadUsersService.loadUsers();
	}

	@Override
	public BatchLoadUsersService getWrappedService() {
		return _batchLoadUsersService;
	}

	@Override
	public void setWrappedService(BatchLoadUsersService batchLoadUsersService) {
		_batchLoadUsersService = batchLoadUsersService;
	}

	private BatchLoadUsersService _batchLoadUsersService;

}