/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchVisiteException;
import com.df.lonis.ventesservice.model.Visite;
import com.df.lonis.ventesservice.model.VisiteTable;
import com.df.lonis.ventesservice.model.impl.VisiteImpl;
import com.df.lonis.ventesservice.model.impl.VisiteModelImpl;
import com.df.lonis.ventesservice.service.persistence.VisitePersistence;
import com.df.lonis.ventesservice.service.persistence.VisiteUtil;
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
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the visite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VisitePersistence.class)
public class VisitePersistenceImpl
	extends BasePersistenceImpl<Visite> implements VisitePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VisiteUtil</code> to access the visite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VisiteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCommercialId;
	private FinderPath _finderPathWithoutPaginationFindByCommercialId;
	private FinderPath _finderPathCountByCommercialId;

	/**
	 * Returns all the visites where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching visites
	 */
	@Override
	public List<Visite> findByCommercialId(long commercialId) {
		return findByCommercialId(
			commercialId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	@Override
	public List<Visite> findByCommercialId(
		long commercialId, int start, int end) {

		return findByCommercialId(commercialId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return findByCommercialId(
			commercialId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCommercialId;
				finderArgs = new Object[] {commercialId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCommercialId;
			finderArgs = new Object[] {
				commercialId, start, end, orderByComparator
			};
		}

		List<Visite> list = null;

		if (useFinderCache) {
			list = (List<Visite>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visite visite : list) {
					if (commercialId != visite.getCommercialId()) {
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

			sb.append(_SQL_SELECT_VISITE_WHERE);

			sb.append(_FINDER_COLUMN_COMMERCIALID_COMMERCIALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				list = (List<Visite>)QueryUtil.list(
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
	 * Returns the first visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByCommercialId_First(
			long commercialId, OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByCommercialId_First(
			commercialId, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByCommercialId_First(
		long commercialId, OrderByComparator<Visite> orderByComparator) {

		List<Visite> list = findByCommercialId(
			commercialId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByCommercialId_Last(
			long commercialId, OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByCommercialId_Last(
			commercialId, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByCommercialId_Last(
		long commercialId, OrderByComparator<Visite> orderByComparator) {

		int count = countByCommercialId(commercialId);

		if (count == 0) {
			return null;
		}

		List<Visite> list = findByCommercialId(
			commercialId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Visite[] array = new VisiteImpl[3];

			array[0] = getByCommercialId_PrevAndNext(
				session, visite, commercialId, orderByComparator, true);

			array[1] = visite;

			array[2] = getByCommercialId_PrevAndNext(
				session, visite, commercialId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visite getByCommercialId_PrevAndNext(
		Session session, Visite visite, long commercialId,
		OrderByComparator<Visite> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISITE_WHERE);

		sb.append(_FINDER_COLUMN_COMMERCIALID_COMMERCIALID_2);

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
			sb.append(VisiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commercialId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visite)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visite> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visites where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	@Override
	public void removeByCommercialId(long commercialId) {
		for (Visite visite :
				findByCommercialId(
					commercialId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visite);
		}
	}

	/**
	 * Returns the number of visites where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching visites
	 */
	@Override
	public int countByCommercialId(long commercialId) {
		FinderPath finderPath = _finderPathCountByCommercialId;

		Object[] finderArgs = new Object[] {commercialId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISITE_WHERE);

			sb.append(_FINDER_COLUMN_COMMERCIALID_COMMERCIALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

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

	private static final String _FINDER_COLUMN_COMMERCIALID_COMMERCIALID_2 =
		"visite.commercialId = ?";

	private FinderPath _finderPathWithPaginationFindByTerminalId;
	private FinderPath _finderPathWithoutPaginationFindByTerminalId;
	private FinderPath _finderPathCountByTerminalId;

	/**
	 * Returns all the visites where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching visites
	 */
	@Override
	public List<Visite> findByTerminalId(long terminalId) {
		return findByTerminalId(
			terminalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	@Override
	public List<Visite> findByTerminalId(long terminalId, int start, int end) {
		return findByTerminalId(terminalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return findByTerminalId(
			terminalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByTerminalId(
		long terminalId, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

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

		List<Visite> list = null;

		if (useFinderCache) {
			list = (List<Visite>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visite visite : list) {
					if (terminalId != visite.getTerminalId()) {
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

			sb.append(_SQL_SELECT_VISITE_WHERE);

			sb.append(_FINDER_COLUMN_TERMINALID_TERMINALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(terminalId);

				list = (List<Visite>)QueryUtil.list(
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
	 * Returns the first visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByTerminalId_First(
			long terminalId, OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByTerminalId_First(terminalId, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the first visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByTerminalId_First(
		long terminalId, OrderByComparator<Visite> orderByComparator) {

		List<Visite> list = findByTerminalId(
			terminalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByTerminalId_Last(
			long terminalId, OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByTerminalId_Last(terminalId, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("terminalId=");
		sb.append(terminalId);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the last visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByTerminalId_Last(
		long terminalId, OrderByComparator<Visite> orderByComparator) {

		int count = countByTerminalId(terminalId);

		if (count == 0) {
			return null;
		}

		List<Visite> list = findByTerminalId(
			terminalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Visite[] array = new VisiteImpl[3];

			array[0] = getByTerminalId_PrevAndNext(
				session, visite, terminalId, orderByComparator, true);

			array[1] = visite;

			array[2] = getByTerminalId_PrevAndNext(
				session, visite, terminalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visite getByTerminalId_PrevAndNext(
		Session session, Visite visite, long terminalId,
		OrderByComparator<Visite> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISITE_WHERE);

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
			sb.append(VisiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(terminalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visite)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visite> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visites where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	@Override
	public void removeByTerminalId(long terminalId) {
		for (Visite visite :
				findByTerminalId(
					terminalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visite);
		}
	}

	/**
	 * Returns the number of visites where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching visites
	 */
	@Override
	public int countByTerminalId(long terminalId) {
		FinderPath finderPath = _finderPathCountByTerminalId;

		Object[] finderArgs = new Object[] {terminalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISITE_WHERE);

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
		"visite.terminalId = ?";

	private FinderPath _finderPathWithPaginationFindByStatut;
	private FinderPath _finderPathWithoutPaginationFindByStatut;
	private FinderPath _finderPathCountByStatut;

	/**
	 * Returns all the visites where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching visites
	 */
	@Override
	public List<Visite> findByStatut(String statut) {
		return findByStatut(statut, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	@Override
	public List<Visite> findByStatut(String statut, int start, int end) {
		return findByStatut(statut, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return findByStatut(statut, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

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

		List<Visite> list = null;

		if (useFinderCache) {
			list = (List<Visite>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visite visite : list) {
					if (!statut.equals(visite.getStatut())) {
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

			sb.append(_SQL_SELECT_VISITE_WHERE);

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
				sb.append(VisiteModelImpl.ORDER_BY_JPQL);
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

				list = (List<Visite>)QueryUtil.list(
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
	 * Returns the first visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByStatut_First(
			String statut, OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByStatut_First(statut, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statut=");
		sb.append(statut);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the first visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByStatut_First(
		String statut, OrderByComparator<Visite> orderByComparator) {

		List<Visite> list = findByStatut(statut, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByStatut_Last(
			String statut, OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByStatut_Last(statut, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statut=");
		sb.append(statut);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the last visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByStatut_Last(
		String statut, OrderByComparator<Visite> orderByComparator) {

		int count = countByStatut(statut);

		if (count == 0) {
			return null;
		}

		List<Visite> list = findByStatut(
			statut, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite[] findByStatut_PrevAndNext(
			long id, String statut, OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		statut = Objects.toString(statut, "");

		Visite visite = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Visite[] array = new VisiteImpl[3];

			array[0] = getByStatut_PrevAndNext(
				session, visite, statut, orderByComparator, true);

			array[1] = visite;

			array[2] = getByStatut_PrevAndNext(
				session, visite, statut, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Visite getByStatut_PrevAndNext(
		Session session, Visite visite, String statut,
		OrderByComparator<Visite> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VISITE_WHERE);

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
			sb.append(VisiteModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(visite)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visite> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visites where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	@Override
	public void removeByStatut(String statut) {
		for (Visite visite :
				findByStatut(
					statut, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(visite);
		}
	}

	/**
	 * Returns the number of visites where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching visites
	 */
	@Override
	public int countByStatut(String statut) {
		statut = Objects.toString(statut, "");

		FinderPath finderPath = _finderPathCountByStatut;

		Object[] finderArgs = new Object[] {statut};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VISITE_WHERE);

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
		"visite.statut = ?";

	private static final String _FINDER_COLUMN_STATUT_STATUT_3 =
		"(visite.statut IS NULL OR visite.statut = '')";

	private FinderPath _finderPathWithPaginationFindByC_S;
	private FinderPath _finderPathWithoutPaginationFindByC_S;
	private FinderPath _finderPathCountByC_S;

	/**
	 * Returns all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @return the matching visites
	 */
	@Override
	public List<Visite> findByC_S(long commercialId, String statut) {
		return findByC_S(
			commercialId, statut, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	@Override
	public List<Visite> findByC_S(
		long commercialId, String statut, int start, int end) {

		return findByC_S(commercialId, statut, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByC_S(
		long commercialId, String statut, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return findByC_S(
			commercialId, statut, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByC_S(
		long commercialId, String statut, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

		statut = Objects.toString(statut, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_S;
				finderArgs = new Object[] {commercialId, statut};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_S;
			finderArgs = new Object[] {
				commercialId, statut, start, end, orderByComparator
			};
		}

		List<Visite> list = null;

		if (useFinderCache) {
			list = (List<Visite>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visite visite : list) {
					if ((commercialId != visite.getCommercialId()) ||
						!statut.equals(visite.getStatut())) {

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

			sb.append(_SQL_SELECT_VISITE_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMMERCIALID_2);

			boolean bindStatut = false;

			if (statut.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_S_STATUT_3);
			}
			else {
				bindStatut = true;

				sb.append(_FINDER_COLUMN_C_S_STATUT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				if (bindStatut) {
					queryPos.add(statut);
				}

				list = (List<Visite>)QueryUtil.list(
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
	 * Returns the first visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByC_S_First(
			long commercialId, String statut,
			OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByC_S_First(
			commercialId, statut, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append(", statut=");
		sb.append(statut);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByC_S_First(
		long commercialId, String statut,
		OrderByComparator<Visite> orderByComparator) {

		List<Visite> list = findByC_S(
			commercialId, statut, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByC_S_Last(
			long commercialId, String statut,
			OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByC_S_Last(
			commercialId, statut, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append(", statut=");
		sb.append(statut);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByC_S_Last(
		long commercialId, String statut,
		OrderByComparator<Visite> orderByComparator) {

		int count = countByC_S(commercialId, statut);

		if (count == 0) {
			return null;
		}

		List<Visite> list = findByC_S(
			commercialId, statut, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite[] findByC_S_PrevAndNext(
			long id, long commercialId, String statut,
			OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		statut = Objects.toString(statut, "");

		Visite visite = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Visite[] array = new VisiteImpl[3];

			array[0] = getByC_S_PrevAndNext(
				session, visite, commercialId, statut, orderByComparator, true);

			array[1] = visite;

			array[2] = getByC_S_PrevAndNext(
				session, visite, commercialId, statut, orderByComparator,
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

	protected Visite getByC_S_PrevAndNext(
		Session session, Visite visite, long commercialId, String statut,
		OrderByComparator<Visite> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VISITE_WHERE);

		sb.append(_FINDER_COLUMN_C_S_COMMERCIALID_2);

		boolean bindStatut = false;

		if (statut.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_S_STATUT_3);
		}
		else {
			bindStatut = true;

			sb.append(_FINDER_COLUMN_C_S_STATUT_2);
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
			sb.append(VisiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commercialId);

		if (bindStatut) {
			queryPos.add(statut);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visite)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visite> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visites where commercialId = &#63; and statut = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 */
	@Override
	public void removeByC_S(long commercialId, String statut) {
		for (Visite visite :
				findByC_S(
					commercialId, statut, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(visite);
		}
	}

	/**
	 * Returns the number of visites where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @return the number of matching visites
	 */
	@Override
	public int countByC_S(long commercialId, String statut) {
		statut = Objects.toString(statut, "");

		FinderPath finderPath = _finderPathCountByC_S;

		Object[] finderArgs = new Object[] {commercialId, statut};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISITE_WHERE);

			sb.append(_FINDER_COLUMN_C_S_COMMERCIALID_2);

			boolean bindStatut = false;

			if (statut.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_S_STATUT_3);
			}
			else {
				bindStatut = true;

				sb.append(_FINDER_COLUMN_C_S_STATUT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

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

	private static final String _FINDER_COLUMN_C_S_COMMERCIALID_2 =
		"visite.commercialId = ? AND ";

	private static final String _FINDER_COLUMN_C_S_STATUT_2 =
		"visite.statut = ?";

	private static final String _FINDER_COLUMN_C_S_STATUT_3 =
		"(visite.statut IS NULL OR visite.statut = '')";

	private FinderPath _finderPathWithPaginationFindByC_D;
	private FinderPath _finderPathWithPaginationCountByC_D;

	/**
	 * Returns all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @return the matching visites
	 */
	@Override
	public List<Visite> findByC_D(long commercialId, Date dateVisite) {
		return findByC_D(
			commercialId, dateVisite, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	@Override
	public List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end) {

		return findByC_D(commercialId, dateVisite, start, end, null);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end,
		OrderByComparator<Visite> orderByComparator) {

		return findByC_D(
			commercialId, dateVisite, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	@Override
	public List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end,
		OrderByComparator<Visite> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByC_D;
		finderArgs = new Object[] {
			commercialId, _getTime(dateVisite), start, end, orderByComparator
		};

		List<Visite> list = null;

		if (useFinderCache) {
			list = (List<Visite>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Visite visite : list) {
					if ((commercialId != visite.getCommercialId()) ||
						(dateVisite.getTime() > visite.getDateVisite(
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

			sb.append(_SQL_SELECT_VISITE_WHERE);

			sb.append(_FINDER_COLUMN_C_D_COMMERCIALID_2);

			boolean bindDateVisite = false;

			if (dateVisite == null) {
				sb.append(_FINDER_COLUMN_C_D_DATEVISITE_1);
			}
			else {
				bindDateVisite = true;

				sb.append(_FINDER_COLUMN_C_D_DATEVISITE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VisiteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				if (bindDateVisite) {
					queryPos.add(new Timestamp(dateVisite.getTime()));
				}

				list = (List<Visite>)QueryUtil.list(
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
	 * Returns the first visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByC_D_First(
			long commercialId, Date dateVisite,
			OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByC_D_First(
			commercialId, dateVisite, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append(", dateVisite>=");
		sb.append(dateVisite);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByC_D_First(
		long commercialId, Date dateVisite,
		OrderByComparator<Visite> orderByComparator) {

		List<Visite> list = findByC_D(
			commercialId, dateVisite, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	@Override
	public Visite findByC_D_Last(
			long commercialId, Date dateVisite,
			OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = fetchByC_D_Last(
			commercialId, dateVisite, orderByComparator);

		if (visite != null) {
			return visite;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append(", dateVisite>=");
		sb.append(dateVisite);

		sb.append("}");

		throw new NoSuchVisiteException(sb.toString());
	}

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	@Override
	public Visite fetchByC_D_Last(
		long commercialId, Date dateVisite,
		OrderByComparator<Visite> orderByComparator) {

		int count = countByC_D(commercialId, dateVisite);

		if (count == 0) {
			return null;
		}

		List<Visite> list = findByC_D(
			commercialId, dateVisite, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite[] findByC_D_PrevAndNext(
			long id, long commercialId, Date dateVisite,
			OrderByComparator<Visite> orderByComparator)
		throws NoSuchVisiteException {

		Visite visite = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Visite[] array = new VisiteImpl[3];

			array[0] = getByC_D_PrevAndNext(
				session, visite, commercialId, dateVisite, orderByComparator,
				true);

			array[1] = visite;

			array[2] = getByC_D_PrevAndNext(
				session, visite, commercialId, dateVisite, orderByComparator,
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

	protected Visite getByC_D_PrevAndNext(
		Session session, Visite visite, long commercialId, Date dateVisite,
		OrderByComparator<Visite> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VISITE_WHERE);

		sb.append(_FINDER_COLUMN_C_D_COMMERCIALID_2);

		boolean bindDateVisite = false;

		if (dateVisite == null) {
			sb.append(_FINDER_COLUMN_C_D_DATEVISITE_1);
		}
		else {
			bindDateVisite = true;

			sb.append(_FINDER_COLUMN_C_D_DATEVISITE_2);
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
			sb.append(VisiteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commercialId);

		if (bindDateVisite) {
			queryPos.add(new Timestamp(dateVisite.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(visite)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Visite> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the visites where commercialId = &#63; and dateVisite &ge; &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 */
	@Override
	public void removeByC_D(long commercialId, Date dateVisite) {
		for (Visite visite :
				findByC_D(
					commercialId, dateVisite, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(visite);
		}
	}

	/**
	 * Returns the number of visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @return the number of matching visites
	 */
	@Override
	public int countByC_D(long commercialId, Date dateVisite) {
		FinderPath finderPath = _finderPathWithPaginationCountByC_D;

		Object[] finderArgs = new Object[] {commercialId, _getTime(dateVisite)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VISITE_WHERE);

			sb.append(_FINDER_COLUMN_C_D_COMMERCIALID_2);

			boolean bindDateVisite = false;

			if (dateVisite == null) {
				sb.append(_FINDER_COLUMN_C_D_DATEVISITE_1);
			}
			else {
				bindDateVisite = true;

				sb.append(_FINDER_COLUMN_C_D_DATEVISITE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				if (bindDateVisite) {
					queryPos.add(new Timestamp(dateVisite.getTime()));
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

	private static final String _FINDER_COLUMN_C_D_COMMERCIALID_2 =
		"visite.commercialId = ? AND ";

	private static final String _FINDER_COLUMN_C_D_DATEVISITE_1 =
		"visite.dateVisite IS NULL";

	private static final String _FINDER_COLUMN_C_D_DATEVISITE_2 =
		"visite.dateVisite >= ?";

	public VisitePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("commercialId", "commercial_id");
		dbColumnNames.put("terminalId", "terminal_id");
		dbColumnNames.put("typeControle", "type_controle");
		dbColumnNames.put("dateVisite", "date_visite");
		dbColumnNames.put("compteRendu", "compte_rendu");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Visite.class);

		setModelImplClass(VisiteImpl.class);
		setModelPKClass(long.class);

		setTable(VisiteTable.INSTANCE);
	}

	/**
	 * Caches the visite in the entity cache if it is enabled.
	 *
	 * @param visite the visite
	 */
	@Override
	public void cacheResult(Visite visite) {
		entityCache.putResult(VisiteImpl.class, visite.getPrimaryKey(), visite);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the visites in the entity cache if it is enabled.
	 *
	 * @param visites the visites
	 */
	@Override
	public void cacheResult(List<Visite> visites) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (visites.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Visite visite : visites) {
			if (entityCache.getResult(
					VisiteImpl.class, visite.getPrimaryKey()) == null) {

				cacheResult(visite);
			}
		}
	}

	/**
	 * Clears the cache for all visites.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VisiteImpl.class);

		finderCache.clearCache(VisiteImpl.class);
	}

	/**
	 * Clears the cache for the visite.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Visite visite) {
		entityCache.removeResult(VisiteImpl.class, visite);
	}

	@Override
	public void clearCache(List<Visite> visites) {
		for (Visite visite : visites) {
			entityCache.removeResult(VisiteImpl.class, visite);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(VisiteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VisiteImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new visite with the primary key. Does not add the visite to the database.
	 *
	 * @param id the primary key for the new visite
	 * @return the new visite
	 */
	@Override
	public Visite create(long id) {
		Visite visite = new VisiteImpl();

		visite.setNew(true);
		visite.setPrimaryKey(id);

		return visite;
	}

	/**
	 * Removes the visite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the visite
	 * @return the visite that was removed
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite remove(long id) throws NoSuchVisiteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the visite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the visite
	 * @return the visite that was removed
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite remove(Serializable primaryKey) throws NoSuchVisiteException {
		Session session = null;

		try {
			session = openSession();

			Visite visite = (Visite)session.get(VisiteImpl.class, primaryKey);

			if (visite == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVisiteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(visite);
		}
		catch (NoSuchVisiteException noSuchEntityException) {
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
	protected Visite removeImpl(Visite visite) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(visite)) {
				visite = (Visite)session.get(
					VisiteImpl.class, visite.getPrimaryKeyObj());
			}

			if (visite != null) {
				session.delete(visite);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (visite != null) {
			clearCache(visite);
		}

		return visite;
	}

	@Override
	public Visite updateImpl(Visite visite) {
		boolean isNew = visite.isNew();

		if (!(visite instanceof VisiteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(visite.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(visite);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in visite proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Visite implementation " +
					visite.getClass());
		}

		VisiteModelImpl visiteModelImpl = (VisiteModelImpl)visite;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(visite);
			}
			else {
				visite = (Visite)session.merge(visite);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(VisiteImpl.class, visiteModelImpl, false, true);

		if (isNew) {
			visite.setNew(false);
		}

		visite.resetOriginalValues();

		return visite;
	}

	/**
	 * Returns the visite with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the visite
	 * @return the visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVisiteException {

		Visite visite = fetchByPrimaryKey(primaryKey);

		if (visite == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVisiteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return visite;
	}

	/**
	 * Returns the visite with the primary key or throws a <code>NoSuchVisiteException</code> if it could not be found.
	 *
	 * @param id the primary key of the visite
	 * @return the visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	@Override
	public Visite findByPrimaryKey(long id) throws NoSuchVisiteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the visite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the visite
	 * @return the visite, or <code>null</code> if a visite with the primary key could not be found
	 */
	@Override
	public Visite fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the visites.
	 *
	 * @return the visites
	 */
	@Override
	public List<Visite> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of visites
	 */
	@Override
	public List<Visite> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visites
	 */
	@Override
	public List<Visite> findAll(
		int start, int end, OrderByComparator<Visite> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visites
	 */
	@Override
	public List<Visite> findAll(
		int start, int end, OrderByComparator<Visite> orderByComparator,
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

		List<Visite> list = null;

		if (useFinderCache) {
			list = (List<Visite>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VISITE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VISITE;

				sql = sql.concat(VisiteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Visite>)QueryUtil.list(
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
	 * Removes all the visites from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Visite visite : findAll()) {
			remove(visite);
		}
	}

	/**
	 * Returns the number of visites.
	 *
	 * @return the number of visites
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VISITE);

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
		return _SQL_SELECT_VISITE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VisiteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the visite persistence.
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

		_finderPathWithPaginationFindByCommercialId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCommercialId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"commercial_id"}, true);

		_finderPathWithoutPaginationFindByCommercialId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCommercialId",
			new String[] {Long.class.getName()}, new String[] {"commercial_id"},
			true);

		_finderPathCountByCommercialId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCommercialId",
			new String[] {Long.class.getName()}, new String[] {"commercial_id"},
			false);

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

		_finderPathWithPaginationFindByC_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"commercial_id", "statut"}, true);

		_finderPathWithoutPaginationFindByC_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_S",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"commercial_id", "statut"}, true);

		_finderPathCountByC_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_S",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"commercial_id", "statut"}, false);

		_finderPathWithPaginationFindByC_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_D",
			new String[] {
				Long.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"commercial_id", "date_visite"}, true);

		_finderPathWithPaginationCountByC_D = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_D",
			new String[] {Long.class.getName(), Date.class.getName()},
			new String[] {"commercial_id", "date_visite"}, false);

		VisiteUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		VisiteUtil.setPersistence(null);

		entityCache.removeCache(VisiteImpl.class.getName());
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

	private static final String _SQL_SELECT_VISITE =
		"SELECT visite FROM Visite visite";

	private static final String _SQL_SELECT_VISITE_WHERE =
		"SELECT visite FROM Visite visite WHERE ";

	private static final String _SQL_COUNT_VISITE =
		"SELECT COUNT(visite) FROM Visite visite";

	private static final String _SQL_COUNT_VISITE_WHERE =
		"SELECT COUNT(visite) FROM Visite visite WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "visite.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Visite exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Visite exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VisitePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"commercialId", "terminalId", "typeControle", "dateVisite",
			"compteRendu", "createdAt", "updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}