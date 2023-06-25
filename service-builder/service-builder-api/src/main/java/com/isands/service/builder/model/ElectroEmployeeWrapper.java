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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ElectroEmployee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployee
 * @generated
 */
public class ElectroEmployeeWrapper
	extends BaseModelWrapper<ElectroEmployee>
	implements ElectroEmployee, ModelWrapper<ElectroEmployee> {

	public ElectroEmployeeWrapper(ElectroEmployee electroEmployee) {
		super(electroEmployee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("id", getId());
		attributes.put("ElectroTypeId", getElectroTypeId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long ElectroTypeId = (Long)attributes.get("ElectroTypeId");

		if (ElectroTypeId != null) {
			setElectroTypeId(ElectroTypeId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	 * Returns the company ID of this electro employee.
	 *
	 * @return the company ID of this electro employee
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the electro type ID of this electro employee.
	 *
	 * @return the electro type ID of this electro employee
	 */
	@Override
	public long getElectroTypeId() {
		return model.getElectroTypeId();
	}

	/**
	 * Returns the employee ID of this electro employee.
	 *
	 * @return the employee ID of this electro employee
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the ID of this electro employee.
	 *
	 * @return the ID of this electro employee
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the mvcc version of this electro employee.
	 *
	 * @return the mvcc version of this electro employee
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this electro employee.
	 *
	 * @return the primary key of this electro employee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this electro employee.
	 *
	 * @param companyId the company ID of this electro employee
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the electro type ID of this electro employee.
	 *
	 * @param ElectroTypeId the electro type ID of this electro employee
	 */
	@Override
	public void setElectroTypeId(long ElectroTypeId) {
		model.setElectroTypeId(ElectroTypeId);
	}

	/**
	 * Sets the employee ID of this electro employee.
	 *
	 * @param employeeId the employee ID of this electro employee
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the ID of this electro employee.
	 *
	 * @param id the ID of this electro employee
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the mvcc version of this electro employee.
	 *
	 * @param mvccVersion the mvcc version of this electro employee
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this electro employee.
	 *
	 * @param primaryKey the primary key of this electro employee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ElectroEmployeeWrapper wrap(ElectroEmployee electroEmployee) {
		return new ElectroEmployeeWrapper(electroEmployee);
	}

}