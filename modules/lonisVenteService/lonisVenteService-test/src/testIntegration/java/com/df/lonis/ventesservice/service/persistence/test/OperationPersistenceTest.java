/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchOperationException;
import com.df.lonis.ventesservice.model.Operation;
import com.df.lonis.ventesservice.service.OperationLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.OperationPersistence;
import com.df.lonis.ventesservice.service.persistence.OperationUtil;

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
public class OperationPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = OperationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Operation> iterator = _operations.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Operation operation = _persistence.create(pk);

		Assert.assertNotNull(operation);

		Assert.assertEquals(operation.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Operation newOperation = addOperation();

		_persistence.remove(newOperation);

		Operation existingOperation = _persistence.fetchByPrimaryKey(
			newOperation.getPrimaryKey());

		Assert.assertNull(existingOperation);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addOperation();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Operation newOperation = _persistence.create(pk);

		newOperation.setCode(RandomTestUtil.randomString());

		newOperation.setLibelle(RandomTestUtil.randomString());

		newOperation.setReference(RandomTestUtil.randomString());

		newOperation.setMontant(RandomTestUtil.nextLong());

		newOperation.setMontantReel(RandomTestUtil.nextLong());

		newOperation.setStatut(RandomTestUtil.randomString());

		newOperation.setTerminalId(RandomTestUtil.nextLong());

		newOperation.setGuichet(RandomTestUtil.randomString());

		newOperation.setDateOperation(RandomTestUtil.nextDate());

		newOperation.setCreatedAt(RandomTestUtil.nextDate());

		newOperation.setUpdatedAt(RandomTestUtil.nextDate());

		_operations.add(_persistence.update(newOperation));

		Operation existingOperation = _persistence.findByPrimaryKey(
			newOperation.getPrimaryKey());

		Assert.assertEquals(existingOperation.getId(), newOperation.getId());
		Assert.assertEquals(
			existingOperation.getCode(), newOperation.getCode());
		Assert.assertEquals(
			existingOperation.getLibelle(), newOperation.getLibelle());
		Assert.assertEquals(
			existingOperation.getReference(), newOperation.getReference());
		Assert.assertEquals(
			existingOperation.getMontant(), newOperation.getMontant());
		Assert.assertEquals(
			existingOperation.getMontantReel(), newOperation.getMontantReel());
		Assert.assertEquals(
			existingOperation.getStatut(), newOperation.getStatut());
		Assert.assertEquals(
			existingOperation.getTerminalId(), newOperation.getTerminalId());
		Assert.assertEquals(
			existingOperation.getGuichet(), newOperation.getGuichet());
		Assert.assertEquals(
			Time.getShortTimestamp(existingOperation.getDateOperation()),
			Time.getShortTimestamp(newOperation.getDateOperation()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingOperation.getCreatedAt()),
			Time.getShortTimestamp(newOperation.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingOperation.getUpdatedAt()),
			Time.getShortTimestamp(newOperation.getUpdatedAt()));
	}

	@Test
	public void testCountByTerminalId() throws Exception {
		_persistence.countByTerminalId(RandomTestUtil.nextLong());

		_persistence.countByTerminalId(0L);
	}

	@Test
	public void testCountByReference() throws Exception {
		_persistence.countByReference("");

		_persistence.countByReference("null");

		_persistence.countByReference((String)null);
	}

	@Test
	public void testCountByStatut() throws Exception {
		_persistence.countByStatut("");

		_persistence.countByStatut("null");

		_persistence.countByStatut((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Operation newOperation = addOperation();

		Operation existingOperation = _persistence.findByPrimaryKey(
			newOperation.getPrimaryKey());

		Assert.assertEquals(existingOperation, newOperation);
	}

	@Test(expected = NoSuchOperationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Operation> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"operations", "id", true, "code", true, "libelle", true,
			"reference", true, "montant", true, "montantReel", true, "statut",
			true, "terminalId", true, "guichet", true, "dateOperation", true,
			"createdAt", true, "updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Operation newOperation = addOperation();

		Operation existingOperation = _persistence.fetchByPrimaryKey(
			newOperation.getPrimaryKey());

		Assert.assertEquals(existingOperation, newOperation);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Operation missingOperation = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingOperation);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Operation newOperation1 = addOperation();
		Operation newOperation2 = addOperation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOperation1.getPrimaryKey());
		primaryKeys.add(newOperation2.getPrimaryKey());

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, operations.size());
		Assert.assertEquals(
			newOperation1, operations.get(newOperation1.getPrimaryKey()));
		Assert.assertEquals(
			newOperation2, operations.get(newOperation2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(operations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Operation newOperation = addOperation();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOperation.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, operations.size());
		Assert.assertEquals(
			newOperation, operations.get(newOperation.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(operations.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Operation newOperation = addOperation();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOperation.getPrimaryKey());

		Map<Serializable, Operation> operations =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, operations.size());
		Assert.assertEquals(
			newOperation, operations.get(newOperation.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			OperationLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Operation>() {

				@Override
				public void performAction(Operation operation) {
					Assert.assertNotNull(operation);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Operation newOperation = addOperation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newOperation.getId()));

		List<Operation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Operation existingOperation = result.get(0);

		Assert.assertEquals(existingOperation, newOperation);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Operation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Operation newOperation = addOperation();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newOperation.getId();

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
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Operation newOperation = addOperation();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newOperation.getPrimaryKey()));
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

		Operation newOperation = addOperation();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Operation.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newOperation.getId()));

		List<Operation> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Operation operation) {
		Assert.assertEquals(
			operation.getReference(),
			ReflectionTestUtil.invoke(
				operation, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "reference"));
	}

	protected Operation addOperation() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Operation operation = _persistence.create(pk);

		operation.setCode(RandomTestUtil.randomString());

		operation.setLibelle(RandomTestUtil.randomString());

		operation.setReference(RandomTestUtil.randomString());

		operation.setMontant(RandomTestUtil.nextLong());

		operation.setMontantReel(RandomTestUtil.nextLong());

		operation.setStatut(RandomTestUtil.randomString());

		operation.setTerminalId(RandomTestUtil.nextLong());

		operation.setGuichet(RandomTestUtil.randomString());

		operation.setDateOperation(RandomTestUtil.nextDate());

		operation.setCreatedAt(RandomTestUtil.nextDate());

		operation.setUpdatedAt(RandomTestUtil.nextDate());

		_operations.add(_persistence.update(operation));

		return operation;
	}

	private List<Operation> _operations = new ArrayList<Operation>();
	private OperationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}