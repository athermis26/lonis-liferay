/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchConcessionnaireException;
import com.df.lonis.ventesservice.model.Concessionnaire;
import com.df.lonis.ventesservice.model.ConcessionnaireTable;
import com.df.lonis.ventesservice.model.impl.ConcessionnaireImpl;
import com.df.lonis.ventesservice.model.impl.ConcessionnaireModelImpl;
import com.df.lonis.ventesservice.service.persistence.ConcessionnairePersistence;
import com.df.lonis.ventesservice.service.persistence.ConcessionnaireUtil;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the concessionnaire service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ConcessionnairePersistence.class)
public class ConcessionnairePersistenceImpl
	extends BasePersistenceImpl<Concessionnaire>
	implements ConcessionnairePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConcessionnaireUtil</code> to access the concessionnaire persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConcessionnaireImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByUid;

	/**
	 * Returns the concessionnaire where uid = &#63; or throws a <code>NoSuchConcessionnaireException</code> if it could not be found.
	 *
	 * @param uid the uid
	 * @return the matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	@Override
	public Concessionnaire findByUid(String uid)
		throws NoSuchConcessionnaireException {

		Concessionnaire concessionnaire = fetchByUid(uid);

		if (concessionnaire == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uid=");
			sb.append(uid);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchConcessionnaireException(sb.toString());
		}

		return concessionnaire;
	}

	/**
	 * Returns the concessionnaire where uid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uid the uid
	 * @return the matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	@Override
	public Concessionnaire fetchByUid(String uid) {
		return fetchByUid(uid, true);
	}

	/**
	 * Returns the concessionnaire where uid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uid the uid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	@Override
	public Concessionnaire fetchByUid(String uid, boolean useFinderCache) {
		uid = Objects.toString(uid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uid};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUid, finderArgs, this);
		}

		if (result instanceof Concessionnaire) {
			Concessionnaire concessionnaire = (Concessionnaire)result;

			if (!Objects.equals(uid, concessionnaire.getUid())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CONCESSIONNAIRE_WHERE);

			boolean bindUid = false;

			if (uid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UID_UID_3);
			}
			else {
				bindUid = true;

				sb.append(_FINDER_COLUMN_UID_UID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUid) {
					queryPos.add(uid);
				}

				List<Concessionnaire> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUid, finderArgs, list);
					}
				}
				else {
					Concessionnaire concessionnaire = list.get(0);

					result = concessionnaire;

					cacheResult(concessionnaire);
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
			return (Concessionnaire)result;
		}
	}

	/**
	 * Removes the concessionnaire where uid = &#63; from the database.
	 *
	 * @param uid the uid
	 * @return the concessionnaire that was removed
	 */
	@Override
	public Concessionnaire removeByUid(String uid)
		throws NoSuchConcessionnaireException {

		Concessionnaire concessionnaire = findByUid(uid);

		return remove(concessionnaire);
	}

	/**
	 * Returns the number of concessionnaires where uid = &#63;.
	 *
	 * @param uid the uid
	 * @return the number of matching concessionnaires
	 */
	@Override
	public int countByUid(String uid) {
		Concessionnaire concessionnaire = fetchByUid(uid);

		if (concessionnaire == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UID_UID_2 =
		"concessionnaire.uid = ?";

	private static final String _FINDER_COLUMN_UID_UID_3 =
		"(concessionnaire.uid IS NULL OR concessionnaire.uid = '')";

	private FinderPath _finderPathWithPaginationFindByNom;
	private FinderPath _finderPathWithoutPaginationFindByNom;
	private FinderPath _finderPathCountByNom;

	/**
	 * Returns all the concessionnaires where nom = &#63;.
	 *
	 * @param nom the nom
	 * @return the matching concessionnaires
	 */
	@Override
	public List<Concessionnaire> findByNom(String nom) {
		return findByNom(nom, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the concessionnaires where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @return the range of matching concessionnaires
	 */
	@Override
	public List<Concessionnaire> findByNom(String nom, int start, int end) {
		return findByNom(nom, start, end, null);
	}

	/**
	 * Returns an ordered range of all the concessionnaires where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concessionnaires
	 */
	@Override
	public List<Concessionnaire> findByNom(
		String nom, int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator) {

		return findByNom(nom, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the concessionnaires where nom = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param nom the nom
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching concessionnaires
	 */
	@Override
	public List<Concessionnaire> findByNom(
		String nom, int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator,
		boolean useFinderCache) {

		nom = Objects.toString(nom, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByNom;
				finderArgs = new Object[] {nom};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByNom;
			finderArgs = new Object[] {nom, start, end, orderByComparator};
		}

		List<Concessionnaire> list = null;

		if (useFinderCache) {
			list = (List<Concessionnaire>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Concessionnaire concessionnaire : list) {
					if (!nom.equals(concessionnaire.getNom())) {
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

			sb.append(_SQL_SELECT_CONCESSIONNAIRE_WHERE);

			boolean bindNom = false;

			if (nom.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOM_NOM_3);
			}
			else {
				bindNom = true;

				sb.append(_FINDER_COLUMN_NOM_NOM_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConcessionnaireModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNom) {
					queryPos.add(nom);
				}

				list = (List<Concessionnaire>)QueryUtil.list(
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
	 * Returns the first concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	@Override
	public Concessionnaire findByNom_First(
			String nom, OrderByComparator<Concessionnaire> orderByComparator)
		throws NoSuchConcessionnaireException {

		Concessionnaire concessionnaire = fetchByNom_First(
			nom, orderByComparator);

		if (concessionnaire != null) {
			return concessionnaire;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nom=");
		sb.append(nom);

		sb.append("}");

		throw new NoSuchConcessionnaireException(sb.toString());
	}

	/**
	 * Returns the first concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	@Override
	public Concessionnaire fetchByNom_First(
		String nom, OrderByComparator<Concessionnaire> orderByComparator) {

		List<Concessionnaire> list = findByNom(nom, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire
	 * @throws NoSuchConcessionnaireException if a matching concessionnaire could not be found
	 */
	@Override
	public Concessionnaire findByNom_Last(
			String nom, OrderByComparator<Concessionnaire> orderByComparator)
		throws NoSuchConcessionnaireException {

		Concessionnaire concessionnaire = fetchByNom_Last(
			nom, orderByComparator);

		if (concessionnaire != null) {
			return concessionnaire;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nom=");
		sb.append(nom);

		sb.append("}");

		throw new NoSuchConcessionnaireException(sb.toString());
	}

	/**
	 * Returns the last concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire, or <code>null</code> if a matching concessionnaire could not be found
	 */
	@Override
	public Concessionnaire fetchByNom_Last(
		String nom, OrderByComparator<Concessionnaire> orderByComparator) {

		int count = countByNom(nom);

		if (count == 0) {
			return null;
		}

		List<Concessionnaire> list = findByNom(
			nom, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the concessionnaires before and after the current concessionnaire in the ordered set where nom = &#63;.
	 *
	 * @param id the primary key of the current concessionnaire
	 * @param nom the nom
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concessionnaire
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	@Override
	public Concessionnaire[] findByNom_PrevAndNext(
			long id, String nom,
			OrderByComparator<Concessionnaire> orderByComparator)
		throws NoSuchConcessionnaireException {

		nom = Objects.toString(nom, "");

		Concessionnaire concessionnaire = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Concessionnaire[] array = new ConcessionnaireImpl[3];

			array[0] = getByNom_PrevAndNext(
				session, concessionnaire, nom, orderByComparator, true);

			array[1] = concessionnaire;

			array[2] = getByNom_PrevAndNext(
				session, concessionnaire, nom, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Concessionnaire getByNom_PrevAndNext(
		Session session, Concessionnaire concessionnaire, String nom,
		OrderByComparator<Concessionnaire> orderByComparator,
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

		sb.append(_SQL_SELECT_CONCESSIONNAIRE_WHERE);

		boolean bindNom = false;

		if (nom.isEmpty()) {
			sb.append(_FINDER_COLUMN_NOM_NOM_3);
		}
		else {
			bindNom = true;

			sb.append(_FINDER_COLUMN_NOM_NOM_2);
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
			sb.append(ConcessionnaireModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindNom) {
			queryPos.add(nom);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						concessionnaire)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Concessionnaire> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the concessionnaires where nom = &#63; from the database.
	 *
	 * @param nom the nom
	 */
	@Override
	public void removeByNom(String nom) {
		for (Concessionnaire concessionnaire :
				findByNom(nom, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(concessionnaire);
		}
	}

	/**
	 * Returns the number of concessionnaires where nom = &#63;.
	 *
	 * @param nom the nom
	 * @return the number of matching concessionnaires
	 */
	@Override
	public int countByNom(String nom) {
		nom = Objects.toString(nom, "");

		FinderPath finderPath = _finderPathCountByNom;

		Object[] finderArgs = new Object[] {nom};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONCESSIONNAIRE_WHERE);

			boolean bindNom = false;

			if (nom.isEmpty()) {
				sb.append(_FINDER_COLUMN_NOM_NOM_3);
			}
			else {
				bindNom = true;

				sb.append(_FINDER_COLUMN_NOM_NOM_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNom) {
					queryPos.add(nom);
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

	private static final String _FINDER_COLUMN_NOM_NOM_2 =
		"concessionnaire.nom = ?";

	private static final String _FINDER_COLUMN_NOM_NOM_3 =
		"(concessionnaire.nom IS NULL OR concessionnaire.nom = '')";

	public ConcessionnairePersistenceImpl() {
		setModelClass(Concessionnaire.class);

		setModelImplClass(ConcessionnaireImpl.class);
		setModelPKClass(long.class);

		setTable(ConcessionnaireTable.INSTANCE);
	}

	/**
	 * Caches the concessionnaire in the entity cache if it is enabled.
	 *
	 * @param concessionnaire the concessionnaire
	 */
	@Override
	public void cacheResult(Concessionnaire concessionnaire) {
		entityCache.putResult(
			ConcessionnaireImpl.class, concessionnaire.getPrimaryKey(),
			concessionnaire);

		finderCache.putResult(
			_finderPathFetchByUid, new Object[] {concessionnaire.getUid()},
			concessionnaire);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the concessionnaires in the entity cache if it is enabled.
	 *
	 * @param concessionnaires the concessionnaires
	 */
	@Override
	public void cacheResult(List<Concessionnaire> concessionnaires) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (concessionnaires.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Concessionnaire concessionnaire : concessionnaires) {
			if (entityCache.getResult(
					ConcessionnaireImpl.class,
					concessionnaire.getPrimaryKey()) == null) {

				cacheResult(concessionnaire);
			}
		}
	}

	/**
	 * Clears the cache for all concessionnaires.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConcessionnaireImpl.class);

		finderCache.clearCache(ConcessionnaireImpl.class);
	}

	/**
	 * Clears the cache for the concessionnaire.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Concessionnaire concessionnaire) {
		entityCache.removeResult(ConcessionnaireImpl.class, concessionnaire);
	}

	@Override
	public void clearCache(List<Concessionnaire> concessionnaires) {
		for (Concessionnaire concessionnaire : concessionnaires) {
			entityCache.removeResult(
				ConcessionnaireImpl.class, concessionnaire);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ConcessionnaireImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ConcessionnaireImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ConcessionnaireModelImpl concessionnaireModelImpl) {

		Object[] args = new Object[] {concessionnaireModelImpl.getUid()};

		finderCache.putResult(
			_finderPathFetchByUid, args, concessionnaireModelImpl);
	}

	/**
	 * Creates a new concessionnaire with the primary key. Does not add the concessionnaire to the database.
	 *
	 * @param id the primary key for the new concessionnaire
	 * @return the new concessionnaire
	 */
	@Override
	public Concessionnaire create(long id) {
		Concessionnaire concessionnaire = new ConcessionnaireImpl();

		concessionnaire.setNew(true);
		concessionnaire.setPrimaryKey(id);

		return concessionnaire;
	}

	/**
	 * Removes the concessionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire that was removed
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	@Override
	public Concessionnaire remove(long id)
		throws NoSuchConcessionnaireException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the concessionnaire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the concessionnaire
	 * @return the concessionnaire that was removed
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	@Override
	public Concessionnaire remove(Serializable primaryKey)
		throws NoSuchConcessionnaireException {

		Session session = null;

		try {
			session = openSession();

			Concessionnaire concessionnaire = (Concessionnaire)session.get(
				ConcessionnaireImpl.class, primaryKey);

			if (concessionnaire == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConcessionnaireException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(concessionnaire);
		}
		catch (NoSuchConcessionnaireException noSuchEntityException) {
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
	protected Concessionnaire removeImpl(Concessionnaire concessionnaire) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(concessionnaire)) {
				concessionnaire = (Concessionnaire)session.get(
					ConcessionnaireImpl.class,
					concessionnaire.getPrimaryKeyObj());
			}

			if (concessionnaire != null) {
				session.delete(concessionnaire);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (concessionnaire != null) {
			clearCache(concessionnaire);
		}

		return concessionnaire;
	}

	@Override
	public Concessionnaire updateImpl(Concessionnaire concessionnaire) {
		boolean isNew = concessionnaire.isNew();

		if (!(concessionnaire instanceof ConcessionnaireModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(concessionnaire.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					concessionnaire);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in concessionnaire proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Concessionnaire implementation " +
					concessionnaire.getClass());
		}

		ConcessionnaireModelImpl concessionnaireModelImpl =
			(ConcessionnaireModelImpl)concessionnaire;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(concessionnaire);
			}
			else {
				concessionnaire = (Concessionnaire)session.merge(
					concessionnaire);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ConcessionnaireImpl.class, concessionnaireModelImpl, false, true);

		cacheUniqueFindersCache(concessionnaireModelImpl);

		if (isNew) {
			concessionnaire.setNew(false);
		}

		concessionnaire.resetOriginalValues();

		return concessionnaire;
	}

	/**
	 * Returns the concessionnaire with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the concessionnaire
	 * @return the concessionnaire
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	@Override
	public Concessionnaire findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConcessionnaireException {

		Concessionnaire concessionnaire = fetchByPrimaryKey(primaryKey);

		if (concessionnaire == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConcessionnaireException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return concessionnaire;
	}

	/**
	 * Returns the concessionnaire with the primary key or throws a <code>NoSuchConcessionnaireException</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire
	 * @throws NoSuchConcessionnaireException if a concessionnaire with the primary key could not be found
	 */
	@Override
	public Concessionnaire findByPrimaryKey(long id)
		throws NoSuchConcessionnaireException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the concessionnaire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire
	 * @return the concessionnaire, or <code>null</code> if a concessionnaire with the primary key could not be found
	 */
	@Override
	public Concessionnaire fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the concessionnaires.
	 *
	 * @return the concessionnaires
	 */
	@Override
	public List<Concessionnaire> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the concessionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @return the range of concessionnaires
	 */
	@Override
	public List<Concessionnaire> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the concessionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of concessionnaires
	 */
	@Override
	public List<Concessionnaire> findAll(
		int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the concessionnaires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaires
	 * @param end the upper bound of the range of concessionnaires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of concessionnaires
	 */
	@Override
	public List<Concessionnaire> findAll(
		int start, int end,
		OrderByComparator<Concessionnaire> orderByComparator,
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

		List<Concessionnaire> list = null;

		if (useFinderCache) {
			list = (List<Concessionnaire>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONCESSIONNAIRE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONCESSIONNAIRE;

				sql = sql.concat(ConcessionnaireModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Concessionnaire>)QueryUtil.list(
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
	 * Removes all the concessionnaires from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Concessionnaire concessionnaire : findAll()) {
			remove(concessionnaire);
		}
	}

	/**
	 * Returns the number of concessionnaires.
	 *
	 * @return the number of concessionnaires
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CONCESSIONNAIRE);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONCESSIONNAIRE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConcessionnaireModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the concessionnaire persistence.
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

		_finderPathFetchByUid = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUid",
			new String[] {String.class.getName()}, new String[] {"uid"}, true);

		_finderPathWithPaginationFindByNom = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNom",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"nom"}, true);

		_finderPathWithoutPaginationFindByNom = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNom",
			new String[] {String.class.getName()}, new String[] {"nom"}, true);

		_finderPathCountByNom = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNom",
			new String[] {String.class.getName()}, new String[] {"nom"}, false);

		ConcessionnaireUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ConcessionnaireUtil.setPersistence(null);

		entityCache.removeCache(ConcessionnaireImpl.class.getName());
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

	private static final String _SQL_SELECT_CONCESSIONNAIRE =
		"SELECT concessionnaire FROM Concessionnaire concessionnaire";

	private static final String _SQL_SELECT_CONCESSIONNAIRE_WHERE =
		"SELECT concessionnaire FROM Concessionnaire concessionnaire WHERE ";

	private static final String _SQL_COUNT_CONCESSIONNAIRE =
		"SELECT COUNT(concessionnaire) FROM Concessionnaire concessionnaire";

	private static final String _SQL_COUNT_CONCESSIONNAIRE_WHERE =
		"SELECT COUNT(concessionnaire) FROM Concessionnaire concessionnaire WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "concessionnaire.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Concessionnaire exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Concessionnaire exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConcessionnairePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}