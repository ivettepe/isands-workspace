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

package com.isands.service.builder.service.base;

import com.isands.service.builder.model.PositionType;
import com.isands.service.builder.service.PositionTypeLocalService;
import com.isands.service.builder.service.PositionTypeLocalServiceUtil;
import com.isands.service.builder.service.persistence.ElectroEmployeePersistence;
import com.isands.service.builder.service.persistence.ElectroTypePersistence;
import com.isands.service.builder.service.persistence.ElectronicsPersistence;
import com.isands.service.builder.service.persistence.EmployeePersistence;
import com.isands.service.builder.service.persistence.PositionTypePersistence;
import com.isands.service.builder.service.persistence.PurchasePersistence;
import com.isands.service.builder.service.persistence.PurchaseTypePersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the position type local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.isands.service.builder.service.impl.PositionTypeLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.isands.service.builder.service.impl.PositionTypeLocalServiceImpl
 * @generated
 */
public abstract class PositionTypeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, PositionTypeLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>PositionTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>PositionTypeLocalServiceUtil</code>.
	 */

	/**
	 * Adds the position type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PositionTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionType the position type
	 * @return the position type that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PositionType addPositionType(PositionType positionType) {
		positionType.setNew(true);

		return positionTypePersistence.update(positionType);
	}

	/**
	 * Creates a new position type with the primary key. Does not add the position type to the database.
	 *
	 * @param positionTypeId the primary key for the new position type
	 * @return the new position type
	 */
	@Override
	@Transactional(enabled = false)
	public PositionType createPositionType(long positionTypeId) {
		return positionTypePersistence.create(positionTypeId);
	}

	/**
	 * Deletes the position type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PositionTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionTypeId the primary key of the position type
	 * @return the position type that was removed
	 * @throws PortalException if a position type with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PositionType deletePositionType(long positionTypeId)
		throws PortalException {

		return positionTypePersistence.remove(positionTypeId);
	}

	/**
	 * Deletes the position type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PositionTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionType the position type
	 * @return the position type that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PositionType deletePositionType(PositionType positionType) {
		return positionTypePersistence.remove(positionType);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			PositionType.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return positionTypePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.isands.service.builder.model.impl.PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return positionTypePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.isands.service.builder.model.impl.PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return positionTypePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return positionTypePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return positionTypePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public PositionType fetchPositionType(long positionTypeId) {
		return positionTypePersistence.fetchByPrimaryKey(positionTypeId);
	}

	/**
	 * Returns the position type with the primary key.
	 *
	 * @param positionTypeId the primary key of the position type
	 * @return the position type
	 * @throws PortalException if a position type with the primary key could not be found
	 */
	@Override
	public PositionType getPositionType(long positionTypeId)
		throws PortalException {

		return positionTypePersistence.findByPrimaryKey(positionTypeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(positionTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PositionType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("positionTypeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			positionTypeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(PositionType.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"positionTypeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(positionTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PositionType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("positionTypeId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return positionTypePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return positionTypeLocalService.deletePositionType(
			(PositionType)persistedModel);
	}

	public BasePersistence<PositionType> getBasePersistence() {
		return positionTypePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return positionTypePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the position types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.isands.service.builder.model.impl.PositionTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of position types
	 * @param end the upper bound of the range of position types (not inclusive)
	 * @return the range of position types
	 */
	@Override
	public List<PositionType> getPositionTypes(int start, int end) {
		return positionTypePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of position types.
	 *
	 * @return the number of position types
	 */
	@Override
	public int getPositionTypesCount() {
		return positionTypePersistence.countAll();
	}

	/**
	 * Updates the position type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PositionTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param positionType the position type
	 * @return the position type that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PositionType updatePositionType(PositionType positionType) {
		return positionTypePersistence.update(positionType);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			PositionTypeLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		positionTypeLocalService = (PositionTypeLocalService)aopProxy;

		_setLocalServiceUtilService(positionTypeLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PositionTypeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return PositionType.class;
	}

	protected String getModelClassName() {
		return PositionType.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = positionTypePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		PositionTypeLocalService positionTypeLocalService) {

		try {
			Field field = PositionTypeLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, positionTypeLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ElectroEmployeePersistence electroEmployeePersistence;

	@Reference
	protected ElectronicsPersistence electronicsPersistence;

	@Reference
	protected ElectroTypePersistence electroTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	protected PositionTypeLocalService positionTypeLocalService;

	@Reference
	protected PositionTypePersistence positionTypePersistence;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		PositionTypeLocalServiceBaseImpl.class);

}