/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchProduitException;
import com.df.lonis.ventesservice.model.Produit;
import com.df.lonis.ventesservice.service.ProduitLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.ProduitPersistence;
import com.df.lonis.ventesservice.service.persistence.ProduitUtil;

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
import com.liferay.portal.kernel.util.Time;
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
public class ProduitPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = ProduitUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Produit> iterator = _produits.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Produit produit = _persistence.create(pk);

		Assert.assertNotNull(produit);

		Assert.assertEquals(produit.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Produit newProduit = addProduit();

		_persistence.remove(newProduit);

		Produit existingProduit = _persistence.fetchByPrimaryKey(
			newProduit.getPrimaryKey());

		Assert.assertNull(existingProduit);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addProduit();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Produit newProduit = _persistence.create(pk);

		newProduit.setCode(RandomTestUtil.randomString());

		newProduit.setLibelle(RandomTestUtil.randomString());

		newProduit.setAbreviation(RandomTestUtil.randomString());

		newProduit.setActive(RandomTestUtil.randomBoolean());

		newProduit.setCreatedAt(RandomTestUtil.nextDate());

		newProduit.setUpdatedAt(RandomTestUtil.nextDate());

		_produits.add(_persistence.update(newProduit));

		Produit existingProduit = _persistence.findByPrimaryKey(
			newProduit.getPrimaryKey());

		Assert.assertEquals(existingProduit.getId(), newProduit.getId());
		Assert.assertEquals(existingProduit.getCode(), newProduit.getCode());
		Assert.assertEquals(
			existingProduit.getLibelle(), newProduit.getLibelle());
		Assert.assertEquals(
			existingProduit.getAbreviation(), newProduit.getAbreviation());
		Assert.assertEquals(existingProduit.isActive(), newProduit.isActive());
		Assert.assertEquals(
			Time.getShortTimestamp(existingProduit.getCreatedAt()),
			Time.getShortTimestamp(newProduit.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingProduit.getUpdatedAt()),
			Time.getShortTimestamp(newProduit.getUpdatedAt()));
	}

	@Test
	public void testCountByCode() throws Exception {
		_persistence.countByCode("");

		_persistence.countByCode("null");

		_persistence.countByCode((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Produit newProduit = addProduit();

		Produit existingProduit = _persistence.findByPrimaryKey(
			newProduit.getPrimaryKey());

		Assert.assertEquals(existingProduit, newProduit);
	}

	@Test(expected = NoSuchProduitException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Produit> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"produits", "id", true, "code", true, "libelle", true,
			"abreviation", true, "active", true, "createdAt", true, "updatedAt",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Produit newProduit = addProduit();

		Produit existingProduit = _persistence.fetchByPrimaryKey(
			newProduit.getPrimaryKey());

		Assert.assertEquals(existingProduit, newProduit);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Produit missingProduit = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingProduit);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Produit newProduit1 = addProduit();
		Produit newProduit2 = addProduit();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProduit1.getPrimaryKey());
		primaryKeys.add(newProduit2.getPrimaryKey());

		Map<Serializable, Produit> produits = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, produits.size());
		Assert.assertEquals(
			newProduit1, produits.get(newProduit1.getPrimaryKey()));
		Assert.assertEquals(
			newProduit2, produits.get(newProduit2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Produit> produits = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(produits.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Produit newProduit = addProduit();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProduit.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Produit> produits = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, produits.size());
		Assert.assertEquals(
			newProduit, produits.get(newProduit.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Produit> produits = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(produits.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Produit newProduit = addProduit();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProduit.getPrimaryKey());

		Map<Serializable, Produit> produits = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, produits.size());
		Assert.assertEquals(
			newProduit, produits.get(newProduit.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ProduitLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Produit>() {

				@Override
				public void performAction(Produit produit) {
					Assert.assertNotNull(produit);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Produit newProduit = addProduit();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Produit.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newProduit.getId()));

		List<Produit> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Produit existingProduit = result.get(0);

		Assert.assertEquals(existingProduit, newProduit);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Produit.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Produit> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Produit newProduit = addProduit();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Produit.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newProduit.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Produit.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Produit newProduit = addProduit();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newProduit.getPrimaryKey()));
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

		Produit newProduit = addProduit();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Produit.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newProduit.getId()));

		List<Produit> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Produit produit) {
		Assert.assertEquals(
			produit.getCode(),
			ReflectionTestUtil.invoke(
				produit, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "code"));
	}

	protected Produit addProduit() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Produit produit = _persistence.create(pk);

		produit.setCode(RandomTestUtil.randomString());

		produit.setLibelle(RandomTestUtil.randomString());

		produit.setAbreviation(RandomTestUtil.randomString());

		produit.setActive(RandomTestUtil.randomBoolean());

		produit.setCreatedAt(RandomTestUtil.nextDate());

		produit.setUpdatedAt(RandomTestUtil.nextDate());

		_produits.add(_persistence.update(produit));

		return produit;
	}

	private List<Produit> _produits = new ArrayList<Produit>();
	private ProduitPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}