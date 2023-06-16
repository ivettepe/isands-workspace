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

package com.isands.service.builder.service.persistence.test;

import com.isands.service.builder.exception.NoSuchElectronicsException;
import com.isands.service.builder.model.Electronics;
import com.isands.service.builder.service.ElectronicsLocalServiceUtil;
import com.isands.service.builder.service.persistence.ElectronicsPersistence;
import com.isands.service.builder.service.persistence.ElectronicsUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ElectronicsPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.isands.service.builder.service"));

	@Before
	public void setUp() {
		_persistence = ElectronicsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Electronics> iterator = _electronicses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronics electronics = _persistence.create(pk);

		Assert.assertNotNull(electronics);

		Assert.assertEquals(electronics.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Electronics newElectronics = addElectronics();

		_persistence.remove(newElectronics);

		Electronics existingElectronics = _persistence.fetchByPrimaryKey(
			newElectronics.getPrimaryKey());

		Assert.assertNull(existingElectronics);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addElectronics();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronics newElectronics = _persistence.create(pk);

		newElectronics.setMvccVersion(RandomTestUtil.nextLong());

		newElectronics.setName(RandomTestUtil.randomString());

		newElectronics.setElectroTypeId(RandomTestUtil.nextLong());

		newElectronics.setPrice(RandomTestUtil.nextLong());

		newElectronics.setCount(RandomTestUtil.nextInt());

		newElectronics.setInStock(RandomTestUtil.randomBoolean());

		newElectronics.setArchive(RandomTestUtil.randomBoolean());

		newElectronics.setDescription(RandomTestUtil.randomString());

		newElectronics.setCompanyId(RandomTestUtil.nextLong());

		_electronicses.add(_persistence.update(newElectronics));

		Electronics existingElectronics = _persistence.findByPrimaryKey(
			newElectronics.getPrimaryKey());

		Assert.assertEquals(
			existingElectronics.getMvccVersion(),
			newElectronics.getMvccVersion());
		Assert.assertEquals(
			existingElectronics.getElectronicsId(),
			newElectronics.getElectronicsId());
		Assert.assertEquals(
			existingElectronics.getName(), newElectronics.getName());
		Assert.assertEquals(
			existingElectronics.getElectroTypeId(),
			newElectronics.getElectroTypeId());
		Assert.assertEquals(
			existingElectronics.getPrice(), newElectronics.getPrice());
		Assert.assertEquals(
			existingElectronics.getCount(), newElectronics.getCount());
		Assert.assertEquals(
			existingElectronics.isInStock(), newElectronics.isInStock());
		Assert.assertEquals(
			existingElectronics.isArchive(), newElectronics.isArchive());
		Assert.assertEquals(
			existingElectronics.getDescription(),
			newElectronics.getDescription());
		Assert.assertEquals(
			existingElectronics.getCompanyId(), newElectronics.getCompanyId());
	}

	@Test
	public void testCountByElectronicsName() throws Exception {
		_persistence.countByElectronicsName("");

		_persistence.countByElectronicsName("null");

		_persistence.countByElectronicsName((String)null);
	}

	@Test
	public void testCountByName() throws Exception {
		_persistence.countByName("");

		_persistence.countByName("null");

		_persistence.countByName((String)null);
	}

	@Test
	public void testCountByElectroType() throws Exception {
		_persistence.countByElectroType(RandomTestUtil.nextLong());

		_persistence.countByElectroType(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Electronics newElectronics = addElectronics();

		Electronics existingElectronics = _persistence.findByPrimaryKey(
			newElectronics.getPrimaryKey());

		Assert.assertEquals(existingElectronics, newElectronics);
	}

	@Test(expected = NoSuchElectronicsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Electronics> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"isands_Electronics", "mvccVersion", true, "electronicsId", true,
			"name", true, "ElectroTypeId", true, "price", true, "count", true,
			"inStock", true, "archive", true, "description", true, "companyId",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Electronics newElectronics = addElectronics();

		Electronics existingElectronics = _persistence.fetchByPrimaryKey(
			newElectronics.getPrimaryKey());

		Assert.assertEquals(existingElectronics, newElectronics);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronics missingElectronics = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingElectronics);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Electronics newElectronics1 = addElectronics();
		Electronics newElectronics2 = addElectronics();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronics1.getPrimaryKey());
		primaryKeys.add(newElectronics2.getPrimaryKey());

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, electronicses.size());
		Assert.assertEquals(
			newElectronics1,
			electronicses.get(newElectronics1.getPrimaryKey()));
		Assert.assertEquals(
			newElectronics2,
			electronicses.get(newElectronics2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronicses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Electronics newElectronics = addElectronics();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronics.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronicses.size());
		Assert.assertEquals(
			newElectronics, electronicses.get(newElectronics.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronicses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Electronics newElectronics = addElectronics();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronics.getPrimaryKey());

		Map<Serializable, Electronics> electronicses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronicses.size());
		Assert.assertEquals(
			newElectronics, electronicses.get(newElectronics.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ElectronicsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Electronics>() {

				@Override
				public void performAction(Electronics electronics) {
					Assert.assertNotNull(electronics);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Electronics newElectronics = addElectronics();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"electronicsId", newElectronics.getElectronicsId()));

		List<Electronics> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Electronics existingElectronics = result.get(0);

		Assert.assertEquals(existingElectronics, newElectronics);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"electronicsId", RandomTestUtil.nextLong()));

		List<Electronics> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Electronics newElectronics = addElectronics();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("electronicsId"));

		Object newElectronicsId = newElectronics.getElectronicsId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"electronicsId", new Object[] {newElectronicsId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingElectronicsId = result.get(0);

		Assert.assertEquals(existingElectronicsId, newElectronicsId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("electronicsId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"electronicsId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Electronics newElectronics = addElectronics();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newElectronics.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Electronics newElectronics = addElectronics();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronics.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"electronicsId", newElectronics.getElectronicsId()));

		List<Electronics> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Electronics electronics) {
		Assert.assertEquals(
			electronics.getName(),
			ReflectionTestUtil.invoke(
				electronics, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "name"));
	}

	protected Electronics addElectronics() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronics electronics = _persistence.create(pk);

		electronics.setMvccVersion(RandomTestUtil.nextLong());

		electronics.setName(RandomTestUtil.randomString());

		electronics.setElectroTypeId(RandomTestUtil.nextLong());

		electronics.setPrice(RandomTestUtil.nextLong());

		electronics.setCount(RandomTestUtil.nextInt());

		electronics.setInStock(RandomTestUtil.randomBoolean());

		electronics.setArchive(RandomTestUtil.randomBoolean());

		electronics.setDescription(RandomTestUtil.randomString());

		electronics.setCompanyId(RandomTestUtil.nextLong());

		_electronicses.add(_persistence.update(electronics));

		return electronics;
	}

	private List<Electronics> _electronicses = new ArrayList<Electronics>();
	private ElectronicsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}