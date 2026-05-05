/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchSiteCommercialException;
import com.df.lonis.ventesservice.model.SiteCommercial;
import com.df.lonis.ventesservice.service.SiteCommercialLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.SiteCommercialPersistence;
import com.df.lonis.ventesservice.service.persistence.SiteCommercialUtil;

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
public class SiteCommercialPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = SiteCommercialUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<SiteCommercial> iterator = _siteCommercials.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SiteCommercial siteCommercial = _persistence.create(pk);

		Assert.assertNotNull(siteCommercial);

		Assert.assertEquals(siteCommercial.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		SiteCommercial newSiteCommercial = addSiteCommercial();

		_persistence.remove(newSiteCommercial);

		SiteCommercial existingSiteCommercial = _persistence.fetchByPrimaryKey(
			newSiteCommercial.getPrimaryKey());

		Assert.assertNull(existingSiteCommercial);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSiteCommercial();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SiteCommercial newSiteCommercial = _persistence.create(pk);

		newSiteCommercial.setSiteId(RandomTestUtil.nextLong());

		newSiteCommercial.setCommercialId(RandomTestUtil.nextLong());

		newSiteCommercial.setDateDebut(RandomTestUtil.nextDate());

		newSiteCommercial.setDateFin(RandomTestUtil.nextDate());

		newSiteCommercial.setIsPrincipal(RandomTestUtil.randomBoolean());

		newSiteCommercial.setCreatedAt(RandomTestUtil.nextDate());

		_siteCommercials.add(_persistence.update(newSiteCommercial));

		SiteCommercial existingSiteCommercial = _persistence.findByPrimaryKey(
			newSiteCommercial.getPrimaryKey());

		Assert.assertEquals(
			existingSiteCommercial.getId(), newSiteCommercial.getId());
		Assert.assertEquals(
			existingSiteCommercial.getSiteId(), newSiteCommercial.getSiteId());
		Assert.assertEquals(
			existingSiteCommercial.getCommercialId(),
			newSiteCommercial.getCommercialId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSiteCommercial.getDateDebut()),
			Time.getShortTimestamp(newSiteCommercial.getDateDebut()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSiteCommercial.getDateFin()),
			Time.getShortTimestamp(newSiteCommercial.getDateFin()));
		Assert.assertEquals(
			existingSiteCommercial.isIsPrincipal(),
			newSiteCommercial.isIsPrincipal());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSiteCommercial.getCreatedAt()),
			Time.getShortTimestamp(newSiteCommercial.getCreatedAt()));
	}

	@Test
	public void testCountBySiteId() throws Exception {
		_persistence.countBySiteId(RandomTestUtil.nextLong());

		_persistence.countBySiteId(0L);
	}

	@Test
	public void testCountByCommercialId() throws Exception {
		_persistence.countByCommercialId(RandomTestUtil.nextLong());

		_persistence.countByCommercialId(0L);
	}

	@Test
	public void testCountByS_C() throws Exception {
		_persistence.countByS_C(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByS_C(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		SiteCommercial newSiteCommercial = addSiteCommercial();

		SiteCommercial existingSiteCommercial = _persistence.findByPrimaryKey(
			newSiteCommercial.getPrimaryKey());

		Assert.assertEquals(existingSiteCommercial, newSiteCommercial);
	}

	@Test(expected = NoSuchSiteCommercialException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<SiteCommercial> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"site_commerciaux", "id", true, "siteId", true, "commercialId",
			true, "dateDebut", true, "dateFin", true, "isPrincipal", true,
			"createdAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		SiteCommercial newSiteCommercial = addSiteCommercial();

		SiteCommercial existingSiteCommercial = _persistence.fetchByPrimaryKey(
			newSiteCommercial.getPrimaryKey());

		Assert.assertEquals(existingSiteCommercial, newSiteCommercial);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SiteCommercial missingSiteCommercial = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingSiteCommercial);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		SiteCommercial newSiteCommercial1 = addSiteCommercial();
		SiteCommercial newSiteCommercial2 = addSiteCommercial();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSiteCommercial1.getPrimaryKey());
		primaryKeys.add(newSiteCommercial2.getPrimaryKey());

		Map<Serializable, SiteCommercial> siteCommercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, siteCommercials.size());
		Assert.assertEquals(
			newSiteCommercial1,
			siteCommercials.get(newSiteCommercial1.getPrimaryKey()));
		Assert.assertEquals(
			newSiteCommercial2,
			siteCommercials.get(newSiteCommercial2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, SiteCommercial> siteCommercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(siteCommercials.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		SiteCommercial newSiteCommercial = addSiteCommercial();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSiteCommercial.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, SiteCommercial> siteCommercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, siteCommercials.size());
		Assert.assertEquals(
			newSiteCommercial,
			siteCommercials.get(newSiteCommercial.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, SiteCommercial> siteCommercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(siteCommercials.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		SiteCommercial newSiteCommercial = addSiteCommercial();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSiteCommercial.getPrimaryKey());

		Map<Serializable, SiteCommercial> siteCommercials =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, siteCommercials.size());
		Assert.assertEquals(
			newSiteCommercial,
			siteCommercials.get(newSiteCommercial.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SiteCommercialLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<SiteCommercial>() {

				@Override
				public void performAction(SiteCommercial siteCommercial) {
					Assert.assertNotNull(siteCommercial);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		SiteCommercial newSiteCommercial = addSiteCommercial();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SiteCommercial.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newSiteCommercial.getId()));

		List<SiteCommercial> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		SiteCommercial existingSiteCommercial = result.get(0);

		Assert.assertEquals(existingSiteCommercial, newSiteCommercial);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SiteCommercial.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<SiteCommercial> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		SiteCommercial newSiteCommercial = addSiteCommercial();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SiteCommercial.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newSiteCommercial.getId();

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
			SiteCommercial.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		SiteCommercial newSiteCommercial = addSiteCommercial();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newSiteCommercial.getPrimaryKey()));
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

		SiteCommercial newSiteCommercial = addSiteCommercial();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			SiteCommercial.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newSiteCommercial.getId()));

		List<SiteCommercial> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(SiteCommercial siteCommercial) {
		Assert.assertEquals(
			Long.valueOf(siteCommercial.getSiteId()),
			ReflectionTestUtil.<Long>invoke(
				siteCommercial, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "site_id"));
		Assert.assertEquals(
			Long.valueOf(siteCommercial.getCommercialId()),
			ReflectionTestUtil.<Long>invoke(
				siteCommercial, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "commercial_id"));
	}

	protected SiteCommercial addSiteCommercial() throws Exception {
		long pk = RandomTestUtil.nextLong();

		SiteCommercial siteCommercial = _persistence.create(pk);

		siteCommercial.setSiteId(RandomTestUtil.nextLong());

		siteCommercial.setCommercialId(RandomTestUtil.nextLong());

		siteCommercial.setDateDebut(RandomTestUtil.nextDate());

		siteCommercial.setDateFin(RandomTestUtil.nextDate());

		siteCommercial.setIsPrincipal(RandomTestUtil.randomBoolean());

		siteCommercial.setCreatedAt(RandomTestUtil.nextDate());

		_siteCommercials.add(_persistence.update(siteCommercial));

		return siteCommercial;
	}

	private List<SiteCommercial> _siteCommercials =
		new ArrayList<SiteCommercial>();
	private SiteCommercialPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}