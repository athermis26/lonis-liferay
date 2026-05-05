/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchEvaluationException;
import com.df.lonis.ventesservice.model.Evaluation;
import com.df.lonis.ventesservice.service.EvaluationLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.EvaluationPersistence;
import com.df.lonis.ventesservice.service.persistence.EvaluationUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.AssertUtils;
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
public class EvaluationPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = EvaluationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Evaluation> iterator = _evaluations.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Evaluation evaluation = _persistence.create(pk);

		Assert.assertNotNull(evaluation);

		Assert.assertEquals(evaluation.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Evaluation newEvaluation = addEvaluation();

		_persistence.remove(newEvaluation);

		Evaluation existingEvaluation = _persistence.fetchByPrimaryKey(
			newEvaluation.getPrimaryKey());

		Assert.assertNull(existingEvaluation);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEvaluation();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Evaluation newEvaluation = _persistence.create(pk);

		newEvaluation.setCommercialId(RandomTestUtil.nextLong());

		newEvaluation.setNbVisitesPrevues(RandomTestUtil.nextInt());

		newEvaluation.setNbVisitesEffectuees(RandomTestUtil.nextInt());

		newEvaluation.setTauxRealisation(RandomTestUtil.nextDouble());

		newEvaluation.setRang(RandomTestUtil.nextInt());

		newEvaluation.setPeriode(RandomTestUtil.randomString());

		newEvaluation.setMois(RandomTestUtil.nextInt());

		newEvaluation.setTrimestre(RandomTestUtil.nextInt());

		newEvaluation.setAnnee(RandomTestUtil.nextInt());

		newEvaluation.setCreatedAt(RandomTestUtil.nextDate());

		newEvaluation.setUpdatedAt(RandomTestUtil.nextDate());

		_evaluations.add(_persistence.update(newEvaluation));

		Evaluation existingEvaluation = _persistence.findByPrimaryKey(
			newEvaluation.getPrimaryKey());

		Assert.assertEquals(existingEvaluation.getId(), newEvaluation.getId());
		Assert.assertEquals(
			existingEvaluation.getCommercialId(),
			newEvaluation.getCommercialId());
		Assert.assertEquals(
			existingEvaluation.getNbVisitesPrevues(),
			newEvaluation.getNbVisitesPrevues());
		Assert.assertEquals(
			existingEvaluation.getNbVisitesEffectuees(),
			newEvaluation.getNbVisitesEffectuees());
		AssertUtils.assertEquals(
			existingEvaluation.getTauxRealisation(),
			newEvaluation.getTauxRealisation());
		Assert.assertEquals(
			existingEvaluation.getRang(), newEvaluation.getRang());
		Assert.assertEquals(
			existingEvaluation.getPeriode(), newEvaluation.getPeriode());
		Assert.assertEquals(
			existingEvaluation.getMois(), newEvaluation.getMois());
		Assert.assertEquals(
			existingEvaluation.getTrimestre(), newEvaluation.getTrimestre());
		Assert.assertEquals(
			existingEvaluation.getAnnee(), newEvaluation.getAnnee());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEvaluation.getCreatedAt()),
			Time.getShortTimestamp(newEvaluation.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingEvaluation.getUpdatedAt()),
			Time.getShortTimestamp(newEvaluation.getUpdatedAt()));
	}

	@Test
	public void testCountByCommercialId() throws Exception {
		_persistence.countByCommercialId(RandomTestUtil.nextLong());

		_persistence.countByCommercialId(0L);
	}

	@Test
	public void testCountByAnnee() throws Exception {
		_persistence.countByAnnee(RandomTestUtil.nextInt());

		_persistence.countByAnnee(0);
	}

	@Test
	public void testCountByC_A() throws Exception {
		_persistence.countByC_A(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByC_A(0L, 0);
	}

	@Test
	public void testCountByC_A_M_P() throws Exception {
		_persistence.countByC_A_M_P(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt(),
			RandomTestUtil.nextInt(), "");

		_persistence.countByC_A_M_P(0L, 0, 0, "null");

		_persistence.countByC_A_M_P(0L, 0, 0, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Evaluation newEvaluation = addEvaluation();

		Evaluation existingEvaluation = _persistence.findByPrimaryKey(
			newEvaluation.getPrimaryKey());

		Assert.assertEquals(existingEvaluation, newEvaluation);
	}

	@Test(expected = NoSuchEvaluationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Evaluation> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"evaluations", "id", true, "commercialId", true, "nbVisitesPrevues",
			true, "nbVisitesEffectuees", true, "tauxRealisation", true, "rang",
			true, "periode", true, "mois", true, "trimestre", true, "annee",
			true, "createdAt", true, "updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Evaluation newEvaluation = addEvaluation();

		Evaluation existingEvaluation = _persistence.fetchByPrimaryKey(
			newEvaluation.getPrimaryKey());

		Assert.assertEquals(existingEvaluation, newEvaluation);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Evaluation missingEvaluation = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEvaluation);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Evaluation newEvaluation1 = addEvaluation();
		Evaluation newEvaluation2 = addEvaluation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvaluation1.getPrimaryKey());
		primaryKeys.add(newEvaluation2.getPrimaryKey());

		Map<Serializable, Evaluation> evaluations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, evaluations.size());
		Assert.assertEquals(
			newEvaluation1, evaluations.get(newEvaluation1.getPrimaryKey()));
		Assert.assertEquals(
			newEvaluation2, evaluations.get(newEvaluation2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Evaluation> evaluations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(evaluations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Evaluation newEvaluation = addEvaluation();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvaluation.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Evaluation> evaluations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, evaluations.size());
		Assert.assertEquals(
			newEvaluation, evaluations.get(newEvaluation.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Evaluation> evaluations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(evaluations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Evaluation newEvaluation = addEvaluation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvaluation.getPrimaryKey());

		Map<Serializable, Evaluation> evaluations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, evaluations.size());
		Assert.assertEquals(
			newEvaluation, evaluations.get(newEvaluation.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EvaluationLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Evaluation>() {

				@Override
				public void performAction(Evaluation evaluation) {
					Assert.assertNotNull(evaluation);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Evaluation newEvaluation = addEvaluation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Evaluation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newEvaluation.getId()));

		List<Evaluation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Evaluation existingEvaluation = result.get(0);

		Assert.assertEquals(existingEvaluation, newEvaluation);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Evaluation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Evaluation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Evaluation newEvaluation = addEvaluation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Evaluation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newEvaluation.getId();

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
			Evaluation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Evaluation newEvaluation = addEvaluation();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newEvaluation.getPrimaryKey()));
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

		Evaluation newEvaluation = addEvaluation();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Evaluation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newEvaluation.getId()));

		List<Evaluation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Evaluation evaluation) {
		Assert.assertEquals(
			Long.valueOf(evaluation.getCommercialId()),
			ReflectionTestUtil.<Long>invoke(
				evaluation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "commercial_id"));
		Assert.assertEquals(
			Integer.valueOf(evaluation.getAnnee()),
			ReflectionTestUtil.<Integer>invoke(
				evaluation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "annee"));
		Assert.assertEquals(
			Integer.valueOf(evaluation.getMois()),
			ReflectionTestUtil.<Integer>invoke(
				evaluation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "mois"));
		Assert.assertEquals(
			evaluation.getPeriode(),
			ReflectionTestUtil.invoke(
				evaluation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "periode"));
	}

	protected Evaluation addEvaluation() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Evaluation evaluation = _persistence.create(pk);

		evaluation.setCommercialId(RandomTestUtil.nextLong());

		evaluation.setNbVisitesPrevues(RandomTestUtil.nextInt());

		evaluation.setNbVisitesEffectuees(RandomTestUtil.nextInt());

		evaluation.setTauxRealisation(RandomTestUtil.nextDouble());

		evaluation.setRang(RandomTestUtil.nextInt());

		evaluation.setPeriode(RandomTestUtil.randomString());

		evaluation.setMois(RandomTestUtil.nextInt());

		evaluation.setTrimestre(RandomTestUtil.nextInt());

		evaluation.setAnnee(RandomTestUtil.nextInt());

		evaluation.setCreatedAt(RandomTestUtil.nextDate());

		evaluation.setUpdatedAt(RandomTestUtil.nextDate());

		_evaluations.add(_persistence.update(evaluation));

		return evaluation;
	}

	private List<Evaluation> _evaluations = new ArrayList<Evaluation>();
	private EvaluationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}