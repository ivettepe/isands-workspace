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
 * This class is a wrapper for {@link EmployeeWithSummary}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWithSummary
 * @generated
 */
public class EmployeeWithSummaryWrapper
	extends BaseModelWrapper<EmployeeWithSummary>
	implements EmployeeWithSummary, ModelWrapper<EmployeeWithSummary> {

	public EmployeeWithSummaryWrapper(EmployeeWithSummary employeeWithSummary) {
		super(employeeWithSummary);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("employeeFullName", getEmployeeFullName());
		attributes.put("electronicsCount", getElectronicsCount());
		attributes.put("soldElectronicsOn", getSoldElectronicsOn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String employeeFullName = (String)attributes.get("employeeFullName");

		if (employeeFullName != null) {
			setEmployeeFullName(employeeFullName);
		}

		Integer electronicsCount = (Integer)attributes.get("electronicsCount");

		if (electronicsCount != null) {
			setElectronicsCount(electronicsCount);
		}

		Long soldElectronicsOn = (Long)attributes.get("soldElectronicsOn");

		if (soldElectronicsOn != null) {
			setSoldElectronicsOn(soldElectronicsOn);
		}
	}

	/**
	 * Returns the electronics count of this employee with summary.
	 *
	 * @return the electronics count of this employee with summary
	 */
	@Override
	public int getElectronicsCount() {
		return model.getElectronicsCount();
	}

	/**
	 * Returns the employee full name of this employee with summary.
	 *
	 * @return the employee full name of this employee with summary
	 */
	@Override
	public String getEmployeeFullName() {
		return model.getEmployeeFullName();
	}

	/**
	 * Returns the employee ID of this employee with summary.
	 *
	 * @return the employee ID of this employee with summary
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the mvcc version of this employee with summary.
	 *
	 * @return the mvcc version of this employee with summary
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this employee with summary.
	 *
	 * @return the primary key of this employee with summary
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sold electronics on of this employee with summary.
	 *
	 * @return the sold electronics on of this employee with summary
	 */
	@Override
	public long getSoldElectronicsOn() {
		return model.getSoldElectronicsOn();
	}

	/**
	 * Sets the electronics count of this employee with summary.
	 *
	 * @param electronicsCount the electronics count of this employee with summary
	 */
	@Override
	public void setElectronicsCount(int electronicsCount) {
		model.setElectronicsCount(electronicsCount);
	}

	/**
	 * Sets the employee full name of this employee with summary.
	 *
	 * @param employeeFullName the employee full name of this employee with summary
	 */
	@Override
	public void setEmployeeFullName(String employeeFullName) {
		model.setEmployeeFullName(employeeFullName);
	}

	/**
	 * Sets the employee ID of this employee with summary.
	 *
	 * @param employeeId the employee ID of this employee with summary
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the mvcc version of this employee with summary.
	 *
	 * @param mvccVersion the mvcc version of this employee with summary
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this employee with summary.
	 *
	 * @param primaryKey the primary key of this employee with summary
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sold electronics on of this employee with summary.
	 *
	 * @param soldElectronicsOn the sold electronics on of this employee with summary
	 */
	@Override
	public void setSoldElectronicsOn(long soldElectronicsOn) {
		model.setSoldElectronicsOn(soldElectronicsOn);
	}

	@Override
	protected EmployeeWithSummaryWrapper wrap(
		EmployeeWithSummary employeeWithSummary) {

		return new EmployeeWithSummaryWrapper(employeeWithSummary);
	}

}