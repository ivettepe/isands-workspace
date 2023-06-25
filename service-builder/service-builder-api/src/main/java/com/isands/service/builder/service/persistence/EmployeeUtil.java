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

import com.isands.service.builder.model.Employee;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the employee service. This utility wraps <code>com.isands.service.builder.service.persistence.impl.EmployeePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeePersistence
 * @generated
 */
public class EmployeeUtil {

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
	public static void clearCache(Employee employee) {
		getPersistence().clearCache(employee);
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
	public static Map<Serializable, Employee> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Employee update(Employee employee) {
		return getPersistence().update(employee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Employee update(
		Employee employee, ServiceContext serviceContext) {

		return getPersistence().update(employee, serviceContext);
	}

	/**
	 * Returns all the employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employees
	 */
	public static List<Employee> findByemployeeId(long employeeId) {
		return getPersistence().findByemployeeId(employeeId);
	}

	/**
	 * Returns a range of all the employees where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByemployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByemployeeId(employeeId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByemployeeId(
		long employeeId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByemployeeId(
			employeeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByemployeeId(
		long employeeId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByemployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByemployeeId_First(
			long employeeId, OrderByComparator<Employee> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().findByemployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByemployeeId_First(
		long employeeId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByemployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByemployeeId_Last(
			long employeeId, OrderByComparator<Employee> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().findByemployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByemployeeId_Last(
		long employeeId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByemployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Removes all the employees where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByemployeeId(long employeeId) {
		getPersistence().removeByemployeeId(employeeId);
	}

	/**
	 * Returns the number of employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employees
	 */
	public static int countByemployeeId(long employeeId) {
		return getPersistence().countByemployeeId(employeeId);
	}

	/**
	 * Returns the employee where firstName = &#63; and lastName = &#63; and patronymic = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByByFullName(
			String firstName, String lastName, String patronymic)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().findByByFullName(
			firstName, lastName, patronymic);
	}

	/**
	 * Returns the employee where firstName = &#63; and lastName = &#63; and patronymic = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByByFullName(
		String firstName, String lastName, String patronymic) {

		return getPersistence().fetchByByFullName(
			firstName, lastName, patronymic);
	}

	/**
	 * Returns the employee where firstName = &#63; and lastName = &#63; and patronymic = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByByFullName(
		String firstName, String lastName, String patronymic,
		boolean useFinderCache) {

		return getPersistence().fetchByByFullName(
			firstName, lastName, patronymic, useFinderCache);
	}

	/**
	 * Removes the employee where firstName = &#63; and lastName = &#63; and patronymic = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the employee that was removed
	 */
	public static Employee removeByByFullName(
			String firstName, String lastName, String patronymic)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().removeByByFullName(
			firstName, lastName, patronymic);
	}

	/**
	 * Returns the number of employees where firstName = &#63; and lastName = &#63; and patronymic = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the number of matching employees
	 */
	public static int countByByFullName(
		String firstName, String lastName, String patronymic) {

		return getPersistence().countByByFullName(
			firstName, lastName, patronymic);
	}

	/**
	 * Returns all the employees where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @return the matching employees
	 */
	public static List<Employee> findByPositionId(long positionId) {
		return getPersistence().findByPositionId(positionId);
	}

	/**
	 * Returns a range of all the employees where positionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param positionId the position ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of matching employees
	 */
	public static List<Employee> findByPositionId(
		long positionId, int start, int end) {

		return getPersistence().findByPositionId(positionId, start, end);
	}

	/**
	 * Returns an ordered range of all the employees where positionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param positionId the position ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByPositionId(
		long positionId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findByPositionId(
			positionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees where positionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param positionId the position ID
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching employees
	 */
	public static List<Employee> findByPositionId(
		long positionId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByPositionId(
			positionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first employee in the ordered set where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByPositionId_First(
			long positionId, OrderByComparator<Employee> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().findByPositionId_First(
			positionId, orderByComparator);
	}

	/**
	 * Returns the first employee in the ordered set where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByPositionId_First(
		long positionId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByPositionId_First(
			positionId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	public static Employee findByPositionId_Last(
			long positionId, OrderByComparator<Employee> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().findByPositionId_Last(
			positionId, orderByComparator);
	}

	/**
	 * Returns the last employee in the ordered set where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	public static Employee fetchByPositionId_Last(
		long positionId, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().fetchByPositionId_Last(
			positionId, orderByComparator);
	}

	/**
	 * Returns the employees before and after the current employee in the ordered set where positionId = &#63;.
	 *
	 * @param employeeId the primary key of the current employee
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee[] findByPositionId_PrevAndNext(
			long employeeId, long positionId,
			OrderByComparator<Employee> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().findByPositionId_PrevAndNext(
			employeeId, positionId, orderByComparator);
	}

	/**
	 * Removes all the employees where positionId = &#63; from the database.
	 *
	 * @param positionId the position ID
	 */
	public static void removeByPositionId(long positionId) {
		getPersistence().removeByPositionId(positionId);
	}

	/**
	 * Returns the number of employees where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @return the number of matching employees
	 */
	public static int countByPositionId(long positionId) {
		return getPersistence().countByPositionId(positionId);
	}

	/**
	 * Caches the employee in the entity cache if it is enabled.
	 *
	 * @param employee the employee
	 */
	public static void cacheResult(Employee employee) {
		getPersistence().cacheResult(employee);
	}

	/**
	 * Caches the employees in the entity cache if it is enabled.
	 *
	 * @param employees the employees
	 */
	public static void cacheResult(List<Employee> employees) {
		getPersistence().cacheResult(employees);
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	public static Employee create(long employeeId) {
		return getPersistence().create(employeeId);
	}

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee remove(long employeeId)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().remove(employeeId);
	}

	public static Employee updateImpl(Employee employee) {
		return getPersistence().updateImpl(employee);
	}

	/**
	 * Returns the employee with the primary key or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	public static Employee findByPrimaryKey(long employeeId)
		throws com.isands.service.builder.exception.NoSuchEmployeeException {

		return getPersistence().findByPrimaryKey(employeeId);
	}

	/**
	 * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee, or <code>null</code> if a employee with the primary key could not be found
	 */
	public static Employee fetchByPrimaryKey(long employeeId) {
		return getPersistence().fetchByPrimaryKey(employeeId);
	}

	/**
	 * Returns all the employees.
	 *
	 * @return the employees
	 */
	public static List<Employee> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 */
	public static List<Employee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employees
	 */
	public static List<Employee> findAll(
		int start, int end, OrderByComparator<Employee> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of employees
	 */
	public static List<Employee> findAll(
		int start, int end, OrderByComparator<Employee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the employees from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EmployeePersistence getPersistence() {
		return _persistence;
	}

	private static volatile EmployeePersistence _persistence;

}