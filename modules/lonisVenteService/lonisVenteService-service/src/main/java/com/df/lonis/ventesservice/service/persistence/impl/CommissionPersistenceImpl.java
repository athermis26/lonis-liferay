/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchCommissionException;
import com.df.lonis.ventesservice.model.Commission;
import com.df.lonis.ventesservice.model.CommissionTable;
import com.df.lonis.ventesservice.model.impl.CommissionImpl;
import com.df.lonis.ventesservice.model.impl.CommissionModelImpl;
import com.df.lonis.ventesservice.service.persistence.CommissionPersistence;
import com.df.lonis.ventesservice.service.persistence.CommissionUtil;
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
 * The persistence implementation for the commission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CommissionPersistence.class)
public class CommissionPersistenceImpl
	extends BasePersistenceImpl<Commission> implements CommissionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommissionUtil</code> to access the commission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommissionImpl.class.getName();

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
	 * Returns all the commissions where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching commissions
	 */
	@Override
	public List<Commission> findByTerminalId(long terminalId) {
		return findByTerminalId(
			terminalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commissions where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @return the range of matching commissions
	 */
	@Override
	public List<Commission> findByTerminalId(
		long terminalId, int start, int end) {

		return findByTerminalId(terminalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commissions where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commissions
	 */
	@Override
	public List<Commission> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Commission> orderByComparator) {

		return findByTerminalId(
			terminalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commissions where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commissions
	 */
	@Override
	public List<Commission> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Commission> orderByComparator,
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

		List<Commission> list = null;

		if (useFinderCache) {
			list = (List<Commission>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Commission commission : list) {
					if (terminalId != commission.getTerminalId()) {
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

			sb.append(_SQL_SELECT_COMMISSION_WHERE);

			sb.append(_FINDER_COLUMN_TERMINALID_TERMINALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(terminalId);

				list = (List<Commission>)QueryUtil.list(
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
	 * Returns the first commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	@Override
	public Commission findByTerminalId_First(
			long terminalId, OrderByComparator<Commission> orderByComparator)
		throws NoSuchCommissionException {

		Commission commission = fetchByTerminalId_First(
			terminalId, orderByComparator);

		if (commission != null) {
			return commission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append("}");

		throw new NoSuchCommissionException(sb.toString());
	}

	/**
	 * Returns the first commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission, or <code>null</code> if a matching commission could not be found
	 */
	@Override
	public Commission fetchByTerminalId_First(
		long terminalId, OrderByComparator<Commission> orderByComparator) {

		List<Commission> list = findByTerminalId(
			terminalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	@Override
	public Commission findByTerminalId_Last(
			long terminalId, OrderByComparator<Commission> orderByComparator)
		throws NoSuchCommissionException {

		Commission commission = fetchByTerminalId_Last(
			terminalId, orderByComparator);

		if (commission != null) {
			return commission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append("}");

		throw new NoSuchCommissionException(sb.toString());
	}

	/**
	 * Returns the last commission in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission, or <code>null</code> if a matching commission could not be found
	 */
	@Override
	public Commission fetchByTerminalId_Last(
		long terminalId, OrderByComparator<Commission> orderByComparator) {

		int count = countByTerminalId(terminalId);

		if (count == 0) {
			return null;
		}

		List<Commission> list = findByTerminalId(
			terminalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commissions before and after the current commission in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current commission
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	@Override
	public Commission[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			OrderByComparator<Commission> orderByComparator)
		throws NoSuchCommissionException {

		Commission commission = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Commission[] array = new CommissionImpl[3];

			array[0] = getByTerminalId_PrevAndNext(
				session, commission, terminalId, orderByComparator, true);

			array[1] = commission;

			array[2] = getByTerminalId_PrevAndNext(
				session, commission, terminalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Commission getByTerminalId_PrevAndNext(
		Session session, Commission commission, long terminalId,
		OrderByComparator<Commission> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMISSION_WHERE);

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
			sb.append(CommissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(terminalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(commission)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Commission> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commissions where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	@Override
	public void removeByTerminalId(long terminalId) {
		for (Commission commission :
				findByTerminalId(
					terminalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commission);
		}
	}

	/**
	 * Returns the number of commissions where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching commissions
	 */
	@Override
	public int countByTerminalId(long terminalId) {
		FinderPath finderPath = _finderPathCountByTerminalId;

		Object[] finderArgs = new Object[] {terminalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMISSION_WHERE);

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
		"commission.terminalId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the commissions where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching commissions
	 */
	@Override
	public List<Commission> findByStatus(String status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commissions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @return the range of matching commissions
	 */
	@Override
	public List<Commission> findByStatus(String status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commissions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commissions
	 */
	@Override
	public List<Commission> findByStatus(
		String status, int start, int end,
		OrderByComparator<Commission> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commissions where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commissions
	 */
	@Override
	public List<Commission> findByStatus(
		String status, int start, int end,
		OrderByComparator<Commission> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Commission> list = null;

		if (useFinderCache) {
			list = (List<Commission>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Commission commission : list) {
					if (!status.equals(commission.getStatus())) {
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

			sb.append(_SQL_SELECT_COMMISSION_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<Commission>)QueryUtil.list(
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
	 * Returns the first commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	@Override
	public Commission findByStatus_First(
			String status, OrderByComparator<Commission> orderByComparator)
		throws NoSuchCommissionException {

		Commission commission = fetchByStatus_First(status, orderByComparator);

		if (commission != null) {
			return commission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommissionException(sb.toString());
	}

	/**
	 * Returns the first commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commission, or <code>null</code> if a matching commission could not be found
	 */
	@Override
	public Commission fetchByStatus_First(
		String status, OrderByComparator<Commission> orderByComparator) {

		List<Commission> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission
	 * @throws NoSuchCommissionException if a matching commission could not be found
	 */
	@Override
	public Commission findByStatus_Last(
			String status, OrderByComparator<Commission> orderByComparator)
		throws NoSuchCommissionException {

		Commission commission = fetchByStatus_Last(status, orderByComparator);

		if (commission != null) {
			return commission;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCommissionException(sb.toString());
	}

	/**
	 * Returns the last commission in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commission, or <code>null</code> if a matching commission could not be found
	 */
	@Override
	public Commission fetchByStatus_Last(
		String status, OrderByComparator<Commission> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Commission> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commissions before and after the current commission in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current commission
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	@Override
	public Commission[] findByStatus_PrevAndNext(
			long id, String status,
			OrderByComparator<Commission> orderByComparator)
		throws NoSuchCommissionException {

		status = Objects.toString(status, "");

		Commission commission = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Commission[] array = new CommissionImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, commission, status, orderByComparator, true);

			array[1] = commission;

			array[2] = getByStatus_PrevAndNext(
				session, commission, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Commission getByStatus_PrevAndNext(
		Session session, Commission commission, String status,
		OrderByComparator<Commission> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMISSION_WHERE);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
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
			sb.append(CommissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(commission)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Commission> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commissions where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(String status) {
		for (Commission commission :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commission);
		}
	}

	/**
	 * Returns the number of commissions where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching commissions
	 */
	@Override
	public int countByStatus(String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMISSION_WHERE);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"commission.status = ?";

	private static final String _FINDER_COLUMN_STATUS_STATUS_3 =
		"(commission.status IS NULL OR commission.status = '')";

	public CommissionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("terminalId", "terminal_id");
		dbColumnNames.put("nombreTerminal", "nombre_terminal");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Commission.class);

		setModelImplClass(CommissionImpl.class);
		setModelPKClass(long.class);

		setTable(CommissionTable.INSTANCE);
	}

	/**
	 * Caches the commission in the entity cache if it is enabled.
	 *
	 * @param commission the commission
	 */
	@Override
	public void cacheResult(Commission commission) {
		entityCache.putResult(
			CommissionImpl.class, commission.getPrimaryKey(), commission);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the commissions in the entity cache if it is enabled.
	 *
	 * @param commissions the commissions
	 */
	@Override
	public void cacheResult(List<Commission> commissions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (commissions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Commission commission : commissions) {
			if (entityCache.getResult(
					CommissionImpl.class, commission.getPrimaryKey()) == null) {

				cacheResult(commission);
			}
		}
	}

	/**
	 * Clears the cache for all commissions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommissionImpl.class);

		finderCache.clearCache(CommissionImpl.class);
	}

	/**
	 * Clears the cache for the commission.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Commission commission) {
		entityCache.removeResult(CommissionImpl.class, commission);
	}

	@Override
	public void clearCache(List<Commission> commissions) {
		for (Commission commission : commissions) {
			entityCache.removeResult(CommissionImpl.class, commission);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CommissionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CommissionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new commission with the primary key. Does not add the commission to the database.
	 *
	 * @param id the primary key for the new commission
	 * @return the new commission
	 */
	@Override
	public Commission create(long id) {
		Commission commission = new CommissionImpl();

		commission.setNew(true);
		commission.setPrimaryKey(id);

		return commission;
	}

	/**
	 * Removes the commission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the commission
	 * @return the commission that was removed
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	@Override
	public Commission remove(long id) throws NoSuchCommissionException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the commission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commission
	 * @return the commission that was removed
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	@Override
	public Commission remove(Serializable primaryKey)
		throws NoSuchCommissionException {

		Session session = null;

		try {
			session = openSession();

			Commission commission = (Commission)session.get(
				CommissionImpl.class, primaryKey);

			if (commission == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommissionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commission);
		}
		catch (NoSuchCommissionException noSuchEntityException) {
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
	protected Commission removeImpl(Commission commission) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commission)) {
				commission = (Commission)session.get(
					CommissionImpl.class, commission.getPrimaryKeyObj());
			}

			if (commission != null) {
				session.delete(commission);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (commission != null) {
			clearCache(commission);
		}

		return commission;
	}

	@Override
	public Commission updateImpl(Commission commission) {
		boolean isNew = commission.isNew();

		if (!(commission instanceof CommissionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commission.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(commission);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commission proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Commission implementation " +
					commission.getClass());
		}

		CommissionModelImpl commissionModelImpl =
			(CommissionModelImpl)commission;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(commission);
			}
			else {
				commission = (Commission)session.merge(commission);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CommissionImpl.class, commissionModelImpl, false, true);

		if (isNew) {
			commission.setNew(false);
		}

		commission.resetOriginalValues();

		return commission;
	}

	/**
	 * Returns the commission with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commission
	 * @return the commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	@Override
	public Commission findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommissionException {

		Commission commission = fetchByPrimaryKey(primaryKey);

		if (commission == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommissionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commission;
	}

	/**
	 * Returns the commission with the primary key or throws a <code>NoSuchCommissionException</code> if it could not be found.
	 *
	 * @param id the primary key of the commission
	 * @return the commission
	 * @throws NoSuchCommissionException if a commission with the primary key could not be found
	 */
	@Override
	public Commission findByPrimaryKey(long id)
		throws NoSuchCommissionException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the commission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the commission
	 * @return the commission, or <code>null</code> if a commission with the primary key could not be found
	 */
	@Override
	public Commission fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the commissions.
	 *
	 * @return the commissions
	 */
	@Override
	public List<Commission> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @return the range of commissions
	 */
	@Override
	public List<Commission> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commissions
	 */
	@Override
	public List<Commission> findAll(
		int start, int end, OrderByComparator<Commission> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commissions
	 * @param end the upper bound of the range of commissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commissions
	 */
	@Override
	public List<Commission> findAll(
		int start, int end, OrderByComparator<Commission> orderByComparator,
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

		List<Commission> list = null;

		if (useFinderCache) {
			list = (List<Commission>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMMISSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMMISSION;

				sql = sql.concat(CommissionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Commission>)QueryUtil.list(
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
	 * Removes all the commissions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Commission commission : findAll()) {
			remove(commission);
		}
	}

	/**
	 * Returns the number of commissions.
	 *
	 * @return the number of commissions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMMISSION);

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
		return _SQL_SELECT_COMMISSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CommissionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commission persistence.
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

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {String.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {String.class.getName()}, new String[] {"status"},
			false);

		CommissionUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CommissionUtil.setPersistence(null);

		entityCache.removeCache(CommissionImpl.class.getName());
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

	private static final String _SQL_SELECT_COMMISSION =
		"SELECT commission FROM Commission commission";

	private static final String _SQL_SELECT_COMMISSION_WHERE =
		"SELECT commission FROM Commission commission WHERE ";

	private static final String _SQL_COUNT_COMMISSION =
		"SELECT COUNT(commission) FROM Commission commission";

	private static final String _SQL_COUNT_COMMISSION_WHERE =
		"SELECT COUNT(commission) FROM Commission commission WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "commission.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Commission exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Commission exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommissionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"terminalId", "nombreTerminal", "createdAt", "updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}