/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchSiteException;
import com.df.lonis.ventesservice.model.Site;
import com.df.lonis.ventesservice.service.SiteLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.SitePersistence;
import com.df.lonis.ventesservice.service.persistence.SiteUtil;

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
public class SitePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = SiteUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Site> iterator = _sites.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Site site = _persistence.create(pk);

		Assert.assertNotNull(site);

		Assert.assertEquals(site.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Site newSite = addSite();

		_persistence.remove(newSite);

		Site existingSite = _persistence.fetchByPrimaryKey(
			newSite.getPrimaryKey());

		Assert.assertNull(existingSite);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSite();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Site newSite = _persistence.create(pk);

		newSite.setLibelle(RandomTestUtil.randomString());

		newSite.setType(RandomTestUtil.nextInt());

		newSite.setParentId(RandomTestUtil.nextLong());

		newSite.setCode(RandomTestUtil.randomString());

		newSite.setCodeProvinov(RandomTestUtil.randomString());

		newSite.setStatus(RandomTestUtil.randomBoolean());

		newSite.setCreatedAt(RandomTestUtil.nextDate());

		newSite.setUpdatedAt(RandomTestUtil.nextDate());

		_sites.add(_persistence.update(newSite));

		Site existingSite = _persistence.findByPrimaryKey(
			newSite.getPrimaryKey());

		Assert.assertEquals(existingSite.getId(), newSite.getId());
		Assert.assertEquals(existingSite.getLibelle(), newSite.getLibelle());
		Assert.assertEquals(existingSite.getType(), newSite.getType());
		Assert.assertEquals(existingSite.getParentId(), newSite.getParentId());
		Assert.assertEquals(existingSite.getCode(), newSite.getCode());
		Assert.assertEquals(
			existingSite.getCodeProvinov(), newSite.getCodeProvinov());
		Assert.assertEquals(existingSite.isStatus(), newSite.isStatus());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSite.getCreatedAt()),
			Time.getShortTimestamp(newSite.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSite.getUpdatedAt()),
			Time.getShortTimestamp(newSite.getUpdatedAt()));
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Site newSite = addSite();

		Site existingSite = _persistence.findByPrimaryKey(
			newSite.getPrimaryKey());

		Assert.assertEquals(existingSite, newSite);
	}

	@Test(expected = NoSuchSiteException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Site> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"sites", "id", true, "libelle", true, "type", true, "parentId",
			true, "code", true, "codeProvinov", true, "status", true,
			"createdAt", true, "updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Site newSite = addSite();

		Site existingSite = _persistence.fetchByPrimaryKey(
			newSite.getPrimaryKey());

		Assert.assertEquals(existingSite, newSite);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Site missingSite = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSite);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Site newSite1 = addSite();
		Site newSite2 = addSite();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSite1.getPrimaryKey());
		primaryKeys.add(newSite2.getPrimaryKey());

		Map<Serializable, Site> sites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, sites.size());
		Assert.assertEquals(newSite1, sites.get(newSite1.getPrimaryKey()));
		Assert.assertEquals(newSite2, sites.get(newSite2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Site> sites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(sites.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Site newSite = addSite();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSite.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Site> sites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, sites.size());
		Assert.assertEquals(newSite, sites.get(newSite.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Site> sites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(sites.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Site newSite = addSite();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSite.getPrimaryKey());

		Map<Serializable, Site> sites = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, sites.size());
		Assert.assertEquals(newSite, sites.get(newSite.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SiteLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Site>() {

				@Override
				public void performAction(Site site) {
					Assert.assertNotNull(site);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Site newSite = addSite();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Site.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newSite.getId()));

		List<Site> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Site existingSite = result.get(0);

		Assert.assertEquals(existingSite, newSite);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Site.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Site> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Site newSite = addSite();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Site.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newSite.getId();

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
			Site.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Site addSite() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Site site = _persistence.create(pk);

		site.setLibelle(RandomTestUtil.randomString());

		site.setType(RandomTestUtil.nextInt());

		site.setParentId(RandomTestUtil.nextLong());

		site.setCode(RandomTestUtil.randomString());

		site.setCodeProvinov(RandomTestUtil.randomString());

		site.setStatus(RandomTestUtil.randomBoolean());

		site.setCreatedAt(RandomTestUtil.nextDate());

		site.setUpdatedAt(RandomTestUtil.nextDate());

		_sites.add(_persistence.update(site));

		return site;
	}

	private List<Site> _sites = new ArrayList<Site>();
	private SitePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}