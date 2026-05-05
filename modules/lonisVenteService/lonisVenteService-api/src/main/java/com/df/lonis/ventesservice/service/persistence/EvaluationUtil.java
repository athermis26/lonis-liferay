/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.Evaluation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the evaluation service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.EvaluationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EvaluationPersistence
 * @generated
 */
public class EvaluationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Evaluation evaluation) {
		getPersistence().clearCache(evaluation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Evaluation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Evaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Evaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Evaluation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Evaluation update(Evaluation evaluation) {
		return getPersistence().update(evaluation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Evaluation update(
		Evaluation evaluation, ServiceContext serviceContext) {

		return getPersistence().update(evaluation, serviceContext);
	}

	/**
	 * Returns all the evaluations where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching evaluations
	 */
	public static List<Evaluation> findByCommercialId(long commercialId) {
		return getPersistence().findByCommercialId(commercialId);
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
	public static List<Evaluation> findByCommercialId(
		long commercialId, int start, int end) {

		return getPersistence().findByCommercialId(commercialId, start, end);
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
	public static List<Evaluation> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().findByCommercialId(
			commercialId, start, end, orderByComparator);
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
	public static List<Evaluation> findByCommercialId(
		long commercialId, int start, int end,
		OrderByComparator<Evaluation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCommercialId(
			commercialId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public static Evaluation findByCommercialId_First(
			long commercialId, OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByCommercialId_First(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public static Evaluation fetchByCommercialId_First(
		long commercialId, OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().fetchByCommercialId_First(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public static Evaluation findByCommercialId_Last(
			long commercialId, OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByCommercialId_Last(
			commercialId, orderByComparator);
	}

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public static Evaluation fetchByCommercialId_Last(
		long commercialId, OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().fetchByCommercialId_Last(
			commercialId, orderByComparator);
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
	public static Evaluation[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByCommercialId_PrevAndNext(
			id, commercialId, orderByComparator);
	}

	/**
	 * Removes all the evaluations where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	public static void removeByCommercialId(long commercialId) {
		getPersistence().removeByCommercialId(commercialId);
	}

	/**
	 * Returns the number of evaluations where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching evaluations
	 */
	public static int countByCommercialId(long commercialId) {
		return getPersistence().countByCommercialId(commercialId);
	}

	/**
	 * Returns all the evaluations where annee = &#63;.
	 *
	 * @param annee the annee
	 * @return the matching evaluations
	 */
	public static List<Evaluation> findByAnnee(int annee) {
		return getPersistence().findByAnnee(annee);
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
	public static List<Evaluation> findByAnnee(int annee, int start, int end) {
		return getPersistence().findByAnnee(annee, start, end);
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
	public static List<Evaluation> findByAnnee(
		int annee, int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().findByAnnee(
			annee, start, end, orderByComparator);
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
	public static List<Evaluation> findByAnnee(
		int annee, int start, int end,
		OrderByComparator<Evaluation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByAnnee(
			annee, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public static Evaluation findByAnnee_First(
			int annee, OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByAnnee_First(annee, orderByComparator);
	}

	/**
	 * Returns the first evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public static Evaluation fetchByAnnee_First(
		int annee, OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().fetchByAnnee_First(annee, orderByComparator);
	}

	/**
	 * Returns the last evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public static Evaluation findByAnnee_Last(
			int annee, OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByAnnee_Last(annee, orderByComparator);
	}

	/**
	 * Returns the last evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public static Evaluation fetchByAnnee_Last(
		int annee, OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().fetchByAnnee_Last(annee, orderByComparator);
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
	public static Evaluation[] findByAnnee_PrevAndNext(
			long id, int annee, OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByAnnee_PrevAndNext(
			id, annee, orderByComparator);
	}

	/**
	 * Removes all the evaluations where annee = &#63; from the database.
	 *
	 * @param annee the annee
	 */
	public static void removeByAnnee(int annee) {
		getPersistence().removeByAnnee(annee);
	}

	/**
	 * Returns the number of evaluations where annee = &#63;.
	 *
	 * @param annee the annee
	 * @return the number of matching evaluations
	 */
	public static int countByAnnee(int annee) {
		return getPersistence().countByAnnee(annee);
	}

	/**
	 * Returns all the evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the matching evaluations
	 */
	public static List<Evaluation> findByC_A(long commercialId, int annee) {
		return getPersistence().findByC_A(commercialId, annee);
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
	public static List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end) {

		return getPersistence().findByC_A(commercialId, annee, start, end);
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
	public static List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end,
		OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().findByC_A(
			commercialId, annee, start, end, orderByComparator);
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
	public static List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end,
		OrderByComparator<Evaluation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByC_A(
			commercialId, annee, start, end, orderByComparator, useFinderCache);
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
	public static Evaluation findByC_A_First(
			long commercialId, int annee,
			OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByC_A_First(
			commercialId, annee, orderByComparator);
	}

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public static Evaluation fetchByC_A_First(
		long commercialId, int annee,
		OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().fetchByC_A_First(
			commercialId, annee, orderByComparator);
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
	public static Evaluation findByC_A_Last(
			long commercialId, int annee,
			OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByC_A_Last(
			commercialId, annee, orderByComparator);
	}

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public static Evaluation fetchByC_A_Last(
		long commercialId, int annee,
		OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().fetchByC_A_Last(
			commercialId, annee, orderByComparator);
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
	public static Evaluation[] findByC_A_PrevAndNext(
			long id, long commercialId, int annee,
			OrderByComparator<Evaluation> orderByComparator)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByC_A_PrevAndNext(
			id, commercialId, annee, orderByComparator);
	}

	/**
	 * Removes all the evaluations where commercialId = &#63; and annee = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 */
	public static void removeByC_A(long commercialId, int annee) {
		getPersistence().removeByC_A(commercialId, annee);
	}

	/**
	 * Returns the number of evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the number of matching evaluations
	 */
	public static int countByC_A(long commercialId, int annee) {
		return getPersistence().countByC_A(commercialId, annee);
	}

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
	public static Evaluation findByC_A_M_P(
			long commercialId, int annee, int mois, String periode)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByC_A_M_P(
			commercialId, annee, mois, periode);
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
	public static Evaluation fetchByC_A_M_P(
		long commercialId, int annee, int mois, String periode) {

		return getPersistence().fetchByC_A_M_P(
			commercialId, annee, mois, periode);
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
	public static Evaluation fetchByC_A_M_P(
		long commercialId, int annee, int mois, String periode,
		boolean useFinderCache) {

		return getPersistence().fetchByC_A_M_P(
			commercialId, annee, mois, periode, useFinderCache);
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
	public static Evaluation removeByC_A_M_P(
			long commercialId, int annee, int mois, String periode)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().removeByC_A_M_P(
			commercialId, annee, mois, periode);
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
	public static int countByC_A_M_P(
		long commercialId, int annee, int mois, String periode) {

		return getPersistence().countByC_A_M_P(
			commercialId, annee, mois, periode);
	}

	/**
	 * Caches the evaluation in the entity cache if it is enabled.
	 *
	 * @param evaluation the evaluation
	 */
	public static void cacheResult(Evaluation evaluation) {
		getPersistence().cacheResult(evaluation);
	}

	/**
	 * Caches the evaluations in the entity cache if it is enabled.
	 *
	 * @param evaluations the evaluations
	 */
	public static void cacheResult(List<Evaluation> evaluations) {
		getPersistence().cacheResult(evaluations);
	}

	/**
	 * Creates a new evaluation with the primary key. Does not add the evaluation to the database.
	 *
	 * @param id the primary key for the new evaluation
	 * @return the new evaluation
	 */
	public static Evaluation create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation that was removed
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	public static Evaluation remove(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().remove(id);
	}

	public static Evaluation updateImpl(Evaluation evaluation) {
		return getPersistence().updateImpl(evaluation);
	}

	/**
	 * Returns the evaluation with the primary key or throws a <code>NoSuchEvaluationException</code> if it could not be found.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	public static Evaluation findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.NoSuchEvaluationException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation, or <code>null</code> if a evaluation with the primary key could not be found
	 */
	public static Evaluation fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the evaluations.
	 *
	 * @return the evaluations
	 */
	public static List<Evaluation> findAll() {
		return getPersistence().findAll();
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
	public static List<Evaluation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Evaluation> findAll(
		int start, int end, OrderByComparator<Evaluation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Evaluation> findAll(
		int start, int end, OrderByComparator<Evaluation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the evaluations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of evaluations.
	 *
	 * @return the number of evaluations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EvaluationPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(EvaluationPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile EvaluationPersistence _persistence;

}