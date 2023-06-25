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

import com.isands.service.builder.exception.NoSuchElectroEmployeeException;
import com.isands.service.builder.model.ElectroEmployee;
import com.isands.service.builder.model.impl.ElectroEmployeeImpl;
import com.isands.service.builder.model.impl.ElectroEmployeeModelImpl;
import com.isands.service.builder.service.persistence.ElectroEmployeePersistence;
import com.isands.service.builder.service.persistence.ElectroEmployeeUtil;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the electro employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElectroEmployeePersistence.class)
public class ElectroEmployeePersistenceImpl
	extends BasePersistenceImpl<ElectroEmployee>
	implements ElectroEmployeePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElectroEmployeeUtil</code> to access the electro employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElectroEmployeeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEmployee;
	private FinderPath _finderPathWithoutPaginationFindByEmployee;
	private FinderPath _finderPathCountByEmployee;

	/**
	 * Returns all the electro employees where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @return the matching electro employees
	 */
	@Override
	public List<ElectroEmployee> findByEmployee(long ElectroTypeId) {
		return findByEmployee(
			ElectroTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end) {

		return findByEmployee(ElectroTypeId, start, end, null);
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
	@Override
	public List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return findByEmployee(
			ElectroTypeId, start, end, orderByComparator, true);
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
	@Override
	public List<ElectroEmployee> findByEmployee(
		long ElectroTypeId, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmployee;
				finderArgs = new Object[] {ElectroTypeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployee;
			finderArgs = new Object[] {
				ElectroTypeId, start, end, orderByComparator
			};
		}

		List<ElectroEmployee> list = null;

		if (useFinderCache) {
			list = (List<ElectroEmployee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElectroEmployee electroEmployee : list) {
					if (ElectroTypeId != electroEmployee.getElectroTypeId()) {
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

			sb.append(_SQL_SELECT_ELECTROEMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEE_ELECTROTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElectroEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ElectroTypeId);

				list = (List<ElectroEmployee>)QueryUtil.list(
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
	 * Returns the first electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	@Override
	public ElectroEmployee findByEmployee_First(
			long ElectroTypeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws NoSuchElectroEmployeeException {

		ElectroEmployee electroEmployee = fetchByEmployee_First(
			ElectroTypeId, orderByComparator);

		if (electroEmployee != null) {
			return electroEmployee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ElectroTypeId=");
		sb.append(ElectroTypeId);

		sb.append("}");

		throw new NoSuchElectroEmployeeException(sb.toString());
	}

	/**
	 * Returns the first electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	@Override
	public ElectroEmployee fetchByEmployee_First(
		long ElectroTypeId,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		List<ElectroEmployee> list = findByEmployee(
			ElectroTypeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	@Override
	public ElectroEmployee findByEmployee_Last(
			long ElectroTypeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws NoSuchElectroEmployeeException {

		ElectroEmployee electroEmployee = fetchByEmployee_Last(
			ElectroTypeId, orderByComparator);

		if (electroEmployee != null) {
			return electroEmployee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ElectroTypeId=");
		sb.append(ElectroTypeId);

		sb.append("}");

		throw new NoSuchElectroEmployeeException(sb.toString());
	}

	/**
	 * Returns the last electro employee in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	@Override
	public ElectroEmployee fetchByEmployee_Last(
		long ElectroTypeId,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		int count = countByEmployee(ElectroTypeId);

		if (count == 0) {
			return null;
		}

		List<ElectroEmployee> list = findByEmployee(
			ElectroTypeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ElectroEmployee[] findByEmployee_PrevAndNext(
			long id, long ElectroTypeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws NoSuchElectroEmployeeException {

		ElectroEmployee electroEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ElectroEmployee[] array = new ElectroEmployeeImpl[3];

			array[0] = getByEmployee_PrevAndNext(
				session, electroEmployee, ElectroTypeId, orderByComparator,
				true);

			array[1] = electroEmployee;

			array[2] = getByEmployee_PrevAndNext(
				session, electroEmployee, ElectroTypeId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElectroEmployee getByEmployee_PrevAndNext(
		Session session, ElectroEmployee electroEmployee, long ElectroTypeId,
		OrderByComparator<ElectroEmployee> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELECTROEMPLOYEE_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEE_ELECTROTYPEID_2);

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
			sb.append(ElectroEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(ElectroTypeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						electroEmployee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElectroEmployee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the electro employees where ElectroTypeId = &#63; from the database.
	 *
	 * @param ElectroTypeId the electro type ID
	 */
	@Override
	public void removeByEmployee(long ElectroTypeId) {
		for (ElectroEmployee electroEmployee :
				findByEmployee(
					ElectroTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(electroEmployee);
		}
	}

	/**
	 * Returns the number of electro employees where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @return the number of matching electro employees
	 */
	@Override
	public int countByEmployee(long ElectroTypeId) {
		FinderPath finderPath = _finderPathCountByEmployee;

		Object[] finderArgs = new Object[] {ElectroTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELECTROEMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEE_ELECTROTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ElectroTypeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEE_ELECTROTYPEID_2 =
		"electroEmployee.ElectroTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByElectroType;
	private FinderPath _finderPathWithoutPaginationFindByElectroType;
	private FinderPath _finderPathCountByElectroType;

	/**
	 * Returns all the electro employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching electro employees
	 */
	@Override
	public List<ElectroEmployee> findByElectroType(long employeeId) {
		return findByElectroType(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end) {

		return findByElectroType(employeeId, start, end, null);
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
	@Override
	public List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return findByElectroType(
			employeeId, start, end, orderByComparator, true);
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
	@Override
	public List<ElectroEmployee> findByElectroType(
		long employeeId, int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByElectroType;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByElectroType;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<ElectroEmployee> list = null;

		if (useFinderCache) {
			list = (List<ElectroEmployee>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElectroEmployee electroEmployee : list) {
					if (employeeId != electroEmployee.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_ELECTROEMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_ELECTROTYPE_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElectroEmployeeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<ElectroEmployee>)QueryUtil.list(
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
	 * Returns the first electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	@Override
	public ElectroEmployee findByElectroType_First(
			long employeeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws NoSuchElectroEmployeeException {

		ElectroEmployee electroEmployee = fetchByElectroType_First(
			employeeId, orderByComparator);

		if (electroEmployee != null) {
			return electroEmployee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchElectroEmployeeException(sb.toString());
	}

	/**
	 * Returns the first electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	@Override
	public ElectroEmployee fetchByElectroType_First(
		long employeeId, OrderByComparator<ElectroEmployee> orderByComparator) {

		List<ElectroEmployee> list = findByElectroType(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee
	 * @throws NoSuchElectroEmployeeException if a matching electro employee could not be found
	 */
	@Override
	public ElectroEmployee findByElectroType_Last(
			long employeeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws NoSuchElectroEmployeeException {

		ElectroEmployee electroEmployee = fetchByElectroType_Last(
			employeeId, orderByComparator);

		if (electroEmployee != null) {
			return electroEmployee;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchElectroEmployeeException(sb.toString());
	}

	/**
	 * Returns the last electro employee in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electro employee, or <code>null</code> if a matching electro employee could not be found
	 */
	@Override
	public ElectroEmployee fetchByElectroType_Last(
		long employeeId, OrderByComparator<ElectroEmployee> orderByComparator) {

		int count = countByElectroType(employeeId);

		if (count == 0) {
			return null;
		}

		List<ElectroEmployee> list = findByElectroType(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ElectroEmployee[] findByElectroType_PrevAndNext(
			long id, long employeeId,
			OrderByComparator<ElectroEmployee> orderByComparator)
		throws NoSuchElectroEmployeeException {

		ElectroEmployee electroEmployee = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ElectroEmployee[] array = new ElectroEmployeeImpl[3];

			array[0] = getByElectroType_PrevAndNext(
				session, electroEmployee, employeeId, orderByComparator, true);

			array[1] = electroEmployee;

			array[2] = getByElectroType_PrevAndNext(
				session, electroEmployee, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElectroEmployee getByElectroType_PrevAndNext(
		Session session, ElectroEmployee electroEmployee, long employeeId,
		OrderByComparator<ElectroEmployee> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELECTROEMPLOYEE_WHERE);

		sb.append(_FINDER_COLUMN_ELECTROTYPE_EMPLOYEEID_2);

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
			sb.append(ElectroEmployeeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						electroEmployee)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElectroEmployee> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the electro employees where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByElectroType(long employeeId) {
		for (ElectroEmployee electroEmployee :
				findByElectroType(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(electroEmployee);
		}
	}

	/**
	 * Returns the number of electro employees where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching electro employees
	 */
	@Override
	public int countByElectroType(long employeeId) {
		FinderPath finderPath = _finderPathCountByElectroType;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELECTROEMPLOYEE_WHERE);

			sb.append(_FINDER_COLUMN_ELECTROTYPE_EMPLOYEEID_2);

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

	private static final String _FINDER_COLUMN_ELECTROTYPE_EMPLOYEEID_2 =
		"electroEmployee.employeeId = ?";

	public ElectroEmployeePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ElectroEmployee.class);

		setModelImplClass(ElectroEmployeeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the electro employee in the entity cache if it is enabled.
	 *
	 * @param electroEmployee the electro employee
	 */
	@Override
	public void cacheResult(ElectroEmployee electroEmployee) {
		entityCache.putResult(
			ElectroEmployeeImpl.class, electroEmployee.getPrimaryKey(),
			electroEmployee);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the electro employees in the entity cache if it is enabled.
	 *
	 * @param electroEmployees the electro employees
	 */
	@Override
	public void cacheResult(List<ElectroEmployee> electroEmployees) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (electroEmployees.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ElectroEmployee electroEmployee : electroEmployees) {
			if (entityCache.getResult(
					ElectroEmployeeImpl.class,
					electroEmployee.getPrimaryKey()) == null) {

				cacheResult(electroEmployee);
			}
		}
	}

	/**
	 * Clears the cache for all electro employees.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElectroEmployeeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the electro employee.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ElectroEmployee electroEmployee) {
		entityCache.removeResult(ElectroEmployeeImpl.class, electroEmployee);
	}

	@Override
	public void clearCache(List<ElectroEmployee> electroEmployees) {
		for (ElectroEmployee electroEmployee : electroEmployees) {
			entityCache.removeResult(
				ElectroEmployeeImpl.class, electroEmployee);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElectroEmployeeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new electro employee with the primary key. Does not add the electro employee to the database.
	 *
	 * @param id the primary key for the new electro employee
	 * @return the new electro employee
	 */
	@Override
	public ElectroEmployee create(long id) {
		ElectroEmployee electroEmployee = new ElectroEmployeeImpl();

		electroEmployee.setNew(true);
		electroEmployee.setPrimaryKey(id);

		electroEmployee.setCompanyId(CompanyThreadLocal.getCompanyId());

		return electroEmployee;
	}

	/**
	 * Removes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee that was removed
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	@Override
	public ElectroEmployee remove(long id)
		throws NoSuchElectroEmployeeException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the electro employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the electro employee
	 * @return the electro employee that was removed
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	@Override
	public ElectroEmployee remove(Serializable primaryKey)
		throws NoSuchElectroEmployeeException {

		Session session = null;

		try {
			session = openSession();

			ElectroEmployee electroEmployee = (ElectroEmployee)session.get(
				ElectroEmployeeImpl.class, primaryKey);

			if (electroEmployee == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElectroEmployeeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(electroEmployee);
		}
		catch (NoSuchElectroEmployeeException noSuchEntityException) {
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
	protected ElectroEmployee removeImpl(ElectroEmployee electroEmployee) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(electroEmployee)) {
				electroEmployee = (ElectroEmployee)session.get(
					ElectroEmployeeImpl.class,
					electroEmployee.getPrimaryKeyObj());
			}

			if (electroEmployee != null) {
				session.delete(electroEmployee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (electroEmployee != null) {
			clearCache(electroEmployee);
		}

		return electroEmployee;
	}

	@Override
	public ElectroEmployee updateImpl(ElectroEmployee electroEmployee) {
		boolean isNew = electroEmployee.isNew();

		if (!(electroEmployee instanceof ElectroEmployeeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(electroEmployee.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					electroEmployee);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in electroEmployee proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ElectroEmployee implementation " +
					electroEmployee.getClass());
		}

		ElectroEmployeeModelImpl electroEmployeeModelImpl =
			(ElectroEmployeeModelImpl)electroEmployee;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(electroEmployee);
			}
			else {
				electroEmployee = (ElectroEmployee)session.merge(
					electroEmployee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ElectroEmployeeImpl.class, electroEmployeeModelImpl, false, true);

		if (isNew) {
			electroEmployee.setNew(false);
		}

		electroEmployee.resetOriginalValues();

		return electroEmployee;
	}

	/**
	 * Returns the electro employee with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the electro employee
	 * @return the electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	@Override
	public ElectroEmployee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElectroEmployeeException {

		ElectroEmployee electroEmployee = fetchByPrimaryKey(primaryKey);

		if (electroEmployee == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElectroEmployeeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return electroEmployee;
	}

	/**
	 * Returns the electro employee with the primary key or throws a <code>NoSuchElectroEmployeeException</code> if it could not be found.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee
	 * @throws NoSuchElectroEmployeeException if a electro employee with the primary key could not be found
	 */
	@Override
	public ElectroEmployee findByPrimaryKey(long id)
		throws NoSuchElectroEmployeeException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the electro employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the electro employee
	 * @return the electro employee, or <code>null</code> if a electro employee with the primary key could not be found
	 */
	@Override
	public ElectroEmployee fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the electro employees.
	 *
	 * @return the electro employees
	 */
	@Override
	public List<ElectroEmployee> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ElectroEmployee> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ElectroEmployee> findAll(
		int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ElectroEmployee> findAll(
		int start, int end,
		OrderByComparator<ElectroEmployee> orderByComparator,
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

		List<ElectroEmployee> list = null;

		if (useFinderCache) {
			list = (List<ElectroEmployee>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELECTROEMPLOYEE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELECTROEMPLOYEE;

				sql = sql.concat(ElectroEmployeeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ElectroEmployee>)QueryUtil.list(
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
	 * Removes all the electro employees from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ElectroEmployee electroEmployee : findAll()) {
			remove(electroEmployee);
		}
	}

	/**
	 * Returns the number of electro employees.
	 *
	 * @return the number of electro employees
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELECTROEMPLOYEE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELECTROEMPLOYEE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElectroEmployeeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the electro employee persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ElectroEmployeeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ElectroEmployee.class.getName()));

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

		_finderPathWithPaginationFindByEmployee = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployee",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ElectroTypeId"}, true);

		_finderPathWithoutPaginationFindByEmployee = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployee",
			new String[] {Long.class.getName()}, new String[] {"ElectroTypeId"},
			true);

		_finderPathCountByEmployee = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployee",
			new String[] {Long.class.getName()}, new String[] {"ElectroTypeId"},
			false);

		_finderPathWithPaginationFindByElectroType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByElectroType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByElectroType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByElectroType",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByElectroType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByElectroType",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_setElectroEmployeeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setElectroEmployeeUtilPersistence(null);

		entityCache.removeCache(ElectroEmployeeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setElectroEmployeeUtilPersistence(
		ElectroEmployeePersistence electroEmployeePersistence) {

		try {
			Field field = ElectroEmployeeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, electroEmployeePersistence);
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

	private static final String _SQL_SELECT_ELECTROEMPLOYEE =
		"SELECT electroEmployee FROM ElectroEmployee electroEmployee";

	private static final String _SQL_SELECT_ELECTROEMPLOYEE_WHERE =
		"SELECT electroEmployee FROM ElectroEmployee electroEmployee WHERE ";

	private static final String _SQL_COUNT_ELECTROEMPLOYEE =
		"SELECT COUNT(electroEmployee) FROM ElectroEmployee electroEmployee";

	private static final String _SQL_COUNT_ELECTROEMPLOYEE_WHERE =
		"SELECT COUNT(electroEmployee) FROM ElectroEmployee electroEmployee WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "electroEmployee.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ElectroEmployee exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ElectroEmployee exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ElectroEmployeePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

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

	private static class ElectroEmployeeModelArgumentsResolver
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

			ElectroEmployeeModelImpl electroEmployeeModelImpl =
				(ElectroEmployeeModelImpl)baseModel;

			long columnBitmask = electroEmployeeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					electroEmployeeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						electroEmployeeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					electroEmployeeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ElectroEmployeeModelImpl electroEmployeeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						electroEmployeeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = electroEmployeeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}