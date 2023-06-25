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

import com.isands.service.builder.model.StatisticsHolder;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StatisticsHolder in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StatisticsHolderCacheModel
	implements CacheModel<StatisticsHolder>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StatisticsHolderCacheModel)) {
			return false;
		}

		StatisticsHolderCacheModel statisticsHolderCacheModel =
			(StatisticsHolderCacheModel)object;

		if (statName.equals(statisticsHolderCacheModel.statName) &&
			(mvccVersion == statisticsHolderCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, statName);

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
		StringBundler sb = new StringBundler(7);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", statName=");
		sb.append(statName);
		sb.append(", result=");
		sb.append(result);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StatisticsHolder toEntityModel() {
		StatisticsHolderImpl statisticsHolderImpl = new StatisticsHolderImpl();

		statisticsHolderImpl.setMvccVersion(mvccVersion);

		if (statName == null) {
			statisticsHolderImpl.setStatName("");
		}
		else {
			statisticsHolderImpl.setStatName(statName);
		}

		statisticsHolderImpl.setResult(result);

		statisticsHolderImpl.resetOriginalValues();

		return statisticsHolderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		statName = objectInput.readUTF();

		result = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (statName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statName);
		}

		objectOutput.writeLong(result);
	}

	public long mvccVersion;
	public String statName;
	public long result;

}