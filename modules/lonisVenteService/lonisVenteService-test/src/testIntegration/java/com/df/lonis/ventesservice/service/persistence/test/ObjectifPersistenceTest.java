/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchObjectifException;
import com.df.lonis.ventesservice.model.Objectif;
import com.df.lonis.ventesservice.service.ObjectifLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.ObjectifPersistence;
import com.df.lonis.ventesservice.service.persistence.ObjectifUtil;

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
public class ObjectifPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = ObjectifUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Objectif> iterator = _objectifs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Objectif objectif = _persistence.create(pk);

		Assert.assertNotNull(objectif);

		Assert.assertEquals(objectif.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Objectif newObjectif = addObjectif();

		_persistence.remove(newObjectif);

		Objectif existingObjectif = _persistence.fetchByPrimaryKey(
			newObjectif.getPrimaryKey());

		Assert.assertNull(existingObjectif);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addObjectif();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Objectif newObjectif = _persistence.create(pk);

		newObjectif.setCommercialId(RandomTestUtil.nextLong());

		newObjectif.setType(RandomTestUtil.randomString());

		newObjectif.setPeriode(RandomTestUtil.randomString());

		newObjectif.setValeurCible(RandomTestUtil.nextInt());

		newObjectif.setValeurReelle(RandomTestUtil.nextInt());

		newObjectif.setMois(RandomTestUtil.nextInt());

		newObjectif.setTrimestre(RandomTestUtil.nextInt());

		newObjectif.setAnnee(RandomTestUtil.nextInt());

		newObjectif.setCreatedAt(RandomTestUtil.nextDate());

		newObjectif.setUpdatedAt(RandomTestUtil.nextDate());

		_objectifs.add(_persistence.update(newObjectif));

		Objectif existingObjectif = _persistence.findByPrimaryKey(
			newObjectif.getPrimaryKey());

		Assert.assertEquals(existingObjectif.getId(), newObjectif.getId());
		Assert.assertEquals(
			existingObjectif.getCommercialId(), newObjectif.getCommercialId());
		Assert.assertEquals(existingObjectif.getType(), newObjectif.getType());
		Assert.assertEquals(
			existingObjectif.getPeriode(), newObjectif.getPeriode());
		Assert.assertEquals(
			existingObjectif.getValeurCible(), newObjectif.getValeurCible());
		Assert.assertEquals(
			existingObjectif.getValeurReelle(), newObjectif.getValeurReelle());
		Assert.assertEquals(existingObjectif.getMois(), newObjectif.getMois());
		Assert.assertEquals(
			existingObjectif.getTrimestre(), newObjectif.getTrimestre());
		Assert.assertEquals(
			existingObjectif.getAnnee(), newObjectif.getAnnee());
		Assert.assertEquals(
			Time.getShortTimestamp(existingObjectif.getCreatedAt()),
			Time.getShortTimestamp(newObjectif.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingObjectif.getUpdatedAt()),
			Time.getShortTimestamp(newObjectif.getUpdatedAt()));
	}

	@Test
	public void testCountByCommercialId() throws Exception {
		_persistence.countByCommercialId(RandomTestUtil.nextLong());

		_persistence.countByCommercialId(0L);
	}

	@Test
	public void testCountByC_A() throws Exception {
		_persistence.countByC_A(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByC_A(0L, 0);
	}

	@Test
	public void testCountByC_A_M() throws Exception {
		_persistence.countByC_A_M(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt(),
			RandomTestUtil.nextInt());

		_persistence.countByC_A_M(0L, 0, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Objectif newObjectif = addObjectif();

		Objectif existingObjectif = _persistence.findByPrimaryKey(
			newObjectif.getPrimaryKey());

		Assert.assertEquals(existingObjectif, newObjectif);
	}

	@Test(expected = NoSuchObjectifException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Objectif> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"objectifs", "id", true, "commercialId", true, "type", true,
			"periode", true, "valeurCible", true, "valeurReelle", true, "mois",
			true, "trimestre", true, "annee", true, "createdAt", true,
			"updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Objectif newObjectif = addObjectif();

		Objectif existingObjectif = _persistence.fetchByPrimaryKey(
			newObjectif.getPrimaryKey());

		Assert.assertEquals(existingObjectif, newObjectif);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Objectif missingObjectif = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingObjectif);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Objectif newObjectif1 = addObjectif();
		Objectif newObjectif2 = addObjectif();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newObjectif1.getPrimaryKey());
		primaryKeys.add(newObjectif2.getPrimaryKey());

		Map<Serializable, Objectif> objectifs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, objectifs.size());
		Assert.assertEquals(
			newObjectif1, objectifs.get(newObjectif1.getPrimaryKey()));
		Assert.assertEquals(
			newObjectif2, objectifs.get(newObjectif2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Objectif> objectifs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(objectifs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Objectif newObjectif = addObjectif();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newObjectif.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Objectif> objectifs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, objectifs.size());
		Assert.assertEquals(
			newObjectif, objectifs.get(newObjectif.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Objectif> objectifs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(objectifs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Objectif newObjectif = addObjectif();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newObjectif.getPrimaryKey());

		Map<Serializable, Objectif> objectifs = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, objectifs.size());
		Assert.assertEquals(
			newObjectif, objectifs.get(newObjectif.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ObjectifLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Objectif>() {

				@Override
				public void performAction(Objectif objectif) {
					Assert.assertNotNull(objectif);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Objectif newObjectif = addObjectif();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Objectif.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newObjectif.getId()));

		List<Objectif> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Objectif existingObjectif = result.get(0);

		Assert.assertEquals(existingObjectif, newObjectif);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Objectif.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Objectif> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Objectif newObjectif = addObjectif();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Objectif.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newObjectif.getId();

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
			Objectif.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Objectif newObjectif = addObjectif();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newObjectif.getPrimaryKey()));
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

		Objectif newObjectif = addObjectif();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Objectif.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newObjectif.getId()));

		List<Objectif> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Objectif objectif) {
		Assert.assertEquals(
			Long.valueOf(objectif.getCommercialId()),
			ReflectionTestUtil.<Long>invoke(
				objectif, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "commercial_id"));
		Assert.assertEquals(
			Integer.valueOf(objectif.getAnnee()),
			ReflectionTestUtil.<Integer>invoke(
				objectif, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "annee"));
		Assert.assertEquals(
			Integer.valueOf(objectif.getMois()),
			ReflectionTestUtil.<Integer>invoke(
				objectif, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "mois"));
	}

	protected Objectif addObjectif() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Objectif objectif = _persistence.create(pk);

		objectif.setCommercialId(RandomTestUtil.nextLong());

		objectif.setType(RandomTestUtil.randomString());

		objectif.setPeriode(RandomTestUtil.randomString());

		objectif.setValeurCible(RandomTestUtil.nextInt());

		objectif.setValeurReelle(RandomTestUtil.nextInt());

		objectif.setMois(RandomTestUtil.nextInt());

		objectif.setTrimestre(RandomTestUtil.nextInt());

		objectif.setAnnee(RandomTestUtil.nextInt());

		objectif.setCreatedAt(RandomTestUtil.nextDate());

		objectif.setUpdatedAt(RandomTestUtil.nextDate());

		_objectifs.add(_persistence.update(objectif));

		return objectif;
	}

	private List<Objectif> _objectifs = new ArrayList<Objectif>();
	private ObjectifPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}