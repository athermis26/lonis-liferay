/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchCommercialException;
import com.df.lonis.ventesservice.model.Commercial;
import com.df.lonis.ventesservice.service.CommercialLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.CommercialPersistence;
import com.df.lonis.ventesservice.service.persistence.CommercialUtil;

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
public class CommercialPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = CommercialUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Commercial> iterator = _commercials.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Commercial commercial = _persistence.create(pk);

		Assert.assertNotNull(commercial);

		Assert.assertEquals(commercial.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Commercial newCommercial = addCommercial();

		_persistence.remove(newCommercial);

		Commercial existingCommercial = _persistence.fetchByPrimaryKey(
			newCommercial.getPrimaryKey());

		Assert.assertNull(existingCommercial);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCommercial();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Commercial newCommercial = _persistence.create(pk);

		newCommercial.setNom(RandomTestUtil.randomString());

		newCommercial.setPrenoms(RandomTestUtil.randomString());

		newCommercial.setTelephone(RandomTestUtil.randomString());

		newCommercial.setEmail(RandomTestUtil.randomString());

		newCommercial.setMatricule(RandomTestUtil.randomString());

		newCommercial.setStatut(RandomTestUtil.randomString());

		newCommercial.setSuperviseurId(RandomTestUtil.nextLong());

		newCommercial.setCreatedAt(RandomTestUtil.nextDate());

		newCommercial.setUpdatedAt(RandomTestUtil.nextDate());

		_commercials.add(_persistence.update(newCommercial));

		Commercial existingCommercial = _persistence.findByPrimaryKey(
			newCommercial.getPrimaryKey());

		Assert.assertEquals(existingCommercial.getId(), newCommercial.getId());
		Assert.assertEquals(
			existingCommercial.getNom(), newCommercial.getNom());
		Assert.assertEquals(
			existingCommercial.getPrenoms(), newCommercial.getPrenoms());
		Assert.assertEquals(
			existingCommercial.getTelephone(), newCommercial.getTelephone());
		Assert.assertEquals(
			existingCommercial.getEmail(), newCommercial.getEmail());
		Assert.assertEquals(
			existingCommercial.getMatricule(), newCommercial.getMatricule());
		Assert.assertEquals(
			existingCommercial.getStatut(), newCommercial.getStatut());
		Assert.assertEquals(
			existingCommercial.getSuperviseurId(),
			newCommercial.getSuperviseurId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommercial.getCreatedAt()),
			Time.getShortTimestamp(newCommercial.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommercial.getUpdatedAt()),
			Time.getShortTimestamp(newCommercial.getUpdatedAt()));
	}

	@Test
	public void testCountByMatricule() throws Exception {
		_persistence.countByMatricule("");

		_persistence.countByMatricule("null");

		_persistence.countByMatricule((String)null);
	}

	@Test
	public void testCountBySuperviseurId() throws Exception {
		_persistence.countBySuperviseurId(RandomTestUtil.nextLong());

		_persistence.countBySuperviseurId(0L);
	}

	@Test
	public void testCountByStatut() throws Exception {
		_persistence.countByStatut("");

		_persistence.countByStatut("null");

		_persistence.countByStatut((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Commercial newCommercial = addCommercial();

		Commercial existingCommercial = _persistence.findByPrimaryKey(
			newCommercial.getPrimaryKey());

		Assert.assertEquals(existingCommercial, newCommercial);
	}

	@Test(expected = NoSuchCommercialException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Commercial> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"commerciaux", "id", true, "nom", true, "prenoms", true,
			"telephone", true, "email", true, "matricule", true, "statut", true,
			"superviseurId", true, "createdAt", true, "updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Commercial newCommercial = addCommercial();

		Commercial existingCommercial = _persistence.fetchByPrimaryKey(
			newCommercial.getPrimaryKey());

		Assert.assertEquals(existingCommercial, newCommercial);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Commercial missingCommercial = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCommercial);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Commercial newCommercial1 = addCommercial();
		Commercial newCommercial2 = addCommercial();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercial1.getPrimaryKey());
		primaryKeys.add(newCommercial2.getPrimaryKey());

		Map<Serializable, Commercial> commercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, commercials.size());
		Assert.assertEquals(
			newCommercial1, commercials.get(newCommercial1.getPrimaryKey()));
		Assert.assertEquals(
			newCommercial2, commercials.get(newCommercial2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Commercial> commercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(commercials.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Commercial newCommercial = addCommercial();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercial.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Commercial> commercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, commercials.size());
		Assert.assertEquals(
			newCommercial, commercials.get(newCommercial.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Commercial> commercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(commercials.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Commercial newCommercial = addCommercial();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommercial.getPrimaryKey());

		Map<Serializable, Commercial> commercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, commercials.size());
		Assert.assertEquals(
			newCommercial, commercials.get(newCommercial.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CommercialLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Commercial>() {

				@Override
				public void performAction(Commercial commercial) {
					Assert.assertNotNull(commercial);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Commercial newCommercial = addCommercial();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Commercial.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newCommercial.getId()));

		List<Commercial> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Commercial existingCommercial = result.get(0);

		Assert.assertEquals(existingCommercial, newCommercial);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Commercial.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Commercial> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Commercial newCommercial = addCommercial();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Commercial.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newCommercial.getId();

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
			Commercial.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Commercial newCommercial = addCommercial();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCommercial.getPrimaryKey()));
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

		Commercial newCommercial = addCommercial();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Commercial.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newCommercial.getId()));

		List<Commercial> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Commercial commercial) {
		Assert.assertEquals(
			commercial.getMatricule(),
			ReflectionTestUtil.invoke(
				commercial, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "matricule"));
	}

	protected Commercial addCommercial() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Commercial commercial = _persistence.create(pk);

		commercial.setNom(RandomTestUtil.randomString());

		commercial.setPrenoms(RandomTestUtil.randomString());

		commercial.setTelephone(RandomTestUtil.randomString());

		commercial.setEmail(RandomTestUtil.randomString());

		commercial.setMatricule(RandomTestUtil.randomString());

		commercial.setStatut(RandomTestUtil.randomString());

		commercial.setSuperviseurId(RandomTestUtil.nextLong());

		commercial.setCreatedAt(RandomTestUtil.nextDate());

		commercial.setUpdatedAt(RandomTestUtil.nextDate());

		_commercials.add(_persistence.update(commercial));

		return commercial;
	}

	private List<Commercial> _commercials = new ArrayList<Commercial>();
	private CommercialPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}