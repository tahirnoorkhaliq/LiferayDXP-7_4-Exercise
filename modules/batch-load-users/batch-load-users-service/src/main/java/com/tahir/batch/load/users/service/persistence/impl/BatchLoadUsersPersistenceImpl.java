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

package com.tahir.batch.load.users.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import com.tahir.batch.load.users.exception.NoSuchLoadUsersException;
import com.tahir.batch.load.users.model.BatchLoadUsers;
import com.tahir.batch.load.users.model.BatchLoadUsersTable;
import com.tahir.batch.load.users.model.impl.BatchLoadUsersImpl;
import com.tahir.batch.load.users.model.impl.BatchLoadUsersModelImpl;
import com.tahir.batch.load.users.service.persistence.BatchLoadUsersPersistence;
import com.tahir.batch.load.users.service.persistence.BatchLoadUsersUtil;
import com.tahir.batch.load.users.service.persistence.impl.constants.BatchPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the batch load users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {BatchLoadUsersPersistence.class, BasePersistence.class})
public class BatchLoadUsersPersistenceImpl
	extends BasePersistenceImpl<BatchLoadUsers>
	implements BatchLoadUsersPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BatchLoadUsersUtil</code> to access the batch load users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BatchLoadUsersImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the batch load userses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching batch load userses
	 */
	@Override
	public List<BatchLoadUsers> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BatchLoadUsers> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<BatchLoadUsers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<BatchLoadUsers> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<BatchLoadUsers> list = null;

		if (useFinderCache) {
			list = (List<BatchLoadUsers>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BatchLoadUsers batchLoadUsers : list) {
					if (!uuid.equals(batchLoadUsers.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_BATCHLOADUSERS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BatchLoadUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<BatchLoadUsers>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers findByUuid_First(
			String uuid, OrderByComparator<BatchLoadUsers> orderByComparator)
		throws NoSuchLoadUsersException {

		BatchLoadUsers batchLoadUsers = fetchByUuid_First(
			uuid, orderByComparator);

		if (batchLoadUsers != null) {
			return batchLoadUsers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLoadUsersException(sb.toString());
	}

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers fetchByUuid_First(
		String uuid, OrderByComparator<BatchLoadUsers> orderByComparator) {

		List<BatchLoadUsers> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers findByUuid_Last(
			String uuid, OrderByComparator<BatchLoadUsers> orderByComparator)
		throws NoSuchLoadUsersException {

		BatchLoadUsers batchLoadUsers = fetchByUuid_Last(
			uuid, orderByComparator);

		if (batchLoadUsers != null) {
			return batchLoadUsers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLoadUsersException(sb.toString());
	}

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers fetchByUuid_Last(
		String uuid, OrderByComparator<BatchLoadUsers> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BatchLoadUsers> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BatchLoadUsers[] findByUuid_PrevAndNext(
			long batchLoadUsersId, String uuid,
			OrderByComparator<BatchLoadUsers> orderByComparator)
		throws NoSuchLoadUsersException {

		uuid = Objects.toString(uuid, "");

		BatchLoadUsers batchLoadUsers = findByPrimaryKey(batchLoadUsersId);

		Session session = null;

		try {
			session = openSession();

			BatchLoadUsers[] array = new BatchLoadUsersImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, batchLoadUsers, uuid, orderByComparator, true);

			array[1] = batchLoadUsers;

			array[2] = getByUuid_PrevAndNext(
				session, batchLoadUsers, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BatchLoadUsers getByUuid_PrevAndNext(
		Session session, BatchLoadUsers batchLoadUsers, String uuid,
		OrderByComparator<BatchLoadUsers> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BATCHLOADUSERS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BatchLoadUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						batchLoadUsers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BatchLoadUsers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the batch load userses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BatchLoadUsers batchLoadUsers :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(batchLoadUsers);
		}
	}

	/**
	 * Returns the number of batch load userses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching batch load userses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BATCHLOADUSERS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"batchLoadUsers.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(batchLoadUsers.uuid IS NULL OR batchLoadUsers.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLoadUsersException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching batch load users
	 * @throws NoSuchLoadUsersException if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers findByUUID_G(String uuid, long groupId)
		throws NoSuchLoadUsersException {

		BatchLoadUsers batchLoadUsers = fetchByUUID_G(uuid, groupId);

		if (batchLoadUsers == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLoadUsersException(sb.toString());
		}

		return batchLoadUsers;
	}

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the batch load users where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof BatchLoadUsers) {
			BatchLoadUsers batchLoadUsers = (BatchLoadUsers)result;

			if (!Objects.equals(uuid, batchLoadUsers.getUuid()) ||
				(groupId != batchLoadUsers.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BATCHLOADUSERS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<BatchLoadUsers> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BatchLoadUsers batchLoadUsers = list.get(0);

					result = batchLoadUsers;

					cacheResult(batchLoadUsers);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BatchLoadUsers)result;
		}
	}

	/**
	 * Removes the batch load users where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the batch load users that was removed
	 */
	@Override
	public BatchLoadUsers removeByUUID_G(String uuid, long groupId)
		throws NoSuchLoadUsersException {

		BatchLoadUsers batchLoadUsers = findByUUID_G(uuid, groupId);

		return remove(batchLoadUsers);
	}

	/**
	 * Returns the number of batch load userses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching batch load userses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BATCHLOADUSERS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"batchLoadUsers.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(batchLoadUsers.uuid IS NULL OR batchLoadUsers.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"batchLoadUsers.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching batch load userses
	 */
	@Override
	public List<BatchLoadUsers> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<BatchLoadUsers> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<BatchLoadUsers> list = null;

		if (useFinderCache) {
			list = (List<BatchLoadUsers>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BatchLoadUsers batchLoadUsers : list) {
					if (!uuid.equals(batchLoadUsers.getUuid()) ||
						(companyId != batchLoadUsers.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_BATCHLOADUSERS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BatchLoadUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<BatchLoadUsers>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public BatchLoadUsers findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BatchLoadUsers> orderByComparator)
		throws NoSuchLoadUsersException {

		BatchLoadUsers batchLoadUsers = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (batchLoadUsers != null) {
			return batchLoadUsers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLoadUsersException(sb.toString());
	}

	/**
	 * Returns the first batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		List<BatchLoadUsers> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BatchLoadUsers findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BatchLoadUsers> orderByComparator)
		throws NoSuchLoadUsersException {

		BatchLoadUsers batchLoadUsers = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (batchLoadUsers != null) {
			return batchLoadUsers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLoadUsersException(sb.toString());
	}

	/**
	 * Returns the last batch load users in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching batch load users, or <code>null</code> if a matching batch load users could not be found
	 */
	@Override
	public BatchLoadUsers fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BatchLoadUsers> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public BatchLoadUsers[] findByUuid_C_PrevAndNext(
			long batchLoadUsersId, String uuid, long companyId,
			OrderByComparator<BatchLoadUsers> orderByComparator)
		throws NoSuchLoadUsersException {

		uuid = Objects.toString(uuid, "");

		BatchLoadUsers batchLoadUsers = findByPrimaryKey(batchLoadUsersId);

		Session session = null;

		try {
			session = openSession();

			BatchLoadUsers[] array = new BatchLoadUsersImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, batchLoadUsers, uuid, companyId, orderByComparator,
				true);

			array[1] = batchLoadUsers;

			array[2] = getByUuid_C_PrevAndNext(
				session, batchLoadUsers, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BatchLoadUsers getByUuid_C_PrevAndNext(
		Session session, BatchLoadUsers batchLoadUsers, String uuid,
		long companyId, OrderByComparator<BatchLoadUsers> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BATCHLOADUSERS_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(BatchLoadUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						batchLoadUsers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BatchLoadUsers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the batch load userses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BatchLoadUsers batchLoadUsers :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(batchLoadUsers);
		}
	}

	/**
	 * Returns the number of batch load userses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching batch load userses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BATCHLOADUSERS_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"batchLoadUsers.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(batchLoadUsers.uuid IS NULL OR batchLoadUsers.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"batchLoadUsers.companyId = ?";

	public BatchLoadUsersPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BatchLoadUsers.class);

		setModelImplClass(BatchLoadUsersImpl.class);
		setModelPKClass(long.class);

		setTable(BatchLoadUsersTable.INSTANCE);
	}

	/**
	 * Caches the batch load users in the entity cache if it is enabled.
	 *
	 * @param batchLoadUsers the batch load users
	 */
	@Override
	public void cacheResult(BatchLoadUsers batchLoadUsers) {
		entityCache.putResult(
			BatchLoadUsersImpl.class, batchLoadUsers.getPrimaryKey(),
			batchLoadUsers);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				batchLoadUsers.getUuid(), batchLoadUsers.getGroupId()
			},
			batchLoadUsers);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the batch load userses in the entity cache if it is enabled.
	 *
	 * @param batchLoadUserses the batch load userses
	 */
	@Override
	public void cacheResult(List<BatchLoadUsers> batchLoadUserses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (batchLoadUserses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BatchLoadUsers batchLoadUsers : batchLoadUserses) {
			if (entityCache.getResult(
					BatchLoadUsersImpl.class, batchLoadUsers.getPrimaryKey()) ==
						null) {

				cacheResult(batchLoadUsers);
			}
		}
	}

	/**
	 * Clears the cache for all batch load userses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BatchLoadUsersImpl.class);

		finderCache.clearCache(BatchLoadUsersImpl.class);
	}

	/**
	 * Clears the cache for the batch load users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BatchLoadUsers batchLoadUsers) {
		entityCache.removeResult(BatchLoadUsersImpl.class, batchLoadUsers);
	}

	@Override
	public void clearCache(List<BatchLoadUsers> batchLoadUserses) {
		for (BatchLoadUsers batchLoadUsers : batchLoadUserses) {
			entityCache.removeResult(BatchLoadUsersImpl.class, batchLoadUsers);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BatchLoadUsersImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BatchLoadUsersImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BatchLoadUsersModelImpl batchLoadUsersModelImpl) {

		Object[] args = new Object[] {
			batchLoadUsersModelImpl.getUuid(),
			batchLoadUsersModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, batchLoadUsersModelImpl);
	}

	/**
	 * Creates a new batch load users with the primary key. Does not add the batch load users to the database.
	 *
	 * @param batchLoadUsersId the primary key for the new batch load users
	 * @return the new batch load users
	 */
	@Override
	public BatchLoadUsers create(long batchLoadUsersId) {
		BatchLoadUsers batchLoadUsers = new BatchLoadUsersImpl();

		batchLoadUsers.setNew(true);
		batchLoadUsers.setPrimaryKey(batchLoadUsersId);

		String uuid = _portalUUID.generate();

		batchLoadUsers.setUuid(uuid);

		batchLoadUsers.setCompanyId(CompanyThreadLocal.getCompanyId());

		return batchLoadUsers;
	}

	/**
	 * Removes the batch load users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users that was removed
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	@Override
	public BatchLoadUsers remove(long batchLoadUsersId)
		throws NoSuchLoadUsersException {

		return remove((Serializable)batchLoadUsersId);
	}

	/**
	 * Removes the batch load users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the batch load users
	 * @return the batch load users that was removed
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	@Override
	public BatchLoadUsers remove(Serializable primaryKey)
		throws NoSuchLoadUsersException {

		Session session = null;

		try {
			session = openSession();

			BatchLoadUsers batchLoadUsers = (BatchLoadUsers)session.get(
				BatchLoadUsersImpl.class, primaryKey);

			if (batchLoadUsers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoadUsersException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(batchLoadUsers);
		}
		catch (NoSuchLoadUsersException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected BatchLoadUsers removeImpl(BatchLoadUsers batchLoadUsers) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(batchLoadUsers)) {
				batchLoadUsers = (BatchLoadUsers)session.get(
					BatchLoadUsersImpl.class,
					batchLoadUsers.getPrimaryKeyObj());
			}

			if (batchLoadUsers != null) {
				session.delete(batchLoadUsers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (batchLoadUsers != null) {
			clearCache(batchLoadUsers);
		}

		return batchLoadUsers;
	}

	@Override
	public BatchLoadUsers updateImpl(BatchLoadUsers batchLoadUsers) {
		boolean isNew = batchLoadUsers.isNew();

		if (!(batchLoadUsers instanceof BatchLoadUsersModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(batchLoadUsers.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					batchLoadUsers);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in batchLoadUsers proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BatchLoadUsers implementation " +
					batchLoadUsers.getClass());
		}

		BatchLoadUsersModelImpl batchLoadUsersModelImpl =
			(BatchLoadUsersModelImpl)batchLoadUsers;

		if (Validator.isNull(batchLoadUsers.getUuid())) {
			String uuid = _portalUUID.generate();

			batchLoadUsers.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (batchLoadUsers.getCreateDate() == null)) {
			if (serviceContext == null) {
				batchLoadUsers.setCreateDate(date);
			}
			else {
				batchLoadUsers.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!batchLoadUsersModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				batchLoadUsers.setModifiedDate(date);
			}
			else {
				batchLoadUsers.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(batchLoadUsers);
			}
			else {
				batchLoadUsers = (BatchLoadUsers)session.merge(batchLoadUsers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BatchLoadUsersImpl.class, batchLoadUsersModelImpl, false, true);

		cacheUniqueFindersCache(batchLoadUsersModelImpl);

		if (isNew) {
			batchLoadUsers.setNew(false);
		}

		batchLoadUsers.resetOriginalValues();

		return batchLoadUsers;
	}

	/**
	 * Returns the batch load users with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the batch load users
	 * @return the batch load users
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	@Override
	public BatchLoadUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoadUsersException {

		BatchLoadUsers batchLoadUsers = fetchByPrimaryKey(primaryKey);

		if (batchLoadUsers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoadUsersException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return batchLoadUsers;
	}

	/**
	 * Returns the batch load users with the primary key or throws a <code>NoSuchLoadUsersException</code> if it could not be found.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users
	 * @throws NoSuchLoadUsersException if a batch load users with the primary key could not be found
	 */
	@Override
	public BatchLoadUsers findByPrimaryKey(long batchLoadUsersId)
		throws NoSuchLoadUsersException {

		return findByPrimaryKey((Serializable)batchLoadUsersId);
	}

	/**
	 * Returns the batch load users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param batchLoadUsersId the primary key of the batch load users
	 * @return the batch load users, or <code>null</code> if a batch load users with the primary key could not be found
	 */
	@Override
	public BatchLoadUsers fetchByPrimaryKey(long batchLoadUsersId) {
		return fetchByPrimaryKey((Serializable)batchLoadUsersId);
	}

	/**
	 * Returns all the batch load userses.
	 *
	 * @return the batch load userses
	 */
	@Override
	public List<BatchLoadUsers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<BatchLoadUsers> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<BatchLoadUsers> findAll(
		int start, int end,
		OrderByComparator<BatchLoadUsers> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<BatchLoadUsers> findAll(
		int start, int end, OrderByComparator<BatchLoadUsers> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<BatchLoadUsers> list = null;

		if (useFinderCache) {
			list = (List<BatchLoadUsers>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BATCHLOADUSERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BATCHLOADUSERS;

				sql = sql.concat(BatchLoadUsersModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BatchLoadUsers>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the batch load userses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BatchLoadUsers batchLoadUsers : findAll()) {
			remove(batchLoadUsers);
		}
	}

	/**
	 * Returns the number of batch load userses.
	 *
	 * @return the number of batch load userses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BATCHLOADUSERS);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "batchLoadUsersId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BATCHLOADUSERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BatchLoadUsersModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the batch load users persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_setBatchLoadUsersUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBatchLoadUsersUtilPersistence(null);

		entityCache.removeCache(BatchLoadUsersImpl.class.getName());
	}

	private void _setBatchLoadUsersUtilPersistence(
		BatchLoadUsersPersistence batchLoadUsersPersistence) {

		try {
			Field field = BatchLoadUsersUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, batchLoadUsersPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = BatchPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BatchPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BatchPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BATCHLOADUSERS =
		"SELECT batchLoadUsers FROM BatchLoadUsers batchLoadUsers";

	private static final String _SQL_SELECT_BATCHLOADUSERS_WHERE =
		"SELECT batchLoadUsers FROM BatchLoadUsers batchLoadUsers WHERE ";

	private static final String _SQL_COUNT_BATCHLOADUSERS =
		"SELECT COUNT(batchLoadUsers) FROM BatchLoadUsers batchLoadUsers";

	private static final String _SQL_COUNT_BATCHLOADUSERS_WHERE =
		"SELECT COUNT(batchLoadUsers) FROM BatchLoadUsers batchLoadUsers WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "batchLoadUsers.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BatchLoadUsers exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BatchLoadUsers exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BatchLoadUsersPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}