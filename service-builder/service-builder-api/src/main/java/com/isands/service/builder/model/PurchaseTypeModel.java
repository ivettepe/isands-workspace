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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PurchaseType service. Represents a row in the &quot;isands_PurchaseType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.isands.service.builder.model.impl.PurchaseTypeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.isands.service.builder.model.impl.PurchaseTypeImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PurchaseType
 * @generated
 */
@ProviderType
public interface PurchaseTypeModel
	extends BaseModel<PurchaseType>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a purchase type model instance should use the {@link PurchaseType} interface instead.
	 */

	/**
	 * Returns the primary key of this purchase type.
	 *
	 * @return the primary key of this purchase type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this purchase type.
	 *
	 * @param primaryKey the primary key of this purchase type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this purchase type.
	 *
	 * @return the mvcc version of this purchase type
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this purchase type.
	 *
	 * @param mvccVersion the mvcc version of this purchase type
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the purchase type ID of this purchase type.
	 *
	 * @return the purchase type ID of this purchase type
	 */
	public long getPurchaseTypeId();

	/**
	 * Sets the purchase type ID of this purchase type.
	 *
	 * @param purchaseTypeId the purchase type ID of this purchase type
	 */
	public void setPurchaseTypeId(long purchaseTypeId);

	/**
	 * Returns the name of this purchase type.
	 *
	 * @return the name of this purchase type
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this purchase type.
	 *
	 * @param name the name of this purchase type
	 */
	public void setName(String name);

	/**
	 * Returns the company ID of this purchase type.
	 *
	 * @return the company ID of this purchase type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this purchase type.
	 *
	 * @param companyId the company ID of this purchase type
	 */
	@Override
	public void setCompanyId(long companyId);

}