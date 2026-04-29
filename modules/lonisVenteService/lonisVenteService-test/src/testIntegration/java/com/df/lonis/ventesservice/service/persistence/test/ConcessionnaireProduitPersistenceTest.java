/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchConcessionnaireProduitException;
import com.df.lonis.ventesservice.model.ConcessionnaireProduit;
import com.df.lonis.ventesservice.service.ConcessionnaireProduitLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.ConcessionnaireProduitPersistence;
import com.df.lonis.ventesservice.service.persistence.ConcessionnaireProduitUtil;

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
public class ConcessionnaireProduitPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = ConcessionnaireProduitUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ConcessionnaireProduit> iterator =
			_concessionnaireProduits.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConcessionnaireProduit concessionnaireProduit = _persistence.create(pk);

		Assert.assertNotNull(concessionnaireProduit);

		Assert.assertEquals(concessionnaireProduit.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		_persistence.remove(newConcessionnaireProduit);

		ConcessionnaireProduit existingConcessionnaireProduit =
			_persistence.fetchByPrimaryKey(
				newConcessionnaireProduit.getPrimaryKey());

		Assert.assertNull(existingConcessionnaireProduit);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addConcessionnaireProduit();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConcessionnaireProduit newConcessionnaireProduit = _persistence.create(
			pk);

		newConcessionnaireProduit.setConcessionnaireId(
			RandomTestUtil.nextLong());

		newConcessionnaireProduit.setProduitId(RandomTestUtil.nextLong());

		newConcessionnaireProduit.setSiteId(RandomTestUtil.nextLong());

		newConcessionnaireProduit.setCode(RandomTestUtil.randomString());

		newConcessionnaireProduit.setConcessionnaireCode(
			RandomTestUtil.randomString());

		newConcessionnaireProduit.setActive(RandomTestUtil.randomBoolean());

		newConcessionnaireProduit.setCreatedAt(RandomTestUtil.nextDate());

		newConcessionnaireProduit.setUpdatedAt(RandomTestUtil.nextDate());

		_concessionnaireProduits.add(
			_persistence.update(newConcessionnaireProduit));

		ConcessionnaireProduit existingConcessionnaireProduit =
			_persistence.findByPrimaryKey(
				newConcessionnaireProduit.getPrimaryKey());

		Assert.assertEquals(
			existingConcessionnaireProduit.getId(),
			newConcessionnaireProduit.getId());
		Assert.assertEquals(
			existingConcessionnaireProduit.getConcessionnaireId(),
			newConcessionnaireProduit.getConcessionnaireId());
		Assert.assertEquals(
			existingConcessionnaireProduit.getProduitId(),
			newConcessionnaireProduit.getProduitId());
		Assert.assertEquals(
			existingConcessionnaireProduit.getSiteId(),
			newConcessionnaireProduit.getSiteId());
		Assert.assertEquals(
			existingConcessionnaireProduit.getCode(),
			newConcessionnaireProduit.getCode());
		Assert.assertEquals(
			existingConcessionnaireProduit.getConcessionnaireCode(),
			newConcessionnaireProduit.getConcessionnaireCode());
		Assert.assertEquals(
			existingConcessionnaireProduit.isActive(),
			newConcessionnaireProduit.isActive());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingConcessionnaireProduit.getCreatedAt()),
			Time.getShortTimestamp(newConcessionnaireProduit.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingConcessionnaireProduit.getUpdatedAt()),
			Time.getShortTimestamp(newConcessionnaireProduit.getUpdatedAt()));
	}

	@Test
	public void testCountByCode() throws Exception {
		_persistence.countByCode("");

		_persistence.countByCode("null");

		_persistence.countByCode((String)null);
	}

	@Test
	public void testCountByConcessionnaireId() throws Exception {
		_persistence.countByConcessionnaireId(RandomTestUtil.nextLong());

		_persistence.countByConcessionnaireId(0L);
	}

	@Test
	public void testCountByProduitId() throws Exception {
		_persistence.countByProduitId(RandomTestUtil.nextLong());

		_persistence.countByProduitId(0L);
	}

	@Test
	public void testCountByC_P() throws Exception {
		_persistence.countByC_P(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByC_P(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		ConcessionnaireProduit existingConcessionnaireProduit =
			_persistence.findByPrimaryKey(
				newConcessionnaireProduit.getPrimaryKey());

		Assert.assertEquals(
			existingConcessionnaireProduit, newConcessionnaireProduit);
	}

	@Test(expected = NoSuchConcessionnaireProduitException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ConcessionnaireProduit> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"concessionnaire_produit", "id", true, "concessionnaireId", true,
			"produitId", true, "siteId", true, "code", true,
			"concessionnaireCode", true, "active", true, "createdAt", true,
			"updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		ConcessionnaireProduit existingConcessionnaireProduit =
			_persistence.fetchByPrimaryKey(
				newConcessionnaireProduit.getPrimaryKey());

		Assert.assertEquals(
			existingConcessionnaireProduit, newConcessionnaireProduit);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConcessionnaireProduit missingConcessionnaireProduit =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingConcessionnaireProduit);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ConcessionnaireProduit newConcessionnaireProduit1 =
			addConcessionnaireProduit();
		ConcessionnaireProduit newConcessionnaireProduit2 =
			addConcessionnaireProduit();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConcessionnaireProduit1.getPrimaryKey());
		primaryKeys.add(newConcessionnaireProduit2.getPrimaryKey());

		Map<Serializable, ConcessionnaireProduit> concessionnaireProduits =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, concessionnaireProduits.size());
		Assert.assertEquals(
			newConcessionnaireProduit1,
			concessionnaireProduits.get(
				newConcessionnaireProduit1.getPrimaryKey()));
		Assert.assertEquals(
			newConcessionnaireProduit2,
			concessionnaireProduits.get(
				newConcessionnaireProduit2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ConcessionnaireProduit> concessionnaireProduits =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(concessionnaireProduits.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConcessionnaireProduit.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ConcessionnaireProduit> concessionnaireProduits =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, concessionnaireProduits.size());
		Assert.assertEquals(
			newConcessionnaireProduit,
			concessionnaireProduits.get(
				newConcessionnaireProduit.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ConcessionnaireProduit> concessionnaireProduits =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(concessionnaireProduits.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConcessionnaireProduit.getPrimaryKey());

		Map<Serializable, ConcessionnaireProduit> concessionnaireProduits =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, concessionnaireProduits.size());
		Assert.assertEquals(
			newConcessionnaireProduit,
			concessionnaireProduits.get(
				newConcessionnaireProduit.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ConcessionnaireProduitLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<ConcessionnaireProduit>() {

				@Override
				public void performAction(
					ConcessionnaireProduit concessionnaireProduit) {

					Assert.assertNotNull(concessionnaireProduit);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConcessionnaireProduit.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id", newConcessionnaireProduit.getId()));

		List<ConcessionnaireProduit> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ConcessionnaireProduit existingConcessionnaireProduit = result.get(0);

		Assert.assertEquals(
			existingConcessionnaireProduit, newConcessionnaireProduit);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConcessionnaireProduit.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<ConcessionnaireProduit> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConcessionnaireProduit.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newConcessionnaireProduit.getId();

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
			ConcessionnaireProduit.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newConcessionnaireProduit.getPrimaryKey()));
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

		ConcessionnaireProduit newConcessionnaireProduit =
			addConcessionnaireProduit();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConcessionnaireProduit.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id", newConcessionnaireProduit.getId()));

		List<ConcessionnaireProduit> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		ConcessionnaireProduit concessionnaireProduit) {

		Assert.assertEquals(
			concessionnaireProduit.getCode(),
			ReflectionTestUtil.invoke(
				concessionnaireProduit, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "code"));

		Assert.assertEquals(
			Long.valueOf(concessionnaireProduit.getConcessionnaireId()),
			ReflectionTestUtil.<Long>invoke(
				concessionnaireProduit, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "concessionnaire_id"));
		Assert.assertEquals(
			Long.valueOf(concessionnaireProduit.getProduitId()),
			ReflectionTestUtil.<Long>invoke(
				concessionnaireProduit, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "produit_id"));
	}

	protected ConcessionnaireProduit addConcessionnaireProduit()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		ConcessionnaireProduit concessionnaireProduit = _persistence.create(pk);

		concessionnaireProduit.setConcessionnaireId(RandomTestUtil.nextLong());

		concessionnaireProduit.setProduitId(RandomTestUtil.nextLong());

		concessionnaireProduit.setSiteId(RandomTestUtil.nextLong());

		concessionnaireProduit.setCode(RandomTestUtil.randomString());

		concessionnaireProduit.setConcessionnaireCode(
			RandomTestUtil.randomString());

		concessionnaireProduit.setActive(RandomTestUtil.randomBoolean());

		concessionnaireProduit.setCreatedAt(RandomTestUtil.nextDate());

		concessionnaireProduit.setUpdatedAt(RandomTestUtil.nextDate());

		_concessionnaireProduits.add(
			_persistence.update(concessionnaireProduit));

		return concessionnaireProduit;
	}

	private List<ConcessionnaireProduit> _concessionnaireProduits =
		new ArrayList<ConcessionnaireProduit>();
	private ConcessionnaireProduitPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}