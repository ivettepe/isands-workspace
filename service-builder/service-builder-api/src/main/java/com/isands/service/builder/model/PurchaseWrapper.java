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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Purchase}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
public class PurchaseWrapper
	extends BaseModelWrapper<Purchase>
	implements ModelWrapper<Purchase>, Purchase {

	public PurchaseWrapper(Purchase purchase) {
		super(purchase);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("purchaseId", getPurchaseId());
		attributes.put("electronicsId", getElectronicsId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("purchaseDate", getPurchaseDate());
		attributes.put("count", getCount());
		attributes.put("companyId", getCompanyId());
		attributes.put("purchaseTypeId", getPurchaseTypeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long purchaseId = (Long)attributes.get("purchaseId");

		if (purchaseId != null) {
			setPurchaseId(purchaseId);
		}

		Long electronicsId = (Long)attributes.get("electronicsId");

		if (electronicsId != null) {
			setElectronicsId(electronicsId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date purchaseDate = (Date)attributes.get("purchaseDate");

		if (purchaseDate != null) {
			setPurchaseDate(purchaseDate);
		}

		Integer count = (Integer)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long purchaseTypeId = (Long)attributes.get("purchaseTypeId");

		if (purchaseTypeId != null) {
			setPurchaseTypeId(purchaseTypeId);
		}
	}

	/**
	 * Returns the company ID of this purchase.
	 *
	 * @return the company ID of this purchase
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the count of this purchase.
	 *
	 * @return the count of this purchase
	 */
	@Override
	public int getCount() {
		return model.getCount();
	}

	/**
	 * Returns the electronics ID of this purchase.
	 *
	 * @return the electronics ID of this purchase
	 */
	@Override
	public long getElectronicsId() {
		return model.getElectronicsId();
	}

	/**
	 * Returns the employee ID of this purchase.
	 *
	 * @return the employee ID of this purchase
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the mvcc version of this purchase.
	 *
	 * @return the mvcc version of this purchase
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this purchase.
	 *
	 * @return the primary key of this purchase
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purchase date of this purchase.
	 *
	 * @return the purchase date of this purchase
	 */
	@Override
	public Date getPurchaseDate() {
		return model.getPurchaseDate();
	}

	/**
	 * Returns the purchase ID of this purchase.
	 *
	 * @return the purchase ID of this purchase
	 */
	@Override
	public long getPurchaseId() {
		return model.getPurchaseId();
	}

	/**
	 * Returns the purchase type ID of this purchase.
	 *
	 * @return the purchase type ID of this purchase
	 */
	@Override
	public long getPurchaseTypeId() {
		return model.getPurchaseTypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this purchase.
	 *
	 * @param companyId the company ID of this purchase
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the count of this purchase.
	 *
	 * @param count the count of this purchase
	 */
	@Override
	public void setCount(int count) {
		model.setCount(count);
	}

	/**
	 * Sets the electronics ID of this purchase.
	 *
	 * @param electronicsId the electronics ID of this purchase
	 */
	@Override
	public void setElectronicsId(long electronicsId) {
		model.setElectronicsId(electronicsId);
	}

	/**
	 * Sets the employee ID of this purchase.
	 *
	 * @param employeeId the employee ID of this purchase
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the mvcc version of this purchase.
	 *
	 * @param mvccVersion the mvcc version of this purchase
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this purchase.
	 *
	 * @param primaryKey the primary key of this purchase
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purchase date of this purchase.
	 *
	 * @param purchaseDate the purchase date of this purchase
	 */
	@Override
	public void setPurchaseDate(Date purchaseDate) {
		model.setPurchaseDate(purchaseDate);
	}

	/**
	 * Sets the purchase ID of this purchase.
	 *
	 * @param purchaseId the purchase ID of this purchase
	 */
	@Override
	public void setPurchaseId(long purchaseId) {
		model.setPurchaseId(purchaseId);
	}

	/**
	 * Sets the purchase type ID of this purchase.
	 *
	 * @param purchaseTypeId the purchase type ID of this purchase
	 */
	@Override
	public void setPurchaseTypeId(long purchaseTypeId) {
		model.setPurchaseTypeId(purchaseTypeId);
	}

	@Override
	protected PurchaseWrapper wrap(Purchase purchase) {
		return new PurchaseWrapper(purchase);
	}

}