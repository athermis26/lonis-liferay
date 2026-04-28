/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchConcessionnaireException;
import com.df.lonis.ventesservice.model.Concessionnaire;
import com.df.lonis.ventesservice.service.ConcessionnaireLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.ConcessionnairePersistence;
import com.df.lonis.ventesservice.service.persistence.ConcessionnaireUtil;

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
public class ConcessionnairePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = ConcessionnaireUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Concessionnaire> iterator = _concessionnaires.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Concessionnaire concessionnaire = _persistence.create(pk);

		Assert.assertNotNull(concessionnaire);

		Assert.assertEquals(concessionnaire.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Concessionnaire newConcessionnaire = addConcessionnaire();

		_persistence.remove(newConcessionnaire);

		Concessionnaire existingConcessionnaire =
			_persistence.fetchByPrimaryKey(newConcessionnaire.getPrimaryKey());

		Assert.assertNull(existingConcessionnaire);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addConcessionnaire();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Concessionnaire newConcessionnaire = _persistence.create(pk);

		newConcessionnaire.setUid(RandomTestUtil.randomString());

		newConcessionnaire.setNom(RandomTestUtil.randomString());

		newConcessionnaire.setPrenoms(RandomTestUtil.randomString());

		newConcessionnaire.setTelephone(RandomTestUtil.randomString());

		newConcessionnaire.setEmail(RandomTestUtil.randomString());

		_concessionnaires.add(_persistence.update(newConcessionnaire));

		Concessionnaire existingConcessionnaire = _persistence.findByPrimaryKey(
			newConcessionnaire.getPrimaryKey());

		Assert.assertEquals(
			existingConcessionnaire.getId(), newConcessionnaire.getId());
		Assert.assertEquals(
			existingConcessionnaire.getUid(), newConcessionnaire.getUid());
		Assert.assertEquals(
			existingConcessionnaire.getNom(), newConcessionnaire.getNom());
		Assert.assertEquals(
			existingConcessionnaire.getPrenoms(),
			newConcessionnaire.getPrenoms());
		Assert.assertEquals(
			existingConcessionnaire.getTelephone(),
			newConcessionnaire.getTelephone());
		Assert.assertEquals(
			existingConcessionnaire.getEmail(), newConcessionnaire.getEmail());
	}

	@Test
	public void testCountByUid() throws Exception {
		_persistence.countByUid("");

		_persistence.countByUid("null");

		_persistence.countByUid((String)null);
	}

	@Test
	public void testCountByNom() throws Exception {
		_persistence.countByNom("");

		_persistence.countByNom("null");

		_persistence.countByNom((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Concessionnaire newConcessionnaire = addConcessionnaire();

		Concessionnaire existingConcessionnaire = _persistence.findByPrimaryKey(
			newConcessionnaire.getPrimaryKey());

		Assert.assertEquals(existingConcessionnaire, newConcessionnaire);
	}

	@Test(expected = NoSuchConcessionnaireException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Concessionnaire> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"concessionnaires", "id", true, "uid", true, "nom", true, "prenoms",
			true, "telephone", true, "email", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Concessionnaire newConcessionnaire = addConcessionnaire();

		Concessionnaire existingConcessionnaire =
			_persistence.fetchByPrimaryKey(newConcessionnaire.getPrimaryKey());

		Assert.assertEquals(existingConcessionnaire, newConcessionnaire);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Concessionnaire missingConcessionnaire = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingConcessionnaire);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Concessionnaire newConcessionnaire1 = addConcessionnaire();
		Concessionnaire newConcessionnaire2 = addConcessionnaire();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConcessionnaire1.getPrimaryKey());
		primaryKeys.add(newConcessionnaire2.getPrimaryKey());

		Map<Serializable, Concessionnaire> concessionnaires =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, concessionnaires.size());
		Assert.assertEquals(
			newConcessionnaire1,
			concessionnaires.get(newConcessionnaire1.getPrimaryKey()));
		Assert.assertEquals(
			newConcessionnaire2,
			concessionnaires.get(newConcessionnaire2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Concessionnaire> concessionnaires =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(concessionnaires.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Concessionnaire newConcessionnaire = addConcessionnaire();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConcessionnaire.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Concessionnaire> concessionnaires =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, concessionnaires.size());
		Assert.assertEquals(
			newConcessionnaire,
			concessionnaires.get(newConcessionnaire.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Concessionnaire> concessionnaires =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(concessionnaires.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Concessionnaire newConcessionnaire = addConcessionnaire();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConcessionnaire.getPrimaryKey());

		Map<Serializable, Concessionnaire> concessionnaires =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, concessionnaires.size());
		Assert.assertEquals(
			newConcessionnaire,
			concessionnaires.get(newConcessionnaire.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ConcessionnaireLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Concessionnaire>() {

				@Override
				public void performAction(Concessionnaire concessionnaire) {
					Assert.assertNotNull(concessionnaire);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Concessionnaire newConcessionnaire = addConcessionnaire();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Concessionnaire.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newConcessionnaire.getId()));

		List<Concessionnaire> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Concessionnaire existingConcessionnaire = result.get(0);

		Assert.assertEquals(existingConcessionnaire, newConcessionnaire);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Concessionnaire.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Concessionnaire> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Concessionnaire newConcessionnaire = addConcessionnaire();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Concessionnaire.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newConcessionnaire.getId();

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
			Concessionnaire.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Concessionnaire newConcessionnaire = addConcessionnaire();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newConcessionnaire.getPrimaryKey()));
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

		Concessionnaire newConcessionnaire = addConcessionnaire();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Concessionnaire.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newConcessionnaire.getId()));

		List<Concessionnaire> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Concessionnaire concessionnaire) {
		Assert.assertEquals(
			concessionnaire.getUid(),
			ReflectionTestUtil.invoke(
				concessionnaire, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uid"));
	}

	protected Concessionnaire addConcessionnaire() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Concessionnaire concessionnaire = _persistence.create(pk);

		concessionnaire.setUid(RandomTestUtil.randomString());

		concessionnaire.setNom(RandomTestUtil.randomString());

		concessionnaire.setPrenoms(RandomTestUtil.randomString());

		concessionnaire.setTelephone(RandomTestUtil.randomString());

		concessionnaire.setEmail(RandomTestUtil.randomString());

		_concessionnaires.add(_persistence.update(concessionnaire));

		return concessionnaire;
	}

	private List<Concessionnaire> _concessionnaires =
		new ArrayList<Concessionnaire>();
	private ConcessionnairePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}