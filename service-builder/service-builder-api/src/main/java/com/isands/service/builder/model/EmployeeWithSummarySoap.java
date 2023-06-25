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
public class EmployeeWithSummarySoap implements Serializable {

	public static EmployeeWithSummarySoap toSoapModel(
		EmployeeWithSummary model) {

		EmployeeWithSummarySoap soapModel = new EmployeeWithSummarySoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setEmployeeFullName(model.getEmployeeFullName());
		soapModel.setElectronicsCount(model.getElectronicsCount());
		soapModel.setSoldElectronicsOn(model.getSoldElectronicsOn());

		return soapModel;
	}

	public static EmployeeWithSummarySoap[] toSoapModels(
		EmployeeWithSummary[] models) {

		EmployeeWithSummarySoap[] soapModels =
			new EmployeeWithSummarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeWithSummarySoap[][] toSoapModels(
		EmployeeWithSummary[][] models) {

		EmployeeWithSummarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new EmployeeWithSummarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeWithSummarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeWithSummarySoap[] toSoapModels(
		List<EmployeeWithSummary> models) {

		List<EmployeeWithSummarySoap> soapModels =
			new ArrayList<EmployeeWithSummarySoap>(models.size());

		for (EmployeeWithSummary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new EmployeeWithSummarySoap[soapModels.size()]);
	}

	public EmployeeWithSummarySoap() {
	}

	public long getPrimaryKey() {
		return _employeeId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getEmployeeFullName() {
		return _employeeFullName;
	}

	public void setEmployeeFullName(String employeeFullName) {
		_employeeFullName = employeeFullName;
	}

	public int getElectronicsCount() {
		return _electronicsCount;
	}

	public void setElectronicsCount(int electronicsCount) {
		_electronicsCount = electronicsCount;
	}

	public long getSoldElectronicsOn() {
		return _soldElectronicsOn;
	}

	public void setSoldElectronicsOn(long soldElectronicsOn) {
		_soldElectronicsOn = soldElectronicsOn;
	}

	private long _mvccVersion;
	private long _employeeId;
	private String _employeeFullName;
	private int _electronicsCount;
	private long _soldElectronicsOn;

}