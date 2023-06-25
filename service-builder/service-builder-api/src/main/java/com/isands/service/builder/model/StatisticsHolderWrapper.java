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
 * This class is a wrapper for {@link StatisticsHolder}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatisticsHolder
 * @generated
 */
public class StatisticsHolderWrapper
	extends BaseModelWrapper<StatisticsHolder>
	implements ModelWrapper<StatisticsHolder>, StatisticsHolder {

	public StatisticsHolderWrapper(StatisticsHolder statisticsHolder) {
		super(statisticsHolder);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("statName", getStatName());
		attributes.put("result", getResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String statName = (String)attributes.get("statName");

		if (statName != null) {
			setStatName(statName);
		}

		Long result = (Long)attributes.get("result");

		if (result != null) {
			setResult(result);
		}
	}

	/**
	 * Returns the mvcc version of this statistics holder.
	 *
	 * @return the mvcc version of this statistics holder
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this statistics holder.
	 *
	 * @return the primary key of this statistics holder
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the result of this statistics holder.
	 *
	 * @return the result of this statistics holder
	 */
	@Override
	public long getResult() {
		return model.getResult();
	}

	/**
	 * Returns the stat name of this statistics holder.
	 *
	 * @return the stat name of this statistics holder
	 */
	@Override
	public String getStatName() {
		return model.getStatName();
	}

	/**
	 * Sets the mvcc version of this statistics holder.
	 *
	 * @param mvccVersion the mvcc version of this statistics holder
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this statistics holder.
	 *
	 * @param primaryKey the primary key of this statistics holder
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the result of this statistics holder.
	 *
	 * @param result the result of this statistics holder
	 */
	@Override
	public void setResult(long result) {
		model.setResult(result);
	}

	/**
	 * Sets the stat name of this statistics holder.
	 *
	 * @param statName the stat name of this statistics holder
	 */
	@Override
	public void setStatName(String statName) {
		model.setStatName(statName);
	}

	@Override
	protected StatisticsHolderWrapper wrap(StatisticsHolder statisticsHolder) {
		return new StatisticsHolderWrapper(statisticsHolder);
	}

}