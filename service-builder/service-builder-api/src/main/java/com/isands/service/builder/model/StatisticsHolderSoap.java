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

package com.isands.service.builder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StatisticsHolderSoap implements Serializable {

	public static StatisticsHolderSoap toSoapModel(StatisticsHolder model) {
		StatisticsHolderSoap soapModel = new StatisticsHolderSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setStatName(model.getStatName());
		soapModel.setResult(model.getResult());

		return soapModel;
	}

	public static StatisticsHolderSoap[] toSoapModels(
		StatisticsHolder[] models) {

		StatisticsHolderSoap[] soapModels =
			new StatisticsHolderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatisticsHolderSoap[][] toSoapModels(
		StatisticsHolder[][] models) {

		StatisticsHolderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new StatisticsHolderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatisticsHolderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatisticsHolderSoap[] toSoapModels(
		List<StatisticsHolder> models) {

		List<StatisticsHolderSoap> soapModels =
			new ArrayList<StatisticsHolderSoap>(models.size());

		for (StatisticsHolder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatisticsHolderSoap[soapModels.size()]);
	}

	public StatisticsHolderSoap() {
	}

	public String getPrimaryKey() {
		return _statName;
	}

	public void setPrimaryKey(String pk) {
		setStatName(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public String getStatName() {
		return _statName;
	}

	public void setStatName(String statName) {
		_statName = statName;
	}

	public long getResult() {
		return _result;
	}

	public void setResult(long result) {
		_result = result;
	}

	private long _mvccVersion;
	private String _statName;
	private long _result;

}