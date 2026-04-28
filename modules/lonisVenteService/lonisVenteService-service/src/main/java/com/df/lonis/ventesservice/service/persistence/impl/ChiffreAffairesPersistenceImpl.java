/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchChiffreAffairesException;
import com.df.lonis.ventesservice.model.ChiffreAffaires;
import com.df.lonis.ventesservice.model.ChiffreAffairesTable;
import com.df.lonis.ventesservice.model.impl.ChiffreAffairesImpl;
import com.df.lonis.ventesservice.model.impl.ChiffreAffairesModelImpl;
import com.df.lonis.ventesservice.service.persistence.ChiffreAffairesPersistence;
import com.df.lonis.ventesservice.service.persistence.ChiffreAffairesUtil;
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

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the chiffre affaires service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ChiffreAffairesPersistence.class)
public class ChiffreAffairesPersistenceImpl
	extends BasePersistenceImpl<ChiffreAffaires>
	implements ChiffreAffairesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChiffreAffairesUtil</code> to access the chiffre affaires persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChiffreAffairesImpl.class.getName();

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
	 * Returns all the chiffre affaireses where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findByTerminalId(long terminalId) {
		return findByTerminalId(
			terminalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chiffre affaireses where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @return the range of matching chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end) {

		return findByTerminalId(terminalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return findByTerminalId(
			terminalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator,
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

		List<ChiffreAffaires> list = null;

		if (useFinderCache) {
			list = (List<ChiffreAffaires>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChiffreAffaires chiffreAffaires : list) {
					if (terminalId != chiffreAffaires.getTerminalId()) {
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

			sb.append(_SQL_SELECT_CHIFFREAFFAIRES_WHERE);

			sb.append(_FINDER_COLUMN_TERMINALID_TERMINALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChiffreAffairesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(terminalId);

				list = (List<ChiffreAffaires>)QueryUtil.list(
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
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	@Override
	public ChiffreAffaires findByTerminalId_First(
			long terminalId,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws NoSuchChiffreAffairesException {

		ChiffreAffaires chiffreAffaires = fetchByTerminalId_First(
			terminalId, orderByComparator);

		if (chiffreAffaires != null) {
			return chiffreAffaires;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append("}");

		throw new NoSuchChiffreAffairesException(sb.toString());
	}

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	@Override
	public ChiffreAffaires fetchByTerminalId_First(
		long terminalId, OrderByComparator<ChiffreAffaires> orderByComparator) {

		List<ChiffreAffaires> list = findByTerminalId(
			terminalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	@Override
	public ChiffreAffaires findByTerminalId_Last(
			long terminalId,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws NoSuchChiffreAffairesException {

		ChiffreAffaires chiffreAffaires = fetchByTerminalId_Last(
			terminalId, orderByComparator);

		if (chiffreAffaires != null) {
			return chiffreAffaires;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append("}");

		throw new NoSuchChiffreAffairesException(sb.toString());
	}

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	@Override
	public ChiffreAffaires fetchByTerminalId_Last(
		long terminalId, OrderByComparator<ChiffreAffaires> orderByComparator) {

		int count = countByTerminalId(terminalId);

		if (count == 0) {
			return null;
		}

		List<ChiffreAffaires> list = findByTerminalId(
			terminalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chiffre affaireses before and after the current chiffre affaires in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current chiffre affaires
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public ChiffreAffaires[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws NoSuchChiffreAffairesException {

		ChiffreAffaires chiffreAffaires = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChiffreAffaires[] array = new ChiffreAffairesImpl[3];

			array[0] = getByTerminalId_PrevAndNext(
				session, chiffreAffaires, terminalId, orderByComparator, true);

			array[1] = chiffreAffaires;

			array[2] = getByTerminalId_PrevAndNext(
				session, chiffreAffaires, terminalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChiffreAffaires getByTerminalId_PrevAndNext(
		Session session, ChiffreAffaires chiffreAffaires, long terminalId,
		OrderByComparator<ChiffreAffaires> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHIFFREAFFAIRES_WHERE);

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
			sb.append(ChiffreAffairesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(terminalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						chiffreAffaires)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChiffreAffaires> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chiffre affaireses where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	@Override
	public void removeByTerminalId(long terminalId) {
		for (ChiffreAffaires chiffreAffaires :
				findByTerminalId(
					terminalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chiffreAffaires);
		}
	}

	/**
	 * Returns the number of chiffre affaireses where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching chiffre affaireses
	 */
	@Override
	public int countByTerminalId(long terminalId) {
		FinderPath finderPath = _finderPathCountByTerminalId;

		Object[] finderArgs = new Object[] {terminalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHIFFREAFFAIRES_WHERE);

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
		"chiffreAffaires.terminalId = ?";

	private FinderPath _finderPathWithPaginationFindByT_D;
	private FinderPath _finderPathWithPaginationCountByT_D;

	/**
	 * Returns all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @return the matching chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findByT_D(long terminalId, Date date) {
		return findByT_D(
			terminalId, date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @return the range of matching chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end) {

		return findByT_D(terminalId, date, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return findByT_D(terminalId, date, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findByT_D(
		long terminalId, Date date, int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByT_D;
		finderArgs = new Object[] {
			terminalId, _getTime(date), start, end, orderByComparator
		};

		List<ChiffreAffaires> list = null;

		if (useFinderCache) {
			list = (List<ChiffreAffaires>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChiffreAffaires chiffreAffaires : list) {
					if ((terminalId != chiffreAffaires.getTerminalId()) ||
						(date.getTime() > chiffreAffaires.getDate(
						).getTime())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CHIFFREAFFAIRES_WHERE);

			sb.append(_FINDER_COLUMN_T_D_TERMINALID_2);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_T_D_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_T_D_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChiffreAffairesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(terminalId);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
				}

				list = (List<ChiffreAffaires>)QueryUtil.list(
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
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	@Override
	public ChiffreAffaires findByT_D_First(
			long terminalId, Date date,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws NoSuchChiffreAffairesException {

		ChiffreAffaires chiffreAffaires = fetchByT_D_First(
			terminalId, date, orderByComparator);

		if (chiffreAffaires != null) {
			return chiffreAffaires;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append(", date>=");
		sb.append(date);

		sb.append("}");

		throw new NoSuchChiffreAffairesException(sb.toString());
	}

	/**
	 * Returns the first chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	@Override
	public ChiffreAffaires fetchByT_D_First(
		long terminalId, Date date,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		List<ChiffreAffaires> list = findByT_D(
			terminalId, date, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a matching chiffre affaires could not be found
	 */
	@Override
	public ChiffreAffaires findByT_D_Last(
			long terminalId, Date date,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws NoSuchChiffreAffairesException {

		ChiffreAffaires chiffreAffaires = fetchByT_D_Last(
			terminalId, date, orderByComparator);

		if (chiffreAffaires != null) {
			return chiffreAffaires;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append(", date>=");
		sb.append(date);

		sb.append("}");

		throw new NoSuchChiffreAffairesException(sb.toString());
	}

	/**
	 * Returns the last chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chiffre affaires, or <code>null</code> if a matching chiffre affaires could not be found
	 */
	@Override
	public ChiffreAffaires fetchByT_D_Last(
		long terminalId, Date date,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		int count = countByT_D(terminalId, date);

		if (count == 0) {
			return null;
		}

		List<ChiffreAffaires> list = findByT_D(
			terminalId, date, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chiffre affaireses before and after the current chiffre affaires in the ordered set where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param id the primary key of the current chiffre affaires
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public ChiffreAffaires[] findByT_D_PrevAndNext(
			long id, long terminalId, Date date,
			OrderByComparator<ChiffreAffaires> orderByComparator)
		throws NoSuchChiffreAffairesException {

		ChiffreAffaires chiffreAffaires = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChiffreAffaires[] array = new ChiffreAffairesImpl[3];

			array[0] = getByT_D_PrevAndNext(
				session, chiffreAffaires, terminalId, date, orderByComparator,
				true);

			array[1] = chiffreAffaires;

			array[2] = getByT_D_PrevAndNext(
				session, chiffreAffaires, terminalId, date, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChiffreAffaires getByT_D_PrevAndNext(
		Session session, ChiffreAffaires chiffreAffaires, long terminalId,
		Date date, OrderByComparator<ChiffreAffaires> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CHIFFREAFFAIRES_WHERE);

		sb.append(_FINDER_COLUMN_T_D_TERMINALID_2);

		boolean bindDate = false;

		if (date == null) {
			sb.append(_FINDER_COLUMN_T_D_DATE_1);
		}
		else {
			bindDate = true;

			sb.append(_FINDER_COLUMN_T_D_DATE_2);
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
			sb.append(ChiffreAffairesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(terminalId);

		if (bindDate) {
			queryPos.add(new Timestamp(date.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						chiffreAffaires)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChiffreAffaires> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chiffre affaireses where terminalId = &#63; and date &ge; &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 */
	@Override
	public void removeByT_D(long terminalId, Date date) {
		for (ChiffreAffaires chiffreAffaires :
				findByT_D(
					terminalId, date, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(chiffreAffaires);
		}
	}

	/**
	 * Returns the number of chiffre affaireses where terminalId = &#63; and date &ge; &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param date the date
	 * @return the number of matching chiffre affaireses
	 */
	@Override
	public int countByT_D(long terminalId, Date date) {
		FinderPath finderPath = _finderPathWithPaginationCountByT_D;

		Object[] finderArgs = new Object[] {terminalId, _getTime(date)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CHIFFREAFFAIRES_WHERE);

			sb.append(_FINDER_COLUMN_T_D_TERMINALID_2);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_T_D_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_T_D_DATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(terminalId);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
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

	private static final String _FINDER_COLUMN_T_D_TERMINALID_2 =
		"chiffreAffaires.terminalId = ? AND ";

	private static final String _FINDER_COLUMN_T_D_DATE_1 =
		"chiffreAffaires.date IS NULL";

	private static final String _FINDER_COLUMN_T_D_DATE_2 =
		"chiffreAffaires.date >= ?";

	public ChiffreAffairesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("terminalId", "terminal_id");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(ChiffreAffaires.class);

		setModelImplClass(ChiffreAffairesImpl.class);
		setModelPKClass(long.class);

		setTable(ChiffreAffairesTable.INSTANCE);
	}

	/**
	 * Caches the chiffre affaires in the entity cache if it is enabled.
	 *
	 * @param chiffreAffaires the chiffre affaires
	 */
	@Override
	public void cacheResult(ChiffreAffaires chiffreAffaires) {
		entityCache.putResult(
			ChiffreAffairesImpl.class, chiffreAffaires.getPrimaryKey(),
			chiffreAffaires);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the chiffre affaireses in the entity cache if it is enabled.
	 *
	 * @param chiffreAffaireses the chiffre affaireses
	 */
	@Override
	public void cacheResult(List<ChiffreAffaires> chiffreAffaireses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (chiffreAffaireses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ChiffreAffaires chiffreAffaires : chiffreAffaireses) {
			if (entityCache.getResult(
					ChiffreAffairesImpl.class,
					chiffreAffaires.getPrimaryKey()) == null) {

				cacheResult(chiffreAffaires);
			}
		}
	}

	/**
	 * Clears the cache for all chiffre affaireses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChiffreAffairesImpl.class);

		finderCache.clearCache(ChiffreAffairesImpl.class);
	}

	/**
	 * Clears the cache for the chiffre affaires.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChiffreAffaires chiffreAffaires) {
		entityCache.removeResult(ChiffreAffairesImpl.class, chiffreAffaires);
	}

	@Override
	public void clearCache(List<ChiffreAffaires> chiffreAffaireses) {
		for (ChiffreAffaires chiffreAffaires : chiffreAffaireses) {
			entityCache.removeResult(
				ChiffreAffairesImpl.class, chiffreAffaires);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ChiffreAffairesImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChiffreAffairesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new chiffre affaires with the primary key. Does not add the chiffre affaires to the database.
	 *
	 * @param id the primary key for the new chiffre affaires
	 * @return the new chiffre affaires
	 */
	@Override
	public ChiffreAffaires create(long id) {
		ChiffreAffaires chiffreAffaires = new ChiffreAffairesImpl();

		chiffreAffaires.setNew(true);
		chiffreAffaires.setPrimaryKey(id);

		return chiffreAffaires;
	}

	/**
	 * Removes the chiffre affaires with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires that was removed
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public ChiffreAffaires remove(long id)
		throws NoSuchChiffreAffairesException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the chiffre affaires with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chiffre affaires
	 * @return the chiffre affaires that was removed
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public ChiffreAffaires remove(Serializable primaryKey)
		throws NoSuchChiffreAffairesException {

		Session session = null;

		try {
			session = openSession();

			ChiffreAffaires chiffreAffaires = (ChiffreAffaires)session.get(
				ChiffreAffairesImpl.class, primaryKey);

			if (chiffreAffaires == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChiffreAffairesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chiffreAffaires);
		}
		catch (NoSuchChiffreAffairesException noSuchEntityException) {
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
	protected ChiffreAffaires removeImpl(ChiffreAffaires chiffreAffaires) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chiffreAffaires)) {
				chiffreAffaires = (ChiffreAffaires)session.get(
					ChiffreAffairesImpl.class,
					chiffreAffaires.getPrimaryKeyObj());
			}

			if (chiffreAffaires != null) {
				session.delete(chiffreAffaires);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (chiffreAffaires != null) {
			clearCache(chiffreAffaires);
		}

		return chiffreAffaires;
	}

	@Override
	public ChiffreAffaires updateImpl(ChiffreAffaires chiffreAffaires) {
		boolean isNew = chiffreAffaires.isNew();

		if (!(chiffreAffaires instanceof ChiffreAffairesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(chiffreAffaires.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					chiffreAffaires);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in chiffreAffaires proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ChiffreAffaires implementation " +
					chiffreAffaires.getClass());
		}

		ChiffreAffairesModelImpl chiffreAffairesModelImpl =
			(ChiffreAffairesModelImpl)chiffreAffaires;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(chiffreAffaires);
			}
			else {
				chiffreAffaires = (ChiffreAffaires)session.merge(
					chiffreAffaires);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ChiffreAffairesImpl.class, chiffreAffairesModelImpl, false, true);

		if (isNew) {
			chiffreAffaires.setNew(false);
		}

		chiffreAffaires.resetOriginalValues();

		return chiffreAffaires;
	}

	/**
	 * Returns the chiffre affaires with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chiffre affaires
	 * @return the chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public ChiffreAffaires findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChiffreAffairesException {

		ChiffreAffaires chiffreAffaires = fetchByPrimaryKey(primaryKey);

		if (chiffreAffaires == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChiffreAffairesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chiffreAffaires;
	}

	/**
	 * Returns the chiffre affaires with the primary key or throws a <code>NoSuchChiffreAffairesException</code> if it could not be found.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires
	 * @throws NoSuchChiffreAffairesException if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public ChiffreAffaires findByPrimaryKey(long id)
		throws NoSuchChiffreAffairesException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chiffre affaires with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires, or <code>null</code> if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public ChiffreAffaires fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the chiffre affaireses.
	 *
	 * @return the chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chiffre affaireses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @return the range of chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findAll(
		int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chiffre affaireses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chiffre affaireses
	 */
	@Override
	public List<ChiffreAffaires> findAll(
		int start, int end,
		OrderByComparator<ChiffreAffaires> orderByComparator,
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

		List<ChiffreAffaires> list = null;

		if (useFinderCache) {
			list = (List<ChiffreAffaires>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHIFFREAFFAIRES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHIFFREAFFAIRES;

				sql = sql.concat(ChiffreAffairesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ChiffreAffaires>)QueryUtil.list(
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
	 * Removes all the chiffre affaireses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChiffreAffaires chiffreAffaires : findAll()) {
			remove(chiffreAffaires);
		}
	}

	/**
	 * Returns the number of chiffre affaireses.
	 *
	 * @return the number of chiffre affaireses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHIFFREAFFAIRES);

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
		return _SQL_SELECT_CHIFFREAFFAIRES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChiffreAffairesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chiffre affaires persistence.
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

		_finderPathWithPaginationFindByT_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_D",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"terminal_id", "date"}, true);

		_finderPathWithPaginationCountByT_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByT_D",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"terminal_id", "date"}, false);

		ChiffreAffairesUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ChiffreAffairesUtil.setPersistence(null);

		entityCache.removeCache(ChiffreAffairesImpl.class.getName());
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_CHIFFREAFFAIRES =
		"SELECT chiffreAffaires FROM ChiffreAffaires chiffreAffaires";

	private static final String _SQL_SELECT_CHIFFREAFFAIRES_WHERE =
		"SELECT chiffreAffaires FROM ChiffreAffaires chiffreAffaires WHERE ";

	private static final String _SQL_COUNT_CHIFFREAFFAIRES =
		"SELECT COUNT(chiffreAffaires) FROM ChiffreAffaires chiffreAffaires";

	private static final String _SQL_COUNT_CHIFFREAFFAIRES_WHERE =
		"SELECT COUNT(chiffreAffaires) FROM ChiffreAffaires chiffreAffaires WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chiffreAffaires.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChiffreAffaires exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ChiffreAffaires exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChiffreAffairesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"terminalId", "createdAt", "updatedAt"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}