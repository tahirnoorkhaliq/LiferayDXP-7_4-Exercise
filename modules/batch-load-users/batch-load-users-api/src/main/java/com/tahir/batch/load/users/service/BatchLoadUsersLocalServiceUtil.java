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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tahir.batch.load.users.model.BatchLoadUsers;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for BatchLoadUsers. This utility wraps
 * <code>com.tahir.batch.load.users.service.impl.BatchLoadUsersLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BatchLoadUsersLocalService
 * @generated
 */
public class BatchLoadUsersLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.tahir.batch.load.users.service.impl.BatchLoadUsersLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static BatchLoadUsers addBatchLoadUsers(
		BatchLoadUsers batchLoadUsers) {

		return getService().addBatchLoadUsers(batchLoadUsers);
	}

	/**
	 * Creates a new batch load users with the primary key. Does not add the batch load users to the database.
	 *
	 * @param batchLoadUsersId the primary key for the new batch load users
	 * @return the new batch load users
	 */
	public static BatchLoadUsers createBatchLoadUsers(long batchLoadUsersId) {
		return getService().createBatchLoadUsers(batchLoadUsersId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static BatchLoadUsers deleteBatchLoadUsers(
		BatchLoadUsers batchLoadUsers) {

		return getService().deleteBatchLoadUsers(batchLoadUsers);
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
	public static BatchLoadUsers deleteBatchLoadUsers(long batchLoadUsersId)
		throws PortalException {

		return getService().deleteBatchLoadUsers(batchLoadUsersId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static BatchLoadUsers fetchBatchLoadUsers(long batchLoadUsersId) {
		return getService().fetchBatchLoadUsers(batchLoadUsersId);
	}

	/**
	 * Returns the batch load users matching the UUID and group.
	 *
	 * @param uuid the batch load users's UUID
	 * @param groupId the primary key of the group
	 * @return the matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public static BatchLoadUsers fetchBatchLoadUsersByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBatchLoadUsersByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the batch load users with the primary key.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users
	 * @throws PortalException if a batch load users with the primary key could not be found
	 */
	public static BatchLoadUsers getBatchLoadUsers(long batchLoadUsersId)
		throws PortalException {

		return getService().getBatchLoadUsers(batchLoadUsersId);
	}

	/**
	 * Returns the batch load users matching the UUID and group.
	 *
	 * @param uuid the batch load users's UUID
	 * @param groupId the primary key of the group
	 * @return the matching batch load users
	 * @throws PortalException if a matching batch load users could not be found
	 */
	public static BatchLoadUsers getBatchLoadUsersByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getBatchLoadUsersByUuidAndGroupId(uuid, groupId);
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
	public static List<BatchLoadUsers> getBatchLoadUserses(int start, int end) {
		return getService().getBatchLoadUserses(start, end);
	}

	/**
	 * Returns all the batch load userses matching the UUID and company.
	 *
	 * @param uuid the UUID of the batch load userses
	 * @param companyId the primary key of the company
	 * @return the matching batch load userses, or an empty list if no matches were found
	 */
	public static List<BatchLoadUsers> getBatchLoadUsersesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBatchLoadUsersesByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<BatchLoadUsers> getBatchLoadUsersesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getService().getBatchLoadUsersesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of batch load userses.
	 *
	 * @return the number of batch load userses
	 */
	public static int getBatchLoadUsersesCount() {
		return getService().getBatchLoadUsersesCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static String loadUsers() {
		return getService().loadUsers();
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
	public static BatchLoadUsers updateBatchLoadUsers(
		BatchLoadUsers batchLoadUsers) {

		return getService().updateBatchLoadUsers(batchLoadUsers);
	}

	public static BatchLoadUsersLocalService getService() {
		return _service;
	}

	private static volatile BatchLoadUsersLocalService _service;

}