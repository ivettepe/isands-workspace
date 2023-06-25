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

import com.isands.service.builder.model.ElectroEmployee;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ElectroEmployee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectroEmployeeCacheModel
	implements CacheModel<ElectroEmployee>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectroEmployeeCacheModel)) {
			return false;
		}

		ElectroEmployeeCacheModel electroEmployeeCacheModel =
			(ElectroEmployeeCacheModel)object;

		if ((id == electroEmployeeCacheModel.id) &&
			(mvccVersion == electroEmployeeCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, id);

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
		StringBundler sb = new StringBundler(11);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", id=");
		sb.append(id);
		sb.append(", ElectroTypeId=");
		sb.append(ElectroTypeId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ElectroEmployee toEntityModel() {
		ElectroEmployeeImpl electroEmployeeImpl = new ElectroEmployeeImpl();

		electroEmployeeImpl.setMvccVersion(mvccVersion);
		electroEmployeeImpl.setId(id);
		electroEmployeeImpl.setElectroTypeId(ElectroTypeId);
		electroEmployeeImpl.setEmployeeId(employeeId);
		electroEmployeeImpl.setCompanyId(companyId);

		electroEmployeeImpl.resetOriginalValues();

		return electroEmployeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		id = objectInput.readLong();

		ElectroTypeId = objectInput.readLong();

		employeeId = objectInput.readLong();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(id);

		objectOutput.writeLong(ElectroTypeId);

		objectOutput.writeLong(employeeId);

		objectOutput.writeLong(companyId);
	}

	public long mvccVersion;
	public long id;
	public long ElectroTypeId;
	public long employeeId;
	public long companyId;

}