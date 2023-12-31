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

import com.isands.service.builder.model.Electronics;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Electronics in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectronicsCacheModel
	implements CacheModel<Electronics>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectronicsCacheModel)) {
			return false;
		}

		ElectronicsCacheModel electronicsCacheModel =
			(ElectronicsCacheModel)object;

		if ((electronicsId == electronicsCacheModel.electronicsId) &&
			(mvccVersion == electronicsCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, electronicsId);

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
		StringBundler sb = new StringBundler(21);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", electronicsId=");
		sb.append(electronicsId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", ElectroTypeId=");
		sb.append(ElectroTypeId);
		sb.append(", price=");
		sb.append(price);
		sb.append(", count=");
		sb.append(count);
		sb.append(", inStock=");
		sb.append(inStock);
		sb.append(", archive=");
		sb.append(archive);
		sb.append(", description=");
		sb.append(description);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Electronics toEntityModel() {
		ElectronicsImpl electronicsImpl = new ElectronicsImpl();

		electronicsImpl.setMvccVersion(mvccVersion);
		electronicsImpl.setElectronicsId(electronicsId);

		if (name == null) {
			electronicsImpl.setName("");
		}
		else {
			electronicsImpl.setName(name);
		}

		electronicsImpl.setElectroTypeId(ElectroTypeId);
		electronicsImpl.setPrice(price);
		electronicsImpl.setCount(count);
		electronicsImpl.setInStock(inStock);
		electronicsImpl.setArchive(archive);

		if (description == null) {
			electronicsImpl.setDescription("");
		}
		else {
			electronicsImpl.setDescription(description);
		}

		electronicsImpl.setCompanyId(companyId);

		electronicsImpl.resetOriginalValues();

		return electronicsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		electronicsId = objectInput.readLong();
		name = objectInput.readUTF();

		ElectroTypeId = objectInput.readLong();

		price = objectInput.readLong();

		count = objectInput.readInt();

		inStock = objectInput.readBoolean();

		archive = objectInput.readBoolean();
		description = objectInput.readUTF();

		companyId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(electronicsId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(ElectroTypeId);

		objectOutput.writeLong(price);

		objectOutput.writeInt(count);

		objectOutput.writeBoolean(inStock);

		objectOutput.writeBoolean(archive);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(companyId);
	}

	public long mvccVersion;
	public long electronicsId;
	public String name;
	public long ElectroTypeId;
	public long price;
	public int count;
	public boolean inStock;
	public boolean archive;
	public String description;
	public long companyId;

}