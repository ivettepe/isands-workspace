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

import com.isands.service.builder.model.EmployeeWithSummary;
import com.isands.service.builder.model.EmployeeWithSummaryModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the EmployeeWithSummary service. Represents a row in the &quot;isands_EmployeeWithSummary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeWithSummaryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeWithSummaryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeWithSummaryImpl
 * @generated
 */
public class EmployeeWithSummaryModelImpl
	extends BaseModelImpl<EmployeeWithSummary>
	implements EmployeeWithSummaryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee with summary model instance should use the <code>EmployeeWithSummary</code> interface instead.
	 */
	public static final String TABLE_NAME = "isands_EmployeeWithSummary";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"employeeId", Types.BIGINT},
		{"employeeFullName", Types.VARCHAR},
		{"electronicsCount", Types.INTEGER}, {"soldElectronicsOn", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeFullName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("electronicsCount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("soldElectronicsOn", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table isands_EmployeeWithSummary (mvccVersion LONG default 0 not null,employeeId LONG not null primary key,employeeFullName VARCHAR(75) null,electronicsCount INTEGER,soldElectronicsOn LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table isands_EmployeeWithSummary";

	public static final String ORDER_BY_JPQL =
		" ORDER BY employeeWithSummary.employeeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY isands_EmployeeWithSummary.employeeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ELECTRONICSCOUNT_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SOLDELECTRONICSON_COLUMN_BITMASK = 4L;

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

	public EmployeeWithSummaryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeWithSummary.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeWithSummary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<EmployeeWithSummary, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<EmployeeWithSummary, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWithSummary, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((EmployeeWithSummary)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<EmployeeWithSummary, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<EmployeeWithSummary, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(EmployeeWithSummary)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<EmployeeWithSummary, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<EmployeeWithSummary, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<EmployeeWithSummary, Object>>
		_attributeGetterFunctions;

	static {
		Map<String, Function<EmployeeWithSummary, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<EmployeeWithSummary, Object>>();

		attributeGetterFunctions.put(
			"mvccVersion", EmployeeWithSummary::getMvccVersion);
		attributeGetterFunctions.put(
			"employeeId", EmployeeWithSummary::getEmployeeId);
		attributeGetterFunctions.put(
			"employeeFullName", EmployeeWithSummary::getEmployeeFullName);
		attributeGetterFunctions.put(
			"electronicsCount", EmployeeWithSummary::getElectronicsCount);
		attributeGetterFunctions.put(
			"soldElectronicsOn", EmployeeWithSummary::getSoldElectronicsOn);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
	}

	private static final Map<String, BiConsumer<EmployeeWithSummary, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, BiConsumer<EmployeeWithSummary, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<EmployeeWithSummary, ?>>();

		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<EmployeeWithSummary, Long>)
				EmployeeWithSummary::setMvccVersion);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<EmployeeWithSummary, Long>)
				EmployeeWithSummary::setEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeFullName",
			(BiConsumer<EmployeeWithSummary, String>)
				EmployeeWithSummary::setEmployeeFullName);
		attributeSetterBiConsumers.put(
			"electronicsCount",
			(BiConsumer<EmployeeWithSummary, Integer>)
				EmployeeWithSummary::setElectronicsCount);
		attributeSetterBiConsumers.put(
			"soldElectronicsOn",
			(BiConsumer<EmployeeWithSummary, Long>)
				EmployeeWithSummary::setSoldElectronicsOn);

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
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeId = employeeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalEmployeeId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("employeeId"));
	}

	@Override
	public String getEmployeeFullName() {
		if (_employeeFullName == null) {
			return "";
		}
		else {
			return _employeeFullName;
		}
	}

	@Override
	public void setEmployeeFullName(String employeeFullName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeeFullName = employeeFullName;
	}

	@Override
	public int getElectronicsCount() {
		return _electronicsCount;
	}

	@Override
	public void setElectronicsCount(int electronicsCount) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_electronicsCount = electronicsCount;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalElectronicsCount() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("electronicsCount"));
	}

	@Override
	public long getSoldElectronicsOn() {
		return _soldElectronicsOn;
	}

	@Override
	public void setSoldElectronicsOn(long soldElectronicsOn) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_soldElectronicsOn = soldElectronicsOn;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalSoldElectronicsOn() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("soldElectronicsOn"));
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, EmployeeWithSummary.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmployeeWithSummary toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, EmployeeWithSummary>
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
		EmployeeWithSummaryImpl employeeWithSummaryImpl =
			new EmployeeWithSummaryImpl();

		employeeWithSummaryImpl.setMvccVersion(getMvccVersion());
		employeeWithSummaryImpl.setEmployeeId(getEmployeeId());
		employeeWithSummaryImpl.setEmployeeFullName(getEmployeeFullName());
		employeeWithSummaryImpl.setElectronicsCount(getElectronicsCount());
		employeeWithSummaryImpl.setSoldElectronicsOn(getSoldElectronicsOn());

		employeeWithSummaryImpl.resetOriginalValues();

		return employeeWithSummaryImpl;
	}

	@Override
	public int compareTo(EmployeeWithSummary employeeWithSummary) {
		long primaryKey = employeeWithSummary.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeWithSummary)) {
			return false;
		}

		EmployeeWithSummary employeeWithSummary = (EmployeeWithSummary)object;

		long primaryKey = employeeWithSummary.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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
	public CacheModel<EmployeeWithSummary> toCacheModel() {
		EmployeeWithSummaryCacheModel employeeWithSummaryCacheModel =
			new EmployeeWithSummaryCacheModel();

		employeeWithSummaryCacheModel.mvccVersion = getMvccVersion();

		employeeWithSummaryCacheModel.employeeId = getEmployeeId();

		employeeWithSummaryCacheModel.employeeFullName = getEmployeeFullName();

		String employeeFullName =
			employeeWithSummaryCacheModel.employeeFullName;

		if ((employeeFullName != null) && (employeeFullName.length() == 0)) {
			employeeWithSummaryCacheModel.employeeFullName = null;
		}

		employeeWithSummaryCacheModel.electronicsCount = getElectronicsCount();

		employeeWithSummaryCacheModel.soldElectronicsOn =
			getSoldElectronicsOn();

		return employeeWithSummaryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<EmployeeWithSummary, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<EmployeeWithSummary, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWithSummary, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(EmployeeWithSummary)this);

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
		Map<String, Function<EmployeeWithSummary, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<EmployeeWithSummary, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<EmployeeWithSummary, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((EmployeeWithSummary)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, EmployeeWithSummary>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					EmployeeWithSummary.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private long _employeeId;
	private String _employeeFullName;
	private int _electronicsCount;
	private long _soldElectronicsOn;

	public <T> T getColumnValue(String columnName) {
		Function<EmployeeWithSummary, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((EmployeeWithSummary)this);
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
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("employeeFullName", _employeeFullName);
		_columnOriginalValues.put("electronicsCount", _electronicsCount);
		_columnOriginalValues.put("soldElectronicsOn", _soldElectronicsOn);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("employeeId", 2L);

		columnBitmasks.put("employeeFullName", 4L);

		columnBitmasks.put("electronicsCount", 8L);

		columnBitmasks.put("soldElectronicsOn", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private EmployeeWithSummary _escapedModel;

}