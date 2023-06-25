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

import com.isands.service.builder.exception.NoSuchElectronicsException;
import com.isands.service.builder.model.Electronics;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the electronics service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicsUtil
 * @generated
 */
@ProviderType
public interface ElectronicsPersistence extends BasePersistence<Electronics> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElectronicsUtil} to access the electronics persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the electronicses where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching electronicses
	 */
	public java.util.List<Electronics> findByElectronicsName(String name);

	/**
	 * Returns a range of all the electronicses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @return the range of matching electronicses
	 */
	public java.util.List<Electronics> findByElectronicsName(
		String name, int start, int end);

	/**
	 * Returns an ordered range of all the electronicses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electronicses
	 */
	public java.util.List<Electronics> findByElectronicsName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator);

	/**
	 * Returns an ordered range of all the electronicses where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electronicses
	 */
	public java.util.List<Electronics> findByElectronicsName(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first electronics in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics
	 * @throws NoSuchElectronicsException if a matching electronics could not be found
	 */
	public Electronics findByElectronicsName_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Electronics>
				orderByComparator)
		throws NoSuchElectronicsException;

	/**
	 * Returns the first electronics in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics, or <code>null</code> if a matching electronics could not be found
	 */
	public Electronics fetchByElectronicsName_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator);

	/**
	 * Returns the last electronics in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics
	 * @throws NoSuchElectronicsException if a matching electronics could not be found
	 */
	public Electronics findByElectronicsName_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Electronics>
				orderByComparator)
		throws NoSuchElectronicsException;

	/**
	 * Returns the last electronics in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics, or <code>null</code> if a matching electronics could not be found
	 */
	public Electronics fetchByElectronicsName_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator);

	/**
	 * Returns the electronicses before and after the current electronics in the ordered set where name = &#63;.
	 *
	 * @param electronicsId the primary key of the current electronics
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electronics
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	public Electronics[] findByElectronicsName_PrevAndNext(
			long electronicsId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Electronics>
				orderByComparator)
		throws NoSuchElectronicsException;

	/**
	 * Removes all the electronicses where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByElectronicsName(String name);

	/**
	 * Returns the number of electronicses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching electronicses
	 */
	public int countByElectronicsName(String name);

	/**
	 * Returns the electronics where name = &#63; or throws a <code>NoSuchElectronicsException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching electronics
	 * @throws NoSuchElectronicsException if a matching electronics could not be found
	 */
	public Electronics findByName(String name)
		throws NoSuchElectronicsException;

	/**
	 * Returns the electronics where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching electronics, or <code>null</code> if a matching electronics could not be found
	 */
	public Electronics fetchByName(String name);

	/**
	 * Returns the electronics where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching electronics, or <code>null</code> if a matching electronics could not be found
	 */
	public Electronics fetchByName(String name, boolean useFinderCache);

	/**
	 * Removes the electronics where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the electronics that was removed
	 */
	public Electronics removeByName(String name)
		throws NoSuchElectronicsException;

	/**
	 * Returns the number of electronicses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching electronicses
	 */
	public int countByName(String name);

	/**
	 * Returns all the electronicses where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @return the matching electronicses
	 */
	public java.util.List<Electronics> findByElectroType(long ElectroTypeId);

	/**
	 * Returns a range of all the electronicses where ElectroTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @return the range of matching electronicses
	 */
	public java.util.List<Electronics> findByElectroType(
		long ElectroTypeId, int start, int end);

	/**
	 * Returns an ordered range of all the electronicses where ElectroTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electronicses
	 */
	public java.util.List<Electronics> findByElectroType(
		long ElectroTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator);

	/**
	 * Returns an ordered range of all the electronicses where ElectroTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electronicses
	 */
	public java.util.List<Electronics> findByElectroType(
		long ElectroTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first electronics in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics
	 * @throws NoSuchElectronicsException if a matching electronics could not be found
	 */
	public Electronics findByElectroType_First(
			long ElectroTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Electronics>
				orderByComparator)
		throws NoSuchElectronicsException;

	/**
	 * Returns the first electronics in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronics, or <code>null</code> if a matching electronics could not be found
	 */
	public Electronics fetchByElectroType_First(
		long ElectroTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator);

	/**
	 * Returns the last electronics in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics
	 * @throws NoSuchElectronicsException if a matching electronics could not be found
	 */
	public Electronics findByElectroType_Last(
			long ElectroTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Electronics>
				orderByComparator)
		throws NoSuchElectronicsException;

	/**
	 * Returns the last electronics in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronics, or <code>null</code> if a matching electronics could not be found
	 */
	public Electronics fetchByElectroType_Last(
		long ElectroTypeId,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator);

	/**
	 * Returns the electronicses before and after the current electronics in the ordered set where ElectroTypeId = &#63;.
	 *
	 * @param electronicsId the primary key of the current electronics
	 * @param ElectroTypeId the electro type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electronics
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	public Electronics[] findByElectroType_PrevAndNext(
			long electronicsId, long ElectroTypeId,
			com.liferay.portal.kernel.util.OrderByComparator<Electronics>
				orderByComparator)
		throws NoSuchElectronicsException;

	/**
	 * Removes all the electronicses where ElectroTypeId = &#63; from the database.
	 *
	 * @param ElectroTypeId the electro type ID
	 */
	public void removeByElectroType(long ElectroTypeId);

	/**
	 * Returns the number of electronicses where ElectroTypeId = &#63;.
	 *
	 * @param ElectroTypeId the electro type ID
	 * @return the number of matching electronicses
	 */
	public int countByElectroType(long ElectroTypeId);

	/**
	 * Caches the electronics in the entity cache if it is enabled.
	 *
	 * @param electronics the electronics
	 */
	public void cacheResult(Electronics electronics);

	/**
	 * Caches the electronicses in the entity cache if it is enabled.
	 *
	 * @param electronicses the electronicses
	 */
	public void cacheResult(java.util.List<Electronics> electronicses);

	/**
	 * Creates a new electronics with the primary key. Does not add the electronics to the database.
	 *
	 * @param electronicsId the primary key for the new electronics
	 * @return the new electronics
	 */
	public Electronics create(long electronicsId);

	/**
	 * Removes the electronics with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electronicsId the primary key of the electronics
	 * @return the electronics that was removed
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	public Electronics remove(long electronicsId)
		throws NoSuchElectronicsException;

	public Electronics updateImpl(Electronics electronics);

	/**
	 * Returns the electronics with the primary key or throws a <code>NoSuchElectronicsException</code> if it could not be found.
	 *
	 * @param electronicsId the primary key of the electronics
	 * @return the electronics
	 * @throws NoSuchElectronicsException if a electronics with the primary key could not be found
	 */
	public Electronics findByPrimaryKey(long electronicsId)
		throws NoSuchElectronicsException;

	/**
	 * Returns the electronics with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electronicsId the primary key of the electronics
	 * @return the electronics, or <code>null</code> if a electronics with the primary key could not be found
	 */
	public Electronics fetchByPrimaryKey(long electronicsId);

	/**
	 * Returns all the electronicses.
	 *
	 * @return the electronicses
	 */
	public java.util.List<Electronics> findAll();

	/**
	 * Returns a range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @return the range of electronicses
	 */
	public java.util.List<Electronics> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electronicses
	 */
	public java.util.List<Electronics> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator);

	/**
	 * Returns an ordered range of all the electronicses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronicses
	 * @param end the upper bound of the range of electronicses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electronicses
	 */
	public java.util.List<Electronics> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronics>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the electronicses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of electronicses.
	 *
	 * @return the number of electronicses
	 */
	public int countAll();

}