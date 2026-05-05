/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchVisiteException;
import com.df.lonis.ventesservice.model.Visite;
import com.df.lonis.ventesservice.service.VisiteLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.VisitePersistence;
import com.df.lonis.ventesservice.service.persistence.VisiteUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
public class VisitePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = VisiteUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Visite> iterator = _visites.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Visite visite = _persistence.create(pk);

		Assert.assertNotNull(visite);

		Assert.assertEquals(visite.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Visite newVisite = addVisite();

		_persistence.remove(newVisite);

		Visite existingVisite = _persistence.fetchByPrimaryKey(
			newVisite.getPrimaryKey());

		Assert.assertNull(existingVisite);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVisite();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Visite newVisite = _persistence.create(pk);

		newVisite.setCommercialId(RandomTestUtil.nextLong());

		newVisite.setTerminalId(RandomTestUtil.nextLong());

		newVisite.setLatitude();

		newVisite.setLongitude();

		newVisite.setStatut(RandomTestUtil.randomString());

		newVisite.setTypeControle(RandomTestUtil.randomString());

		newVisite.setDateVisite(RandomTestUtil.nextDate());

		newVisite.setCompteRendu(RandomTestUtil.randomString());

		newVisite.setCreatedAt(RandomTestUtil.nextDate());

		newVisite.setUpdatedAt(RandomTestUtil.nextDate());

		_visites.add(_persistence.update(newVisite));

		Visite existingVisite = _persistence.findByPrimaryKey(
			newVisite.getPrimaryKey());

		Assert.assertEquals(existingVisite.getId(), newVisite.getId());
		Assert.assertEquals(
			existingVisite.getCommercialId(), newVisite.getCommercialId());
		Assert.assertEquals(
			existingVisite.getTerminalId(), newVisite.getTerminalId());
		Assert.assertEquals(
			existingVisite.getLatitude(), newVisite.getLatitude());
		Assert.assertEquals(
			existingVisite.getLongitude(), newVisite.getLongitude());
		Assert.assertEquals(existingVisite.getStatut(), newVisite.getStatut());
		Assert.assertEquals(
			existingVisite.getTypeControle(), newVisite.getTypeControle());
		Assert.assertEquals(
			Time.getShortTimestamp(existingVisite.getDateVisite()),
			Time.getShortTimestamp(newVisite.getDateVisite()));
		Assert.assertEquals(
			existingVisite.getCompteRendu(), newVisite.getCompteRendu());
		Assert.assertEquals(
			Time.getShortTimestamp(existingVisite.getCreatedAt()),
			Time.getShortTimestamp(newVisite.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingVisite.getUpdatedAt()),
			Time.getShortTimestamp(newVisite.getUpdatedAt()));
	}

	@Test
	public void testCountByCommercialId() throws Exception {
		_persistence.countByCommercialId(RandomTestUtil.nextLong());

		_persistence.countByCommercialId(0L);
	}

	@Test
	public void testCountByTerminalId() throws Exception {
		_persistence.countByTerminalId(RandomTestUtil.nextLong());

		_persistence.countByTerminalId(0L);
	}

	@Test
	public void testCountByStatut() throws Exception {
		_persistence.countByStatut("");

		_persistence.countByStatut("null");

		_persistence.countByStatut((String)null);
	}

	@Test
	public void testCountByC_S() throws Exception {
		_persistence.countByC_S(RandomTestUtil.nextLong(), "");

		_persistence.countByC_S(0L, "null");

		_persistence.countByC_S(0L, (String)null);
	}

	@Test
	public void testCountByC_D() throws Exception {
		_persistence.countByC_D(
			RandomTestUtil.nextLong(), RandomTestUtil.nextDate());

		_persistence.countByC_D(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Visite newVisite = addVisite();

		Visite existingVisite = _persistence.findByPrimaryKey(
			newVisite.getPrimaryKey());

		Assert.assertEquals(existingVisite, newVisite);
	}

	@Test(expected = NoSuchVisiteException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Visite> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"visites", "id", true, "commercialId", true, "terminalId", true,
			"latitude", true, "longitude", true, "statut", true, "typeControle",
			true, "dateVisite", true, "compteRendu", true, "createdAt", true,
			"updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Visite newVisite = addVisite();

		Visite existingVisite = _persistence.fetchByPrimaryKey(
			newVisite.getPrimaryKey());

		Assert.assertEquals(existingVisite, newVisite);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Visite missingVisite = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVisite);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Visite newVisite1 = addVisite();
		Visite newVisite2 = addVisite();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVisite1.getPrimaryKey());
		primaryKeys.add(newVisite2.getPrimaryKey());

		Map<Serializable, Visite> visites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, visites.size());
		Assert.assertEquals(
			newVisite1, visites.get(newVisite1.getPrimaryKey()));
		Assert.assertEquals(
			newVisite2, visites.get(newVisite2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Visite> visites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(visites.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Visite newVisite = addVisite();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVisite.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Visite> visites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, visites.size());
		Assert.assertEquals(newVisite, visites.get(newVisite.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Visite> visites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(visites.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Visite newVisite = addVisite();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVisite.getPrimaryKey());

		Map<Serializable, Visite> visites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, visites.size());
		Assert.assertEquals(newVisite, visites.get(newVisite.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			VisiteLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Visite>() {

				@Override
				public void performAction(Visite visite) {
					Assert.assertNotNull(visite);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Visite newVisite = addVisite();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Visite.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newVisite.getId()));

		List<Visite> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Visite existingVisite = result.get(0);

		Assert.assertEquals(existingVisite, newVisite);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Visite.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Visite> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Visite newVisite = addVisite();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Visite.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newVisite.getId();

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
			Visite.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Visite addVisite() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Visite visite = _persistence.create(pk);

		visite.setCommercialId(RandomTestUtil.nextLong());

		visite.setTerminalId(RandomTestUtil.nextLong());

		visite.setLatitude();

		visite.setLongitude();

		visite.setStatut(RandomTestUtil.randomString());

		visite.setTypeControle(RandomTestUtil.randomString());

		visite.setDateVisite(RandomTestUtil.nextDate());

		visite.setCompteRendu(RandomTestUtil.randomString());

		visite.setCreatedAt(RandomTestUtil.nextDate());

		visite.setUpdatedAt(RandomTestUtil.nextDate());

		_visites.add(_persistence.update(visite));

		return visite;
	}

	private List<Visite> _visites = new ArrayList<Visite>();
	private VisitePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}