/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchObjectifException;
import com.df.lonis.ventesservice.model.Objectif;
import com.df.lonis.ventesservice.model.ObjectifTable;
import com.df.lonis.ventesservice.model.impl.ObjectifImpl;
import com.df.lonis.ventesservice.model.impl.ObjectifModelImpl;
import com.df.lonis.ventesservice.service.persistence.ObjectifPersistence;
import com.df.lonis.ventesservice.service.persistence.ObjectifUtil;
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
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the objectif service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ObjectifPersistence.class)
public class ObjectifPersistenceImpl
	extends BasePersistenceImpl<Objectif> implements ObjectifPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ObjectifUtil</code> to access the objectif persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ObjectifImpl.class.getName();

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
	 * Returns all the objectifs where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching objectifs
	 */
	@Override
	public List<Objectif> findByCommercialId(long commercialId) {
		return findByCommercialId(
			commercialId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of matching objectifs
	 */
	@Override
	public List<Objectif> findByCommercialId(
		long commercialId, int start, int end) {

		return findByCommercialId(commercialId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching objectifs
	 */
	@Override
	public List<Objectif> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Objectif> orderByComparator) {

		return findByCommercialId(
			commercialId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching objectifs
	 */
	@Override
	public List<Objectif> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Objectif> orderByComparator, boolean useFinderCache) {

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

		List<Objectif> list = null;

		if (useFinderCache) {
			list = (List<Objectif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Objectif objectif : list) {
					if (commercialId != objectif.getCommercialId()) {
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

			sb.append(_SQL_SELECT_OBJECTIF_WHERE);

			sb.append(_FINDER_COLUMN_COMMERCIALID_COMMERCIALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ObjectifModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				list = (List<Objectif>)QueryUtil.list(
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
	 * Returns the first objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	@Override
	public Objectif findByCommercialId_First(
			long commercialId, OrderByComparator<Objectif> orderByComparator)
		throws NoSuchObjectifException {

		Objectif objectif = fetchByCommercialId_First(
			commercialId, orderByComparator);

		if (objectif != null) {
			return objectif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append("}");

		throw new NoSuchObjectifException(sb.toString());
	}

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	@Override
	public Objectif fetchByCommercialId_First(
		long commercialId, OrderByComparator<Objectif> orderByComparator) {

		List<Objectif> list = findByCommercialId(
			commercialId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	@Override
	public Objectif findByCommercialId_Last(
			long commercialId, OrderByComparator<Objectif> orderByComparator)
		throws NoSuchObjectifException {

		Objectif objectif = fetchByCommercialId_Last(
			commercialId, orderByComparator);

		if (objectif != null) {
			return objectif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append("}");

		throw new NoSuchObjectifException(sb.toString());
	}

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	@Override
	public Objectif fetchByCommercialId_Last(
		long commercialId, OrderByComparator<Objectif> orderByComparator) {

		int count = countByCommercialId(commercialId);

		if (count == 0) {
			return null;
		}

		List<Objectif> list = findByCommercialId(
			commercialId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the objectifs before and after the current objectif in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current objectif
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	@Override
	public Objectif[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			OrderByComparator<Objectif> orderByComparator)
		throws NoSuchObjectifException {

		Objectif objectif = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Objectif[] array = new ObjectifImpl[3];

			array[0] = getByCommercialId_PrevAndNext(
				session, objectif, commercialId, orderByComparator, true);

			array[1] = objectif;

			array[2] = getByCommercialId_PrevAndNext(
				session, objectif, commercialId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Objectif getByCommercialId_PrevAndNext(
		Session session, Objectif objectif, long commercialId,
		OrderByComparator<Objectif> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OBJECTIF_WHERE);

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
			sb.append(ObjectifModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commercialId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(objectif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Objectif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the objectifs where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	@Override
	public void removeByCommercialId(long commercialId) {
		for (Objectif objectif :
				findByCommercialId(
					commercialId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(objectif);
		}
	}

	/**
	 * Returns the number of objectifs where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching objectifs
	 */
	@Override
	public int countByCommercialId(long commercialId) {
		FinderPath finderPath = _finderPathCountByCommercialId;

		Object[] finderArgs = new Object[] {commercialId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OBJECTIF_WHERE);

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
		"objectif.commercialId = ?";

	private FinderPath _finderPathWithPaginationFindByC_A;
	private FinderPath _finderPathWithoutPaginationFindByC_A;
	private FinderPath _finderPathCountByC_A;

	/**
	 * Returns all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the matching objectifs
	 */
	@Override
	public List<Objectif> findByC_A(long commercialId, int annee) {
		return findByC_A(
			commercialId, annee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of matching objectifs
	 */
	@Override
	public List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end) {

		return findByC_A(commercialId, annee, start, end, null);
	}

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching objectifs
	 */
	@Override
	public List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end,
		OrderByComparator<Objectif> orderByComparator) {

		return findByC_A(
			commercialId, annee, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching objectifs
	 */
	@Override
	public List<Objectif> findByC_A(
		long commercialId, int annee, int start, int end,
		OrderByComparator<Objectif> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByC_A;
				finderArgs = new Object[] {commercialId, annee};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByC_A;
			finderArgs = new Object[] {
				commercialId, annee, start, end, orderByComparator
			};
		}

		List<Objectif> list = null;

		if (useFinderCache) {
			list = (List<Objectif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Objectif objectif : list) {
					if ((commercialId != objectif.getCommercialId()) ||
						(annee != objectif.getAnnee())) {

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

			sb.append(_SQL_SELECT_OBJECTIF_WHERE);

			sb.append(_FINDER_COLUMN_C_A_COMMERCIALID_2);

			sb.append(_FINDER_COLUMN_C_A_ANNEE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ObjectifModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				queryPos.add(annee);

				list = (List<Objectif>)QueryUtil.list(
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
	 * Returns the first objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	@Override
	public Objectif findByC_A_First(
			long commercialId, int annee,
			OrderByComparator<Objectif> orderByComparator)
		throws NoSuchObjectifException {

		Objectif objectif = fetchByC_A_First(
			commercialId, annee, orderByComparator);

		if (objectif != null) {
			return objectif;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append(", annee=");
		sb.append(annee);

		sb.append("}");

		throw new NoSuchObjectifException(sb.toString());
	}

	/**
	 * Returns the first objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	@Override
	public Objectif fetchByC_A_First(
		long commercialId, int annee,
		OrderByComparator<Objectif> orderByComparator) {

		List<Objectif> list = findByC_A(
			commercialId, annee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	@Override
	public Objectif findByC_A_Last(
			long commercialId, int annee,
			OrderByComparator<Objectif> orderByComparator)
		throws NoSuchObjectifException {

		Objectif objectif = fetchByC_A_Last(
			commercialId, annee, orderByComparator);

		if (objectif != null) {
			return objectif;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append(", annee=");
		sb.append(annee);

		sb.append("}");

		throw new NoSuchObjectifException(sb.toString());
	}

	/**
	 * Returns the last objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	@Override
	public Objectif fetchByC_A_Last(
		long commercialId, int annee,
		OrderByComparator<Objectif> orderByComparator) {

		int count = countByC_A(commercialId, annee);

		if (count == 0) {
			return null;
		}

		List<Objectif> list = findByC_A(
			commercialId, annee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the objectifs before and after the current objectif in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param id the primary key of the current objectif
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	@Override
	public Objectif[] findByC_A_PrevAndNext(
			long id, long commercialId, int annee,
			OrderByComparator<Objectif> orderByComparator)
		throws NoSuchObjectifException {

		Objectif objectif = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Objectif[] array = new ObjectifImpl[3];

			array[0] = getByC_A_PrevAndNext(
				session, objectif, commercialId, annee, orderByComparator,
				true);

			array[1] = objectif;

			array[2] = getByC_A_PrevAndNext(
				session, objectif, commercialId, annee, orderByComparator,
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

	protected Objectif getByC_A_PrevAndNext(
		Session session, Objectif objectif, long commercialId, int annee,
		OrderByComparator<Objectif> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_OBJECTIF_WHERE);

		sb.append(_FINDER_COLUMN_C_A_COMMERCIALID_2);

		sb.append(_FINDER_COLUMN_C_A_ANNEE_2);

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
			sb.append(ObjectifModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commercialId);

		queryPos.add(annee);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(objectif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Objectif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the objectifs where commercialId = &#63; and annee = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 */
	@Override
	public void removeByC_A(long commercialId, int annee) {
		for (Objectif objectif :
				findByC_A(
					commercialId, annee, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(objectif);
		}
	}

	/**
	 * Returns the number of objectifs where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the number of matching objectifs
	 */
	@Override
	public int countByC_A(long commercialId, int annee) {
		FinderPath finderPath = _finderPathCountByC_A;

		Object[] finderArgs = new Object[] {commercialId, annee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_OBJECTIF_WHERE);

			sb.append(_FINDER_COLUMN_C_A_COMMERCIALID_2);

			sb.append(_FINDER_COLUMN_C_A_ANNEE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				queryPos.add(annee);

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

	private static final String _FINDER_COLUMN_C_A_COMMERCIALID_2 =
		"objectif.commercialId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_ANNEE_2 =
		"objectif.annee = ?";

	private FinderPath _finderPathFetchByC_A_M;

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or throws a <code>NoSuchObjectifException</code> if it could not be found.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the matching objectif
	 * @throws NoSuchObjectifException if a matching objectif could not be found
	 */
	@Override
	public Objectif findByC_A_M(long commercialId, int annee, int mois)
		throws NoSuchObjectifException {

		Objectif objectif = fetchByC_A_M(commercialId, annee, mois);

		if (objectif == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("commercialId=");
			sb.append(commercialId);

			sb.append(", annee=");
			sb.append(annee);

			sb.append(", mois=");
			sb.append(mois);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchObjectifException(sb.toString());
		}

		return objectif;
	}

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	@Override
	public Objectif fetchByC_A_M(long commercialId, int annee, int mois) {
		return fetchByC_A_M(commercialId, annee, mois, true);
	}

	/**
	 * Returns the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching objectif, or <code>null</code> if a matching objectif could not be found
	 */
	@Override
	public Objectif fetchByC_A_M(
		long commercialId, int annee, int mois, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {commercialId, annee, mois};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_A_M, finderArgs, this);
		}

		if (result instanceof Objectif) {
			Objectif objectif = (Objectif)result;

			if ((commercialId != objectif.getCommercialId()) ||
				(annee != objectif.getAnnee()) ||
				(mois != objectif.getMois())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_OBJECTIF_WHERE);

			sb.append(_FINDER_COLUMN_C_A_M_COMMERCIALID_2);

			sb.append(_FINDER_COLUMN_C_A_M_ANNEE_2);

			sb.append(_FINDER_COLUMN_C_A_M_MOIS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				queryPos.add(annee);

				queryPos.add(mois);

				List<Objectif> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_A_M, finderArgs, list);
					}
				}
				else {
					Objectif objectif = list.get(0);

					result = objectif;

					cacheResult(objectif);
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
			return (Objectif)result;
		}
	}

	/**
	 * Removes the objectif where commercialId = &#63; and annee = &#63; and mois = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the objectif that was removed
	 */
	@Override
	public Objectif removeByC_A_M(long commercialId, int annee, int mois)
		throws NoSuchObjectifException {

		Objectif objectif = findByC_A_M(commercialId, annee, mois);

		return remove(objectif);
	}

	/**
	 * Returns the number of objectifs where commercialId = &#63; and annee = &#63; and mois = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @return the number of matching objectifs
	 */
	@Override
	public int countByC_A_M(long commercialId, int annee, int mois) {
		Objectif objectif = fetchByC_A_M(commercialId, annee, mois);

		if (objectif == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_C_A_M_COMMERCIALID_2 =
		"objectif.commercialId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_M_ANNEE_2 =
		"objectif.annee = ? AND ";

	private static final String _FINDER_COLUMN_C_A_M_MOIS_2 =
		"objectif.mois = ?";

	public ObjectifPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("commercialId", "commercial_id");
		dbColumnNames.put("valeurCible", "valeur_cible");
		dbColumnNames.put("valeurReelle", "valeur_reelle");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Objectif.class);

		setModelImplClass(ObjectifImpl.class);
		setModelPKClass(long.class);

		setTable(ObjectifTable.INSTANCE);
	}

	/**
	 * Caches the objectif in the entity cache if it is enabled.
	 *
	 * @param objectif the objectif
	 */
	@Override
	public void cacheResult(Objectif objectif) {
		entityCache.putResult(
			ObjectifImpl.class, objectif.getPrimaryKey(), objectif);

		finderCache.putResult(
			_finderPathFetchByC_A_M,
			new Object[] {
				objectif.getCommercialId(), objectif.getAnnee(),
				objectif.getMois()
			},
			objectif);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the objectifs in the entity cache if it is enabled.
	 *
	 * @param objectifs the objectifs
	 */
	@Override
	public void cacheResult(List<Objectif> objectifs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (objectifs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Objectif objectif : objectifs) {
			if (entityCache.getResult(
					ObjectifImpl.class, objectif.getPrimaryKey()) == null) {

				cacheResult(objectif);
			}
		}
	}

	/**
	 * Clears the cache for all objectifs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ObjectifImpl.class);

		finderCache.clearCache(ObjectifImpl.class);
	}

	/**
	 * Clears the cache for the objectif.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Objectif objectif) {
		entityCache.removeResult(ObjectifImpl.class, objectif);
	}

	@Override
	public void clearCache(List<Objectif> objectifs) {
		for (Objectif objectif : objectifs) {
			entityCache.removeResult(ObjectifImpl.class, objectif);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ObjectifImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ObjectifImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ObjectifModelImpl objectifModelImpl) {

		Object[] args = new Object[] {
			objectifModelImpl.getCommercialId(), objectifModelImpl.getAnnee(),
			objectifModelImpl.getMois()
		};

		finderCache.putResult(_finderPathFetchByC_A_M, args, objectifModelImpl);
	}

	/**
	 * Creates a new objectif with the primary key. Does not add the objectif to the database.
	 *
	 * @param id the primary key for the new objectif
	 * @return the new objectif
	 */
	@Override
	public Objectif create(long id) {
		Objectif objectif = new ObjectifImpl();

		objectif.setNew(true);
		objectif.setPrimaryKey(id);

		return objectif;
	}

	/**
	 * Removes the objectif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif that was removed
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	@Override
	public Objectif remove(long id) throws NoSuchObjectifException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the objectif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the objectif
	 * @return the objectif that was removed
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	@Override
	public Objectif remove(Serializable primaryKey)
		throws NoSuchObjectifException {

		Session session = null;

		try {
			session = openSession();

			Objectif objectif = (Objectif)session.get(
				ObjectifImpl.class, primaryKey);

			if (objectif == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchObjectifException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(objectif);
		}
		catch (NoSuchObjectifException noSuchEntityException) {
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
	protected Objectif removeImpl(Objectif objectif) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(objectif)) {
				objectif = (Objectif)session.get(
					ObjectifImpl.class, objectif.getPrimaryKeyObj());
			}

			if (objectif != null) {
				session.delete(objectif);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (objectif != null) {
			clearCache(objectif);
		}

		return objectif;
	}

	@Override
	public Objectif updateImpl(Objectif objectif) {
		boolean isNew = objectif.isNew();

		if (!(objectif instanceof ObjectifModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(objectif.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(objectif);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in objectif proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Objectif implementation " +
					objectif.getClass());
		}

		ObjectifModelImpl objectifModelImpl = (ObjectifModelImpl)objectif;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(objectif);
			}
			else {
				objectif = (Objectif)session.merge(objectif);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ObjectifImpl.class, objectifModelImpl, false, true);

		cacheUniqueFindersCache(objectifModelImpl);

		if (isNew) {
			objectif.setNew(false);
		}

		objectif.resetOriginalValues();

		return objectif;
	}

	/**
	 * Returns the objectif with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the objectif
	 * @return the objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	@Override
	public Objectif findByPrimaryKey(Serializable primaryKey)
		throws NoSuchObjectifException {

		Objectif objectif = fetchByPrimaryKey(primaryKey);

		if (objectif == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchObjectifException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return objectif;
	}

	/**
	 * Returns the objectif with the primary key or throws a <code>NoSuchObjectifException</code> if it could not be found.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif
	 * @throws NoSuchObjectifException if a objectif with the primary key could not be found
	 */
	@Override
	public Objectif findByPrimaryKey(long id) throws NoSuchObjectifException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the objectif with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the objectif
	 * @return the objectif, or <code>null</code> if a objectif with the primary key could not be found
	 */
	@Override
	public Objectif fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the objectifs.
	 *
	 * @return the objectifs
	 */
	@Override
	public List<Objectif> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @return the range of objectifs
	 */
	@Override
	public List<Objectif> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of objectifs
	 */
	@Override
	public List<Objectif> findAll(
		int start, int end, OrderByComparator<Objectif> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the objectifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of objectifs
	 * @param end the upper bound of the range of objectifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of objectifs
	 */
	@Override
	public List<Objectif> findAll(
		int start, int end, OrderByComparator<Objectif> orderByComparator,
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

		List<Objectif> list = null;

		if (useFinderCache) {
			list = (List<Objectif>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OBJECTIF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OBJECTIF;

				sql = sql.concat(ObjectifModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Objectif>)QueryUtil.list(
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
	 * Removes all the objectifs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Objectif objectif : findAll()) {
			remove(objectif);
		}
	}

	/**
	 * Returns the number of objectifs.
	 *
	 * @return the number of objectifs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OBJECTIF);

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
		return _SQL_SELECT_OBJECTIF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ObjectifModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the objectif persistence.
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

		_finderPathWithPaginationFindByC_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_A",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"commercial_id", "annee"}, true);

		_finderPathWithoutPaginationFindByC_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_A",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"commercial_id", "annee"}, true);

		_finderPathCountByC_A = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"commercial_id", "annee"}, false);

		_finderPathFetchByC_A_M = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_A_M",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			new String[] {"commercial_id", "annee", "mois"}, true);

		ObjectifUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ObjectifUtil.setPersistence(null);

		entityCache.removeCache(ObjectifImpl.class.getName());
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

	private static final String _SQL_SELECT_OBJECTIF =
		"SELECT objectif FROM Objectif objectif";

	private static final String _SQL_SELECT_OBJECTIF_WHERE =
		"SELECT objectif FROM Objectif objectif WHERE ";

	private static final String _SQL_COUNT_OBJECTIF =
		"SELECT COUNT(objectif) FROM Objectif objectif";

	private static final String _SQL_COUNT_OBJECTIF_WHERE =
		"SELECT COUNT(objectif) FROM Objectif objectif WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "objectif.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Objectif exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Objectif exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ObjectifPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"commercialId", "valeurCible", "valeurReelle", "createdAt",
			"updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}