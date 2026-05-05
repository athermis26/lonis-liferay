/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchCommercialException;
import com.df.lonis.ventesservice.model.Commercial;
import com.df.lonis.ventesservice.model.CommercialTable;
import com.df.lonis.ventesservice.model.impl.CommercialImpl;
import com.df.lonis.ventesservice.model.impl.CommercialModelImpl;
import com.df.lonis.ventesservice.service.persistence.CommercialPersistence;
import com.df.lonis.ventesservice.service.persistence.CommercialUtil;
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
 * The persistence implementation for the commercial service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CommercialPersistence.class)
public class CommercialPersistenceImpl
	extends BasePersistenceImpl<Commercial> implements CommercialPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CommercialUtil</code> to access the commercial persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CommercialImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByMatricule;

	/**
	 * Returns the commercial where matricule = &#63; or throws a <code>NoSuchCommercialException</code> if it could not be found.
	 *
	 * @param matricule the matricule
	 * @return the matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	@Override
	public Commercial findByMatricule(String matricule)
		throws NoSuchCommercialException {

		Commercial commercial = fetchByMatricule(matricule);

		if (commercial == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("matricule=");
			sb.append(matricule);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCommercialException(sb.toString());
		}

		return commercial;
	}

	/**
	 * Returns the commercial where matricule = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param matricule the matricule
	 * @return the matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	@Override
	public Commercial fetchByMatricule(String matricule) {
		return fetchByMatricule(matricule, true);
	}

	/**
	 * Returns the commercial where matricule = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param matricule the matricule
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	@Override
	public Commercial fetchByMatricule(
		String matricule, boolean useFinderCache) {

		matricule = Objects.toString(matricule, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {matricule};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByMatricule, finderArgs, this);
		}

		if (result instanceof Commercial) {
			Commercial commercial = (Commercial)result;

			if (!Objects.equals(matricule, commercial.getMatricule())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_COMMERCIAL_WHERE);

			boolean bindMatricule = false;

			if (matricule.isEmpty()) {
				sb.append(_FINDER_COLUMN_MATRICULE_MATRICULE_3);
			}
			else {
				bindMatricule = true;

				sb.append(_FINDER_COLUMN_MATRICULE_MATRICULE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMatricule) {
					queryPos.add(matricule);
				}

				List<Commercial> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByMatricule, finderArgs, list);
					}
				}
				else {
					Commercial commercial = list.get(0);

					result = commercial;

					cacheResult(commercial);
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
			return (Commercial)result;
		}
	}

	/**
	 * Removes the commercial where matricule = &#63; from the database.
	 *
	 * @param matricule the matricule
	 * @return the commercial that was removed
	 */
	@Override
	public Commercial removeByMatricule(String matricule)
		throws NoSuchCommercialException {

		Commercial commercial = findByMatricule(matricule);

		return remove(commercial);
	}

	/**
	 * Returns the number of commercials where matricule = &#63;.
	 *
	 * @param matricule the matricule
	 * @return the number of matching commercials
	 */
	@Override
	public int countByMatricule(String matricule) {
		Commercial commercial = fetchByMatricule(matricule);

		if (commercial == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_MATRICULE_MATRICULE_2 =
		"commercial.matricule = ?";

	private static final String _FINDER_COLUMN_MATRICULE_MATRICULE_3 =
		"(commercial.matricule IS NULL OR commercial.matricule = '')";

	private FinderPath _finderPathWithPaginationFindBySuperviseurId;
	private FinderPath _finderPathWithoutPaginationFindBySuperviseurId;
	private FinderPath _finderPathCountBySuperviseurId;

	/**
	 * Returns all the commercials where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @return the matching commercials
	 */
	@Override
	public List<Commercial> findBySuperviseurId(long superviseurId) {
		return findBySuperviseurId(
			superviseurId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of matching commercials
	 */
	@Override
	public List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end) {

		return findBySuperviseurId(superviseurId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commercials
	 */
	@Override
	public List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end,
		OrderByComparator<Commercial> orderByComparator) {

		return findBySuperviseurId(
			superviseurId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commercials where superviseurId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param superviseurId the superviseur ID
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commercials
	 */
	@Override
	public List<Commercial> findBySuperviseurId(
		long superviseurId, int start, int end,
		OrderByComparator<Commercial> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySuperviseurId;
				finderArgs = new Object[] {superviseurId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySuperviseurId;
			finderArgs = new Object[] {
				superviseurId, start, end, orderByComparator
			};
		}

		List<Commercial> list = null;

		if (useFinderCache) {
			list = (List<Commercial>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Commercial commercial : list) {
					if (superviseurId != commercial.getSuperviseurId()) {
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

			sb.append(_SQL_SELECT_COMMERCIAL_WHERE);

			sb.append(_FINDER_COLUMN_SUPERVISEURID_SUPERVISEURID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CommercialModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(superviseurId);

				list = (List<Commercial>)QueryUtil.list(
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
	 * Returns the first commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	@Override
	public Commercial findBySuperviseurId_First(
			long superviseurId, OrderByComparator<Commercial> orderByComparator)
		throws NoSuchCommercialException {

		Commercial commercial = fetchBySuperviseurId_First(
			superviseurId, orderByComparator);

		if (commercial != null) {
			return commercial;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("superviseurId=");
		sb.append(superviseurId);

		sb.append("}");

		throw new NoSuchCommercialException(sb.toString());
	}

	/**
	 * Returns the first commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	@Override
	public Commercial fetchBySuperviseurId_First(
		long superviseurId, OrderByComparator<Commercial> orderByComparator) {

		List<Commercial> list = findBySuperviseurId(
			superviseurId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	@Override
	public Commercial findBySuperviseurId_Last(
			long superviseurId, OrderByComparator<Commercial> orderByComparator)
		throws NoSuchCommercialException {

		Commercial commercial = fetchBySuperviseurId_Last(
			superviseurId, orderByComparator);

		if (commercial != null) {
			return commercial;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("superviseurId=");
		sb.append(superviseurId);

		sb.append("}");

		throw new NoSuchCommercialException(sb.toString());
	}

	/**
	 * Returns the last commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	@Override
	public Commercial fetchBySuperviseurId_Last(
		long superviseurId, OrderByComparator<Commercial> orderByComparator) {

		int count = countBySuperviseurId(superviseurId);

		if (count == 0) {
			return null;
		}

		List<Commercial> list = findBySuperviseurId(
			superviseurId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commercials before and after the current commercial in the ordered set where superviseurId = &#63;.
	 *
	 * @param id the primary key of the current commercial
	 * @param superviseurId the superviseur ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	@Override
	public Commercial[] findBySuperviseurId_PrevAndNext(
			long id, long superviseurId,
			OrderByComparator<Commercial> orderByComparator)
		throws NoSuchCommercialException {

		Commercial commercial = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Commercial[] array = new CommercialImpl[3];

			array[0] = getBySuperviseurId_PrevAndNext(
				session, commercial, superviseurId, orderByComparator, true);

			array[1] = commercial;

			array[2] = getBySuperviseurId_PrevAndNext(
				session, commercial, superviseurId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Commercial getBySuperviseurId_PrevAndNext(
		Session session, Commercial commercial, long superviseurId,
		OrderByComparator<Commercial> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMERCIAL_WHERE);

		sb.append(_FINDER_COLUMN_SUPERVISEURID_SUPERVISEURID_2);

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
			sb.append(CommercialModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(superviseurId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(commercial)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Commercial> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commercials where superviseurId = &#63; from the database.
	 *
	 * @param superviseurId the superviseur ID
	 */
	@Override
	public void removeBySuperviseurId(long superviseurId) {
		for (Commercial commercial :
				findBySuperviseurId(
					superviseurId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(commercial);
		}
	}

	/**
	 * Returns the number of commercials where superviseurId = &#63;.
	 *
	 * @param superviseurId the superviseur ID
	 * @return the number of matching commercials
	 */
	@Override
	public int countBySuperviseurId(long superviseurId) {
		FinderPath finderPath = _finderPathCountBySuperviseurId;

		Object[] finderArgs = new Object[] {superviseurId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMERCIAL_WHERE);

			sb.append(_FINDER_COLUMN_SUPERVISEURID_SUPERVISEURID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(superviseurId);

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

	private static final String _FINDER_COLUMN_SUPERVISEURID_SUPERVISEURID_2 =
		"commercial.superviseurId = ?";

	private FinderPath _finderPathWithPaginationFindByStatut;
	private FinderPath _finderPathWithoutPaginationFindByStatut;
	private FinderPath _finderPathCountByStatut;

	/**
	 * Returns all the commercials where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching commercials
	 */
	@Override
	public List<Commercial> findByStatut(String statut) {
		return findByStatut(statut, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of matching commercials
	 */
	@Override
	public List<Commercial> findByStatut(String statut, int start, int end) {
		return findByStatut(statut, start, end, null);
	}

	/**
	 * Returns an ordered range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching commercials
	 */
	@Override
	public List<Commercial> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Commercial> orderByComparator) {

		return findByStatut(statut, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commercials where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching commercials
	 */
	@Override
	public List<Commercial> findByStatut(
		String statut, int start, int end,
		OrderByComparator<Commercial> orderByComparator,
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

		List<Commercial> list = null;

		if (useFinderCache) {
			list = (List<Commercial>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Commercial commercial : list) {
					if (!statut.equals(commercial.getStatut())) {
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

			sb.append(_SQL_SELECT_COMMERCIAL_WHERE);

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
				sb.append(CommercialModelImpl.ORDER_BY_JPQL);
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

				list = (List<Commercial>)QueryUtil.list(
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
	 * Returns the first commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	@Override
	public Commercial findByStatut_First(
			String statut, OrderByComparator<Commercial> orderByComparator)
		throws NoSuchCommercialException {

		Commercial commercial = fetchByStatut_First(statut, orderByComparator);

		if (commercial != null) {
			return commercial;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statut=");
		sb.append(statut);

		sb.append("}");

		throw new NoSuchCommercialException(sb.toString());
	}

	/**
	 * Returns the first commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	@Override
	public Commercial fetchByStatut_First(
		String statut, OrderByComparator<Commercial> orderByComparator) {

		List<Commercial> list = findByStatut(statut, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial
	 * @throws NoSuchCommercialException if a matching commercial could not be found
	 */
	@Override
	public Commercial findByStatut_Last(
			String statut, OrderByComparator<Commercial> orderByComparator)
		throws NoSuchCommercialException {

		Commercial commercial = fetchByStatut_Last(statut, orderByComparator);

		if (commercial != null) {
			return commercial;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statut=");
		sb.append(statut);

		sb.append("}");

		throw new NoSuchCommercialException(sb.toString());
	}

	/**
	 * Returns the last commercial in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching commercial, or <code>null</code> if a matching commercial could not be found
	 */
	@Override
	public Commercial fetchByStatut_Last(
		String statut, OrderByComparator<Commercial> orderByComparator) {

		int count = countByStatut(statut);

		if (count == 0) {
			return null;
		}

		List<Commercial> list = findByStatut(
			statut, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the commercials before and after the current commercial in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current commercial
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	@Override
	public Commercial[] findByStatut_PrevAndNext(
			long id, String statut,
			OrderByComparator<Commercial> orderByComparator)
		throws NoSuchCommercialException {

		statut = Objects.toString(statut, "");

		Commercial commercial = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Commercial[] array = new CommercialImpl[3];

			array[0] = getByStatut_PrevAndNext(
				session, commercial, statut, orderByComparator, true);

			array[1] = commercial;

			array[2] = getByStatut_PrevAndNext(
				session, commercial, statut, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Commercial getByStatut_PrevAndNext(
		Session session, Commercial commercial, String statut,
		OrderByComparator<Commercial> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMMERCIAL_WHERE);

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
			sb.append(CommercialModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(commercial)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Commercial> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the commercials where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	@Override
	public void removeByStatut(String statut) {
		for (Commercial commercial :
				findByStatut(
					statut, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(commercial);
		}
	}

	/**
	 * Returns the number of commercials where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching commercials
	 */
	@Override
	public int countByStatut(String statut) {
		statut = Objects.toString(statut, "");

		FinderPath finderPath = _finderPathCountByStatut;

		Object[] finderArgs = new Object[] {statut};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMMERCIAL_WHERE);

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
		"commercial.statut = ?";

	private static final String _FINDER_COLUMN_STATUT_STATUT_3 =
		"(commercial.statut IS NULL OR commercial.statut = '')";

	public CommercialPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("superviseurId", "superviseur_id");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Commercial.class);

		setModelImplClass(CommercialImpl.class);
		setModelPKClass(long.class);

		setTable(CommercialTable.INSTANCE);
	}

	/**
	 * Caches the commercial in the entity cache if it is enabled.
	 *
	 * @param commercial the commercial
	 */
	@Override
	public void cacheResult(Commercial commercial) {
		entityCache.putResult(
			CommercialImpl.class, commercial.getPrimaryKey(), commercial);

		finderCache.putResult(
			_finderPathFetchByMatricule,
			new Object[] {commercial.getMatricule()}, commercial);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the commercials in the entity cache if it is enabled.
	 *
	 * @param commercials the commercials
	 */
	@Override
	public void cacheResult(List<Commercial> commercials) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (commercials.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Commercial commercial : commercials) {
			if (entityCache.getResult(
					CommercialImpl.class, commercial.getPrimaryKey()) == null) {

				cacheResult(commercial);
			}
		}
	}

	/**
	 * Clears the cache for all commercials.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CommercialImpl.class);

		finderCache.clearCache(CommercialImpl.class);
	}

	/**
	 * Clears the cache for the commercial.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Commercial commercial) {
		entityCache.removeResult(CommercialImpl.class, commercial);
	}

	@Override
	public void clearCache(List<Commercial> commercials) {
		for (Commercial commercial : commercials) {
			entityCache.removeResult(CommercialImpl.class, commercial);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CommercialImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CommercialImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CommercialModelImpl commercialModelImpl) {

		Object[] args = new Object[] {commercialModelImpl.getMatricule()};

		finderCache.putResult(
			_finderPathFetchByMatricule, args, commercialModelImpl);
	}

	/**
	 * Creates a new commercial with the primary key. Does not add the commercial to the database.
	 *
	 * @param id the primary key for the new commercial
	 * @return the new commercial
	 */
	@Override
	public Commercial create(long id) {
		Commercial commercial = new CommercialImpl();

		commercial.setNew(true);
		commercial.setPrimaryKey(id);

		return commercial;
	}

	/**
	 * Removes the commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial that was removed
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	@Override
	public Commercial remove(long id) throws NoSuchCommercialException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the commercial with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the commercial
	 * @return the commercial that was removed
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	@Override
	public Commercial remove(Serializable primaryKey)
		throws NoSuchCommercialException {

		Session session = null;

		try {
			session = openSession();

			Commercial commercial = (Commercial)session.get(
				CommercialImpl.class, primaryKey);

			if (commercial == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommercialException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(commercial);
		}
		catch (NoSuchCommercialException noSuchEntityException) {
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
	protected Commercial removeImpl(Commercial commercial) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commercial)) {
				commercial = (Commercial)session.get(
					CommercialImpl.class, commercial.getPrimaryKeyObj());
			}

			if (commercial != null) {
				session.delete(commercial);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (commercial != null) {
			clearCache(commercial);
		}

		return commercial;
	}

	@Override
	public Commercial updateImpl(Commercial commercial) {
		boolean isNew = commercial.isNew();

		if (!(commercial instanceof CommercialModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(commercial.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(commercial);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in commercial proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Commercial implementation " +
					commercial.getClass());
		}

		CommercialModelImpl commercialModelImpl =
			(CommercialModelImpl)commercial;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(commercial);
			}
			else {
				commercial = (Commercial)session.merge(commercial);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CommercialImpl.class, commercialModelImpl, false, true);

		cacheUniqueFindersCache(commercialModelImpl);

		if (isNew) {
			commercial.setNew(false);
		}

		commercial.resetOriginalValues();

		return commercial;
	}

	/**
	 * Returns the commercial with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the commercial
	 * @return the commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	@Override
	public Commercial findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommercialException {

		Commercial commercial = fetchByPrimaryKey(primaryKey);

		if (commercial == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommercialException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return commercial;
	}

	/**
	 * Returns the commercial with the primary key or throws a <code>NoSuchCommercialException</code> if it could not be found.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial
	 * @throws NoSuchCommercialException if a commercial with the primary key could not be found
	 */
	@Override
	public Commercial findByPrimaryKey(long id)
		throws NoSuchCommercialException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the commercial with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the commercial
	 * @return the commercial, or <code>null</code> if a commercial with the primary key could not be found
	 */
	@Override
	public Commercial fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the commercials.
	 *
	 * @return the commercials
	 */
	@Override
	public List<Commercial> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @return the range of commercials
	 */
	@Override
	public List<Commercial> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of commercials
	 */
	@Override
	public List<Commercial> findAll(
		int start, int end, OrderByComparator<Commercial> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the commercials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CommercialModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of commercials
	 * @param end the upper bound of the range of commercials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of commercials
	 */
	@Override
	public List<Commercial> findAll(
		int start, int end, OrderByComparator<Commercial> orderByComparator,
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

		List<Commercial> list = null;

		if (useFinderCache) {
			list = (List<Commercial>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMMERCIAL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMMERCIAL;

				sql = sql.concat(CommercialModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Commercial>)QueryUtil.list(
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
	 * Removes all the commercials from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Commercial commercial : findAll()) {
			remove(commercial);
		}
	}

	/**
	 * Returns the number of commercials.
	 *
	 * @return the number of commercials
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMMERCIAL);

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
		return _SQL_SELECT_COMMERCIAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CommercialModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the commercial persistence.
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

		_finderPathFetchByMatricule = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByMatricule",
			new String[] {String.class.getName()}, new String[] {"matricule"},
			true);

		_finderPathWithPaginationFindBySuperviseurId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySuperviseurId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"superviseur_id"}, true);

		_finderPathWithoutPaginationFindBySuperviseurId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySuperviseurId",
			new String[] {Long.class.getName()},
			new String[] {"superviseur_id"}, true);

		_finderPathCountBySuperviseurId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySuperviseurId",
			new String[] {Long.class.getName()},
			new String[] {"superviseur_id"}, false);

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

		CommercialUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CommercialUtil.setPersistence(null);

		entityCache.removeCache(CommercialImpl.class.getName());
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

	private static final String _SQL_SELECT_COMMERCIAL =
		"SELECT commercial FROM Commercial commercial";

	private static final String _SQL_SELECT_COMMERCIAL_WHERE =
		"SELECT commercial FROM Commercial commercial WHERE ";

	private static final String _SQL_COUNT_COMMERCIAL =
		"SELECT COUNT(commercial) FROM Commercial commercial";

	private static final String _SQL_COUNT_COMMERCIAL_WHERE =
		"SELECT COUNT(commercial) FROM Commercial commercial WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "commercial.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Commercial exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Commercial exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CommercialPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"superviseurId", "createdAt", "updatedAt"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}