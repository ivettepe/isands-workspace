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

import com.isands.service.builder.model.Purchase;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the purchase service. This utility wraps <code>com.isands.service.builder.service.persistence.impl.PurchasePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PurchasePersistence
 * @generated
 */
public class PurchaseUtil {

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
	public static void clearCache(Purchase purchase) {
		getPersistence().clearCache(purchase);
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
	public static Map<Serializable, Purchase> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Purchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Purchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Purchase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Purchase update(Purchase purchase) {
		return getPersistence().update(purchase);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Purchase update(
		Purchase purchase, ServiceContext serviceContext) {

		return getPersistence().update(purchase, serviceContext);
	}

	/**
	 * Returns all the purchases where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching purchases
	 */
	public static List<Purchase> findByEmployeeId(long employeeId) {
		return getPersistence().findByEmployeeId(employeeId);
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
	public static List<Purchase> findByEmployeeId(
		long employeeId, int start, int end) {

		return getPersistence().findByEmployeeId(employeeId, start, end);
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
	public static List<Purchase> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator);
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
	public static List<Purchase> findByEmployeeId(
		long employeeId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			employeeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByEmployeeId_First(
			long employeeId, OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the first purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByEmployeeId_First(
		long employeeId, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByEmployeeId_Last(
			long employeeId, OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByEmployeeId_Last(
			employeeId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByEmployeeId_Last(
		long employeeId, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			employeeId, orderByComparator);
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
	public static Purchase[] findByEmployeeId_PrevAndNext(
			long purchaseId, long employeeId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			purchaseId, employeeId, orderByComparator);
	}

	/**
	 * Removes all the purchases where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 */
	public static void removeByEmployeeId(long employeeId) {
		getPersistence().removeByEmployeeId(employeeId);
	}

	/**
	 * Returns the number of purchases where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching purchases
	 */
	public static int countByEmployeeId(long employeeId) {
		return getPersistence().countByEmployeeId(employeeId);
	}

	/**
	 * Returns all the purchases where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @return the matching purchases
	 */
	public static List<Purchase> findByElectronicsId(long electronicsId) {
		return getPersistence().findByElectronicsId(electronicsId);
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
	public static List<Purchase> findByElectronicsId(
		long electronicsId, int start, int end) {

		return getPersistence().findByElectronicsId(electronicsId, start, end);
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
	public static List<Purchase> findByElectronicsId(
		long electronicsId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findByElectronicsId(
			electronicsId, start, end, orderByComparator);
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
	public static List<Purchase> findByElectronicsId(
		long electronicsId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByElectronicsId(
			electronicsId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByElectronicsId_First(
			long electronicsId, OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByElectronicsId_First(
			electronicsId, orderByComparator);
	}

	/**
	 * Returns the first purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByElectronicsId_First(
		long electronicsId, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByElectronicsId_First(
			electronicsId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase
	 * @throws NoSuchPurchaseException if a matching purchase could not be found
	 */
	public static Purchase findByElectronicsId_Last(
			long electronicsId, OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByElectronicsId_Last(
			electronicsId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByElectronicsId_Last(
		long electronicsId, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByElectronicsId_Last(
			electronicsId, orderByComparator);
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
	public static Purchase[] findByElectronicsId_PrevAndNext(
			long purchaseId, long electronicsId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByElectronicsId_PrevAndNext(
			purchaseId, electronicsId, orderByComparator);
	}

	/**
	 * Removes all the purchases where electronicsId = &#63; from the database.
	 *
	 * @param electronicsId the electronics ID
	 */
	public static void removeByElectronicsId(long electronicsId) {
		getPersistence().removeByElectronicsId(electronicsId);
	}

	/**
	 * Returns the number of purchases where electronicsId = &#63;.
	 *
	 * @param electronicsId the electronics ID
	 * @return the number of matching purchases
	 */
	public static int countByElectronicsId(long electronicsId) {
		return getPersistence().countByElectronicsId(electronicsId);
	}

	/**
	 * Returns all the purchases where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @return the matching purchases
	 */
	public static List<Purchase> findByEmployeeIdElectronicsId(
		long employeeId, long electronicsId) {

		return getPersistence().findByEmployeeIdElectronicsId(
			employeeId, electronicsId);
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
	public static List<Purchase> findByEmployeeIdElectronicsId(
		long employeeId, long electronicsId, int start, int end) {

		return getPersistence().findByEmployeeIdElectronicsId(
			employeeId, electronicsId, start, end);
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
	public static List<Purchase> findByEmployeeIdElectronicsId(
		long employeeId, long electronicsId, int start, int end,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findByEmployeeIdElectronicsId(
			employeeId, electronicsId, start, end, orderByComparator);
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
	public static List<Purchase> findByEmployeeIdElectronicsId(
		long employeeId, long electronicsId, int start, int end,
		OrderByComparator<Purchase> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEmployeeIdElectronicsId(
			employeeId, electronicsId, start, end, orderByComparator,
			useFinderCache);
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
	public static Purchase findByEmployeeIdElectronicsId_First(
			long employeeId, long electronicsId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByEmployeeIdElectronicsId_First(
			employeeId, electronicsId, orderByComparator);
	}

	/**
	 * Returns the first purchase in the ordered set where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByEmployeeIdElectronicsId_First(
		long employeeId, long electronicsId,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByEmployeeIdElectronicsId_First(
			employeeId, electronicsId, orderByComparator);
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
	public static Purchase findByEmployeeIdElectronicsId_Last(
			long employeeId, long electronicsId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByEmployeeIdElectronicsId_Last(
			employeeId, electronicsId, orderByComparator);
	}

	/**
	 * Returns the last purchase in the ordered set where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching purchase, or <code>null</code> if a matching purchase could not be found
	 */
	public static Purchase fetchByEmployeeIdElectronicsId_Last(
		long employeeId, long electronicsId,
		OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().fetchByEmployeeIdElectronicsId_Last(
			employeeId, electronicsId, orderByComparator);
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
	public static Purchase[] findByEmployeeIdElectronicsId_PrevAndNext(
			long purchaseId, long employeeId, long electronicsId,
			OrderByComparator<Purchase> orderByComparator)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByEmployeeIdElectronicsId_PrevAndNext(
			purchaseId, employeeId, electronicsId, orderByComparator);
	}

	/**
	 * Removes all the purchases where employeeId = &#63; and electronicsId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 */
	public static void removeByEmployeeIdElectronicsId(
		long employeeId, long electronicsId) {

		getPersistence().removeByEmployeeIdElectronicsId(
			employeeId, electronicsId);
	}

	/**
	 * Returns the number of purchases where employeeId = &#63; and electronicsId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param electronicsId the electronics ID
	 * @return the number of matching purchases
	 */
	public static int countByEmployeeIdElectronicsId(
		long employeeId, long electronicsId) {

		return getPersistence().countByEmployeeIdElectronicsId(
			employeeId, electronicsId);
	}

	/**
	 * Caches the purchase in the entity cache if it is enabled.
	 *
	 * @param purchase the purchase
	 */
	public static void cacheResult(Purchase purchase) {
		getPersistence().cacheResult(purchase);
	}

	/**
	 * Caches the purchases in the entity cache if it is enabled.
	 *
	 * @param purchases the purchases
	 */
	public static void cacheResult(List<Purchase> purchases) {
		getPersistence().cacheResult(purchases);
	}

	/**
	 * Creates a new purchase with the primary key. Does not add the purchase to the database.
	 *
	 * @param purchaseId the primary key for the new purchase
	 * @return the new purchase
	 */
	public static Purchase create(long purchaseId) {
		return getPersistence().create(purchaseId);
	}

	/**
	 * Removes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public static Purchase remove(long purchaseId)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().remove(purchaseId);
	}

	public static Purchase updateImpl(Purchase purchase) {
		return getPersistence().updateImpl(purchase);
	}

	/**
	 * Returns the purchase with the primary key or throws a <code>NoSuchPurchaseException</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase
	 * @throws NoSuchPurchaseException if a purchase with the primary key could not be found
	 */
	public static Purchase findByPrimaryKey(long purchaseId)
		throws com.isands.service.builder.exception.NoSuchPurchaseException {

		return getPersistence().findByPrimaryKey(purchaseId);
	}

	/**
	 * Returns the purchase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purchaseId the primary key of the purchase
	 * @return the purchase, or <code>null</code> if a purchase with the primary key could not be found
	 */
	public static Purchase fetchByPrimaryKey(long purchaseId) {
		return getPersistence().fetchByPrimaryKey(purchaseId);
	}

	/**
	 * Returns all the purchases.
	 *
	 * @return the purchases
	 */
	public static List<Purchase> findAll() {
		return getPersistence().findAll();
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
	public static List<Purchase> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Purchase> findAll(
		int start, int end, OrderByComparator<Purchase> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Purchase> findAll(
		int start, int end, OrderByComparator<Purchase> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the purchases from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of purchases.
	 *
	 * @return the number of purchases
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PurchasePersistence getPersistence() {
		return _persistence;
	}

	private static volatile PurchasePersistence _persistence;

}