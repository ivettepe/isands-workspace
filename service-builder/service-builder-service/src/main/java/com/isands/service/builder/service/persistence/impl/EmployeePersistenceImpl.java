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

package com.isands.service.builder.service.persistence.impl;

import com.isands.service.builder.exception.NoSuchEmployeeException;
import com.isands.service.builder.model.Employee;
import com.isands.service.builder.model.impl.EmployeeImpl;
import com.isands.service.builder.model.impl.EmployeeModelImpl;
import com.isands.service.builder.service.persistence.EmployeePersistence;
import com.isands.service.builder.service.persistence.EmployeeUtil;
import com.isands.service.builder.service.persistence.impl.constants.isandsPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EmployeePersistence.class)
public class EmployeePersistenceImpl
	extends BasePersistenceImpl<Employee> implements EmployeePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EmployeeUtil</code> to access the employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EmployeeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByemployeeId;
	private FinderPath _finderPathWithoutPaginationFindByemployeeId;
	private FinderPath _finderPathCountByemployeeId;

	/**
	 * Returns all the employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching employees
	 */
	@Override
	public List<Employee> findByemployeeId(long employeeId) {
		return findByemployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Employee> findByemployeeId(
		long employeeId, int start, int end) {

		return findByemployeeId(employeeId, start, end, null);
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
	@Override
	public List<Employee> findByemployeeId(
		long employeeId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return findByemployeeId(
			employeeId, start, end, orderByComparator, true);
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
	@Override
	public List<Employee> findByemployeeId(
		long employeeId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByemployeeId;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByemployeeId;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<Employee> list = null;

		if (useFinderCache) {
			list = (List<Employee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Employee employee : list) {
					if (employeeId != employee.getEmployeeId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<Employee>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	@Override
	public Employee findByemployeeId_First(
			long employeeId, OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException {

		Employee employee = fetchByemployeeId_First(
			employeeId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeException(sb.toString());
	}

	/**
	 * Returns the first employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Override
	public Employee fetchByemployeeId_First(
		long employeeId, OrderByComparator<Employee> orderByComparator) {

		List<Employee> list = findByemployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	@Override
	public Employee findByemployeeId_Last(
			long employeeId, OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException {

		Employee employee = fetchByemployeeId_Last(
			employeeId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchEmployeeException(sb.toString());
	}

	/**
	 * Returns the last employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Override
	public Employee fetchByemployeeId_Last(
		long employeeId, OrderByComparator<Employee> orderByComparator) {

		int count = countByemployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByemployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the employees where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByemployeeId(long employeeId) {
		for (Employee employee :
				findByemployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching employees
	 */
	@Override
	public int countByemployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByemployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2 =
		"employee.employeeId = ?";

	private FinderPath _finderPathFetchByByFullName;
	private FinderPath _finderPathCountByByFullName;

	/**
	 * Returns the employee where firstName = &#63; and lastName = &#63; and patronymic = &#63; or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	@Override
	public Employee findByByFullName(
			String firstName, String lastName, String patronymic)
		throws NoSuchEmployeeException {

		Employee employee = fetchByByFullName(firstName, lastName, patronymic);

		if (employee == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("firstName=");
			sb.append(firstName);

			sb.append(", lastName=");
			sb.append(lastName);

			sb.append(", patronymic=");
			sb.append(patronymic);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEmployeeException(sb.toString());
		}

		return employee;
	}

	/**
	 * Returns the employee where firstName = &#63; and lastName = &#63; and patronymic = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Override
	public Employee fetchByByFullName(
		String firstName, String lastName, String patronymic) {

		return fetchByByFullName(firstName, lastName, patronymic, true);
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
	@Override
	public Employee fetchByByFullName(
		String firstName, String lastName, String patronymic,
		boolean useFinderCache) {

		firstName = Objects.toString(firstName, "");
		lastName = Objects.toString(lastName, "");
		patronymic = Objects.toString(patronymic, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {firstName, lastName, patronymic};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByByFullName, finderArgs, this);
		}

		if (result instanceof Employee) {
			Employee employee = (Employee)result;

			if (!Objects.equals(firstName, employee.getFirstName()) ||
				!Objects.equals(lastName, employee.getLastName()) ||
				!Objects.equals(patronymic, employee.getPatronymic())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_EMPLOYEE_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYFULLNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				sb.append(_FINDER_COLUMN_BYFULLNAME_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYFULLNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_BYFULLNAME_LASTNAME_2);
			}

			boolean bindPatronymic = false;

			if (patronymic.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYFULLNAME_PATRONYMIC_3);
			}
			else {
				bindPatronymic = true;

				sb.append(_FINDER_COLUMN_BYFULLNAME_PATRONYMIC_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFirstName) {
					queryPos.add(firstName);
				}

				if (bindLastName) {
					queryPos.add(lastName);
				}

				if (bindPatronymic) {
					queryPos.add(patronymic);
				}

				List<Employee> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByByFullName, finderArgs, list);
					}
				}
				else {
					Employee employee = list.get(0);

					result = employee;

					cacheResult(employee);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Employee)result;
		}
	}

	/**
	 * Removes the employee where firstName = &#63; and lastName = &#63; and patronymic = &#63; from the database.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the employee that was removed
	 */
	@Override
	public Employee removeByByFullName(
			String firstName, String lastName, String patronymic)
		throws NoSuchEmployeeException {

		Employee employee = findByByFullName(firstName, lastName, patronymic);

		return remove(employee);
	}

	/**
	 * Returns the number of employees where firstName = &#63; and lastName = &#63; and patronymic = &#63;.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param patronymic the patronymic
	 * @return the number of matching employees
	 */
	@Override
	public int countByByFullName(
		String firstName, String lastName, String patronymic) {

		firstName = Objects.toString(firstName, "");
		lastName = Objects.toString(lastName, "");
		patronymic = Objects.toString(patronymic, "");

		FinderPath finderPath = _finderPathCountByByFullName;

		Object[] finderArgs = new Object[] {firstName, lastName, patronymic};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_EMPLOYEE_WHERE);

			boolean bindFirstName = false;

			if (firstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYFULLNAME_FIRSTNAME_3);
			}
			else {
				bindFirstName = true;

				sb.append(_FINDER_COLUMN_BYFULLNAME_FIRSTNAME_2);
			}

			boolean bindLastName = false;

			if (lastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYFULLNAME_LASTNAME_3);
			}
			else {
				bindLastName = true;

				sb.append(_FINDER_COLUMN_BYFULLNAME_LASTNAME_2);
			}

			boolean bindPatronymic = false;

			if (patronymic.isEmpty()) {
				sb.append(_FINDER_COLUMN_BYFULLNAME_PATRONYMIC_3);
			}
			else {
				bindPatronymic = true;

				sb.append(_FINDER_COLUMN_BYFULLNAME_PATRONYMIC_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindFirstName) {
					queryPos.add(firstName);
				}

				if (bindLastName) {
					queryPos.add(lastName);
				}

				if (bindPatronymic) {
					queryPos.add(patronymic);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYFULLNAME_FIRSTNAME_2 =
		"employee.firstName = ? AND ";

	private static final String _FINDER_COLUMN_BYFULLNAME_FIRSTNAME_3 =
		"(employee.firstName IS NULL OR employee.firstName = '') AND ";

	private static final String _FINDER_COLUMN_BYFULLNAME_LASTNAME_2 =
		"employee.lastName = ? AND ";

	private static final String _FINDER_COLUMN_BYFULLNAME_LASTNAME_3 =
		"(employee.lastName IS NULL OR employee.lastName = '') AND ";

	private static final String _FINDER_COLUMN_BYFULLNAME_PATRONYMIC_2 =
		"employee.patronymic = ?";

	private static final String _FINDER_COLUMN_BYFULLNAME_PATRONYMIC_3 =
		"(employee.patronymic IS NULL OR employee.patronymic = '')";

	private FinderPath _finderPathWithPaginationFindByPositionId;
	private FinderPath _finderPathWithoutPaginationFindByPositionId;
	private FinderPath _finderPathCountByPositionId;

	/**
	 * Returns all the employees where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @return the matching employees
	 */
	@Override
	public List<Employee> findByPositionId(long positionId) {
		return findByPositionId(
			positionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Employee> findByPositionId(
		long positionId, int start, int end) {

		return findByPositionId(positionId, start, end, null);
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
	@Override
	public List<Employee> findByPositionId(
		long positionId, int start, int end,
		OrderByComparator<Employee> orderByComparator) {

		return findByPositionId(
			positionId, start, end, orderByComparator, true);
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
	@Override
	public List<Employee> findByPositionId(
		long positionId, int start, int end,
		OrderByComparator<Employee> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPositionId;
				finderArgs = new Object[] {positionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPositionId;
			finderArgs = new Object[] {
				positionId, start, end, orderByComparator
			};
		}

		List<Employee> list = null;

		if (useFinderCache) {
			list = (List<Employee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Employee employee : list) {
					if (positionId != employee.getPositionId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_EMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(positionId);

				list = (List<Employee>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first employee in the ordered set where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	@Override
	public Employee findByPositionId_First(
			long positionId, OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException {

		Employee employee = fetchByPositionId_First(
			positionId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("positionId=");
		sb.append(positionId);

		sb.append("}");

		throw new NoSuchEmployeeException(sb.toString());
	}

	/**
	 * Returns the first employee in the ordered set where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Override
	public Employee fetchByPositionId_First(
		long positionId, OrderByComparator<Employee> orderByComparator) {

		List<Employee> list = findByPositionId(
			positionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee in the ordered set where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee
	 * @throws NoSuchEmployeeException if a matching employee could not be found
	 */
	@Override
	public Employee findByPositionId_Last(
			long positionId, OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException {

		Employee employee = fetchByPositionId_Last(
			positionId, orderByComparator);

		if (employee != null) {
			return employee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("positionId=");
		sb.append(positionId);

		sb.append("}");

		throw new NoSuchEmployeeException(sb.toString());
	}

	/**
	 * Returns the last employee in the ordered set where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Override
	public Employee fetchByPositionId_Last(
		long positionId, OrderByComparator<Employee> orderByComparator) {

		int count = countByPositionId(positionId);

		if (count == 0) {
			return null;
		}

		List<Employee> list = findByPositionId(
			positionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Employee[] findByPositionId_PrevAndNext(
			long employeeId, long positionId,
			OrderByComparator<Employee> orderByComparator)
		throws NoSuchEmployeeException {

		Employee employee = findByPrimaryKey(employeeId);

		Session session = null;

		try {
			session = openSession();

			Employee[] array = new EmployeeImpl[3];

			array[0] = getByPositionId_PrevAndNext(
				session, employee, positionId, orderByComparator, true);

			array[1] = employee;

			array[2] = getByPositionId_PrevAndNext(
				session, employee, positionId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Employee getByPositionId_PrevAndNext(
		Session session, Employee employee, long positionId,
		OrderByComparator<Employee> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EMPLOYEE_WHERE);

		sb.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(EmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(positionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(employee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Employee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employees where positionId = &#63; from the database.
	 *
	 * @param positionId the position ID
	 */
	@Override
	public void removeByPositionId(long positionId) {
		for (Employee employee :
				findByPositionId(
					positionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(employee);
		}
	}

	/**
	 * Returns the number of employees where positionId = &#63;.
	 *
	 * @param positionId the position ID
	 * @return the number of matching employees
	 */
	@Override
	public int countByPositionId(long positionId) {
		FinderPath finderPath = _finderPathCountByPositionId;

		Object[] finderArgs = new Object[] {positionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_POSITIONID_POSITIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(positionId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_POSITIONID_POSITIONID_2 =
		"employee.positionId = ?";

	public EmployeePersistenceImpl() {
		setModelClass(Employee.class);

		setModelImplClass(EmployeeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the employee in the entity cache if it is enabled.
	 *
	 * @param employee the employee
	 */
	@Override
	public void cacheResult(Employee employee) {
		entityCache.putResult(
			EmployeeImpl.class, employee.getPrimaryKey(), employee);

		finderCache.putResult(
			_finderPathFetchByByFullName,
			new Object[] {
				employee.getFirstName(), employee.getLastName(),
				employee.getPatronymic()
			},
			employee);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the employees in the entity cache if it is enabled.
	 *
	 * @param employees the employees
	 */
	@Override
	public void cacheResult(List<Employee> employees) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (employees.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Employee employee : employees) {
			if (entityCache.getResult(
					EmployeeImpl.class, employee.getPrimaryKey()) == null) {

				cacheResult(employee);
			}
		}
	}

	/**
	 * Clears the cache for all employees.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EmployeeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Employee employee) {
		entityCache.removeResult(EmployeeImpl.class, employee);
	}

	@Override
	public void clearCache(List<Employee> employees) {
		for (Employee employee : employees) {
			entityCache.removeResult(EmployeeImpl.class, employee);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EmployeeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EmployeeModelImpl employeeModelImpl) {

		Object[] args = new Object[] {
			employeeModelImpl.getFirstName(), employeeModelImpl.getLastName(),
			employeeModelImpl.getPatronymic()
		};

		finderCache.putResult(
			_finderPathCountByByFullName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByByFullName, args, employeeModelImpl, false);
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	@Override
	public Employee create(long employeeId) {
		Employee employee = new EmployeeImpl();

		employee.setNew(true);
		employee.setPrimaryKey(employeeId);

		employee.setCompanyId(CompanyThreadLocal.getCompanyId());

		return employee;
	}

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	@Override
	public Employee remove(long employeeId) throws NoSuchEmployeeException {
		return remove((Serializable)employeeId);
	}

	/**
	 * Removes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee
	 * @return the employee that was removed
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	@Override
	public Employee remove(Serializable primaryKey)
		throws NoSuchEmployeeException {

		Session session = null;

		try {
			session = openSession();

			Employee employee = (Employee)session.get(
				EmployeeImpl.class, primaryKey);

			if (employee == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(employee);
		}
		catch (NoSuchEmployeeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Employee removeImpl(Employee employee) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employee)) {
				employee = (Employee)session.get(
					EmployeeImpl.class, employee.getPrimaryKeyObj());
			}

			if (employee != null) {
				session.delete(employee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (employee != null) {
			clearCache(employee);
		}

		return employee;
	}

	@Override
	public Employee updateImpl(Employee employee) {
		boolean isNew = employee.isNew();

		if (!(employee instanceof EmployeeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(employee.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(employee);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in employee proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Employee implementation " +
					employee.getClass());
		}

		EmployeeModelImpl employeeModelImpl = (EmployeeModelImpl)employee;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(employee);
			}
			else {
				employee = (Employee)session.merge(employee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EmployeeImpl.class, employeeModelImpl, false, true);

		cacheUniqueFindersCache(employeeModelImpl);

		if (isNew) {
			employee.setNew(false);
		}

		employee.resetOriginalValues();

		return employee;
	}

	/**
	 * Returns the employee with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee
	 * @return the employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	@Override
	public Employee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeException {

		Employee employee = fetchByPrimaryKey(primaryKey);

		if (employee == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return employee;
	}

	/**
	 * Returns the employee with the primary key or throws a <code>NoSuchEmployeeException</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws NoSuchEmployeeException if a employee with the primary key could not be found
	 */
	@Override
	public Employee findByPrimaryKey(long employeeId)
		throws NoSuchEmployeeException {

		return findByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns the employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee, or <code>null</code> if a employee with the primary key could not be found
	 */
	@Override
	public Employee fetchByPrimaryKey(long employeeId) {
		return fetchByPrimaryKey((Serializable)employeeId);
	}

	/**
	 * Returns all the employees.
	 *
	 * @return the employees
	 */
	@Override
	public List<Employee> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Employee> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Employee> findAll(
		int start, int end, OrderByComparator<Employee> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Employee> findAll(
		int start, int end, OrderByComparator<Employee> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Employee> list = null;

		if (useFinderCache) {
			list = (List<Employee>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMPLOYEE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEE;

				sql = sql.concat(EmployeeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Employee>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the employees from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Employee employee : findAll()) {
			remove(employee);
		}
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMPLOYEE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "employeeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EMPLOYEE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EmployeeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the employee persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new EmployeeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Employee.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByemployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByemployeeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByemployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByemployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByemployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathFetchByByFullName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByByFullName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"firstName", "lastName", "patronymic"}, true);

		_finderPathCountByByFullName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByFullName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"firstName", "lastName", "patronymic"}, false);

		_finderPathWithPaginationFindByPositionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPositionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"positionId"}, true);

		_finderPathWithoutPaginationFindByPositionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPositionId",
			new String[] {Long.class.getName()}, new String[] {"positionId"},
			true);

		_finderPathCountByPositionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPositionId",
			new String[] {Long.class.getName()}, new String[] {"positionId"},
			false);

		_setEmployeeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setEmployeeUtilPersistence(null);

		entityCache.removeCache(EmployeeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setEmployeeUtilPersistence(
		EmployeePersistence employeePersistence) {

		try {
			Field field = EmployeeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, employeePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = isandsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = isandsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = isandsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EMPLOYEE =
		"SELECT employee FROM Employee employee";

	private static final String _SQL_SELECT_EMPLOYEE_WHERE =
		"SELECT employee FROM Employee employee WHERE ";

	private static final String _SQL_COUNT_EMPLOYEE =
		"SELECT COUNT(employee) FROM Employee employee";

	private static final String _SQL_COUNT_EMPLOYEE_WHERE =
		"SELECT COUNT(employee) FROM Employee employee WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "employee.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Employee exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Employee exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EmployeePersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class EmployeeModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			EmployeeModelImpl employeeModelImpl = (EmployeeModelImpl)baseModel;

			long columnBitmask = employeeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(employeeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						employeeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(employeeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			EmployeeModelImpl employeeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = employeeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = employeeModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}