/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchCommissionException;
import com.df.lonis.ventesservice.model.Commission;
import com.df.lonis.ventesservice.service.CommissionLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.CommissionPersistence;
import com.df.lonis.ventesservice.service.persistence.CommissionUtil;

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
public class CommissionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = CommissionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Commission> iterator = _commissions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Commission commission = _persistence.create(pk);

		Assert.assertNotNull(commission);

		Assert.assertEquals(commission.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Commission newCommission = addCommission();

		_persistence.remove(newCommission);

		Commission existingCommission = _persistence.fetchByPrimaryKey(
			newCommission.getPrimaryKey());

		Assert.assertNull(existingCommission);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCommission();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Commission newCommission = _persistence.create(pk);

		newCommission.setCode(RandomTestUtil.randomString());

		newCommission.setTerminalId(RandomTestUtil.nextLong());

		newCommission.setNombreTerminal(RandomTestUtil.nextInt());

		newCommission.setPaye(RandomTestUtil.randomBoolean());

		newCommission.setLibelle(RandomTestUtil.randomString());

		newCommission.setStatus(RandomTestUtil.randomString());

		newCommission.setCreatedAt(RandomTestUtil.nextDate());

		newCommission.setUpdatedAt(RandomTestUtil.nextDate());

		_commissions.add(_persistence.update(newCommission));

		Commission existingCommission = _persistence.findByPrimaryKey(
			newCommission.getPrimaryKey());

		Assert.assertEquals(existingCommission.getId(), newCommission.getId());
		Assert.assertEquals(
			existingCommission.getCode(), newCommission.getCode());
		Assert.assertEquals(
			existingCommission.getTerminalId(), newCommission.getTerminalId());
		Assert.assertEquals(
			existingCommission.getNombreTerminal(),
			newCommission.getNombreTerminal());
		Assert.assertEquals(
			existingCommission.isPaye(), newCommission.isPaye());
		Assert.assertEquals(
			existingCommission.getLibelle(), newCommission.getLibelle());
		Assert.assertEquals(
			existingCommission.getStatus(), newCommission.getStatus());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommission.getCreatedAt()),
			Time.getShortTimestamp(newCommission.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCommission.getUpdatedAt()),
			Time.getShortTimestamp(newCommission.getUpdatedAt()));
	}

	@Test
	public void testCountByTerminalId() throws Exception {
		_persistence.countByTerminalId(RandomTestUtil.nextLong());

		_persistence.countByTerminalId(0L);
	}

	@Test
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus("");

		_persistence.countByStatus("null");

		_persistence.countByStatus((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Commission newCommission = addCommission();

		Commission existingCommission = _persistence.findByPrimaryKey(
			newCommission.getPrimaryKey());

		Assert.assertEquals(existingCommission, newCommission);
	}

	@Test(expected = NoSuchCommissionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Commission> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"commissions", "id", true, "code", true, "terminalId", true,
			"nombreTerminal", true, "paye", true, "libelle", true, "status",
			true, "createdAt", true, "updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Commission newCommission = addCommission();

		Commission existingCommission = _persistence.fetchByPrimaryKey(
			newCommission.getPrimaryKey());

		Assert.assertEquals(existingCommission, newCommission);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Commission missingCommission = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCommission);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Commission newCommission1 = addCommission();
		Commission newCommission2 = addCommission();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommission1.getPrimaryKey());
		primaryKeys.add(newCommission2.getPrimaryKey());

		Map<Serializable, Commission> commissions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, commissions.size());
		Assert.assertEquals(
			newCommission1, commissions.get(newCommission1.getPrimaryKey()));
		Assert.assertEquals(
			newCommission2, commissions.get(newCommission2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Commission> commissions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(commissions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Commission newCommission = addCommission();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommission.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Commission> commissions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, commissions.size());
		Assert.assertEquals(
			newCommission, commissions.get(newCommission.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Commission> commissions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(commissions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Commission newCommission = addCommission();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCommission.getPrimaryKey());

		Map<Serializable, Commission> commissions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, commissions.size());
		Assert.assertEquals(
			newCommission, commissions.get(newCommission.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CommissionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Commission>() {

				@Override
				public void performAction(Commission commission) {
					Assert.assertNotNull(commission);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Commission newCommission = addCommission();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Commission.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newCommission.getId()));

		List<Commission> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Commission existingCommission = result.get(0);

		Assert.assertEquals(existingCommission, newCommission);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Commission.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Commission> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Commission newCommission = addCommission();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Commission.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newCommission.getId();

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
			Commission.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Commission addCommission() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Commission commission = _persistence.create(pk);

		commission.setCode(RandomTestUtil.randomString());

		commission.setTerminalId(RandomTestUtil.nextLong());

		commission.setNombreTerminal(RandomTestUtil.nextInt());

		commission.setPaye(RandomTestUtil.randomBoolean());

		commission.setLibelle(RandomTestUtil.randomString());

		commission.setStatus(RandomTestUtil.randomString());

		commission.setCreatedAt(RandomTestUtil.nextDate());

		commission.setUpdatedAt(RandomTestUtil.nextDate());

		_commissions.add(_persistence.update(commission));

		return commission;
	}

	private List<Commission> _commissions = new ArrayList<Commission>();
	private CommissionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}