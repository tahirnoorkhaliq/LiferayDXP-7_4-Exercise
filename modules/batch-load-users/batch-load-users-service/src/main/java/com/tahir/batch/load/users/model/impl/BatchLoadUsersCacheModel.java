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

package com.tahir.batch.load.users.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.tahir.batch.load.users.model.BatchLoadUsers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BatchLoadUsers in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BatchLoadUsersCacheModel
	implements CacheModel<BatchLoadUsers>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BatchLoadUsersCacheModel)) {
			return false;
		}

		BatchLoadUsersCacheModel batchLoadUsersCacheModel =
			(BatchLoadUsersCacheModel)object;

		if (batchLoadUsersId == batchLoadUsersCacheModel.batchLoadUsersId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, batchLoadUsersId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", batchLoadUsersId=");
		sb.append(batchLoadUsersId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BatchLoadUsers toEntityModel() {
		BatchLoadUsersImpl batchLoadUsersImpl = new BatchLoadUsersImpl();

		if (uuid == null) {
			batchLoadUsersImpl.setUuid("");
		}
		else {
			batchLoadUsersImpl.setUuid(uuid);
		}

		batchLoadUsersImpl.setBatchLoadUsersId(batchLoadUsersId);
		batchLoadUsersImpl.setGroupId(groupId);
		batchLoadUsersImpl.setCompanyId(companyId);
		batchLoadUsersImpl.setUserId(userId);

		if (userName == null) {
			batchLoadUsersImpl.setUserName("");
		}
		else {
			batchLoadUsersImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			batchLoadUsersImpl.setCreateDate(null);
		}
		else {
			batchLoadUsersImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			batchLoadUsersImpl.setModifiedDate(null);
		}
		else {
			batchLoadUsersImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			batchLoadUsersImpl.setName("");
		}
		else {
			batchLoadUsersImpl.setName(name);
		}

		batchLoadUsersImpl.resetOriginalValues();

		return batchLoadUsersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		batchLoadUsersId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(batchLoadUsersId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public long batchLoadUsersId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;

}