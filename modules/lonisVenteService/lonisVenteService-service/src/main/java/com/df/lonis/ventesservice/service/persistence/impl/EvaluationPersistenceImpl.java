/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.exception.NoSuchEvaluationException;
import com.df.lonis.ventesservice.model.Evaluation;
import com.df.lonis.ventesservice.model.EvaluationTable;
import com.df.lonis.ventesservice.model.impl.EvaluationImpl;
import com.df.lonis.ventesservice.model.impl.EvaluationModelImpl;
import com.df.lonis.ventesservice.service.persistence.EvaluationPersistence;
import com.df.lonis.ventesservice.service.persistence.EvaluationUtil;
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
 * The persistence implementation for the evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EvaluationPersistence.class)
public class EvaluationPersistenceImpl
	extends BasePersistenceImpl<Evaluation> implements EvaluationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EvaluationUtil</code> to access the evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EvaluationImpl.class.getName();

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
	 * Returns all the evaluations where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching evaluations
	 */
	@Override
	public List<Evaluation> findByCommercialId(long commercialId) {
		return findByCommercialId(
			commercialId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluations where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @return the range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByCommercialId(
		long commercialId, int start, int end) {

		return findByCommercialId(commercialId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluations where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {

		return findByCommercialId(
			commercialId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the evaluations where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Evaluation> orderByComparator,
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

		List<Evaluation> list = null;

		if (useFinderCache) {
			list = (List<Evaluation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Evaluation evaluation : list) {
					if (commercialId != evaluation.getCommercialId()) {
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

			sb.append(_SQL_SELECT_EVALUATION_WHERE);

			sb.append(_FINDER_COLUMN_COMMERCIALID_COMMERCIALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EvaluationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				list = (List<Evaluation>)QueryUtil.list(
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
	 * Returns the first evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	@Override
	public Evaluation findByCommercialId_First(
			long commercialId, OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = fetchByCommercialId_First(
			commercialId, orderByComparator);

		if (evaluation != null) {
			return evaluation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append("}");

		throw new NoSuchEvaluationException(sb.toString());
	}

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	@Override
	public Evaluation fetchByCommercialId_First(
		long commercialId, OrderByComparator<Evaluation> orderByComparator) {

		List<Evaluation> list = findByCommercialId(
			commercialId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	@Override
	public Evaluation findByCommercialId_Last(
			long commercialId, OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = fetchByCommercialId_Last(
			commercialId, orderByComparator);

		if (evaluation != null) {
			return evaluation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append("}");

		throw new NoSuchEvaluationException(sb.toString());
	}

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	@Override
	public Evaluation fetchByCommercialId_Last(
		long commercialId, OrderByComparator<Evaluation> orderByComparator) {

		int count = countByCommercialId(commercialId);

		if (count == 0) {
			return null;
		}

		List<Evaluation> list = findByCommercialId(
			commercialId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evaluations before and after the current evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current evaluation
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Evaluation[] array = new EvaluationImpl[3];

			array[0] = getByCommercialId_PrevAndNext(
				session, evaluation, commercialId, orderByComparator, true);

			array[1] = evaluation;

			array[2] = getByCommercialId_PrevAndNext(
				session, evaluation, commercialId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Evaluation getByCommercialId_PrevAndNext(
		Session session, Evaluation evaluation, long commercialId,
		OrderByComparator<Evaluation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVALUATION_WHERE);

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
			sb.append(EvaluationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commercialId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(evaluation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Evaluation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evaluations where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	@Override
	public void removeByCommercialId(long commercialId) {
		for (Evaluation evaluation :
				findByCommercialId(
					commercialId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(evaluation);
		}
	}

	/**
	 * Returns the number of evaluations where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching evaluations
	 */
	@Override
	public int countByCommercialId(long commercialId) {
		FinderPath finderPath = _finderPathCountByCommercialId;

		Object[] finderArgs = new Object[] {commercialId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVALUATION_WHERE);

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
		"evaluation.commercialId = ?";

	private FinderPath _finderPathWithPaginationFindByAnnee;
	private FinderPath _finderPathWithoutPaginationFindByAnnee;
	private FinderPath _finderPathCountByAnnee;

	/**
	 * Returns all the evaluations where annee = &#63;.
	 *
	 * @param annee the annee
	 * @return the matching evaluations
	 */
	@Override
	public List<Evaluation> findByAnnee(int annee) {
		return findByAnnee(annee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluations where annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param annee the annee
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @return the range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByAnnee(int annee, int start, int end) {
		return findByAnnee(annee, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluations where annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param annee the annee
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByAnnee(
		int annee, int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {

		return findByAnnee(annee, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the evaluations where annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param annee the annee
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByAnnee(
		int annee, int start, int end,
		OrderByComparator<Evaluation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAnnee;
				finderArgs = new Object[] {annee};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAnnee;
			finderArgs = new Object[] {annee, start, end, orderByComparator};
		}

		List<Evaluation> list = null;

		if (useFinderCache) {
			list = (List<Evaluation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Evaluation evaluation : list) {
					if (annee != evaluation.getAnnee()) {
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

			sb.append(_SQL_SELECT_EVALUATION_WHERE);

			sb.append(_FINDER_COLUMN_ANNEE_ANNEE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EvaluationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(annee);

				list = (List<Evaluation>)QueryUtil.list(
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
	 * Returns the first evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	@Override
	public Evaluation findByAnnee_First(
			int annee, OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = fetchByAnnee_First(annee, orderByComparator);

		if (evaluation != null) {
			return evaluation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("annee=");
		sb.append(annee);

		sb.append("}");

		throw new NoSuchEvaluationException(sb.toString());
	}

	/**
	 * Returns the first evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	@Override
	public Evaluation fetchByAnnee_First(
		int annee, OrderByComparator<Evaluation> orderByComparator) {

		List<Evaluation> list = findByAnnee(annee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	@Override
	public Evaluation findByAnnee_Last(
			int annee, OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = fetchByAnnee_Last(annee, orderByComparator);

		if (evaluation != null) {
			return evaluation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("annee=");
		sb.append(annee);

		sb.append("}");

		throw new NoSuchEvaluationException(sb.toString());
	}

	/**
	 * Returns the last evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	@Override
	public Evaluation fetchByAnnee_Last(
		int annee, OrderByComparator<Evaluation> orderByComparator) {

		int count = countByAnnee(annee);

		if (count == 0) {
			return null;
		}

		List<Evaluation> list = findByAnnee(
			annee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evaluations before and after the current evaluation in the ordered set where annee = &#63;.
	 *
	 * @param id the primary key of the current evaluation
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation[] findByAnnee_PrevAndNext(
			long id, int annee, OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Evaluation[] array = new EvaluationImpl[3];

			array[0] = getByAnnee_PrevAndNext(
				session, evaluation, annee, orderByComparator, true);

			array[1] = evaluation;

			array[2] = getByAnnee_PrevAndNext(
				session, evaluation, annee, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Evaluation getByAnnee_PrevAndNext(
		Session session, Evaluation evaluation, int annee,
		OrderByComparator<Evaluation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVALUATION_WHERE);

		sb.append(_FINDER_COLUMN_ANNEE_ANNEE_2);

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
			sb.append(EvaluationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(annee);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(evaluation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Evaluation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evaluations where annee = &#63; from the database.
	 *
	 * @param annee the annee
	 */
	@Override
	public void removeByAnnee(int annee) {
		for (Evaluation evaluation :
				findByAnnee(
					annee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(evaluation);
		}
	}

	/**
	 * Returns the number of evaluations where annee = &#63;.
	 *
	 * @param annee the annee
	 * @return the number of matching evaluations
	 */
	@Override
	public int countByAnnee(int annee) {
		FinderPath finderPath = _finderPathCountByAnnee;

		Object[] finderArgs = new Object[] {annee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVALUATION_WHERE);

			sb.append(_FINDER_COLUMN_ANNEE_ANNEE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_ANNEE_ANNEE_2 =
		"evaluation.annee = ?";

	private FinderPath _finderPathWithPaginationFindByC_A;
	private FinderPath _finderPathWithoutPaginationFindByC_A;
	private FinderPath _finderPathCountByC_A;

	/**
	 * Returns all the evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the matching evaluations
	 */
	@Override
	public List<Evaluation> findByC_A(long commercialId, int annee) {
		return findByC_A(
			commercialId, annee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @return the range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end) {

		return findByC_A(commercialId, annee, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {

		return findByC_A(
			commercialId, annee, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching evaluations
	 */
	@Override
	public List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end,
		OrderByComparator<Evaluation> orderByComparator,
		boolean useFinderCache) {

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

		List<Evaluation> list = null;

		if (useFinderCache) {
			list = (List<Evaluation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Evaluation evaluation : list) {
					if ((commercialId != evaluation.getCommercialId()) ||
						(annee != evaluation.getAnnee())) {

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

			sb.append(_SQL_SELECT_EVALUATION_WHERE);

			sb.append(_FINDER_COLUMN_C_A_COMMERCIALID_2);

			sb.append(_FINDER_COLUMN_C_A_ANNEE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EvaluationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				queryPos.add(annee);

				list = (List<Evaluation>)QueryUtil.list(
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
	 * Returns the first evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	@Override
	public Evaluation findByC_A_First(
			long commercialId, int annee,
			OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = fetchByC_A_First(
			commercialId, annee, orderByComparator);

		if (evaluation != null) {
			return evaluation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append(", annee=");
		sb.append(annee);

		sb.append("}");

		throw new NoSuchEvaluationException(sb.toString());
	}

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	@Override
	public Evaluation fetchByC_A_First(
		long commercialId, int annee,
		OrderByComparator<Evaluation> orderByComparator) {

		List<Evaluation> list = findByC_A(
			commercialId, annee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	@Override
	public Evaluation findByC_A_Last(
			long commercialId, int annee,
			OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = fetchByC_A_Last(
			commercialId, annee, orderByComparator);

		if (evaluation != null) {
			return evaluation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commercialId=");
		sb.append(commercialId);

		sb.append(", annee=");
		sb.append(annee);

		sb.append("}");

		throw new NoSuchEvaluationException(sb.toString());
	}

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	@Override
	public Evaluation fetchByC_A_Last(
		long commercialId, int annee,
		OrderByComparator<Evaluation> orderByComparator) {

		int count = countByC_A(commercialId, annee);

		if (count == 0) {
			return null;
		}

		List<Evaluation> list = findByC_A(
			commercialId, annee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evaluations before and after the current evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param id the primary key of the current evaluation
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation[] findByC_A_PrevAndNext(
			long id, long commercialId, int annee,
			OrderByComparator<Evaluation> orderByComparator)
		throws NoSuchEvaluationException {

		Evaluation evaluation = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Evaluation[] array = new EvaluationImpl[3];

			array[0] = getByC_A_PrevAndNext(
				session, evaluation, commercialId, annee, orderByComparator,
				true);

			array[1] = evaluation;

			array[2] = getByC_A_PrevAndNext(
				session, evaluation, commercialId, annee, orderByComparator,
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

	protected Evaluation getByC_A_PrevAndNext(
		Session session, Evaluation evaluation, long commercialId, int annee,
		OrderByComparator<Evaluation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EVALUATION_WHERE);

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
			sb.append(EvaluationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(evaluation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Evaluation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evaluations where commercialId = &#63; and annee = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 */
	@Override
	public void removeByC_A(long commercialId, int annee) {
		for (Evaluation evaluation :
				findByC_A(
					commercialId, annee, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(evaluation);
		}
	}

	/**
	 * Returns the number of evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the number of matching evaluations
	 */
	@Override
	public int countByC_A(long commercialId, int annee) {
		FinderPath finderPath = _finderPathCountByC_A;

		Object[] finderArgs = new Object[] {commercialId, annee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EVALUATION_WHERE);

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
		"evaluation.commercialId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_ANNEE_2 =
		"evaluation.annee = ?";

	private FinderPath _finderPathFetchByC_A_M_P;

	/**
	 * Returns the evaluation where commercialId = &#63; and annee = &#63; and mois = &#63; and periode = &#63; or throws a <code>NoSuchEvaluationException</code> if it could not be found.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param periode the periode
	 * @return the matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	@Override
	public Evaluation findByC_A_M_P(
			long commercialId, int annee, int mois, String periode)
		throws NoSuchEvaluationException {

		Evaluation evaluation = fetchByC_A_M_P(
			commercialId, annee, mois, periode);

		if (evaluation == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("commercialId=");
			sb.append(commercialId);

			sb.append(", annee=");
			sb.append(annee);

			sb.append(", mois=");
			sb.append(mois);

			sb.append(", periode=");
			sb.append(periode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchEvaluationException(sb.toString());
		}

		return evaluation;
	}

	/**
	 * Returns the evaluation where commercialId = &#63; and annee = &#63; and mois = &#63; and periode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param periode the periode
	 * @return the matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	@Override
	public Evaluation fetchByC_A_M_P(
		long commercialId, int annee, int mois, String periode) {

		return fetchByC_A_M_P(commercialId, annee, mois, periode, true);
	}

	/**
	 * Returns the evaluation where commercialId = &#63; and annee = &#63; and mois = &#63; and periode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param periode the periode
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	@Override
	public Evaluation fetchByC_A_M_P(
		long commercialId, int annee, int mois, String periode,
		boolean useFinderCache) {

		periode = Objects.toString(periode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {commercialId, annee, mois, periode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_A_M_P, finderArgs, this);
		}

		if (result instanceof Evaluation) {
			Evaluation evaluation = (Evaluation)result;

			if ((commercialId != evaluation.getCommercialId()) ||
				(annee != evaluation.getAnnee()) ||
				(mois != evaluation.getMois()) ||
				!Objects.equals(periode, evaluation.getPeriode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_EVALUATION_WHERE);

			sb.append(_FINDER_COLUMN_C_A_M_P_COMMERCIALID_2);

			sb.append(_FINDER_COLUMN_C_A_M_P_ANNEE_2);

			sb.append(_FINDER_COLUMN_C_A_M_P_MOIS_2);

			boolean bindPeriode = false;

			if (periode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_A_M_P_PERIODE_3);
			}
			else {
				bindPeriode = true;

				sb.append(_FINDER_COLUMN_C_A_M_P_PERIODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commercialId);

				queryPos.add(annee);

				queryPos.add(mois);

				if (bindPeriode) {
					queryPos.add(periode);
				}

				List<Evaluation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_A_M_P, finderArgs, list);
					}
				}
				else {
					Evaluation evaluation = list.get(0);

					result = evaluation;

					cacheResult(evaluation);
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
			return (Evaluation)result;
		}
	}

	/**
	 * Removes the evaluation where commercialId = &#63; and annee = &#63; and mois = &#63; and periode = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param periode the periode
	 * @return the evaluation that was removed
	 */
	@Override
	public Evaluation removeByC_A_M_P(
			long commercialId, int annee, int mois, String periode)
		throws NoSuchEvaluationException {

		Evaluation evaluation = findByC_A_M_P(
			commercialId, annee, mois, periode);

		return remove(evaluation);
	}

	/**
	 * Returns the number of evaluations where commercialId = &#63; and annee = &#63; and mois = &#63; and periode = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param periode the periode
	 * @return the number of matching evaluations
	 */
	@Override
	public int countByC_A_M_P(
		long commercialId, int annee, int mois, String periode) {

		Evaluation evaluation = fetchByC_A_M_P(
			commercialId, annee, mois, periode);

		if (evaluation == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_C_A_M_P_COMMERCIALID_2 =
		"evaluation.commercialId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_M_P_ANNEE_2 =
		"evaluation.annee = ? AND ";

	private static final String _FINDER_COLUMN_C_A_M_P_MOIS_2 =
		"evaluation.mois = ? AND ";

	private static final String _FINDER_COLUMN_C_A_M_P_PERIODE_2 =
		"evaluation.periode = ?";

	private static final String _FINDER_COLUMN_C_A_M_P_PERIODE_3 =
		"(evaluation.periode IS NULL OR evaluation.periode = '')";

	public EvaluationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("commercialId", "commercial_id");
		dbColumnNames.put("nbVisitesPrevues", "nb_visites_prevues");
		dbColumnNames.put("nbVisitesEffectuees", "nb_visites_effectuees");
		dbColumnNames.put("tauxRealisation", "taux_realisation");
		dbColumnNames.put("createdAt", "created_at");
		dbColumnNames.put("updatedAt", "updated_at");

		setDBColumnNames(dbColumnNames);

		setModelClass(Evaluation.class);

		setModelImplClass(EvaluationImpl.class);
		setModelPKClass(long.class);

		setTable(EvaluationTable.INSTANCE);
	}

	/**
	 * Caches the evaluation in the entity cache if it is enabled.
	 *
	 * @param evaluation the evaluation
	 */
	@Override
	public void cacheResult(Evaluation evaluation) {
		entityCache.putResult(
			EvaluationImpl.class, evaluation.getPrimaryKey(), evaluation);

		finderCache.putResult(
			_finderPathFetchByC_A_M_P,
			new Object[] {
				evaluation.getCommercialId(), evaluation.getAnnee(),
				evaluation.getMois(), evaluation.getPeriode()
			},
			evaluation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the evaluations in the entity cache if it is enabled.
	 *
	 * @param evaluations the evaluations
	 */
	@Override
	public void cacheResult(List<Evaluation> evaluations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (evaluations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Evaluation evaluation : evaluations) {
			if (entityCache.getResult(
					EvaluationImpl.class, evaluation.getPrimaryKey()) == null) {

				cacheResult(evaluation);
			}
		}
	}

	/**
	 * Clears the cache for all evaluations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EvaluationImpl.class);

		finderCache.clearCache(EvaluationImpl.class);
	}

	/**
	 * Clears the cache for the evaluation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Evaluation evaluation) {
		entityCache.removeResult(EvaluationImpl.class, evaluation);
	}

	@Override
	public void clearCache(List<Evaluation> evaluations) {
		for (Evaluation evaluation : evaluations) {
			entityCache.removeResult(EvaluationImpl.class, evaluation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EvaluationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EvaluationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		EvaluationModelImpl evaluationModelImpl) {

		Object[] args = new Object[] {
			evaluationModelImpl.getCommercialId(),
			evaluationModelImpl.getAnnee(), evaluationModelImpl.getMois(),
			evaluationModelImpl.getPeriode()
		};

		finderCache.putResult(
			_finderPathFetchByC_A_M_P, args, evaluationModelImpl);
	}

	/**
	 * Creates a new evaluation with the primary key. Does not add the evaluation to the database.
	 *
	 * @param id the primary key for the new evaluation
	 * @return the new evaluation
	 */
	@Override
	public Evaluation create(long id) {
		Evaluation evaluation = new EvaluationImpl();

		evaluation.setNew(true);
		evaluation.setPrimaryKey(id);

		return evaluation;
	}

	/**
	 * Removes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation that was removed
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation remove(long id) throws NoSuchEvaluationException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the evaluation
	 * @return the evaluation that was removed
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation remove(Serializable primaryKey)
		throws NoSuchEvaluationException {

		Session session = null;

		try {
			session = openSession();

			Evaluation evaluation = (Evaluation)session.get(
				EvaluationImpl.class, primaryKey);

			if (evaluation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEvaluationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(evaluation);
		}
		catch (NoSuchEvaluationException noSuchEntityException) {
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
	protected Evaluation removeImpl(Evaluation evaluation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(evaluation)) {
				evaluation = (Evaluation)session.get(
					EvaluationImpl.class, evaluation.getPrimaryKeyObj());
			}

			if (evaluation != null) {
				session.delete(evaluation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (evaluation != null) {
			clearCache(evaluation);
		}

		return evaluation;
	}

	@Override
	public Evaluation updateImpl(Evaluation evaluation) {
		boolean isNew = evaluation.isNew();

		if (!(evaluation instanceof EvaluationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(evaluation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(evaluation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in evaluation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Evaluation implementation " +
					evaluation.getClass());
		}

		EvaluationModelImpl evaluationModelImpl =
			(EvaluationModelImpl)evaluation;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(evaluation);
			}
			else {
				evaluation = (Evaluation)session.merge(evaluation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EvaluationImpl.class, evaluationModelImpl, false, true);

		cacheUniqueFindersCache(evaluationModelImpl);

		if (isNew) {
			evaluation.setNew(false);
		}

		evaluation.resetOriginalValues();

		return evaluation;
	}

	/**
	 * Returns the evaluation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the evaluation
	 * @return the evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEvaluationException {

		Evaluation evaluation = fetchByPrimaryKey(primaryKey);

		if (evaluation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEvaluationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return evaluation;
	}

	/**
	 * Returns the evaluation with the primary key or throws a <code>NoSuchEvaluationException</code> if it could not be found.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation findByPrimaryKey(long id)
		throws NoSuchEvaluationException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation, or <code>null</code> if a evaluation with the primary key could not be found
	 */
	@Override
	public Evaluation fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the evaluations.
	 *
	 * @return the evaluations
	 */
	@Override
	public List<Evaluation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @return the range of evaluations
	 */
	@Override
	public List<Evaluation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of evaluations
	 */
	@Override
	public List<Evaluation> findAll(
		int start, int end, OrderByComparator<Evaluation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of evaluations
	 */
	@Override
	public List<Evaluation> findAll(
		int start, int end, OrderByComparator<Evaluation> orderByComparator,
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

		List<Evaluation> list = null;

		if (useFinderCache) {
			list = (List<Evaluation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EVALUATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EVALUATION;

				sql = sql.concat(EvaluationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Evaluation>)QueryUtil.list(
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
	 * Removes all the evaluations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Evaluation evaluation : findAll()) {
			remove(evaluation);
		}
	}

	/**
	 * Returns the number of evaluations.
	 *
	 * @return the number of evaluations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EVALUATION);

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
		return _SQL_SELECT_EVALUATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EvaluationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the evaluation persistence.
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

		_finderPathWithPaginationFindByAnnee = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAnnee",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"annee"}, true);

		_finderPathWithoutPaginationFindByAnnee = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAnnee",
			new String[] {Integer.class.getName()}, new String[] {"annee"},
			true);

		_finderPathCountByAnnee = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAnnee",
			new String[] {Integer.class.getName()}, new String[] {"annee"},
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

		_finderPathFetchByC_A_M_P = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_A_M_P",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), String.class.getName()
			},
			new String[] {"commercial_id", "annee", "mois", "periode"}, true);

		EvaluationUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		EvaluationUtil.setPersistence(null);

		entityCache.removeCache(EvaluationImpl.class.getName());
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

	private static final String _SQL_SELECT_EVALUATION =
		"SELECT evaluation FROM Evaluation evaluation";

	private static final String _SQL_SELECT_EVALUATION_WHERE =
		"SELECT evaluation FROM Evaluation evaluation WHERE ";

	private static final String _SQL_COUNT_EVALUATION =
		"SELECT COUNT(evaluation) FROM Evaluation evaluation";

	private static final String _SQL_COUNT_EVALUATION_WHERE =
		"SELECT COUNT(evaluation) FROM Evaluation evaluation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "evaluation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Evaluation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Evaluation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EvaluationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"commercialId", "nbVisitesPrevues", "nbVisitesEffectuees",
			"tauxRealisation", "createdAt", "updatedAt"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}