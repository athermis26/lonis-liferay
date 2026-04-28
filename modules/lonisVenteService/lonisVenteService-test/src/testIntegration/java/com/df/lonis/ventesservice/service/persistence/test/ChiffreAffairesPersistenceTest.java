/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchChiffreAffairesException;
import com.df.lonis.ventesservice.model.ChiffreAffaires;
import com.df.lonis.ventesservice.service.ChiffreAffairesLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.ChiffreAffairesPersistence;
import com.df.lonis.ventesservice.service.persistence.ChiffreAffairesUtil;

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
public class ChiffreAffairesPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = ChiffreAffairesUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ChiffreAffaires> iterator = _chiffreAffaireses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChiffreAffaires chiffreAffaires = _persistence.create(pk);

		Assert.assertNotNull(chiffreAffaires);

		Assert.assertEquals(chiffreAffaires.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ChiffreAffaires newChiffreAffaires = addChiffreAffaires();

		_persistence.remove(newChiffreAffaires);

		ChiffreAffaires existingChiffreAffaires =
			_persistence.fetchByPrimaryKey(newChiffreAffaires.getPrimaryKey());

		Assert.assertNull(existingChiffreAffaires);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addChiffreAffaires();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChiffreAffaires newChiffreAffaires = _persistence.create(pk);

		newChiffreAffaires.setTerminalId(RandomTestUtil.nextLong());

		newChiffreAffaires.setBrut(RandomTestUtil.nextLong());

		newChiffreAffaires.setPaiement(RandomTestUtil.nextLong());

		newChiffreAffaires.setAnnulation(RandomTestUtil.nextLong());

		newChiffreAffaires.setRemboursement(RandomTestUtil.nextLong());

		newChiffreAffaires.setVentes(RandomTestUtil.nextLong());

		newChiffreAffaires.setBalance(RandomTestUtil.nextLong());

		newChiffreAffaires.setDeposit(RandomTestUtil.nextLong());

		newChiffreAffaires.setDate(RandomTestUtil.nextDate());

		newChiffreAffaires.setCreatedAt(RandomTestUtil.nextDate());

		newChiffreAffaires.setUpdatedAt(RandomTestUtil.nextDate());

		_chiffreAffaireses.add(_persistence.update(newChiffreAffaires));

		ChiffreAffaires existingChiffreAffaires = _persistence.findByPrimaryKey(
			newChiffreAffaires.getPrimaryKey());

		Assert.assertEquals(
			existingChiffreAffaires.getId(), newChiffreAffaires.getId());
		Assert.assertEquals(
			existingChiffreAffaires.getTerminalId(),
			newChiffreAffaires.getTerminalId());
		Assert.assertEquals(
			existingChiffreAffaires.getBrut(), newChiffreAffaires.getBrut());
		Assert.assertEquals(
			existingChiffreAffaires.getPaiement(),
			newChiffreAffaires.getPaiement());
		Assert.assertEquals(
			existingChiffreAffaires.getAnnulation(),
			newChiffreAffaires.getAnnulation());
		Assert.assertEquals(
			existingChiffreAffaires.getRemboursement(),
			newChiffreAffaires.getRemboursement());
		Assert.assertEquals(
			existingChiffreAffaires.getVentes(),
			newChiffreAffaires.getVentes());
		Assert.assertEquals(
			existingChiffreAffaires.getBalance(),
			newChiffreAffaires.getBalance());
		Assert.assertEquals(
			existingChiffreAffaires.getDeposit(),
			newChiffreAffaires.getDeposit());
		Assert.assertEquals(
			Time.getShortTimestamp(existingChiffreAffaires.getDate()),
			Time.getShortTimestamp(newChiffreAffaires.getDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingChiffreAffaires.getCreatedAt()),
			Time.getShortTimestamp(newChiffreAffaires.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingChiffreAffaires.getUpdatedAt()),
			Time.getShortTimestamp(newChiffreAffaires.getUpdatedAt()));
	}

	@Test
	public void testCountByTerminalId() throws Exception {
		_persistence.countByTerminalId(RandomTestUtil.nextLong());

		_persistence.countByTerminalId(0L);
	}

	@Test
	public void testCountByT_D() throws Exception {
		_persistence.countByT_D(
			RandomTestUtil.nextLong(), RandomTestUtil.nextDate());

		_persistence.countByT_D(0L, RandomTestUtil.nextDate());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ChiffreAffaires newChiffreAffaires = addChiffreAffaires();

		ChiffreAffaires existingChiffreAffaires = _persistence.findByPrimaryKey(
			newChiffreAffaires.getPrimaryKey());

		Assert.assertEquals(existingChiffreAffaires, newChiffreAffaires);
	}

	@Test(expected = NoSuchChiffreAffairesException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ChiffreAffaires> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"chiffre_affaires", "id", true, "terminalId", true, "brut", true,
			"paiement", true, "annulation", true, "remboursement", true,
			"ventes", true, "balance", true, "deposit", true, "date", true,
			"createdAt", true, "updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ChiffreAffaires newChiffreAffaires = addChiffreAffaires();

		ChiffreAffaires existingChiffreAffaires =
			_persistence.fetchByPrimaryKey(newChiffreAffaires.getPrimaryKey());

		Assert.assertEquals(existingChiffreAffaires, newChiffreAffaires);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChiffreAffaires missingChiffreAffaires = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingChiffreAffaires);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ChiffreAffaires newChiffreAffaires1 = addChiffreAffaires();
		ChiffreAffaires newChiffreAffaires2 = addChiffreAffaires();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChiffreAffaires1.getPrimaryKey());
		primaryKeys.add(newChiffreAffaires2.getPrimaryKey());

		Map<Serializable, ChiffreAffaires> chiffreAffaireses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, chiffreAffaireses.size());
		Assert.assertEquals(
			newChiffreAffaires1,
			chiffreAffaireses.get(newChiffreAffaires1.getPrimaryKey()));
		Assert.assertEquals(
			newChiffreAffaires2,
			chiffreAffaireses.get(newChiffreAffaires2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ChiffreAffaires> chiffreAffaireses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(chiffreAffaireses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ChiffreAffaires newChiffreAffaires = addChiffreAffaires();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChiffreAffaires.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ChiffreAffaires> chiffreAffaireses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, chiffreAffaireses.size());
		Assert.assertEquals(
			newChiffreAffaires,
			chiffreAffaireses.get(newChiffreAffaires.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ChiffreAffaires> chiffreAffaireses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(chiffreAffaireses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ChiffreAffaires newChiffreAffaires = addChiffreAffaires();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newChiffreAffaires.getPrimaryKey());

		Map<Serializable, ChiffreAffaires> chiffreAffaireses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, chiffreAffaireses.size());
		Assert.assertEquals(
			newChiffreAffaires,
			chiffreAffaireses.get(newChiffreAffaires.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ChiffreAffairesLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ChiffreAffaires>() {

				@Override
				public void performAction(ChiffreAffaires chiffreAffaires) {
					Assert.assertNotNull(chiffreAffaires);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ChiffreAffaires newChiffreAffaires = addChiffreAffaires();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChiffreAffaires.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newChiffreAffaires.getId()));

		List<ChiffreAffaires> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ChiffreAffaires existingChiffreAffaires = result.get(0);

		Assert.assertEquals(existingChiffreAffaires, newChiffreAffaires);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChiffreAffaires.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<ChiffreAffaires> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ChiffreAffaires newChiffreAffaires = addChiffreAffaires();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ChiffreAffaires.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newChiffreAffaires.getId();

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
			ChiffreAffaires.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ChiffreAffaires addChiffreAffaires() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ChiffreAffaires chiffreAffaires = _persistence.create(pk);

		chiffreAffaires.setTerminalId(RandomTestUtil.nextLong());

		chiffreAffaires.setBrut(RandomTestUtil.nextLong());

		chiffreAffaires.setPaiement(RandomTestUtil.nextLong());

		chiffreAffaires.setAnnulation(RandomTestUtil.nextLong());

		chiffreAffaires.setRemboursement(RandomTestUtil.nextLong());

		chiffreAffaires.setVentes(RandomTestUtil.nextLong());

		chiffreAffaires.setBalance(RandomTestUtil.nextLong());

		chiffreAffaires.setDeposit(RandomTestUtil.nextLong());

		chiffreAffaires.setDate(RandomTestUtil.nextDate());

		chiffreAffaires.setCreatedAt(RandomTestUtil.nextDate());

		chiffreAffaires.setUpdatedAt(RandomTestUtil.nextDate());

		_chiffreAffaireses.add(_persistence.update(chiffreAffaires));

		return chiffreAffaires;
	}

	private List<ChiffreAffaires> _chiffreAffaireses =
		new ArrayList<ChiffreAffaires>();
	private ChiffreAffairesPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}