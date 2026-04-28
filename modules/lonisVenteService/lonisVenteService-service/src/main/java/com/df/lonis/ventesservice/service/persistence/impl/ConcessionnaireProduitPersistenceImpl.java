/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchConcessionnaireProduitException;
import com.df.lonis.ventesservice.model.ConcessionnaireProduit;
import com.df.lonis.ventesservice.model.ConcessionnaireProduitTable;
import com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitImpl;
import com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitModelImpl;
import com.df.lonis.ventesservice.service.persistence.ConcessionnaireProduitPersistence;
import com.df.lonis.ventesservice.service.persistence.ConcessionnaireProduitUtil;
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
 * The persistence implementation for the concessionnaire produit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ConcessionnaireProduitPersistence.class)
public class ConcessionnaireProduitPersistenceImpl
	extends BasePersistenceImpl<ConcessionnaireProduit>
	implements ConcessionnaireProduitPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConcessionnaireProduitUtil</code> to access the concessionnaire produit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConcessionnaireProduitImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByConcessionnaireId;
	private FinderPath _finderPathWithoutPaginationFindByConcessionnaireId;
	private FinderPath _finderPathCountByConcessionnaireId;

	/**
	 * Returns all the concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the matching concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId) {

		return findByConcessionnaireId(
			concessionnaireId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @return the range of matching concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end) {

		return findByConcessionnaireId(concessionnaireId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return findByConcessionnaireId(
			concessionnaireId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByConcessionnaireId;
				finderArgs = new Object[] {concessionnaireId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByConcessionnaireId;
			finderArgs = new Object[] {
				concessionnaireId, start, end, orderByComparator
			};
		}

		List<ConcessionnaireProduit> list = null;

		if (useFinderCache) {
			list = (List<ConcessionnaireProduit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConcessionnaireProduit concessionnaireProduit : list) {
					if (concessionnaireId !=
							concessionnaireProduit.getConcessionnaireId()) {

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

			sb.append(_SQL_SELECT_CONCESSIONNAIREPRODUIT_WHERE);

			sb.append(_FINDER_COLUMN_CONCESSIONNAIREID_CONCESSIONNAIREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConcessionnaireProduitModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(concessionnaireId);

				list = (List<ConcessionnaireProduit>)QueryUtil.list(
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
	 * Returns the first concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit findByConcessionnaireId_First(
			long concessionnaireId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit =
			fetchByConcessionnaireId_First(
				concessionnaireId, orderByComparator);

		if (concessionnaireProduit != null) {
			return concessionnaireProduit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("concessionnaireId=");
		sb.append(concessionnaireId);

		sb.append("}");

		throw new NoSuchConcessionnaireProduitException(sb.toString());
	}

	/**
	 * Returns the first concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit fetchByConcessionnaireId_First(
		long concessionnaireId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		List<ConcessionnaireProduit> list = findByConcessionnaireId(
			concessionnaireId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit findByConcessionnaireId_Last(
			long concessionnaireId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit =
			fetchByConcessionnaireId_Last(concessionnaireId, orderByComparator);

		if (concessionnaireProduit != null) {
			return concessionnaireProduit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("concessionnaireId=");
		sb.append(concessionnaireId);

		sb.append("}");

		throw new NoSuchConcessionnaireProduitException(sb.toString());
	}

	/**
	 * Returns the last concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit fetchByConcessionnaireId_Last(
		long concessionnaireId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		int count = countByConcessionnaireId(concessionnaireId);

		if (count == 0) {
			return null;
		}

		List<ConcessionnaireProduit> list = findByConcessionnaireId(
			concessionnaireId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the concessionnaire produits before and after the current concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param id the primary key of the current concessionnaire produit
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public ConcessionnaireProduit[] findByConcessionnaireId_PrevAndNext(
			long id, long concessionnaireId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ConcessionnaireProduit[] array = new ConcessionnaireProduitImpl[3];

			array[0] = getByConcessionnaireId_PrevAndNext(
				session, concessionnaireProduit, concessionnaireId,
				orderByComparator, true);

			array[1] = concessionnaireProduit;

			array[2] = getByConcessionnaireId_PrevAndNext(
				session, concessionnaireProduit, concessionnaireId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConcessionnaireProduit getByConcessionnaireId_PrevAndNext(
		Session session, ConcessionnaireProduit concessionnaireProduit,
		long concessionnaireId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator,
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

		sb.append(_SQL_SELECT_CONCESSIONNAIREPRODUIT_WHERE);

		sb.append(_FINDER_COLUMN_CONCESSIONNAIREID_CONCESSIONNAIREID_2);

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
			sb.append(ConcessionnaireProduitModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(concessionnaireId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						concessionnaireProduit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConcessionnaireProduit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the concessionnaire produits where concessionnaireId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 */
	@Override
	public void removeByConcessionnaireId(long concessionnaireId) {
		for (ConcessionnaireProduit concessionnaireProduit :
				findByConcessionnaireId(
					concessionnaireId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(concessionnaireProduit);
		}
	}

	/**
	 * Returns the number of concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the number of matching concessionnaire produits
	 */
	@Override
	public int countByConcessionnaireId(long concessionnaireId) {
		FinderPath finderPath = _finderPathCountByConcessionnaireId;

		Object[] finderArgs = new Object[] {concessionnaireId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONCESSIONNAIREPRODUIT_WHERE);

			sb.append(_FINDER_COLUMN_CONCESSIONNAIREID_CONCESSIONNAIREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(concessionnaireId);

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

	private static final String
		_FINDER_COLUMN_CONCESSIONNAIREID_CONCESSIONNAIREID_2 =
			"concessionnaireProduit.concessionnaireId = ?";

	private FinderPath _finderPathWithPaginationFindByProduitId;
	private FinderPath _finderPathWithoutPaginationFindByProduitId;
	private FinderPath _finderPathCountByProduitId;

	/**
	 * Returns all the concessionnaire produits where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findByProduitId(long produitId) {
		return findByProduitId(
			produitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the concessionnaire produits where produitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param produitId the produit ID
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @return the range of matching concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end) {

		return findByProduitId(produitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the concessionnaire produits where produitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param produitId the produit ID
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return findByProduitId(produitId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the concessionnaire produits where produitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param produitId the produit ID
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProduitId;
				finderArgs = new Object[] {produitId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProduitId;
			finderArgs = new Object[] {
				produitId, start, end, orderByComparator
			};
		}

		List<ConcessionnaireProduit> list = null;

		if (useFinderCache) {
			list = (List<ConcessionnaireProduit>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConcessionnaireProduit concessionnaireProduit : list) {
					if (produitId != concessionnaireProduit.getProduitId()) {
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

			sb.append(_SQL_SELECT_CONCESSIONNAIREPRODUIT_WHERE);

			sb.append(_FINDER_COLUMN_PRODUITID_PRODUITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConcessionnaireProduitModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(produitId);

				list = (List<ConcessionnaireProduit>)QueryUtil.list(
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
	 * Returns the first concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit findByProduitId_First(
			long produitId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit = fetchByProduitId_First(
			produitId, orderByComparator);

		if (concessionnaireProduit != null) {
			return concessionnaireProduit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("produitId=");
		sb.append(produitId);

		sb.append("}");

		throw new NoSuchConcessionnaireProduitException(sb.toString());
	}

	/**
	 * Returns the first concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit fetchByProduitId_First(
		long produitId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		List<ConcessionnaireProduit> list = findByProduitId(
			produitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit findByProduitId_Last(
			long produitId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit = fetchByProduitId_Last(
			produitId, orderByComparator);

		if (concessionnaireProduit != null) {
			return concessionnaireProduit;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("produitId=");
		sb.append(produitId);

		sb.append("}");

		throw new NoSuchConcessionnaireProduitException(sb.toString());
	}

	/**
	 * Returns the last concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit fetchByProduitId_Last(
		long produitId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		int count = countByProduitId(produitId);

		if (count == 0) {
			return null;
		}

		List<ConcessionnaireProduit> list = findByProduitId(
			produitId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the concessionnaire produits before and after the current concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param id the primary key of the current concessionnaire produit
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public ConcessionnaireProduit[] findByProduitId_PrevAndNext(
			long id, long produitId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ConcessionnaireProduit[] array = new ConcessionnaireProduitImpl[3];

			array[0] = getByProduitId_PrevAndNext(
				session, concessionnaireProduit, produitId, orderByComparator,
				true);

			array[1] = concessionnaireProduit;

			array[2] = getByProduitId_PrevAndNext(
				session, concessionnaireProduit, produitId, orderByComparator,
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

	protected ConcessionnaireProduit getByProduitId_PrevAndNext(
		Session session, ConcessionnaireProduit concessionnaireProduit,
		long produitId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator,
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

		sb.append(_SQL_SELECT_CONCESSIONNAIREPRODUIT_WHERE);

		sb.append(_FINDER_COLUMN_PRODUITID_PRODUITID_2);

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
			sb.append(ConcessionnaireProduitModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(produitId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						concessionnaireProduit)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConcessionnaireProduit> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the concessionnaire produits where produitId = &#63; from the database.
	 *
	 * @param produitId the produit ID
	 */
	@Override
	public void removeByProduitId(long produitId) {
		for (ConcessionnaireProduit concessionnaireProduit :
				findByProduitId(
					produitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(concessionnaireProduit);
		}
	}

	/**
	 * Returns the number of concessionnaire produits where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @return the number of matching concessionnaire produits
	 */
	@Override
	public int countByProduitId(long produitId) {
		FinderPath finderPath = _finderPathCountByProduitId;

		Object[] finderArgs = new Object[] {produitId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONCESSIONNAIREPRODUIT_WHERE);

			sb.append(_FINDER_COLUMN_PRODUITID_PRODUITID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(produitId);

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

	private static final String _FINDER_COLUMN_PRODUITID_PRODUITID_2 =
		"concessionnaireProduit.produitId = ?";

	private FinderPath _finderPathFetchByC_P;

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or throws a <code>NoSuchConcessionnaireProduitException</code> if it could not be found.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit findByC_P(
			long concessionnaireId, long produitId)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit = fetchByC_P(
			concessionnaireId, produitId);

		if (concessionnaireProduit == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("concessionnaireId=");
			sb.append(concessionnaireId);

			sb.append(", produitId=");
			sb.append(produitId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchConcessionnaireProduitException(sb.toString());
		}

		return concessionnaireProduit;
	}

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit fetchByC_P(
		long concessionnaireId, long produitId) {

		return fetchByC_P(concessionnaireId, produitId, true);
	}

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	@Override
	public ConcessionnaireProduit fetchByC_P(
		long concessionnaireId, long produitId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {concessionnaireId, produitId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_P, finderArgs, this);
		}

		if (result instanceof ConcessionnaireProduit) {
			ConcessionnaireProduit concessionnaireProduit =
				(ConcessionnaireProduit)result;

			if ((concessionnaireId !=
					concessionnaireProduit.getConcessionnaireId()) ||
				(produitId != concessionnaireProduit.getProduitId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CONCESSIONNAIREPRODUIT_WHERE);

			sb.append(_FINDER_COLUMN_C_P_CONCESSIONNAIREID_2);

			sb.append(_FINDER_COLUMN_C_P_PRODUITID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(concessionnaireId);

				queryPos.add(produitId);

				List<ConcessionnaireProduit> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_P, finderArgs, list);
					}
				}
				else {
					ConcessionnaireProduit concessionnaireProduit = list.get(0);

					result = concessionnaireProduit;

					cacheResult(concessionnaireProduit);
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
			return (ConcessionnaireProduit)result;
		}
	}

	/**
	 * Removes the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the concessionnaire produit that was removed
	 */
	@Override
	public ConcessionnaireProduit removeByC_P(
			long concessionnaireId, long produitId)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit = findByC_P(
			concessionnaireId, produitId);

		return remove(concessionnaireProduit);
	}

	/**
	 * Returns the number of concessionnaire produits where concessionnaireId = &#63; and produitId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the number of matching concessionnaire produits
	 */
	@Override
	public int countByC_P(long concessionnaireId, long produitId) {
		ConcessionnaireProduit concessionnaireProduit = fetchByC_P(
			concessionnaireId, produitId);

		if (concessionnaireProduit == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_C_P_CONCESSIONNAIREID_2 =
		"concessionnaireProduit.concessionnaireId = ? AND ";

	private static final String _FINDER_COLUMN_C_P_PRODUITID_2 =
		"concessionnaireProduit.produitId = ?";

	public ConcessionnaireProduitPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("concessionnaireId", "concessionnaire_id");
		dbColumnNames.put("produitId", "produit_id");
		dbColumnNames.put("siteId", "site_id");
		dbColumnNames.put("concessionnaireCode", "concessionnaire_code");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(ConcessionnaireProduit.class);

		setModelImplClass(ConcessionnaireProduitImpl.class);
		setModelPKClass(long.class);

		setTable(ConcessionnaireProduitTable.INSTANCE);
	}

	/**
	 * Caches the concessionnaire produit in the entity cache if it is enabled.
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 */
	@Override
	public void cacheResult(ConcessionnaireProduit concessionnaireProduit) {
		entityCache.putResult(
			ConcessionnaireProduitImpl.class,
			concessionnaireProduit.getPrimaryKey(), concessionnaireProduit);

		finderCache.putResult(
			_finderPathFetchByC_P,
			new Object[] {
				concessionnaireProduit.getConcessionnaireId(),
				concessionnaireProduit.getProduitId()
			},
			concessionnaireProduit);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the concessionnaire produits in the entity cache if it is enabled.
	 *
	 * @param concessionnaireProduits the concessionnaire produits
	 */
	@Override
	public void cacheResult(
		List<ConcessionnaireProduit> concessionnaireProduits) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (concessionnaireProduits.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ConcessionnaireProduit concessionnaireProduit :
				concessionnaireProduits) {

			if (entityCache.getResult(
					ConcessionnaireProduitImpl.class,
					concessionnaireProduit.getPrimaryKey()) == null) {

				cacheResult(concessionnaireProduit);
			}
		}
	}

	/**
	 * Clears the cache for all concessionnaire produits.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConcessionnaireProduitImpl.class);

		finderCache.clearCache(ConcessionnaireProduitImpl.class);
	}

	/**
	 * Clears the cache for the concessionnaire produit.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConcessionnaireProduit concessionnaireProduit) {
		entityCache.removeResult(
			ConcessionnaireProduitImpl.class, concessionnaireProduit);
	}

	@Override
	public void clearCache(
		List<ConcessionnaireProduit> concessionnaireProduits) {

		for (ConcessionnaireProduit concessionnaireProduit :
				concessionnaireProduits) {

			entityCache.removeResult(
				ConcessionnaireProduitImpl.class, concessionnaireProduit);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ConcessionnaireProduitImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ConcessionnaireProduitImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ConcessionnaireProduitModelImpl concessionnaireProduitModelImpl) {

		Object[] args = new Object[] {
			concessionnaireProduitModelImpl.getConcessionnaireId(),
			concessionnaireProduitModelImpl.getProduitId()
		};

		finderCache.putResult(
			_finderPathFetchByC_P, args, concessionnaireProduitModelImpl);
	}

	/**
	 * Creates a new concessionnaire produit with the primary key. Does not add the concessionnaire produit to the database.
	 *
	 * @param id the primary key for the new concessionnaire produit
	 * @return the new concessionnaire produit
	 */
	@Override
	public ConcessionnaireProduit create(long id) {
		ConcessionnaireProduit concessionnaireProduit =
			new ConcessionnaireProduitImpl();

		concessionnaireProduit.setNew(true);
		concessionnaireProduit.setPrimaryKey(id);

		return concessionnaireProduit;
	}

	/**
	 * Removes the concessionnaire produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit that was removed
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public ConcessionnaireProduit remove(long id)
		throws NoSuchConcessionnaireProduitException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the concessionnaire produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the concessionnaire produit
	 * @return the concessionnaire produit that was removed
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public ConcessionnaireProduit remove(Serializable primaryKey)
		throws NoSuchConcessionnaireProduitException {

		Session session = null;

		try {
			session = openSession();

			ConcessionnaireProduit concessionnaireProduit =
				(ConcessionnaireProduit)session.get(
					ConcessionnaireProduitImpl.class, primaryKey);

			if (concessionnaireProduit == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConcessionnaireProduitException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(concessionnaireProduit);
		}
		catch (NoSuchConcessionnaireProduitException noSuchEntityException) {
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
	protected ConcessionnaireProduit removeImpl(
		ConcessionnaireProduit concessionnaireProduit) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(concessionnaireProduit)) {
				concessionnaireProduit = (ConcessionnaireProduit)session.get(
					ConcessionnaireProduitImpl.class,
					concessionnaireProduit.getPrimaryKeyObj());
			}

			if (concessionnaireProduit != null) {
				session.delete(concessionnaireProduit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (concessionnaireProduit != null) {
			clearCache(concessionnaireProduit);
		}

		return concessionnaireProduit;
	}

	@Override
	public ConcessionnaireProduit updateImpl(
		ConcessionnaireProduit concessionnaireProduit) {

		boolean isNew = concessionnaireProduit.isNew();

		if (!(concessionnaireProduit instanceof
				ConcessionnaireProduitModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(concessionnaireProduit.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					concessionnaireProduit);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in concessionnaireProduit proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ConcessionnaireProduit implementation " +
					concessionnaireProduit.getClass());
		}

		ConcessionnaireProduitModelImpl concessionnaireProduitModelImpl =
			(ConcessionnaireProduitModelImpl)concessionnaireProduit;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(concessionnaireProduit);
			}
			else {
				concessionnaireProduit = (ConcessionnaireProduit)session.merge(
					concessionnaireProduit);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ConcessionnaireProduitImpl.class, concessionnaireProduitModelImpl,
			false, true);

		cacheUniqueFindersCache(concessionnaireProduitModelImpl);

		if (isNew) {
			concessionnaireProduit.setNew(false);
		}

		concessionnaireProduit.resetOriginalValues();

		return concessionnaireProduit;
	}

	/**
	 * Returns the concessionnaire produit with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the concessionnaire produit
	 * @return the concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public ConcessionnaireProduit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConcessionnaireProduitException {

		ConcessionnaireProduit concessionnaireProduit = fetchByPrimaryKey(
			primaryKey);

		if (concessionnaireProduit == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConcessionnaireProduitException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return concessionnaireProduit;
	}

	/**
	 * Returns the concessionnaire produit with the primary key or throws a <code>NoSuchConcessionnaireProduitException</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public ConcessionnaireProduit findByPrimaryKey(long id)
		throws NoSuchConcessionnaireProduitException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the concessionnaire produit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit, or <code>null</code> if a concessionnaire produit with the primary key could not be found
	 */
	@Override
	public ConcessionnaireProduit fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the concessionnaire produits.
	 *
	 * @return the concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the concessionnaire produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @return the range of concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the concessionnaire produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findAll(
		int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the concessionnaire produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of concessionnaire produits
	 */
	@Override
	public List<ConcessionnaireProduit> findAll(
		int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator,
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

		List<ConcessionnaireProduit> list = null;

		if (useFinderCache) {
			list = (List<ConcessionnaireProduit>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONCESSIONNAIREPRODUIT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONCESSIONNAIREPRODUIT;

				sql = sql.concat(ConcessionnaireProduitModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ConcessionnaireProduit>)QueryUtil.list(
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
	 * Removes all the concessionnaire produits from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ConcessionnaireProduit concessionnaireProduit : findAll()) {
			remove(concessionnaireProduit);
		}
	}

	/**
	 * Returns the number of concessionnaire produits.
	 *
	 * @return the number of concessionnaire produits
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CONCESSIONNAIREPRODUIT);

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
		return _SQL_SELECT_CONCESSIONNAIREPRODUIT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConcessionnaireProduitModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the concessionnaire produit persistence.
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

		_finderPathWithPaginationFindByConcessionnaireId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConcessionnaireId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"concessionnaire_id"}, true);

		_finderPathWithoutPaginationFindByConcessionnaireId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByConcessionnaireId", new String[] {Long.class.getName()},
			new String[] {"concessionnaire_id"}, true);

		_finderPathCountByConcessionnaireId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByConcessionnaireId", new String[] {Long.class.getName()},
			new String[] {"concessionnaire_id"}, false);

		_finderPathWithPaginationFindByProduitId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProduitId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"produit_id"}, true);

		_finderPathWithoutPaginationFindByProduitId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProduitId",
			new String[] {Long.class.getName()}, new String[] {"produit_id"},
			true);

		_finderPathCountByProduitId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProduitId",
			new String[] {Long.class.getName()}, new String[] {"produit_id"},
			false);

		_finderPathFetchByC_P = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_P",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"concessionnaire_id", "produit_id"}, true);

		ConcessionnaireProduitUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ConcessionnaireProduitUtil.setPersistence(null);

		entityCache.removeCache(ConcessionnaireProduitImpl.class.getName());
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

	private static final String _SQL_SELECT_CONCESSIONNAIREPRODUIT =
		"SELECT concessionnaireProduit FROM ConcessionnaireProduit concessionnaireProduit";

	private static final String _SQL_SELECT_CONCESSIONNAIREPRODUIT_WHERE =
		"SELECT concessionnaireProduit FROM ConcessionnaireProduit concessionnaireProduit WHERE ";

	private static final String _SQL_COUNT_CONCESSIONNAIREPRODUIT =
		"SELECT COUNT(concessionnaireProduit) FROM ConcessionnaireProduit concessionnaireProduit";

	private static final String _SQL_COUNT_CONCESSIONNAIREPRODUIT_WHERE =
		"SELECT COUNT(concessionnaireProduit) FROM ConcessionnaireProduit concessionnaireProduit WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"concessionnaireProduit.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ConcessionnaireProduit exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ConcessionnaireProduit exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConcessionnaireProduitPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"concessionnaireId", "produitId", "siteId", "concessionnaireCode",
			"createdAt", "updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}