/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchOperationException;
import com.df.lonis.ventesservice.model.Operation;
import com.df.lonis.ventesservice.model.OperationTable;
import com.df.lonis.ventesservice.model.impl.OperationImpl;
import com.df.lonis.ventesservice.model.impl.OperationModelImpl;
import com.df.lonis.ventesservice.service.persistence.OperationPersistence;
import com.df.lonis.ventesservice.service.persistence.OperationUtil;
import com.df.lonis.ventesservice.service.persistence.impl.constants.LONISPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the operation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OperationPersistence.class)
public class OperationPersistenceImpl
	extends BasePersistenceImpl<Operation> implements OperationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OperationUtil</code> to access the operation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OperationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTerminalId;
	private FinderPath _finderPathWithoutPaginationFindByTerminalId;
	private FinderPath _finderPathCountByTerminalId;

	/**
	 * Returns all the operations where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching operations
	 */
	@Override
	public List<Operation> findByTerminalId(long terminalId) {
		return findByTerminalId(
			terminalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the operations where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of matching operations
	 */
	@Override
	public List<Operation> findByTerminalId(
		long terminalId, int start, int end) {

		return findByTerminalId(terminalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the operations where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching operations
	 */
	@Override
	public List<Operation> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Operation> orderByComparator) {

		return findByTerminalId(
			terminalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the operations where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching operations
	 */
	@Override
	public List<Operation> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Operation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTerminalId;
				finderArgs = new Object[] {terminalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTerminalId;
			finderArgs = new Object[] {
				terminalId, start, end, orderByComparator
			};
		}

		List<Operation> list = null;

		if (useFinderCache) {
			list = (List<Operation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Operation operation : list) {
					if (terminalId != operation.getTerminalId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OPERATION_WHERE);

			sb.append(_FINDER_COLUMN_TERMINALID_TERMINALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OperationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(terminalId);

				list = (List<Operation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	@Override
	public Operation findByTerminalId_First(
			long terminalId, OrderByComparator<Operation> orderByComparator)
		throws NoSuchOperationException {

		Operation operation = fetchByTerminalId_First(
			terminalId, orderByComparator);

		if (operation != null) {
			return operation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append("}");

		throw new NoSuchOperationException(sb.toString());
	}

	/**
	 * Returns the first operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 */
	@Override
	public Operation fetchByTerminalId_First(
		long terminalId, OrderByComparator<Operation> orderByComparator) {

		List<Operation> list = findByTerminalId(
			terminalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	@Override
	public Operation findByTerminalId_Last(
			long terminalId, OrderByComparator<Operation> orderByComparator)
		throws NoSuchOperationException {

		Operation operation = fetchByTerminalId_Last(
			terminalId, orderByComparator);

		if (operation != null) {
			return operation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append("}");

		throw new NoSuchOperationException(sb.toString());
	}

	/**
	 * Returns the last operation in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 */
	@Override
	public Operation fetchByTerminalId_Last(
		long terminalId, OrderByComparator<Operation> orderByComparator) {

		int count = countByTerminalId(terminalId);

		if (count == 0) {
			return null;
		}

		List<Operation> list = findByTerminalId(
			terminalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the operations before and after the current operation in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current operation
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	@Override
	public Operation[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			OrderByComparator<Operation> orderByComparator)
		throws NoSuchOperationException {

		Operation operation = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Operation[] array = new OperationImpl[3];

			array[0] = getByTerminalId_PrevAndNext(
				session, operation, terminalId, orderByComparator, true);

			array[1] = operation;

			array[2] = getByTerminalId_PrevAndNext(
				session, operation, terminalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Operation getByTerminalId_PrevAndNext(
		Session session, Operation operation, long terminalId,
		OrderByComparator<Operation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OPERATION_WHERE);

		sb.append(_FINDER_COLUMN_TERMINALID_TERMINALID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OperationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(terminalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(operation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Operation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the operations where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	@Override
	public void removeByTerminalId(long terminalId) {
		for (Operation operation :
				findByTerminalId(
					terminalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(operation);
		}
	}

	/**
	 * Returns the number of operations where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching operations
	 */
	@Override
	public int countByTerminalId(long terminalId) {
		FinderPath finderPath = _finderPathCountByTerminalId;

		Object[] finderArgs = new Object[] {terminalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OPERATION_WHERE);

			sb.append(_FINDER_COLUMN_TERMINALID_TERMINALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(terminalId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TERMINALID_TERMINALID_2 =
		"operation.terminalId = ?";

	private FinderPath _finderPathFetchByReference;

	/**
	 * Returns the operation where reference = &#63; or throws a <code>NoSuchOperationException</code> if it could not be found.
	 *
	 * @param reference the reference
	 * @return the matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	@Override
	public Operation findByReference(String reference)
		throws NoSuchOperationException {

		Operation operation = fetchByReference(reference);

		if (operation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("reference=");
			sb.append(reference);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchOperationException(sb.toString());
		}

		return operation;
	}

	/**
	 * Returns the operation where reference = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param reference the reference
	 * @return the matching operation, or <code>null</code> if a matching operation could not be found
	 */
	@Override
	public Operation fetchByReference(String reference) {
		return fetchByReference(reference, true);
	}

	/**
	 * Returns the operation where reference = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param reference the reference
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching operation, or <code>null</code> if a matching operation could not be found
	 */
	@Override
	public Operation fetchByReference(
		String reference, boolean useFinderCache) {

		reference = Objects.toString(reference, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {reference};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByReference, finderArgs, this);
		}

		if (result instanceof Operation) {
			Operation operation = (Operation)result;

			if (!Objects.equals(reference, operation.getReference())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_OPERATION_WHERE);

			boolean bindReference = false;

			if (reference.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFERENCE_REFERENCE_3);
			}
			else {
				bindReference = true;

				sb.append(_FINDER_COLUMN_REFERENCE_REFERENCE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindReference) {
					queryPos.add(reference);
				}

				List<Operation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByReference, finderArgs, list);
					}
				}
				else {
					Operation operation = list.get(0);

					result = operation;

					cacheResult(operation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Operation)result;
		}
	}

	/**
	 * Removes the operation where reference = &#63; from the database.
	 *
	 * @param reference the reference
	 * @return the operation that was removed
	 */
	@Override
	public Operation removeByReference(String reference)
		throws NoSuchOperationException {

		Operation operation = findByReference(reference);

		return remove(operation);
	}

	/**
	 * Returns the number of operations where reference = &#63;.
	 *
	 * @param reference the reference
	 * @return the number of matching operations
	 */
	@Override
	public int countByReference(String reference) {
		Operation operation = fetchByReference(reference);

		if (operation == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_REFERENCE_REFERENCE_2 =
		"operation.reference = ?";

	private static final String _FINDER_COLUMN_REFERENCE_REFERENCE_3 =
		"(operation.reference IS NULL OR operation.reference = '')";

	private FinderPath _finderPathWithPaginationFindByStatut;
	private FinderPath _finderPathWithoutPaginationFindByStatut;
	private FinderPath _finderPathCountByStatut;

	/**
	 * Returns all the operations where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching operations
	 */
	@Override
	public List<Operation> findByStatut(String statut) {
		return findByStatut(statut, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the operations where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of matching operations
	 */
	@Override
	public List<Operation> findByStatut(String statut, int start, int end) {
		return findByStatut(statut, start, end, null);
	}

	/**
	 * Returns an ordered range of all the operations where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching operations
	 */
	@Override
	public List<Operation> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Operation> orderByComparator) {

		return findByStatut(statut, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the operations where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching operations
	 */
	@Override
	public List<Operation> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Operation> orderByComparator,
		boolean useFinderCache) {

		statut = Objects.toString(statut, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatut;
				finderArgs = new Object[] {statut};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatut;
			finderArgs = new Object[] {statut, start, end, orderByComparator};
		}

		List<Operation> list = null;

		if (useFinderCache) {
			list = (List<Operation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Operation operation : list) {
					if (!statut.equals(operation.getStatut())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OPERATION_WHERE);

			boolean bindStatut = false;

			if (statut.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUT_STATUT_3);
			}
			else {
				bindStatut = true;

				sb.append(_FINDER_COLUMN_STATUT_STATUT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OperationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatut) {
					queryPos.add(statut);
				}

				list = (List<Operation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	@Override
	public Operation findByStatut_First(
			String statut, OrderByComparator<Operation> orderByComparator)
		throws NoSuchOperationException {

		Operation operation = fetchByStatut_First(statut, orderByComparator);

		if (operation != null) {
			return operation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statut=");
		sb.append(statut);

		sb.append("}");

		throw new NoSuchOperationException(sb.toString());
	}

	/**
	 * Returns the first operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching operation, or <code>null</code> if a matching operation could not be found
	 */
	@Override
	public Operation fetchByStatut_First(
		String statut, OrderByComparator<Operation> orderByComparator) {

		List<Operation> list = findByStatut(statut, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation
	 * @throws NoSuchOperationException if a matching operation could not be found
	 */
	@Override
	public Operation findByStatut_Last(
			String statut, OrderByComparator<Operation> orderByComparator)
		throws NoSuchOperationException {

		Operation operation = fetchByStatut_Last(statut, orderByComparator);

		if (operation != null) {
			return operation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statut=");
		sb.append(statut);

		sb.append("}");

		throw new NoSuchOperationException(sb.toString());
	}

	/**
	 * Returns the last operation in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching operation, or <code>null</code> if a matching operation could not be found
	 */
	@Override
	public Operation fetchByStatut_Last(
		String statut, OrderByComparator<Operation> orderByComparator) {

		int count = countByStatut(statut);

		if (count == 0) {
			return null;
		}

		List<Operation> list = findByStatut(
			statut, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the operations before and after the current operation in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current operation
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	@Override
	public Operation[] findByStatut_PrevAndNext(
			long id, String statut,
			OrderByComparator<Operation> orderByComparator)
		throws NoSuchOperationException {

		statut = Objects.toString(statut, "");

		Operation operation = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Operation[] array = new OperationImpl[3];

			array[0] = getByStatut_PrevAndNext(
				session, operation, statut, orderByComparator, true);

			array[1] = operation;

			array[2] = getByStatut_PrevAndNext(
				session, operation, statut, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Operation getByStatut_PrevAndNext(
		Session session, Operation operation, String statut,
		OrderByComparator<Operation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OPERATION_WHERE);

		boolean bindStatut = false;

		if (statut.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUT_STATUT_3);
		}
		else {
			bindStatut = true;

			sb.append(_FINDER_COLUMN_STATUT_STATUT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OperationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatut) {
			queryPos.add(statut);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(operation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Operation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the operations where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	@Override
	public void removeByStatut(String statut) {
		for (Operation operation :
				findByStatut(
					statut, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(operation);
		}
	}

	/**
	 * Returns the number of operations where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching operations
	 */
	@Override
	public int countByStatut(String statut) {
		statut = Objects.toString(statut, "");

		FinderPath finderPath = _finderPathCountByStatut;

		Object[] finderArgs = new Object[] {statut};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OPERATION_WHERE);

			boolean bindStatut = false;

			if (statut.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUT_STATUT_3);
			}
			else {
				bindStatut = true;

				sb.append(_FINDER_COLUMN_STATUT_STATUT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatut) {
					queryPos.add(statut);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUT_STATUT_2 =
		"operation.statut = ?";

	private static final String _FINDER_COLUMN_STATUT_STATUT_3 =
		"(operation.statut IS NULL OR operation.statut = '')";

	public OperationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("montantReel", "montant_reel");
		dbColumnNames.put("terminalId", "terminal_id");
		dbColumnNames.put("dateOperation", "date_operation");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Operation.class);

		setModelImplClass(OperationImpl.class);
		setModelPKClass(long.class);

		setTable(OperationTable.INSTANCE);
	}

	/**
	 * Caches the operation in the entity cache if it is enabled.
	 *
	 * @param operation the operation
	 */
	@Override
	public void cacheResult(Operation operation) {
		entityCache.putResult(
			OperationImpl.class, operation.getPrimaryKey(), operation);

		finderCache.putResult(
			_finderPathFetchByReference,
			new Object[] {operation.getReference()}, operation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the operations in the entity cache if it is enabled.
	 *
	 * @param operations the operations
	 */
	@Override
	public void cacheResult(List<Operation> operations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (operations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Operation operation : operations) {
			if (entityCache.getResult(
					OperationImpl.class, operation.getPrimaryKey()) == null) {

				cacheResult(operation);
			}
		}
	}

	/**
	 * Clears the cache for all operations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OperationImpl.class);

		finderCache.clearCache(OperationImpl.class);
	}

	/**
	 * Clears the cache for the operation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Operation operation) {
		entityCache.removeResult(OperationImpl.class, operation);
	}

	@Override
	public void clearCache(List<Operation> operations) {
		for (Operation operation : operations) {
			entityCache.removeResult(OperationImpl.class, operation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(OperationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OperationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		OperationModelImpl operationModelImpl) {

		Object[] args = new Object[] {operationModelImpl.getReference()};

		finderCache.putResult(
			_finderPathFetchByReference, args, operationModelImpl);
	}

	/**
	 * Creates a new operation with the primary key. Does not add the operation to the database.
	 *
	 * @param id the primary key for the new operation
	 * @return the new operation
	 */
	@Override
	public Operation create(long id) {
		Operation operation = new OperationImpl();

		operation.setNew(true);
		operation.setPrimaryKey(id);

		return operation;
	}

	/**
	 * Removes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the operation
	 * @return the operation that was removed
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	@Override
	public Operation remove(long id) throws NoSuchOperationException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the operation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the operation
	 * @return the operation that was removed
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	@Override
	public Operation remove(Serializable primaryKey)
		throws NoSuchOperationException {

		Session session = null;

		try {
			session = openSession();

			Operation operation = (Operation)session.get(
				OperationImpl.class, primaryKey);

			if (operation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOperationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(operation);
		}
		catch (NoSuchOperationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Operation removeImpl(Operation operation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(operation)) {
				operation = (Operation)session.get(
					OperationImpl.class, operation.getPrimaryKeyObj());
			}

			if (operation != null) {
				session.delete(operation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (operation != null) {
			clearCache(operation);
		}

		return operation;
	}

	@Override
	public Operation updateImpl(Operation operation) {
		boolean isNew = operation.isNew();

		if (!(operation instanceof OperationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(operation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(operation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in operation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Operation implementation " +
					operation.getClass());
		}

		OperationModelImpl operationModelImpl = (OperationModelImpl)operation;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(operation);
			}
			else {
				operation = (Operation)session.merge(operation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OperationImpl.class, operationModelImpl, false, true);

		cacheUniqueFindersCache(operationModelImpl);

		if (isNew) {
			operation.setNew(false);
		}

		operation.resetOriginalValues();

		return operation;
	}

	/**
	 * Returns the operation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the operation
	 * @return the operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	@Override
	public Operation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOperationException {

		Operation operation = fetchByPrimaryKey(primaryKey);

		if (operation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOperationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return operation;
	}

	/**
	 * Returns the operation with the primary key or throws a <code>NoSuchOperationException</code> if it could not be found.
	 *
	 * @param id the primary key of the operation
	 * @return the operation
	 * @throws NoSuchOperationException if a operation with the primary key could not be found
	 */
	@Override
	public Operation findByPrimaryKey(long id) throws NoSuchOperationException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the operation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the operation
	 * @return the operation, or <code>null</code> if a operation with the primary key could not be found
	 */
	@Override
	public Operation fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the operations.
	 *
	 * @return the operations
	 */
	@Override
	public List<Operation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @return the range of operations
	 */
	@Override
	public List<Operation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of operations
	 */
	@Override
	public List<Operation> findAll(
		int start, int end, OrderByComparator<Operation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the operations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OperationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of operations
	 * @param end the upper bound of the range of operations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of operations
	 */
	@Override
	public List<Operation> findAll(
		int start, int end, OrderByComparator<Operation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Operation> list = null;

		if (useFinderCache) {
			list = (List<Operation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OPERATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OPERATION;

				sql = sql.concat(OperationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Operation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the operations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Operation operation : findAll()) {
			remove(operation);
		}
	}

	/**
	 * Returns the number of operations.
	 *
	 * @return the number of operations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OPERATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OPERATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OperationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the operation persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByTerminalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTerminalId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"terminal_id"}, true);

		_finderPathWithoutPaginationFindByTerminalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTerminalId",
			new String[] {Long.class.getName()}, new String[] {"terminal_id"},
			true);

		_finderPathCountByTerminalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTerminalId",
			new String[] {Long.class.getName()}, new String[] {"terminal_id"},
			false);

		_finderPathFetchByReference = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByReference",
			new String[] {String.class.getName()}, new String[] {"reference"},
			true);

		_finderPathWithPaginationFindByStatut = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatut",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"statut"}, true);

		_finderPathWithoutPaginationFindByStatut = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatut",
			new String[] {String.class.getName()}, new String[] {"statut"},
			true);

		_finderPathCountByStatut = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatut",
			new String[] {String.class.getName()}, new String[] {"statut"},
			false);

		OperationUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		OperationUtil.setPersistence(null);

		entityCache.removeCache(OperationImpl.class.getName());
	}

	@Override
	@Reference(
		target = LONISPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LONISPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LONISPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OPERATION =
		"SELECT operation FROM Operation operation";

	private static final String _SQL_SELECT_OPERATION_WHERE =
		"SELECT operation FROM Operation operation WHERE ";

	private static final String _SQL_COUNT_OPERATION =
		"SELECT COUNT(operation) FROM Operation operation";

	private static final String _SQL_COUNT_OPERATION_WHERE =
		"SELECT COUNT(operation) FROM Operation operation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "operation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Operation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Operation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OperationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"montantReel", "terminalId", "dateOperation", "createdAt",
			"updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}