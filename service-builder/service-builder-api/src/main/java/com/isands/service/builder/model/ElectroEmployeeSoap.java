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
public class ElectroEmployeeSoap implements Serializable {

	public static ElectroEmployeeSoap toSoapModel(ElectroEmployee model) {
		ElectroEmployeeSoap soapModel = new ElectroEmployeeSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setId(model.getId());
		soapModel.setElectroTypeId(model.getElectroTypeId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static ElectroEmployeeSoap[] toSoapModels(ElectroEmployee[] models) {
		ElectroEmployeeSoap[] soapModels =
			new ElectroEmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ElectroEmployeeSoap[][] toSoapModels(
		ElectroEmployee[][] models) {

		ElectroEmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ElectroEmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ElectroEmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ElectroEmployeeSoap[] toSoapModels(
		List<ElectroEmployee> models) {

		List<ElectroEmployeeSoap> soapModels =
			new ArrayList<ElectroEmployeeSoap>(models.size());

		for (ElectroEmployee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ElectroEmployeeSoap[soapModels.size()]);
	}

	public ElectroEmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getElectroTypeId() {
		return _ElectroTypeId;
	}

	public void setElectroTypeId(long ElectroTypeId) {
		_ElectroTypeId = ElectroTypeId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private long _mvccVersion;
	private long _id;
	private long _ElectroTypeId;
	private long _employeeId;
	private long _companyId;

}