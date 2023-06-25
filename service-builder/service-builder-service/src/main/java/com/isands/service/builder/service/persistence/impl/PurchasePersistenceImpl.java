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

import com.isands.service.builder.exception.NoSuchPurchaseException;
import com.isands.service.builder.model.Purchase;
import com.isands.service.builder.model.impl.PurchaseImpl;
import com.isands.service.builder.model.impl.PurchaseModelImpl;
import com.isands.service.builder.service.persistence.PurchasePersistence;
import com.isands.service.builder.service.persistence.PurchaseUtil;
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
 * The persistence implementation for the purchase service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PurchasePersistence.class)
public class PurchasePersistenceImpl
	extends BasePersistenceImpl<Purchase> implements PurchasePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PurchaseUtil</code> to access the purchase persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PurchaseImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByEmployeeId;
	private FinderPath _finderPathWithoutPaginationFindByEmployeeId;
	private FinderPath _finderPathCountByEmployeeId;

	/**
	 * Returns all the purchases where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByEmployeeId(long employeeId) {
		return findByEmployeeId(
			employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByEmployeeId(
		long employeeId, int start, int end) {

		return findByEmployeeId(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByEmployeeId(
			employeeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmployeeId;
				finderArgs = new Object[] {employeeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeId;
			finderArgs = new Object[] {
				employeeId, start, end, orderByComparator
			};
		}

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if (employeeId != purchase.getEmployeeId()) {
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

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByEmployeeId_First(
			long employeeId, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByEmployeeId_First(
			employeeId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByEmployeeId_First(
		long employeeId, OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByEmployeeId(
			employeeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByEmployeeId_Last(
			long employeeId, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByEmployeeId_Last(
			employeeId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<Purchase> orderByComparator) {

		int count = countByEmployeeId(employeeId);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByEmployeeId(
			employeeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByEmployeeId_PrevAndNext(
			long purchaseId, long employeeId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByEmployeeId_PrevAndNext(
				session, purchase, employeeId, orderByComparator, true);

			array[1] = purchase;

			array[2] = getByEmployeeId_PrevAndNext(
				session, purchase, employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Purchase getByEmployeeId_PrevAndNext(
		Session session, Purchase purchase, long employeeId,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEID_EMPLOYEEID_2);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	@Override
	public void removeByEmployeeId(long employeeId) {
		for (Purchase purchase :
				findByEmployeeId(
					employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByEmployeeId(long employeeId) {
		FinderPath finderPath = _finderPathCountByEmployeeId;

		Object[] finderArgs = new Object[] {employeeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

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
		"purchase.employeeId = ?";

	private FinderPath _finderPathWithPaginationFindByElectronicsId;
	private FinderPath _finderPathWithoutPaginationFindByElectronicsId;
	private FinderPath _finderPathCountByElectronicsId;

	/**
	 * Returns all the purchases where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByElectronicsId(long electronicsId) {
		return findByElectronicsId(
			electronicsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases where electronicsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param electronicsId the electronics ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByElectronicsId(
		long electronicsId, int start, int end) {

		return findByElectronicsId(electronicsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where electronicsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param electronicsId the electronics ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByElectronicsId(
		long electronicsId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByElectronicsId(
			electronicsId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where electronicsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param electronicsId the electronics ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByElectronicsId(
		long electronicsId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByElectronicsId;
				finderArgs = new Object[] {electronicsId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByElectronicsId;
			finderArgs = new Object[] {
				electronicsId, start, end, orderByComparator
			};
		}

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if (electronicsId != purchase.getElectronicsId()) {
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

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_ELECTRONICSID_ELECTRONICSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(electronicsId);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByElectronicsId_First(
			long electronicsId, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByElectronicsId_First(
			electronicsId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("electronicsId=");
		sb.append(electronicsId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByElectronicsId_First(
		long electronicsId, OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByElectronicsId(
			electronicsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByElectronicsId_Last(
			long electronicsId, OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByElectronicsId_Last(
			electronicsId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("electronicsId=");
		sb.append(electronicsId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByElectronicsId_Last(
		long electronicsId, OrderByComparator<Purchase> orderByComparator) {

		int count = countByElectronicsId(electronicsId);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByElectronicsId(
			electronicsId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByElectronicsId_PrevAndNext(
			long purchaseId, long electronicsId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByElectronicsId_PrevAndNext(
				session, purchase, electronicsId, orderByComparator, true);

			array[1] = purchase;

			array[2] = getByElectronicsId_PrevAndNext(
				session, purchase, electronicsId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Purchase getByElectronicsId_PrevAndNext(
		Session session, Purchase purchase, long electronicsId,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

		sb.append(_FINDER_COLUMN_ELECTRONICSID_ELECTRONICSID_2);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(electronicsId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where electronicsId = &#63; from the database.
	 *
	 * @param electronicsId the electronics ID
	 */
	@Override
	public void removeByElectronicsId(long electronicsId) {
		for (Purchase purchase :
				findByElectronicsId(
					electronicsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByElectronicsId(long electronicsId) {
		FinderPath finderPath = _finderPathCountByElectronicsId;

		Object[] finderArgs = new Object[] {electronicsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_ELECTRONICSID_ELECTRONICSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(electronicsId);

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

	private static final String _FINDER_COLUMN_ELECTRONICSID_ELECTRONICSID_2 =
		"purchase.electronicsId = ?";

	private FinderPath _finderPathWithPaginationFindByEmployeeIdElectronicsId;
	private FinderPath
		_finderPathWithoutPaginationFindByEmployeeIdElectronicsId;
	private FinderPath _finderPathCountByEmployeeIdElectronicsId;

	/**
	 * Returns all the purchases where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @return the matching purchases
	 */
	@Override
	public List<Purchase> findByEmployeeIdElectronicsId(
		long employeeId, long electronicsId) {

		return findByEmployeeIdElectronicsId(
			employeeId, electronicsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the purchases where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of matching purchases
	 */
	@Override
	public List<Purchase> findByEmployeeIdElectronicsId(
		long employeeId, long electronicsId, int start, int end) {

		return findByEmployeeIdElectronicsId(
			employeeId, electronicsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByEmployeeIdElectronicsId(
		long employeeId, long electronicsId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return findByEmployeeIdElectronicsId(
			employeeId, electronicsId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching purchases
	 */
	@Override
	public List<Purchase> findByEmployeeIdElectronicsId(
		long employeeId, long electronicsId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEmployeeIdElectronicsId;
				finderArgs = new Object[] {employeeId, electronicsId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmployeeIdElectronicsId;
			finderArgs = new Object[] {
				employeeId, electronicsId, start, end, orderByComparator
			};
		}

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Purchase purchase : list) {
					if ((employeeId != purchase.getEmployeeId()) ||
						(electronicsId != purchase.getElectronicsId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDELECTRONICSID_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDELECTRONICSID_ELECTRONICSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(electronicsId);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Returns the first purchase in the ordered set where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByEmployeeIdElectronicsId_First(
			long employeeId, long electronicsId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByEmployeeIdElectronicsId_First(
			employeeId, electronicsId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", electronicsId=");
		sb.append(electronicsId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the first purchase in the ordered set where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByEmployeeIdElectronicsId_First(
		long employeeId, long electronicsId,
		OrderByComparator<Purchase> orderByComparator) {

		List<Purchase> list = findByEmployeeIdElectronicsId(
			employeeId, electronicsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last purchase in the ordered set where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	@Override
	public Purchase findByEmployeeIdElectronicsId_Last(
			long employeeId, long electronicsId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByEmployeeIdElectronicsId_Last(
			employeeId, electronicsId, orderByComparator);

		if (purchase != null) {
			return purchase;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("employeeId=");
		sb.append(employeeId);

		sb.append(", electronicsId=");
		sb.append(electronicsId);

		sb.append("}");

		throw new NoSuchPurchaseException(sb.toString());
	}

	/**
	 * Returns the last purchase in the ordered set where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	@Override
	public Purchase fetchByEmployeeIdElectronicsId_Last(
		long employeeId, long electronicsId,
		OrderByComparator<Purchase> orderByComparator) {

		int count = countByEmployeeIdElectronicsId(employeeId, electronicsId);

		if (count == 0) {
			return null;
		}

		List<Purchase> list = findByEmployeeIdElectronicsId(
			employeeId, electronicsId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the purchases before and after the current purchase in the ordered set where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param purchaseId the primary key of the current purchase
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase[] findByEmployeeIdElectronicsId_PrevAndNext(
			long purchaseId, long employeeId, long electronicsId,
			OrderByComparator<Purchase> orderByComparator)
		throws NoSuchPurchaseException {

		Purchase purchase = findByPrimaryKey(purchaseId);

		Session session = null;

		try {
			session = openSession();

			Purchase[] array = new PurchaseImpl[3];

			array[0] = getByEmployeeIdElectronicsId_PrevAndNext(
				session, purchase, employeeId, electronicsId, orderByComparator,
				true);

			array[1] = purchase;

			array[2] = getByEmployeeIdElectronicsId_PrevAndNext(
				session, purchase, employeeId, electronicsId, orderByComparator,
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

	protected Purchase getByEmployeeIdElectronicsId_PrevAndNext(
		Session session, Purchase purchase, long employeeId, long electronicsId,
		OrderByComparator<Purchase> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PURCHASE_WHERE);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDELECTRONICSID_EMPLOYEEID_2);

		sb.append(_FINDER_COLUMN_EMPLOYEEIDELECTRONICSID_ELECTRONICSID_2);

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
			sb.append(PurchaseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(employeeId);

		queryPos.add(electronicsId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(purchase)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Purchase> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the purchases where employeeId = &#63; and electronicsId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 */
	@Override
	public void removeByEmployeeIdElectronicsId(
		long employeeId, long electronicsId) {

		for (Purchase purchase :
				findByEmployeeIdElectronicsId(
					employeeId, electronicsId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @return the number of matching purchases
	 */
	@Override
	public int countByEmployeeIdElectronicsId(
		long employeeId, long electronicsId) {

		FinderPath finderPath = _finderPathCountByEmployeeIdElectronicsId;

		Object[] finderArgs = new Object[] {employeeId, electronicsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PURCHASE_WHERE);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDELECTRONICSID_EMPLOYEEID_2);

			sb.append(_FINDER_COLUMN_EMPLOYEEIDELECTRONICSID_ELECTRONICSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(employeeId);

				queryPos.add(electronicsId);

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

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDELECTRONICSID_EMPLOYEEID_2 =
			"purchase.employeeId = ? AND ";

	private static final String
		_FINDER_COLUMN_EMPLOYEEIDELECTRONICSID_ELECTRONICSID_2 =
			"purchase.electronicsId = ?";

	public PurchasePersistenceImpl() {
		setModelClass(Purchase.class);

		setModelImplClass(PurchaseImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the purchase in the entity cache if it is enabled.
	 *
	 * @param purchase the purchase
	 */
	@Override
	public void cacheResult(Purchase purchase) {
		entityCache.putResult(
			PurchaseImpl.class, purchase.getPrimaryKey(), purchase);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the purchases in the entity cache if it is enabled.
	 *
	 * @param purchases the purchases
	 */
	@Override
	public void cacheResult(List<Purchase> purchases) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (purchases.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Purchase purchase : purchases) {
			if (entityCache.getResult(
					PurchaseImpl.class, purchase.getPrimaryKey()) == null) {

				cacheResult(purchase);
			}
		}
	}

	/**
	 * Clears the cache for all purchases.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PurchaseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the purchase.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Purchase purchase) {
		entityCache.removeResult(PurchaseImpl.class, purchase);
	}

	@Override
	public void clearCache(List<Purchase> purchases) {
		for (Purchase purchase : purchases) {
			entityCache.removeResult(PurchaseImpl.class, purchase);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PurchaseImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new purchase with the primary key. Does not add the purchase to the database.
	 *
	 * @param purchaseId the primary key for the new purchase
	 * @return the new purchase
	 */
	@Override
	public Purchase create(long purchaseId) {
		Purchase purchase = new PurchaseImpl();

		purchase.setNew(true);
		purchase.setPrimaryKey(purchaseId);

		purchase.setCompanyId(CompanyThreadLocal.getCompanyId());

		return purchase;
	}

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase remove(long purchaseId) throws NoSuchPurchaseException {
		return remove((Serializable)purchaseId);
	}

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase remove(Serializable primaryKey)
		throws NoSuchPurchaseException {

		Session session = null;

		try {
			session = openSession();

			Purchase purchase = (Purchase)session.get(
				PurchaseImpl.class, primaryKey);

			if (purchase == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPurchaseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(purchase);
		}
		catch (NoSuchPurchaseException noSuchEntityException) {
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
	protected Purchase removeImpl(Purchase purchase) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(purchase)) {
				purchase = (Purchase)session.get(
					PurchaseImpl.class, purchase.getPrimaryKeyObj());
			}

			if (purchase != null) {
				session.delete(purchase);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (purchase != null) {
			clearCache(purchase);
		}

		return purchase;
	}

	@Override
	public Purchase updateImpl(Purchase purchase) {
		boolean isNew = purchase.isNew();

		if (!(purchase instanceof PurchaseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(purchase.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(purchase);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in purchase proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Purchase implementation " +
					purchase.getClass());
		}

		PurchaseModelImpl purchaseModelImpl = (PurchaseModelImpl)purchase;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(purchase);
			}
			else {
				purchase = (Purchase)session.merge(purchase);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PurchaseImpl.class, purchaseModelImpl, false, true);

		if (isNew) {
			purchase.setNew(false);
		}

		purchase.resetOriginalValues();

		return purchase;
	}

	/**
	 * Returns the purchase with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPurchaseException {

		Purchase purchase = fetchByPrimaryKey(primaryKey);

		if (purchase == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPurchaseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return purchase;
	}

	/**
	 * Returns the purchase with the primary key or throws a <code>NoSuchPurchaseException</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase findByPrimaryKey(long purchaseId)
		throws NoSuchPurchaseException {

		return findByPrimaryKey((Serializable)purchaseId);
	}

	/**
	 * Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	 */
	@Override
	public Purchase fetchByPrimaryKey(long purchaseId) {
		return fetchByPrimaryKey((Serializable)purchaseId);
	}

	/**
	 * Returns all the purchases.
	 *
	 * @return the purchases
	 */
	@Override
	public List<Purchase> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of purchases
	 */
	@Override
	public List<Purchase> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of purchases
	 */
	@Override
	public List<Purchase> findAll(
		int start, int end, OrderByComparator<Purchase> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of purchases
	 */
	@Override
	public List<Purchase> findAll(
		int start, int end, OrderByComparator<Purchase> orderByComparator,
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

		List<Purchase> list = null;

		if (useFinderCache) {
			list = (List<Purchase>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PURCHASE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PURCHASE;

				sql = sql.concat(PurchaseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Purchase>)QueryUtil.list(
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
	 * Removes all the purchases from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Purchase purchase : findAll()) {
			remove(purchase);
		}
	}

	/**
	 * Returns the number of purchases.
	 *
	 * @return the number of purchases
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PURCHASE);

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
		return "purchaseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PURCHASE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PurchaseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the purchase persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PurchaseModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Purchase.class.getName()));

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

		_finderPathWithPaginationFindByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployeeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"employeeId"}, true);

		_finderPathWithoutPaginationFindByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			true);

		_finderPathCountByEmployeeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployeeId",
			new String[] {Long.class.getName()}, new String[] {"employeeId"},
			false);

		_finderPathWithPaginationFindByElectronicsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByElectronicsId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"electronicsId"}, true);

		_finderPathWithoutPaginationFindByElectronicsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByElectronicsId",
			new String[] {Long.class.getName()}, new String[] {"electronicsId"},
			true);

		_finderPathCountByElectronicsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByElectronicsId",
			new String[] {Long.class.getName()}, new String[] {"electronicsId"},
			false);

		_finderPathWithPaginationFindByEmployeeIdElectronicsId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByEmployeeIdElectronicsId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"employeeId", "electronicsId"}, true);

		_finderPathWithoutPaginationFindByEmployeeIdElectronicsId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByEmployeeIdElectronicsId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"employeeId", "electronicsId"}, true);

		_finderPathCountByEmployeeIdElectronicsId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmployeeIdElectronicsId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"employeeId", "electronicsId"}, false);

		_setPurchaseUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPurchaseUtilPersistence(null);

		entityCache.removeCache(PurchaseImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setPurchaseUtilPersistence(
		PurchasePersistence purchasePersistence) {

		try {
			Field field = PurchaseUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, purchasePersistence);
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

	private static final String _SQL_SELECT_PURCHASE =
		"SELECT purchase FROM Purchase purchase";

	private static final String _SQL_SELECT_PURCHASE_WHERE =
		"SELECT purchase FROM Purchase purchase WHERE ";

	private static final String _SQL_COUNT_PURCHASE =
		"SELECT COUNT(purchase) FROM Purchase purchase";

	private static final String _SQL_COUNT_PURCHASE_WHERE =
		"SELECT COUNT(purchase) FROM Purchase purchase WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "purchase.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Purchase exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Purchase exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PurchasePersistenceImpl.class);

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

	private static class PurchaseModelArgumentsResolver
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

			PurchaseModelImpl purchaseModelImpl = (PurchaseModelImpl)baseModel;

			long columnBitmask = purchaseModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(purchaseModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						purchaseModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PurchasePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(purchaseModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PurchaseModelImpl purchaseModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = purchaseModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = purchaseModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			orderByColumnsBitmask |= PurchaseModelImpl.getColumnBitmask(
				"purchaseDate");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}