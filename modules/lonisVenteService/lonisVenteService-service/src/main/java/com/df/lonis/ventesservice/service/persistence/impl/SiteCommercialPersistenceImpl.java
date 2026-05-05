/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchSiteCommercialException;
import com.df.lonis.ventesservice.model.SiteCommercial;
import com.df.lonis.ventesservice.model.SiteCommercialTable;
import com.df.lonis.ventesservice.model.impl.SiteCommercialImpl;
import com.df.lonis.ventesservice.model.impl.SiteCommercialModelImpl;
import com.df.lonis.ventesservice.service.persistence.SiteCommercialPersistence;
import com.df.lonis.ventesservice.service.persistence.SiteCommercialUtil;
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
 * The persistence implementation for the site commercial service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SiteCommercialPersistence.class)
public class SiteCommercialPersistenceImpl
	extends BasePersistenceImpl<SiteCommercial>
	implements SiteCommercialPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SiteCommercialUtil</code> to access the site commercial persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SiteCommercialImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBySiteId;
	private FinderPath _finderPathWithoutPaginationFindBySiteId;
	private FinderPath _finderPathCountBySiteId;

	/**
	 * Returns all the site commercials where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the matching site commercials
	 */
	@Override
	public List<SiteCommercial> findBySiteId(long siteId) {
		return findBySiteId(siteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the site commercials where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @return the range of matching site commercials
	 */
	@Override
	public List<SiteCommercial> findBySiteId(long siteId, int start, int end) {
		return findBySiteId(siteId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the site commercials where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching site commercials
	 */
	@Override
	public List<SiteCommercial> findBySiteId(
		long siteId, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return findBySiteId(siteId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the site commercials where siteId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param siteId the site ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching site commercials
	 */
	@Override
	public List<SiteCommercial> findBySiteId(
		long siteId, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySiteId;
				finderArgs = new Object[] {siteId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySiteId;
			finderArgs = new Object[] {siteId, start, end, orderByComparator};
		}

		List<SiteCommercial> list = null;

		if (useFinderCache) {
			list = (List<SiteCommercial>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SiteCommercial siteCommercial : list) {
					if (siteId != siteCommercial.getSiteId()) {
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

			sb.append(_SQL_SELECT_SITECOMMERCIAL_WHERE);

			sb.append(_FINDER_COLUMN_SITEID_SITEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SiteCommercialModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(siteId);

				list = (List<SiteCommercial>)QueryUtil.list(
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
	 * Returns the first site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial findBySiteId_First(
			long siteId, OrderByComparator<SiteCommercial> orderByComparator)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = fetchBySiteId_First(
			siteId, orderByComparator);

		if (siteCommercial != null) {
			return siteCommercial;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("siteId=");
		sb.append(siteId);

		sb.append("}");

		throw new NoSuchSiteCommercialException(sb.toString());
	}

	/**
	 * Returns the first site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial fetchBySiteId_First(
		long siteId, OrderByComparator<SiteCommercial> orderByComparator) {

		List<SiteCommercial> list = findBySiteId(
			siteId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial findBySiteId_Last(
			long siteId, OrderByComparator<SiteCommercial> orderByComparator)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = fetchBySiteId_Last(
			siteId, orderByComparator);

		if (siteCommercial != null) {
			return siteCommercial;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("siteId=");
		sb.append(siteId);

		sb.append("}");

		throw new NoSuchSiteCommercialException(sb.toString());
	}

	/**
	 * Returns the last site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial fetchBySiteId_Last(
		long siteId, OrderByComparator<SiteCommercial> orderByComparator) {

		int count = countBySiteId(siteId);

		if (count == 0) {
			return null;
		}

		List<SiteCommercial> list = findBySiteId(
			siteId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the site commercials before and after the current site commercial in the ordered set where siteId = &#63;.
	 *
	 * @param id the primary key of the current site commercial
	 * @param siteId the site ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	@Override
	public SiteCommercial[] findBySiteId_PrevAndNext(
			long id, long siteId,
			OrderByComparator<SiteCommercial> orderByComparator)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SiteCommercial[] array = new SiteCommercialImpl[3];

			array[0] = getBySiteId_PrevAndNext(
				session, siteCommercial, siteId, orderByComparator, true);

			array[1] = siteCommercial;

			array[2] = getBySiteId_PrevAndNext(
				session, siteCommercial, siteId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected SiteCommercial getBySiteId_PrevAndNext(
		Session session, SiteCommercial siteCommercial, long siteId,
		OrderByComparator<SiteCommercial> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SITECOMMERCIAL_WHERE);

		sb.append(_FINDER_COLUMN_SITEID_SITEID_2);

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
			sb.append(SiteCommercialModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(siteId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						siteCommercial)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SiteCommercial> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the site commercials where siteId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 */
	@Override
	public void removeBySiteId(long siteId) {
		for (SiteCommercial siteCommercial :
				findBySiteId(
					siteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(siteCommercial);
		}
	}

	/**
	 * Returns the number of site commercials where siteId = &#63;.
	 *
	 * @param siteId the site ID
	 * @return the number of matching site commercials
	 */
	@Override
	public int countBySiteId(long siteId) {
		FinderPath finderPath = _finderPathCountBySiteId;

		Object[] finderArgs = new Object[] {siteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SITECOMMERCIAL_WHERE);

			sb.append(_FINDER_COLUMN_SITEID_SITEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(siteId);

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

	private static final String _FINDER_COLUMN_SITEID_SITEID_2 =
		"siteCommercial.siteId = ?";

	private FinderPath _finderPathWithPaginationFindByCommercialId;
	private FinderPath _finderPathWithoutPaginationFindByCommercialId;
	private FinderPath _finderPathCountByCommercialId;

	/**
	 * Returns all the site commercials where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching site commercials
	 */
	@Override
	public List<SiteCommercial> findByCommercialId(long commercialId) {
		return findByCommercialId(
			commercialId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the site commercials where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @return the range of matching site commercials
	 */
	@Override
	public List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end) {

		return findByCommercialId(commercialId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the site commercials where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching site commercials
	 */
	@Override
	public List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return findByCommercialId(
			commercialId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the site commercials where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching site commercials
	 */
	@Override
	public List<SiteCommercial> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator,
		boolean useFinderCache) {

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

		List<SiteCommercial> list = null;

		if (useFinderCache) {
			list = (List<SiteCommercial>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SiteCommercial siteCommercial : list) {
					if (commercialId != siteCommercial.getCommercialId()) {
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

			sb.append(_SQL_SELECT_SITECOMMERCIAL_WHERE);

			sb.append(_FINDER_COLUMN_COMMERCIALID_COMMERCIALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SiteCommercialModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				list = (List<SiteCommercial>)QueryUtil.list(
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
	 * Returns the first site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial findByCommercialId_First(
			long commercialId,
			OrderByComparator<SiteCommercial> orderByComparator)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = fetchByCommercialId_First(
			commercialId, orderByComparator);

		if (siteCommercial != null) {
			return siteCommercial;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append("}");

		throw new NoSuchSiteCommercialException(sb.toString());
	}

	/**
	 * Returns the first site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial fetchByCommercialId_First(
		long commercialId,
		OrderByComparator<SiteCommercial> orderByComparator) {

		List<SiteCommercial> list = findByCommercialId(
			commercialId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial findByCommercialId_Last(
			long commercialId,
			OrderByComparator<SiteCommercial> orderByComparator)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = fetchByCommercialId_Last(
			commercialId, orderByComparator);

		if (siteCommercial != null) {
			return siteCommercial;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append("}");

		throw new NoSuchSiteCommercialException(sb.toString());
	}

	/**
	 * Returns the last site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial fetchByCommercialId_Last(
		long commercialId,
		OrderByComparator<SiteCommercial> orderByComparator) {

		int count = countByCommercialId(commercialId);

		if (count == 0) {
			return null;
		}

		List<SiteCommercial> list = findByCommercialId(
			commercialId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the site commercials before and after the current site commercial in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current site commercial
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	@Override
	public SiteCommercial[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			OrderByComparator<SiteCommercial> orderByComparator)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			SiteCommercial[] array = new SiteCommercialImpl[3];

			array[0] = getByCommercialId_PrevAndNext(
				session, siteCommercial, commercialId, orderByComparator, true);

			array[1] = siteCommercial;

			array[2] = getByCommercialId_PrevAndNext(
				session, siteCommercial, commercialId, orderByComparator,
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

	protected SiteCommercial getByCommercialId_PrevAndNext(
		Session session, SiteCommercial siteCommercial, long commercialId,
		OrderByComparator<SiteCommercial> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SITECOMMERCIAL_WHERE);

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
			sb.append(SiteCommercialModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commercialId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						siteCommercial)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SiteCommercial> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the site commercials where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	@Override
	public void removeByCommercialId(long commercialId) {
		for (SiteCommercial siteCommercial :
				findByCommercialId(
					commercialId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(siteCommercial);
		}
	}

	/**
	 * Returns the number of site commercials where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching site commercials
	 */
	@Override
	public int countByCommercialId(long commercialId) {
		FinderPath finderPath = _finderPathCountByCommercialId;

		Object[] finderArgs = new Object[] {commercialId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SITECOMMERCIAL_WHERE);

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
		"siteCommercial.commercialId = ?";

	private FinderPath _finderPathFetchByS_C;

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or throws a <code>NoSuchSiteCommercialException</code> if it could not be found.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the matching site commercial
	 * @throws NoSuchSiteCommercialException if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial findByS_C(long siteId, long commercialId)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = fetchByS_C(siteId, commercialId);

		if (siteCommercial == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("siteId=");
			sb.append(siteId);

			sb.append(", commercialId=");
			sb.append(commercialId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSiteCommercialException(sb.toString());
		}

		return siteCommercial;
	}

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial fetchByS_C(long siteId, long commercialId) {
		return fetchByS_C(siteId, commercialId, true);
	}

	/**
	 * Returns the site commercial where siteId = &#63; and commercialId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching site commercial, or <code>null</code> if a matching site commercial could not be found
	 */
	@Override
	public SiteCommercial fetchByS_C(
		long siteId, long commercialId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {siteId, commercialId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByS_C, finderArgs, this);
		}

		if (result instanceof SiteCommercial) {
			SiteCommercial siteCommercial = (SiteCommercial)result;

			if ((siteId != siteCommercial.getSiteId()) ||
				(commercialId != siteCommercial.getCommercialId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SITECOMMERCIAL_WHERE);

			sb.append(_FINDER_COLUMN_S_C_SITEID_2);

			sb.append(_FINDER_COLUMN_S_C_COMMERCIALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(siteId);

				queryPos.add(commercialId);

				List<SiteCommercial> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByS_C, finderArgs, list);
					}
				}
				else {
					SiteCommercial siteCommercial = list.get(0);

					result = siteCommercial;

					cacheResult(siteCommercial);
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
			return (SiteCommercial)result;
		}
	}

	/**
	 * Removes the site commercial where siteId = &#63; and commercialId = &#63; from the database.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the site commercial that was removed
	 */
	@Override
	public SiteCommercial removeByS_C(long siteId, long commercialId)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = findByS_C(siteId, commercialId);

		return remove(siteCommercial);
	}

	/**
	 * Returns the number of site commercials where siteId = &#63; and commercialId = &#63;.
	 *
	 * @param siteId the site ID
	 * @param commercialId the commercial ID
	 * @return the number of matching site commercials
	 */
	@Override
	public int countByS_C(long siteId, long commercialId) {
		SiteCommercial siteCommercial = fetchByS_C(siteId, commercialId);

		if (siteCommercial == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_S_C_SITEID_2 =
		"siteCommercial.siteId = ? AND ";

	private static final String _FINDER_COLUMN_S_C_COMMERCIALID_2 =
		"siteCommercial.commercialId = ?";

	public SiteCommercialPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("siteId", "site_id");
		dbColumnNames.put("commercialId", "commercial_id");
		dbColumnNames.put("dateDebut", "date_debut");
		dbColumnNames.put("dateFin", "date_fin");
		dbColumnNames.put("isPrincipal", "is_principal");
		dbColumnNames.put("createdAt", "created_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(SiteCommercial.class);

		setModelImplClass(SiteCommercialImpl.class);
		setModelPKClass(long.class);

		setTable(SiteCommercialTable.INSTANCE);
	}

	/**
	 * Caches the site commercial in the entity cache if it is enabled.
	 *
	 * @param siteCommercial the site commercial
	 */
	@Override
	public void cacheResult(SiteCommercial siteCommercial) {
		entityCache.putResult(
			SiteCommercialImpl.class, siteCommercial.getPrimaryKey(),
			siteCommercial);

		finderCache.putResult(
			_finderPathFetchByS_C,
			new Object[] {
				siteCommercial.getSiteId(), siteCommercial.getCommercialId()
			},
			siteCommercial);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the site commercials in the entity cache if it is enabled.
	 *
	 * @param siteCommercials the site commercials
	 */
	@Override
	public void cacheResult(List<SiteCommercial> siteCommercials) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (siteCommercials.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SiteCommercial siteCommercial : siteCommercials) {
			if (entityCache.getResult(
					SiteCommercialImpl.class, siteCommercial.getPrimaryKey()) ==
						null) {

				cacheResult(siteCommercial);
			}
		}
	}

	/**
	 * Clears the cache for all site commercials.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SiteCommercialImpl.class);

		finderCache.clearCache(SiteCommercialImpl.class);
	}

	/**
	 * Clears the cache for the site commercial.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SiteCommercial siteCommercial) {
		entityCache.removeResult(SiteCommercialImpl.class, siteCommercial);
	}

	@Override
	public void clearCache(List<SiteCommercial> siteCommercials) {
		for (SiteCommercial siteCommercial : siteCommercials) {
			entityCache.removeResult(SiteCommercialImpl.class, siteCommercial);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SiteCommercialImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SiteCommercialImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SiteCommercialModelImpl siteCommercialModelImpl) {

		Object[] args = new Object[] {
			siteCommercialModelImpl.getSiteId(),
			siteCommercialModelImpl.getCommercialId()
		};

		finderCache.putResult(
			_finderPathFetchByS_C, args, siteCommercialModelImpl);
	}

	/**
	 * Creates a new site commercial with the primary key. Does not add the site commercial to the database.
	 *
	 * @param id the primary key for the new site commercial
	 * @return the new site commercial
	 */
	@Override
	public SiteCommercial create(long id) {
		SiteCommercial siteCommercial = new SiteCommercialImpl();

		siteCommercial.setNew(true);
		siteCommercial.setPrimaryKey(id);

		return siteCommercial;
	}

	/**
	 * Removes the site commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial that was removed
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	@Override
	public SiteCommercial remove(long id) throws NoSuchSiteCommercialException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the site commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the site commercial
	 * @return the site commercial that was removed
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	@Override
	public SiteCommercial remove(Serializable primaryKey)
		throws NoSuchSiteCommercialException {

		Session session = null;

		try {
			session = openSession();

			SiteCommercial siteCommercial = (SiteCommercial)session.get(
				SiteCommercialImpl.class, primaryKey);

			if (siteCommercial == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSiteCommercialException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(siteCommercial);
		}
		catch (NoSuchSiteCommercialException noSuchEntityException) {
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
	protected SiteCommercial removeImpl(SiteCommercial siteCommercial) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(siteCommercial)) {
				siteCommercial = (SiteCommercial)session.get(
					SiteCommercialImpl.class,
					siteCommercial.getPrimaryKeyObj());
			}

			if (siteCommercial != null) {
				session.delete(siteCommercial);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (siteCommercial != null) {
			clearCache(siteCommercial);
		}

		return siteCommercial;
	}

	@Override
	public SiteCommercial updateImpl(SiteCommercial siteCommercial) {
		boolean isNew = siteCommercial.isNew();

		if (!(siteCommercial instanceof SiteCommercialModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(siteCommercial.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					siteCommercial);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in siteCommercial proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SiteCommercial implementation " +
					siteCommercial.getClass());
		}

		SiteCommercialModelImpl siteCommercialModelImpl =
			(SiteCommercialModelImpl)siteCommercial;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(siteCommercial);
			}
			else {
				siteCommercial = (SiteCommercial)session.merge(siteCommercial);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SiteCommercialImpl.class, siteCommercialModelImpl, false, true);

		cacheUniqueFindersCache(siteCommercialModelImpl);

		if (isNew) {
			siteCommercial.setNew(false);
		}

		siteCommercial.resetOriginalValues();

		return siteCommercial;
	}

	/**
	 * Returns the site commercial with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the site commercial
	 * @return the site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	@Override
	public SiteCommercial findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSiteCommercialException {

		SiteCommercial siteCommercial = fetchByPrimaryKey(primaryKey);

		if (siteCommercial == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSiteCommercialException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return siteCommercial;
	}

	/**
	 * Returns the site commercial with the primary key or throws a <code>NoSuchSiteCommercialException</code> if it could not be found.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial
	 * @throws NoSuchSiteCommercialException if a site commercial with the primary key could not be found
	 */
	@Override
	public SiteCommercial findByPrimaryKey(long id)
		throws NoSuchSiteCommercialException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the site commercial with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the site commercial
	 * @return the site commercial, or <code>null</code> if a site commercial with the primary key could not be found
	 */
	@Override
	public SiteCommercial fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the site commercials.
	 *
	 * @return the site commercials
	 */
	@Override
	public List<SiteCommercial> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the site commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @return the range of site commercials
	 */
	@Override
	public List<SiteCommercial> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the site commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of site commercials
	 */
	@Override
	public List<SiteCommercial> findAll(
		int start, int end,
		OrderByComparator<SiteCommercial> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the site commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SiteCommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of site commercials
	 * @param end the upper bound of the range of site commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of site commercials
	 */
	@Override
	public List<SiteCommercial> findAll(
		int start, int end, OrderByComparator<SiteCommercial> orderByComparator,
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

		List<SiteCommercial> list = null;

		if (useFinderCache) {
			list = (List<SiteCommercial>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SITECOMMERCIAL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SITECOMMERCIAL;

				sql = sql.concat(SiteCommercialModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SiteCommercial>)QueryUtil.list(
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
	 * Removes all the site commercials from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SiteCommercial siteCommercial : findAll()) {
			remove(siteCommercial);
		}
	}

	/**
	 * Returns the number of site commercials.
	 *
	 * @return the number of site commercials
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SITECOMMERCIAL);

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
		return _SQL_SELECT_SITECOMMERCIAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SiteCommercialModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the site commercial persistence.
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

		_finderPathWithPaginationFindBySiteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySiteId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"site_id"}, true);

		_finderPathWithoutPaginationFindBySiteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySiteId",
			new String[] {Long.class.getName()}, new String[] {"site_id"},
			true);

		_finderPathCountBySiteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySiteId",
			new String[] {Long.class.getName()}, new String[] {"site_id"},
			false);

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

		_finderPathFetchByS_C = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByS_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"site_id", "commercial_id"}, true);

		SiteCommercialUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		SiteCommercialUtil.setPersistence(null);

		entityCache.removeCache(SiteCommercialImpl.class.getName());
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

	private static final String _SQL_SELECT_SITECOMMERCIAL =
		"SELECT siteCommercial FROM SiteCommercial siteCommercial";

	private static final String _SQL_SELECT_SITECOMMERCIAL_WHERE =
		"SELECT siteCommercial FROM SiteCommercial siteCommercial WHERE ";

	private static final String _SQL_COUNT_SITECOMMERCIAL =
		"SELECT COUNT(siteCommercial) FROM SiteCommercial siteCommercial";

	private static final String _SQL_COUNT_SITECOMMERCIAL_WHERE =
		"SELECT COUNT(siteCommercial) FROM SiteCommercial siteCommercial WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "siteCommercial.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SiteCommercial exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SiteCommercial exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SiteCommercialPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"siteId", "commercialId", "dateDebut", "dateFin", "isPrincipal",
			"createdAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}