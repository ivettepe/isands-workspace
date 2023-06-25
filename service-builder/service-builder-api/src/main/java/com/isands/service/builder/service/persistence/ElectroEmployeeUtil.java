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

package com.isands.service.builder.service.persistence;

import com.isands.service.builder.model.ElectroEmployee;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the electro employee service. This utility wraps <code>com.isands.service.builder.service.persistence.impl.ElectroEmployeePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployeePersistence
 * @generated
 */
public class ElectroEmployeeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ElectroEmployee electroEmployee) {
		getPersistence().clearCache(electroEmployee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ElectroEmployee> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ElectroEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ElectroEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ElectroEmployee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ElectroEmployee update(ElectroEmployee electroEmployee) {
		return getPersistence().update(electroEmployee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ElectroEmployee update(
		ElectroEmployee electroEmployee, ServiceContext serviceContext) {

		return getPersistence().update(electroEmployee, serviceContext);
	}

	/**
	 * Returns all the electro employees where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @return the matching electro employees
	 */
	public static List<ElectroEmployee> findByEmployee(long ElectroTypeId) {
		return getPersistence().findByEmployee(ElectroTypeId);
	}

	/**
	 * Returns a range of all the electro employees where ElectroTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @return the range of matching electro employees
	 */
	public static List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end) {

		return getPersistence().findByEmployee(ElectroTypeId, start, end);
	}

	/**
	 * Returns an ordered range of all the electro employees where ElectroTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electro employees
	 */
	public static List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return getPersistence().findByEmployee(
			ElectroTypeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electro employees where ElectroTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electro employees
	 */
	public static List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployee(
			ElectroTypeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	public static ElectroEmployee findByEmployee_First(
			long ElectroTypeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws com.isands.service.builder.exception.
			NoSuchElectroEmployeeException {

		return getPersistence().findByEmployee_First(
			ElectroTypeId, orderByComparator);
	}

	/**
	 * Returns the first electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	public static ElectroEmployee fetchByEmployee_First(
		long ElectroTypeId,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return getPersistence().fetchByEmployee_First(
			ElectroTypeId, orderByComparator);
	}

	/**
	 * Returns the last electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	public static ElectroEmployee findByEmployee_Last(
			long ElectroTypeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws com.isands.service.builder.exception.
			NoSuchElectroEmployeeException {

		return getPersistence().findByEmployee_Last(
			ElectroTypeId, orderByComparator);
	}

	/**
	 * Returns the last electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	public static ElectroEmployee fetchByEmployee_Last(
		long ElectroTypeId,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return getPersistence().fetchByEmployee_Last(
			ElectroTypeId, orderByComparator);
	}

	/**
	 * Returns the electro employees before and after the current electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param id the primary key of the current electro employee
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public static ElectroEmployee[] findByEmployee_PrevAndNext(
			long id, long ElectroTypeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws com.isands.service.builder.exception.
			NoSuchElectroEmployeeException {

		return getPersistence().findByEmployee_PrevAndNext(
			id, ElectroTypeId, orderByComparator);
	}

	/**
	 * Removes all the electro employees where ElectroTypeId = &#63; from the database.
	 *
	 * @param ElectroTypeId the electro type ID
	 */
	public static void removeByEmployee(long ElectroTypeId) {
		getPersistence().removeByEmployee(ElectroTypeId);
	}

	/**
	 * Returns the number of electro employees where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @return the number of matching electro employees
	 */
	public static int countByEmployee(long ElectroTypeId) {
		return getPersistence().countByEmployee(ElectroTypeId);
	}

	/**
	 * Returns all the electro employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching electro employees
	 */
	public static List<ElectroEmployee> findByElectroType(long employeeId) {
		return getPersistence().findByElectroType(employeeId);
	}

	/**
	 * Returns a range of all the electro employees where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @return the range of matching electro employees
	 */
	public static List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end) {

		return getPersistence().findByElectroType(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the electro employees where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electro employees
	 */
	public static List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return getPersistence().findByElectroType(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electro employees where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electro employees
	 */
	public static List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByElectroType(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	public static ElectroEmployee findByElectroType_First(
			long employeeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws com.isands.service.builder.exception.
			NoSuchElectroEmployeeException {

		return getPersistence().findByElectroType_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	public static ElectroEmployee fetchByElectroType_First(
		long employeeId, OrderByComparator<ElectroEmployee> orderByComparator) {

		return getPersistence().fetchByElectroType_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	public static ElectroEmployee findByElectroType_Last(
			long employeeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws com.isands.service.builder.exception.
			NoSuchElectroEmployeeException {

		return getPersistence().findByElectroType_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	public static ElectroEmployee fetchByElectroType_Last(
		long employeeId, OrderByComparator<ElectroEmployee> orderByComparator) {

		return getPersistence().fetchByElectroType_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the electro employees before and after the current electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param id the primary key of the current electro employee
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public static ElectroEmployee[] findByElectroType_PrevAndNext(
			long id, long employeeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws com.isands.service.builder.exception.
			NoSuchElectroEmployeeException {

		return getPersistence().findByElectroType_PrevAndNext(
			id, employeeId, orderByComparator);
	}

	/**
	 * Removes all the electro employees where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByElectroType(long employeeId) {
		getPersistence().removeByElectroType(employeeId);
	}

	/**
	 * Returns the number of electro employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching electro employees
	 */
	public static int countByElectroType(long employeeId) {
		return getPersistence().countByElectroType(employeeId);
	}

	/**
	 * Caches the electro employee in the entity cache if it is enabled.
	 *
	 * @param electroEmployee the electro employee
	 */
	public static void cacheResult(ElectroEmployee electroEmployee) {
		getPersistence().cacheResult(electroEmployee);
	}

	/**
	 * Caches the electro employees in the entity cache if it is enabled.
	 *
	 * @param electroEmployees the electro employees
	 */
	public static void cacheResult(List<ElectroEmployee> electroEmployees) {
		getPersistence().cacheResult(electroEmployees);
	}

	/**
	 * Creates a new electro employee with the primary key. Does not add the electro employee to the database.
	 *
	 * @param id the primary key for the new electro employee
	 * @return the new electro employee
	 */
	public static ElectroEmployee create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee that was removed
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public static ElectroEmployee remove(long id)
		throws com.isands.service.builder.exception.
			NoSuchElectroEmployeeException {

		return getPersistence().remove(id);
	}

	public static ElectroEmployee updateImpl(ElectroEmployee electroEmployee) {
		return getPersistence().updateImpl(electroEmployee);
	}

	/**
	 * Returns the electro employee with the primary key or throws a <code>NoSuchElectroEmployeeException</code> if it could not be found.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public static ElectroEmployee findByPrimaryKey(long id)
		throws com.isands.service.builder.exception.
			NoSuchElectroEmployeeException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the electro employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee, or <code>null</code> if a electro employee with the primary key could not be found
	 */
	public static ElectroEmployee fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the electro employees.
	 *
	 * @return the electro employees
	 */
	public static List<ElectroEmployee> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the electro employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @return the range of electro employees
	 */
	public static List<ElectroEmployee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the electro employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electro employees
	 */
	public static List<ElectroEmployee> findAll(
		int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electro employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectroEmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electro employees
	 * @param end the upper bound of the range of electro employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electro employees
	 */
	public static List<ElectroEmployee> findAll(
		int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the electro employees from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of electro employees.
	 *
	 * @return the number of electro employees
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ElectroEmployeePersistence getPersistence() {
		return _persistence;
	}

	private static volatile ElectroEmployeePersistence _persistence;

}