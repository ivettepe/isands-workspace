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

import com.isands.service.builder.exception.NoSuchElectroEmployeeException;
import com.isands.service.builder.model.ElectroEmployee;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the electro employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectroEmployeeUtil
 * @generated
 */
@ProviderType
public interface ElectroEmployeePersistence
	extends BasePersistence<ElectroEmployee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElectroEmployeeUtil} to access the electro employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the electro employees where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @return the matching electro employees
	 */
	public java.util.List<ElectroEmployee> findByEmployee(long ElectroTypeId);

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
	public java.util.List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end);

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
	public java.util.List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator);

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
	public java.util.List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	public ElectroEmployee findByEmployee_First(
			long ElectroTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
				orderByComparator)
		throws NoSuchElectroEmployeeException;

	/**
	 * Returns the first electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	public ElectroEmployee fetchByEmployee_First(
		long ElectroTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator);

	/**
	 * Returns the last electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	public ElectroEmployee findByEmployee_Last(
			long ElectroTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
				orderByComparator)
		throws NoSuchElectroEmployeeException;

	/**
	 * Returns the last electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	public ElectroEmployee fetchByEmployee_Last(
		long ElectroTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator);

	/**
	 * Returns the electro employees before and after the current electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param id the primary key of the current electro employee
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public ElectroEmployee[] findByEmployee_PrevAndNext(
			long id, long ElectroTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
				orderByComparator)
		throws NoSuchElectroEmployeeException;

	/**
	 * Removes all the electro employees where ElectroTypeId = &#63; from the database.
	 *
	 * @param ElectroTypeId the electro type ID
	 */
	public void removeByEmployee(long ElectroTypeId);

	/**
	 * Returns the number of electro employees where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @return the number of matching electro employees
	 */
	public int countByEmployee(long ElectroTypeId);

	/**
	 * Returns all the electro employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching electro employees
	 */
	public java.util.List<ElectroEmployee> findByElectroType(long employeeId);

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
	public java.util.List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end);

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
	public java.util.List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator);

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
	public java.util.List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	public ElectroEmployee findByElectroType_First(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
				orderByComparator)
		throws NoSuchElectroEmployeeException;

	/**
	 * Returns the first electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	public ElectroEmployee fetchByElectroType_First(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator);

	/**
	 * Returns the last electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	public ElectroEmployee findByElectroType_Last(
			long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
				orderByComparator)
		throws NoSuchElectroEmployeeException;

	/**
	 * Returns the last electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	public ElectroEmployee fetchByElectroType_Last(
		long employeeId,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator);

	/**
	 * Returns the electro employees before and after the current electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param id the primary key of the current electro employee
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public ElectroEmployee[] findByElectroType_PrevAndNext(
			long id, long employeeId,
			com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
				orderByComparator)
		throws NoSuchElectroEmployeeException;

	/**
	 * Removes all the electro employees where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public void removeByElectroType(long employeeId);

	/**
	 * Returns the number of electro employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching electro employees
	 */
	public int countByElectroType(long employeeId);

	/**
	 * Caches the electro employee in the entity cache if it is enabled.
	 *
	 * @param electroEmployee the electro employee
	 */
	public void cacheResult(ElectroEmployee electroEmployee);

	/**
	 * Caches the electro employees in the entity cache if it is enabled.
	 *
	 * @param electroEmployees the electro employees
	 */
	public void cacheResult(java.util.List<ElectroEmployee> electroEmployees);

	/**
	 * Creates a new electro employee with the primary key. Does not add the electro employee to the database.
	 *
	 * @param id the primary key for the new electro employee
	 * @return the new electro employee
	 */
	public ElectroEmployee create(long id);

	/**
	 * Removes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee that was removed
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public ElectroEmployee remove(long id)
		throws NoSuchElectroEmployeeException;

	public ElectroEmployee updateImpl(ElectroEmployee electroEmployee);

	/**
	 * Returns the electro employee with the primary key or throws a <code>NoSuchElectroEmployeeException</code> if it could not be found.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	public ElectroEmployee findByPrimaryKey(long id)
		throws NoSuchElectroEmployeeException;

	/**
	 * Returns the electro employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee, or <code>null</code> if a electro employee with the primary key could not be found
	 */
	public ElectroEmployee fetchByPrimaryKey(long id);

	/**
	 * Returns all the electro employees.
	 *
	 * @return the electro employees
	 */
	public java.util.List<ElectroEmployee> findAll();

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
	public java.util.List<ElectroEmployee> findAll(int start, int end);

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
	public java.util.List<ElectroEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator);

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
	public java.util.List<ElectroEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectroEmployee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the electro employees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of electro employees.
	 *
	 * @return the number of electro employees
	 */
	public int countAll();

}