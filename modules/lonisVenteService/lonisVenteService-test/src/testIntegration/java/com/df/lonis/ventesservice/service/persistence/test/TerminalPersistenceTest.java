/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.test;

import com.df.lonis.ventesservice.exception.NoSuchTerminalException;
import com.df.lonis.ventesservice.model.Terminal;
import com.df.lonis.ventesservice.service.TerminalLocalServiceUtil;
import com.df.lonis.ventesservice.service.persistence.TerminalPersistence;
import com.df.lonis.ventesservice.service.persistence.TerminalUtil;

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
public class TerminalPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.df.lonis.ventesservice.service"));

	@Before
	public void setUp() {
		_persistence = TerminalUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Terminal> iterator = _terminals.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Terminal terminal = _persistence.create(pk);

		Assert.assertNotNull(terminal);

		Assert.assertEquals(terminal.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Terminal newTerminal = addTerminal();

		_persistence.remove(newTerminal);

		Terminal existingTerminal = _persistence.fetchByPrimaryKey(
			newTerminal.getPrimaryKey());

		Assert.assertNull(existingTerminal);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTerminal();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Terminal newTerminal = _persistence.create(pk);

		newTerminal.setCodeTerminal(RandomTestUtil.randomString());

		newTerminal.setConcessionnaireId(RandomTestUtil.nextLong());

		newTerminal.setConcessionnaireCode(RandomTestUtil.randomString());

		newTerminal.setProduitId(RandomTestUtil.nextLong());

		newTerminal.setConcessionnaireProduitCode(
			RandomTestUtil.randomString());

		newTerminal.setSiteId(RandomTestUtil.nextLong());

		newTerminal.setLatitude();

		newTerminal.setLongitude();

		newTerminal.setAdresse(RandomTestUtil.randomString());

		newTerminal.setStatutValidation(RandomTestUtil.randomString());

		newTerminal.setCreatedAt(RandomTestUtil.nextDate());

		newTerminal.setUpdatedAt(RandomTestUtil.nextDate());

		_terminals.add(_persistence.update(newTerminal));

		Terminal existingTerminal = _persistence.findByPrimaryKey(
			newTerminal.getPrimaryKey());

		Assert.assertEquals(existingTerminal.getId(), newTerminal.getId());
		Assert.assertEquals(
			existingTerminal.getCodeTerminal(), newTerminal.getCodeTerminal());
		Assert.assertEquals(
			existingTerminal.getConcessionnaireId(),
			newTerminal.getConcessionnaireId());
		Assert.assertEquals(
			existingTerminal.getConcessionnaireCode(),
			newTerminal.getConcessionnaireCode());
		Assert.assertEquals(
			existingTerminal.getProduitId(), newTerminal.getProduitId());
		Assert.assertEquals(
			existingTerminal.getConcessionnaireProduitCode(),
			newTerminal.getConcessionnaireProduitCode());
		Assert.assertEquals(
			existingTerminal.getSiteId(), newTerminal.getSiteId());
		Assert.assertEquals(
			existingTerminal.getLatitude(), newTerminal.getLatitude());
		Assert.assertEquals(
			existingTerminal.getLongitude(), newTerminal.getLongitude());
		Assert.assertEquals(
			existingTerminal.getAdresse(), newTerminal.getAdresse());
		Assert.assertEquals(
			existingTerminal.getStatutValidation(),
			newTerminal.getStatutValidation());
		Assert.assertEquals(
			Time.getShortTimestamp(existingTerminal.getCreatedAt()),
			Time.getShortTimestamp(newTerminal.getCreatedAt()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingTerminal.getUpdatedAt()),
			Time.getShortTimestamp(newTerminal.getUpdatedAt()));
	}

	@Test
	public void testCountByConcessionnaireProduitCode() throws Exception {
		_persistence.countByConcessionnaireProduitCode("");

		_persistence.countByConcessionnaireProduitCode("null");

		_persistence.countByConcessionnaireProduitCode((String)null);
	}

	@Test
	public void testCountByConcessionnaireId() throws Exception {
		_persistence.countByConcessionnaireId(RandomTestUtil.nextLong());

		_persistence.countByConcessionnaireId(0L);
	}

	@Test
	public void testCountBySiteId() throws Exception {
		_persistence.countBySiteId(RandomTestUtil.nextLong());

		_persistence.countBySiteId(0L);
	}

	@Test
	public void testCountByStatutValidation() throws Exception {
		_persistence.countByStatutValidation("");

		_persistence.countByStatutValidation("null");

		_persistence.countByStatutValidation((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Terminal newTerminal = addTerminal();

		Terminal existingTerminal = _persistence.findByPrimaryKey(
			newTerminal.getPrimaryKey());

		Assert.assertEquals(existingTerminal, newTerminal);
	}

	@Test(expected = NoSuchTerminalException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Terminal> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"terminals", "id", true, "codeTerminal", true, "concessionnaireId",
			true, "concessionnaireCode", true, "produitId", true,
			"concessionnaireProduitCode", true, "siteId", true, "latitude",
			true, "longitude", true, "adresse", true, "statutValidation", true,
			"createdAt", true, "updatedAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Terminal newTerminal = addTerminal();

		Terminal existingTerminal = _persistence.fetchByPrimaryKey(
			newTerminal.getPrimaryKey());

		Assert.assertEquals(existingTerminal, newTerminal);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Terminal missingTerminal = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTerminal);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Terminal newTerminal1 = addTerminal();
		Terminal newTerminal2 = addTerminal();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTerminal1.getPrimaryKey());
		primaryKeys.add(newTerminal2.getPrimaryKey());

		Map<Serializable, Terminal> terminals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, terminals.size());
		Assert.assertEquals(
			newTerminal1, terminals.get(newTerminal1.getPrimaryKey()));
		Assert.assertEquals(
			newTerminal2, terminals.get(newTerminal2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Terminal> terminals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(terminals.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Terminal newTerminal = addTerminal();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTerminal.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Terminal> terminals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, terminals.size());
		Assert.assertEquals(
			newTerminal, terminals.get(newTerminal.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Terminal> terminals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(terminals.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Terminal newTerminal = addTerminal();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTerminal.getPrimaryKey());

		Map<Serializable, Terminal> terminals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, terminals.size());
		Assert.assertEquals(
			newTerminal, terminals.get(newTerminal.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TerminalLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Terminal>() {

				@Override
				public void performAction(Terminal terminal) {
					Assert.assertNotNull(terminal);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Terminal newTerminal = addTerminal();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Terminal.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newTerminal.getId()));

		List<Terminal> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Terminal existingTerminal = result.get(0);

		Assert.assertEquals(existingTerminal, newTerminal);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Terminal.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Terminal> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Terminal newTerminal = addTerminal();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Terminal.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newTerminal.getId();

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
			Terminal.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Terminal addTerminal() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Terminal terminal = _persistence.create(pk);

		terminal.setCodeTerminal(RandomTestUtil.randomString());

		terminal.setConcessionnaireId(RandomTestUtil.nextLong());

		terminal.setConcessionnaireCode(RandomTestUtil.randomString());

		terminal.setProduitId(RandomTestUtil.nextLong());

		terminal.setConcessionnaireProduitCode(RandomTestUtil.randomString());

		terminal.setSiteId(RandomTestUtil.nextLong());

		terminal.setLatitude();

		terminal.setLongitude();

		terminal.setAdresse(RandomTestUtil.randomString());

		terminal.setStatutValidation(RandomTestUtil.randomString());

		terminal.setCreatedAt(RandomTestUtil.nextDate());

		terminal.setUpdatedAt(RandomTestUtil.nextDate());

		_terminals.add(_persistence.update(terminal));

		return terminal;
	}

	private List<Terminal> _terminals = new ArrayList<Terminal>();
	private TerminalPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}