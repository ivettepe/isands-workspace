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

package com.isands.service.builder.model.impl;

import com.isands.service.builder.model.PositionType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PositionType in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PositionTypeCacheModel
	implements CacheModel<PositionType>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PositionTypeCacheModel)) {
			return false;
		}

		PositionTypeCacheModel positionTypeCacheModel =
			(PositionTypeCacheModel)object;

		if ((positionTypeId == positionTypeCacheModel.positionTypeId) &&
			(mvccVersion == positionTypeCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, positionTypeId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", positionTypeId=");
		sb.append(positionTypeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PositionType toEntityModel() {
		PositionTypeImpl positionTypeImpl = new PositionTypeImpl();

		positionTypeImpl.setMvccVersion(mvccVersion);
		positionTypeImpl.setPositionTypeId(positionTypeId);

		if (name == null) {
			positionTypeImpl.setName("");
		}
		else {
			positionTypeImpl.setName(name);
		}

		positionTypeImpl.setCompanyId(companyId);

		positionTypeImpl.resetOriginalValues();

		return positionTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		positionTypeId = objectInput.readLong();
		name = objectInput.readUTF();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(positionTypeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(companyId);
	}

	public long mvccVersion;
	public long positionTypeId;
	public String name;
	public long companyId;

}