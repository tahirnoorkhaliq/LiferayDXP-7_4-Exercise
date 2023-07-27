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
 * Provides a wrapper for {@link BatchLoadUsersLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BatchLoadUsersLocalService
 * @generated
 */
public class BatchLoadUsersLocalServiceWrapper
	implements BatchLoadUsersLocalService,
			   ServiceWrapper<BatchLoadUsersLocalService> {

	public BatchLoadUsersLocalServiceWrapper() {
		this(null);
	}

	public BatchLoadUsersLocalServiceWrapper(
		BatchLoadUsersLocalService batchLoadUsersLocalService) {

		_batchLoadUsersLocalService = batchLoadUsersLocalService;
	}

	/**
	 * Adds the batch load users to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BatchLoadUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param batchLoadUsers the batch load users
	 * @return the batch load users that was added
	 */
	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers addBatchLoadUsers(
		com.tahir.batch.load.users.model.BatchLoadUsers batchLoadUsers) {

		return _batchLoadUsersLocalService.addBatchLoadUsers(batchLoadUsers);
	}

	/**
	 * Creates a new batch load users with the primary key. Does not add the batch load users to the database.
	 *
	 * @param batchLoadUsersId the primary key for the new batch load users
	 * @return the new batch load users
	 */
	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers createBatchLoadUsers(
		long batchLoadUsersId) {

		return _batchLoadUsersLocalService.createBatchLoadUsers(
			batchLoadUsersId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchLoadUsersLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the batch load users from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BatchLoadUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param batchLoadUsers the batch load users
	 * @return the batch load users that was removed
	 */
	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers deleteBatchLoadUsers(
		com.tahir.batch.load.users.model.BatchLoadUsers batchLoadUsers) {

		return _batchLoadUsersLocalService.deleteBatchLoadUsers(batchLoadUsers);
	}

	/**
	 * Deletes the batch load users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BatchLoadUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users that was removed
	 * @throws PortalException if a batch load users with the primary key could not be found
	 */
	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers deleteBatchLoadUsers(
			long batchLoadUsersId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchLoadUsersLocalService.deleteBatchLoadUsers(
			batchLoadUsersId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchLoadUsersLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _batchLoadUsersLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _batchLoadUsersLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _batchLoadUsersLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _batchLoadUsersLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tahir.batch.load.users.model.impl.BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _batchLoadUsersLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tahir.batch.load.users.model.impl.BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _batchLoadUsersLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _batchLoadUsersLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _batchLoadUsersLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers fetchBatchLoadUsers(
		long batchLoadUsersId) {

		return _batchLoadUsersLocalService.fetchBatchLoadUsers(
			batchLoadUsersId);
	}

	/**
	 * Returns the batch load users matching the UUID and group.
	 *
	 * @param uuid the batch load users's UUID
	 * @param groupId the primary key of the group
	 * @return the matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers
		fetchBatchLoadUsersByUuidAndGroupId(String uuid, long groupId) {

		return _batchLoadUsersLocalService.fetchBatchLoadUsersByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _batchLoadUsersLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the batch load users with the primary key.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users
	 * @throws PortalException if a batch load users with the primary key could not be found
	 */
	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers getBatchLoadUsers(
			long batchLoadUsersId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchLoadUsersLocalService.getBatchLoadUsers(batchLoadUsersId);
	}

	/**
	 * Returns the batch load users matching the UUID and group.
	 *
	 * @param uuid the batch load users's UUID
	 * @param groupId the primary key of the group
	 * @return the matching batch load users
	 * @throws PortalException if a matching batch load users could not be found
	 */
	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers
			getBatchLoadUsersByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchLoadUsersLocalService.getBatchLoadUsersByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the batch load userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.tahir.batch.load.users.model.impl.BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @return the range of batch load userses
	 */
	@Override
	public java.util.List<com.tahir.batch.load.users.model.BatchLoadUsers>
		getBatchLoadUserses(int start, int end) {

		return _batchLoadUsersLocalService.getBatchLoadUserses(start, end);
	}

	/**
	 * Returns all the batch load userses matching the UUID and company.
	 *
	 * @param uuid the UUID of the batch load userses
	 * @param companyId the primary key of the company
	 * @return the matching batch load userses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tahir.batch.load.users.model.BatchLoadUsers>
		getBatchLoadUsersesByUuidAndCompanyId(String uuid, long companyId) {

		return _batchLoadUsersLocalService.
			getBatchLoadUsersesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of batch load userses matching the UUID and company.
	 *
	 * @param uuid the UUID of the batch load userses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching batch load userses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.tahir.batch.load.users.model.BatchLoadUsers>
		getBatchLoadUsersesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.tahir.batch.load.users.model.BatchLoadUsers>
					orderByComparator) {

		return _batchLoadUsersLocalService.
			getBatchLoadUsersesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of batch load userses.
	 *
	 * @return the number of batch load userses
	 */
	@Override
	public int getBatchLoadUsersesCount() {
		return _batchLoadUsersLocalService.getBatchLoadUsersesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _batchLoadUsersLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _batchLoadUsersLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _batchLoadUsersLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _batchLoadUsersLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public String loadUsers() {
		return _batchLoadUsersLocalService.loadUsers();
	}

	/**
	 * Updates the batch load users in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BatchLoadUsersLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param batchLoadUsers the batch load users
	 * @return the batch load users that was updated
	 */
	@Override
	public com.tahir.batch.load.users.model.BatchLoadUsers updateBatchLoadUsers(
		com.tahir.batch.load.users.model.BatchLoadUsers batchLoadUsers) {

		return _batchLoadUsersLocalService.updateBatchLoadUsers(batchLoadUsers);
	}

	@Override
	public BatchLoadUsersLocalService getWrappedService() {
		return _batchLoadUsersLocalService;
	}

	@Override
	public void setWrappedService(
		BatchLoadUsersLocalService batchLoadUsersLocalService) {

		_batchLoadUsersLocalService = batchLoadUsersLocalService;
	}

	private BatchLoadUsersLocalService _batchLoadUsersLocalService;

}