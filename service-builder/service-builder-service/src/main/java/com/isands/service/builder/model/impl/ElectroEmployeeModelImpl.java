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

import com.isands.service.builder.model.ElectroEmployee;
import com.isands.service.builder.model.ElectroEmployeeModel;

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
 * The base model implementation for the ElectroEmployee service. Represents a row in the &quot;isands_ElectroEmployee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ElectroEmployeeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ElectroEmployeeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployeeImpl
 * @generated
 */
public class ElectroEmployeeModelImpl
	extends BaseModelImpl<ElectroEmployee> implements ElectroEmployeeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a electro employee model instance should use the <code>ElectroEmployee</code> interface instead.
	 */
	public static final String TABLE_NAME = "isands_ElectroEmployee";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"id_", Types.BIGINT},
		{"ElectroTypeId", Types.BIGINT}, {"employeeId", Types.BIGINT},
		{"companyId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ElectroTypeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table isands_ElectroEmployee (mvccVersion LONG default 0 not null,id_ LONG not null primary key,ElectroTypeId LONG,employeeId LONG,companyId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table isands_ElectroEmployee";

	public static final String ORDER_BY_JPQL =
		" ORDER BY electroEmployee.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY isands_ElectroEmployee.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ELECTROTYPEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EMPLOYEEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ID_COLUMN_BITMASK = 4L;

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

	public ElectroEmployeeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ElectroEmployee.class;
	}

	@Override
	public String getModelClassName() {
		return ElectroEmployee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ElectroEmployee, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ElectroEmployee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ElectroEmployee, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ElectroEmployee)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ElectroEmployee, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ElectroEmployee, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ElectroEmployee)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ElectroEmployee, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ElectroEmployee, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ElectroEmployee, Object>>
		_attributeGetterFunctions;

	static {
		Map<String, Function<ElectroEmployee, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<ElectroEmployee, Object>>();

		attributeGetterFunctions.put(
			"mvccVersion", ElectroEmployee::getMvccVersion);
		attributeGetterFunctions.put("id", ElectroEmployee::getId);
		attributeGetterFunctions.put(
			"ElectroTypeId", ElectroEmployee::getElectroTypeId);
		attributeGetterFunctions.put(
			"employeeId", ElectroEmployee::getEmployeeId);
		attributeGetterFunctions.put(
			"companyId", ElectroEmployee::getCompanyId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
	}

	private static final Map<String, BiConsumer<ElectroEmployee, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, BiConsumer<ElectroEmployee, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ElectroEmployee, ?>>();

		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<ElectroEmployee, Long>)ElectroEmployee::setMvccVersion);
		attributeSetterBiConsumers.put(
			"id", (BiConsumer<ElectroEmployee, Long>)ElectroEmployee::setId);
		attributeSetterBiConsumers.put(
			"ElectroTypeId",
			(BiConsumer<ElectroEmployee, Long>)
				ElectroEmployee::setElectroTypeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<ElectroEmployee, Long>)ElectroEmployee::setEmployeeId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ElectroEmployee, Long>)ElectroEmployee::setCompanyId);

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
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_id = id;
	}

	@Override
	public long getElectroTypeId() {
		return _ElectroTypeId;
	}

	@Override
	public void setElectroTypeId(long ElectroTypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ElectroTypeId = ElectroTypeId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalElectroTypeId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("ElectroTypeId"));
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
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
			getCompanyId(), ElectroEmployee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ElectroEmployee toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ElectroEmployee>
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
		ElectroEmployeeImpl electroEmployeeImpl = new ElectroEmployeeImpl();

		electroEmployeeImpl.setMvccVersion(getMvccVersion());
		electroEmployeeImpl.setId(getId());
		electroEmployeeImpl.setElectroTypeId(getElectroTypeId());
		electroEmployeeImpl.setEmployeeId(getEmployeeId());
		electroEmployeeImpl.setCompanyId(getCompanyId());

		electroEmployeeImpl.resetOriginalValues();

		return electroEmployeeImpl;
	}

	@Override
	public int compareTo(ElectroEmployee electroEmployee) {
		long primaryKey = electroEmployee.getPrimaryKey();

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

		if (!(object instanceof ElectroEmployee)) {
			return false;
		}

		ElectroEmployee electroEmployee = (ElectroEmployee)object;

		long primaryKey = electroEmployee.getPrimaryKey();

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
	public CacheModel<ElectroEmployee> toCacheModel() {
		ElectroEmployeeCacheModel electroEmployeeCacheModel =
			new ElectroEmployeeCacheModel();

		electroEmployeeCacheModel.mvccVersion = getMvccVersion();

		electroEmployeeCacheModel.id = getId();

		electroEmployeeCacheModel.ElectroTypeId = getElectroTypeId();

		electroEmployeeCacheModel.employeeId = getEmployeeId();

		electroEmployeeCacheModel.companyId = getCompanyId();

		return electroEmployeeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ElectroEmployee, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ElectroEmployee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ElectroEmployee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((ElectroEmployee)this);

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
		Map<String, Function<ElectroEmployee, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ElectroEmployee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ElectroEmployee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ElectroEmployee)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ElectroEmployee>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					ElectroEmployee.class, ModelWrapper.class);

	}

	private long _mvccVersion;
	private long _id;
	private long _ElectroTypeId;
	private long _employeeId;
	private long _companyId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ElectroEmployee, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ElectroEmployee)this);
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
		_columnOriginalValues.put("id_", _id);
		_columnOriginalValues.put("ElectroTypeId", _ElectroTypeId);
		_columnOriginalValues.put("employeeId", _employeeId);
		_columnOriginalValues.put("companyId", _companyId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("id_", "id");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("mvccVersion", 1L);

		columnBitmasks.put("id_", 2L);

		columnBitmasks.put("ElectroTypeId", 4L);

		columnBitmasks.put("employeeId", 8L);

		columnBitmasks.put("companyId", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ElectroEmployee _escapedModel;

}