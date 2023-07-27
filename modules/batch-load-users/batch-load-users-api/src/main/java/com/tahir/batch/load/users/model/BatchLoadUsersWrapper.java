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

package com.tahir.batch.load.users.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BatchLoadUsers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BatchLoadUsers
 * @generated
 */
public class BatchLoadUsersWrapper
	extends BaseModelWrapper<BatchLoadUsers>
	implements BatchLoadUsers, ModelWrapper<BatchLoadUsers> {

	public BatchLoadUsersWrapper(BatchLoadUsers batchLoadUsers) {
		super(batchLoadUsers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("batchLoadUsersId", getBatchLoadUsersId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long batchLoadUsersId = (Long)attributes.get("batchLoadUsersId");

		if (batchLoadUsersId != null) {
			setBatchLoadUsersId(batchLoadUsersId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public BatchLoadUsers cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the batch load users ID of this batch load users.
	 *
	 * @return the batch load users ID of this batch load users
	 */
	@Override
	public long getBatchLoadUsersId() {
		return model.getBatchLoadUsersId();
	}

	/**
	 * Returns the company ID of this batch load users.
	 *
	 * @return the company ID of this batch load users
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this batch load users.
	 *
	 * @return the create date of this batch load users
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this batch load users.
	 *
	 * @return the group ID of this batch load users
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this batch load users.
	 *
	 * @return the modified date of this batch load users
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this batch load users.
	 *
	 * @return the name of this batch load users
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this batch load users.
	 *
	 * @return the primary key of this batch load users
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this batch load users.
	 *
	 * @return the user ID of this batch load users
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this batch load users.
	 *
	 * @return the user name of this batch load users
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this batch load users.
	 *
	 * @return the user uuid of this batch load users
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this batch load users.
	 *
	 * @return the uuid of this batch load users
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the batch load users ID of this batch load users.
	 *
	 * @param batchLoadUsersId the batch load users ID of this batch load users
	 */
	@Override
	public void setBatchLoadUsersId(long batchLoadUsersId) {
		model.setBatchLoadUsersId(batchLoadUsersId);
	}

	/**
	 * Sets the company ID of this batch load users.
	 *
	 * @param companyId the company ID of this batch load users
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this batch load users.
	 *
	 * @param createDate the create date of this batch load users
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this batch load users.
	 *
	 * @param groupId the group ID of this batch load users
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this batch load users.
	 *
	 * @param modifiedDate the modified date of this batch load users
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this batch load users.
	 *
	 * @param name the name of this batch load users
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this batch load users.
	 *
	 * @param primaryKey the primary key of this batch load users
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this batch load users.
	 *
	 * @param userId the user ID of this batch load users
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this batch load users.
	 *
	 * @param userName the user name of this batch load users
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this batch load users.
	 *
	 * @param userUuid the user uuid of this batch load users
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this batch load users.
	 *
	 * @param uuid the uuid of this batch load users
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected BatchLoadUsersWrapper wrap(BatchLoadUsers batchLoadUsers) {
		return new BatchLoadUsersWrapper(batchLoadUsers);
	}

}