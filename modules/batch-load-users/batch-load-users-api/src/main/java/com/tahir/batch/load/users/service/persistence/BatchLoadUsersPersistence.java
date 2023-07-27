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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.tahir.batch.load.users.exception.NoSuchLoadUsersException;
import com.tahir.batch.load.users.model.BatchLoadUsers;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the batch load users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BatchLoadUsersUtil
 * @generated
 */
@ProviderType
public interface BatchLoadUsersPersistence
	extends BasePersistence<BatchLoadUsers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BatchLoadUsersUtil} to access the batch load users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the batch load userses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching batch load userses
	 */
	public java.util.List<BatchLoadUsers> findByUuid(String uuid);

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
	public java.util.List<BatchLoadUsers> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<BatchLoadUsers> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator);

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
	public java.util.List<BatchLoadUsers> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public BatchLoadUsers findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
				orderByComparator)
		throws NoSuchLoadUsersException;

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public BatchLoadUsers fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator);

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public BatchLoadUsers findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
				orderByComparator)
		throws NoSuchLoadUsersException;

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public BatchLoadUsers fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator);

	/**
	 * Returns the batch load userses before and after the current batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param batchLoadUsersId the primary key of the current batch load users
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next batch load users
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	public BatchLoadUsers[] findByUuid_PrevAndNext(
			long batchLoadUsersId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
				orderByComparator)
		throws NoSuchLoadUsersException;

	/**
	 * Removes all the batch load userses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of batch load userses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching batch load userses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLoadUsersException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public BatchLoadUsers findByUUID_G(String uuid, long groupId)
		throws NoSuchLoadUsersException;

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public BatchLoadUsers fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public BatchLoadUsers fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the batch load users where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the batch load users that was removed
	 */
	public BatchLoadUsers removeByUUID_G(String uuid, long groupId)
		throws NoSuchLoadUsersException;

	/**
	 * Returns the number of batch load userses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching batch load userses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching batch load userses
	 */
	public java.util.List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator);

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
	public java.util.List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public BatchLoadUsers findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
				orderByComparator)
		throws NoSuchLoadUsersException;

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public BatchLoadUsers fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator);

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	public BatchLoadUsers findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
				orderByComparator)
		throws NoSuchLoadUsersException;

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	public BatchLoadUsers fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator);

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
	public BatchLoadUsers[] findByUuid_C_PrevAndNext(
			long batchLoadUsersId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
				orderByComparator)
		throws NoSuchLoadUsersException;

	/**
	 * Removes all the batch load userses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching batch load userses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the batch load users in the entity cache if it is enabled.
	 *
	 * @param batchLoadUsers the batch load users
	 */
	public void cacheResult(BatchLoadUsers batchLoadUsers);

	/**
	 * Caches the batch load userses in the entity cache if it is enabled.
	 *
	 * @param batchLoadUserses the batch load userses
	 */
	public void cacheResult(java.util.List<BatchLoadUsers> batchLoadUserses);

	/**
	 * Creates a new batch load users with the primary key. Does not add the batch load users to the database.
	 *
	 * @param batchLoadUsersId the primary key for the new batch load users
	 * @return the new batch load users
	 */
	public BatchLoadUsers create(long batchLoadUsersId);

	/**
	 * Removes the batch load users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users that was removed
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	public BatchLoadUsers remove(long batchLoadUsersId)
		throws NoSuchLoadUsersException;

	public BatchLoadUsers updateImpl(BatchLoadUsers batchLoadUsers);

	/**
	 * Returns the batch load users with the primary key or throws a <code>NoSuchLoadUsersException</code> if it could not be found.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	public BatchLoadUsers findByPrimaryKey(long batchLoadUsersId)
		throws NoSuchLoadUsersException;

	/**
	 * Returns the batch load users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users, or <code>null</code> if a batch load users with the primary key could not be found
	 */
	public BatchLoadUsers fetchByPrimaryKey(long batchLoadUsersId);

	/**
	 * Returns all the batch load userses.
	 *
	 * @return the batch load userses
	 */
	public java.util.List<BatchLoadUsers> findAll();

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
	public java.util.List<BatchLoadUsers> findAll(int start, int end);

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
	public java.util.List<BatchLoadUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator);

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
	public java.util.List<BatchLoadUsers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BatchLoadUsers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the batch load userses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of batch load userses.
	 *
	 * @return the number of batch load userses
	 */
	public int countAll();

}