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
public class PositionTypeSoap implements Serializable {

	public static PositionTypeSoap toSoapModel(PositionType model) {
		PositionTypeSoap soapModel = new PositionTypeSoap();

		soapModel.setMvccVersion(model.getMvccVersion());
		soapModel.setPositionTypeId(model.getPositionTypeId());
		soapModel.setName(model.getName());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static PositionTypeSoap[] toSoapModels(PositionType[] models) {
		PositionTypeSoap[] soapModels = new PositionTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PositionTypeSoap[][] toSoapModels(PositionType[][] models) {
		PositionTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PositionTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PositionTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PositionTypeSoap[] toSoapModels(List<PositionType> models) {
		List<PositionTypeSoap> soapModels = new ArrayList<PositionTypeSoap>(
			models.size());

		for (PositionType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PositionTypeSoap[soapModels.size()]);
	}

	public PositionTypeSoap() {
	}

	public long getPrimaryKey() {
		return _positionTypeId;
	}

	public void setPrimaryKey(long pk) {
		setPositionTypeId(pk);
	}

	public long getMvccVersion() {
		return _mvccVersion;
	}

	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	public long getPositionTypeId() {
		return _positionTypeId;
	}

	public void setPositionTypeId(long positionTypeId) {
		_positionTypeId = positionTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private long _mvccVersion;
	private long _positionTypeId;
	private String _name;
	private long _companyId;

}