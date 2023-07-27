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

package com.tahir.batch.load.users.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.tahir.batch.load.users.model.BatchLoadUsers;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the batch load users service. This utility wraps <code>com.tahir.batch.load.users.service.persistence.impl.BatchLoadUsersPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BatchLoadUsersPersistence
 * @generated
 */
public class BatchLoadUsersUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(BatchLoadUsers batchLoadUsers) {
		getPersistence().clearCache(batchLoadUsers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, BatchLoadUsers> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BatchLoadUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BatchLoadUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BatchLoadUsers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BatchLoadUsers update(BatchLoadUsers batchLoadUsers) {
		return getPersistence().update(batchLoadUsers);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BatchLoadUsers update(
		BatchLoadUsers batchLoadUsers, ServiceContext serviceContext) {

		return getPersistence().update(batchLoadUsers, serviceContext);
	}

	/**
	 * Returns all the batch load userses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching batch load userses
	 */
	public static List<BatchLoadUsers> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the batch load userses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @return the range of matching batch load userses
	 */
	public static List<BatchLoadUsers> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the batch load userses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching batch load userses
	 */
	public static List<BatchLoadUsers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the batch load userses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching batch load userses
	 */
	public static List<BatchLoadUsers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public static BatchLoadUsers findByUuid_First(
			String uuid, OrderByComparator<BatchLoadUsers> orderByComparator)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public static BatchLoadUsers fetchByUuid_First(
		String uuid, OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public static BatchLoadUsers findByUuid_Last(
			String uuid, OrderByComparator<BatchLoadUsers> orderByComparator)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public static BatchLoadUsers fetchByUuid_Last(
		String uuid, OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the batch load userses before and after the current batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param batchLoadUsersId the primary key of the current batch load users
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next batch load users
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	public static BatchLoadUsers[] findByUuid_PrevAndNext(
			long batchLoadUsersId, String uuid,
			OrderByComparator<BatchLoadUsers> orderByComparator)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().findByUuid_PrevAndNext(
			batchLoadUsersId, uuid, orderByComparator);
	}

	/**
	 * Removes all the batch load userses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of batch load userses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching batch load userses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLoadUsersException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public static BatchLoadUsers findByUUID_G(String uuid, long groupId)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public static BatchLoadUsers fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public static BatchLoadUsers fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the batch load users where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the batch load users that was removed
	 */
	public static BatchLoadUsers removeByUUID_G(String uuid, long groupId)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of batch load userses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching batch load userses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching batch load userses
	 */
	public static List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @return the range of matching batch load userses
	 */
	public static List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching batch load userses
	 */
	public static List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching batch load userses
	 */
	public static List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public static BatchLoadUsers findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BatchLoadUsers> orderByComparator)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public static BatchLoadUsers fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public static BatchLoadUsers findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BatchLoadUsers> orderByComparator)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public static BatchLoadUsers fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the batch load userses before and after the current batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param batchLoadUsersId the primary key of the current batch load users
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next batch load users
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	public static BatchLoadUsers[] findByUuid_C_PrevAndNext(
			long batchLoadUsersId, String uuid, long companyId,
			OrderByComparator<BatchLoadUsers> orderByComparator)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().findByUuid_C_PrevAndNext(
			batchLoadUsersId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the batch load userses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching batch load userses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the batch load users in the entity cache if it is enabled.
	 *
	 * @param batchLoadUsers the batch load users
	 */
	public static void cacheResult(BatchLoadUsers batchLoadUsers) {
		getPersistence().cacheResult(batchLoadUsers);
	}

	/**
	 * Caches the batch load userses in the entity cache if it is enabled.
	 *
	 * @param batchLoadUserses the batch load userses
	 */
	public static void cacheResult(List<BatchLoadUsers> batchLoadUserses) {
		getPersistence().cacheResult(batchLoadUserses);
	}

	/**
	 * Creates a new batch load users with the primary key. Does not add the batch load users to the database.
	 *
	 * @param batchLoadUsersId the primary key for the new batch load users
	 * @return the new batch load users
	 */
	public static BatchLoadUsers create(long batchLoadUsersId) {
		return getPersistence().create(batchLoadUsersId);
	}

	/**
	 * Removes the batch load users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users that was removed
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	public static BatchLoadUsers remove(long batchLoadUsersId)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().remove(batchLoadUsersId);
	}

	public static BatchLoadUsers updateImpl(BatchLoadUsers batchLoadUsers) {
		return getPersistence().updateImpl(batchLoadUsers);
	}

	/**
	 * Returns the batch load users with the primary key or throws a <code>NoSuchLoadUsersException</code> if it could not be found.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	public static BatchLoadUsers findByPrimaryKey(long batchLoadUsersId)
		throws com.tahir.batch.load.users.exception.NoSuchLoadUsersException {

		return getPersistence().findByPrimaryKey(batchLoadUsersId);
	}

	/**
	 * Returns the batch load users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users, or <code>null</code> if a batch load users with the primary key could not be found
	 */
	public static BatchLoadUsers fetchByPrimaryKey(long batchLoadUsersId) {
		return getPersistence().fetchByPrimaryKey(batchLoadUsersId);
	}

	/**
	 * Returns all the batch load userses.
	 *
	 * @return the batch load userses
	 */
	public static List<BatchLoadUsers> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the batch load userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @return the range of batch load userses
	 */
	public static List<BatchLoadUsers> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the batch load userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of batch load userses
	 */
	public static List<BatchLoadUsers> findAll(
		int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the batch load userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BatchLoadUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of batch load userses
	 * @param end the upper bound of the range of batch load userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of batch load userses
	 */
	public static List<BatchLoadUsers> findAll(
		int start, int end, OrderByComparator<BatchLoadUsers> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the batch load userses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of batch load userses.
	 *
	 * @return the number of batch load userses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BatchLoadUsersPersistence getPersistence() {
		return _persistence;
	}

	private static volatile BatchLoadUsersPersistence _persistence;

}