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

import com.isands.service.builder.model.Purchase;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Purchase in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PurchaseCacheModel
	implements CacheModel<Purchase>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PurchaseCacheModel)) {
			return false;
		}

		PurchaseCacheModel purchaseCacheModel = (PurchaseCacheModel)object;

		if ((purchaseId == purchaseCacheModel.purchaseId) &&
			(mvccVersion == purchaseCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, purchaseId);

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
		StringBundler sb = new StringBundler(17);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", purchaseId=");
		sb.append(purchaseId);
		sb.append(", electronicsId=");
		sb.append(electronicsId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", purchaseDate=");
		sb.append(purchaseDate);
		sb.append(", count=");
		sb.append(count);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", purchaseTypeId=");
		sb.append(purchaseTypeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Purchase toEntityModel() {
		PurchaseImpl purchaseImpl = new PurchaseImpl();

		purchaseImpl.setMvccVersion(mvccVersion);
		purchaseImpl.setPurchaseId(purchaseId);
		purchaseImpl.setElectronicsId(electronicsId);
		purchaseImpl.setEmployeeId(employeeId);

		if (purchaseDate == Long.MIN_VALUE) {
			purchaseImpl.setPurchaseDate(null);
		}
		else {
			purchaseImpl.setPurchaseDate(new Date(purchaseDate));
		}

		purchaseImpl.setCount(count);
		purchaseImpl.setCompanyId(companyId);
		purchaseImpl.setPurchaseTypeId(purchaseTypeId);

		purchaseImpl.resetOriginalValues();

		return purchaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		purchaseId = objectInput.readLong();

		electronicsId = objectInput.readLong();

		employeeId = objectInput.readLong();
		purchaseDate = objectInput.readLong();

		count = objectInput.readInt();

		companyId = objectInput.readLong();

		purchaseTypeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(purchaseId);

		objectOutput.writeLong(electronicsId);

		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(purchaseDate);

		objectOutput.writeInt(count);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(purchaseTypeId);
	}

	public long mvccVersion;
	public long purchaseId;
	public long electronicsId;
	public long employeeId;
	public long purchaseDate;
	public int count;
	public long companyId;
	public long purchaseTypeId;

}