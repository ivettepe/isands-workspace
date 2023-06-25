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
import com.isands.service.builder.model.StatisticsHolderModel;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the StatisticsHolder service. Represents a row in the &quot;isands_StatisticsHolder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StatisticsHolderModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StatisticsHolderImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StatisticsHolderImpl
 * @generated
 */
public class StatisticsHolderModelImpl
	extends BaseModelImpl<StatisticsHolder> implements StatisticsHolderModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a statistics holder model instance should use the <code>StatisticsHolder</code> interface instead.
	 */
	public static final String TABLE_NAME = "isands_StatisticsHolder";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"statName", Types.VARCHAR},
		{"result", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("result", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table isands_StatisticsHolder (mvccVersion LONG default 0 not null,statName VARCHAR(75) not null primary key,result LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table isands_StatisticsHolder";

	public static final String ORDER_BY_JPQL =
		" ORDER BY statisticsHolder.statName ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY isands_StatisticsHolder.statName ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATNAME_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public StatisticsHolderModelImpl() {
	}

	@Override
	public String getPrimaryKey() {
		return _statName;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setStatName(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statName;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return StatisticsHolder.class;
	}

	@Override
	public String getModelClassName() {
		return StatisticsHolder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<StatisticsHolder, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<StatisticsHolder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StatisticsHolder, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((StatisticsHolder)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<StatisticsHolder, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<StatisticsHolder, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(StatisticsHolder)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<StatisticsHolder, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<StatisticsHolder, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<StatisticsHolder, Object>>
		_attributeGetterFunctions;

	static {
		Map<String, Function<StatisticsHolder, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<StatisticsHolder, Object>>();

		attributeGetterFunctions.put(
			"mvccVersion", StatisticsHolder::getMvccVersion);
		attributeGetterFunctions.put("statName", StatisticsHolder::getStatName);
		attributeGetterFunctions.put("result", StatisticsHolder::getResult);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
	}

	private static final Map<String, BiConsumer<StatisticsHolder, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, BiConsumer<StatisticsHolder, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<StatisticsHolder, ?>>();

		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<StatisticsHolder, Long>)
				StatisticsHolder::setMvccVersion);
		attributeSetterBiConsumers.put(
			"statName",
			(BiConsumer<StatisticsHolder, String>)
				StatisticsHolder::setStatName);
		attributeSetterBiConsumers.put(
			"result",
			(BiConsumer<StatisticsHolder, Long>)StatisticsHolder::setResult);

		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mvccVersion = mvccVersion;
	}

	@Override
	public String getStatName() {
		if (_statName == null) {
			return "";
		}
		else {
			return _statName;
		}
	}

	@Override
	public void setStatName(String statName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statName = statName;
	}

	@Override
	public long getResult() {
		return _result;
	}

	@Override
	public void setResult(long result) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_result = result;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public StatisticsHolder toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, StatisticsHolder>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StatisticsHolderImpl statisticsHolderImpl = new StatisticsHolderImpl();

		statisticsHolderImpl.setMvccVersion(getMvccVersion());
		statisticsHolderImpl.setStatName(getStatName());
		statisticsHolderImpl.setResult(getResult());

		statisticsHolderImpl.resetOriginalValues();

		return statisticsHolderImpl;
	}

	@Override
	public int compareTo(StatisticsHolder statisticsHolder) {
		String primaryKey = statisticsHolder.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StatisticsHolder)) {
			return false;
		}

		StatisticsHolder statisticsHolder = (StatisticsHolder)object;

		String primaryKey = statisticsHolder.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<StatisticsHolder> toCacheModel() {
		StatisticsHolderCacheModel statisticsHolderCacheModel =
			new StatisticsHolderCacheModel();

		statisticsHolderCacheModel.mvccVersion = getMvccVersion();

		statisticsHolderCacheModel.statName = getStatName();

		String statName = statisticsHolderCacheModel.statName;

		if ((statName != null) && (statName.length() == 0)) {
			statisticsHolderCacheModel.statName = null;
		}

		statisticsHolderCacheModel.result = getResult();

		return statisticsHolderCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<StatisticsHolder, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<StatisticsHolder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StatisticsHolder, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(StatisticsHolder)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<StatisticsHolder, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<StatisticsHolder, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StatisticsHolder, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((StatisticsHolder)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, StatisticsHolder>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					StatisticsHolder.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private String _statName;
	private long _result;

	public <T> T getColumnValue(String columnName) {
		Function<StatisticsHolder, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((StatisticsHolder)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("mvccVersion", _mvccVersion);
		_columnOriginalValues.put("statName", _statName);
		_columnOriginalValues.put("result", _result);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("statName", 2L);

		columnBitmasks.put("result", 4L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private StatisticsHolder _escapedModel;

}