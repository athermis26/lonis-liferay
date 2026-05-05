/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchEvaluationException;
import com.df.lonis.ventesservice.model.Evaluation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EvaluationUtil
 * @generated
 */
@ProviderType
public interface EvaluationPersistence extends BasePersistence<Evaluation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EvaluationUtil} to access the evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the evaluations where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching evaluations
	 */
	public java.util.List<Evaluation> findByCommercialId(long commercialId);

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
	public java.util.List<Evaluation> findByCommercialId(
		long commercialId, int start, int end);

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
	public java.util.List<Evaluation> findByCommercialId(
		long commercialId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

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
	public java.util.List<Evaluation> findByCommercialId(
		long commercialId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public Evaluation findByCommercialId_First(
			long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public Evaluation fetchByCommercialId_First(
		long commercialId,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public Evaluation findByCommercialId_Last(
			long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public Evaluation fetchByCommercialId_Last(
		long commercialId,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

	/**
	 * Returns the evaluations before and after the current evaluation in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current evaluation
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	public Evaluation[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Removes all the evaluations where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	public void removeByCommercialId(long commercialId);

	/**
	 * Returns the number of evaluations where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching evaluations
	 */
	public int countByCommercialId(long commercialId);

	/**
	 * Returns all the evaluations where annee = &#63;.
	 *
	 * @param annee the annee
	 * @return the matching evaluations
	 */
	public java.util.List<Evaluation> findByAnnee(int annee);

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
	public java.util.List<Evaluation> findByAnnee(
		int annee, int start, int end);

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
	public java.util.List<Evaluation> findByAnnee(
		int annee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

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
	public java.util.List<Evaluation> findByAnnee(
		int annee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public Evaluation findByAnnee_First(
			int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Returns the first evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public Evaluation fetchByAnnee_First(
		int annee,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

	/**
	 * Returns the last evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public Evaluation findByAnnee_Last(
			int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Returns the last evaluation in the ordered set where annee = &#63;.
	 *
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public Evaluation fetchByAnnee_Last(
		int annee,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

	/**
	 * Returns the evaluations before and after the current evaluation in the ordered set where annee = &#63;.
	 *
	 * @param id the primary key of the current evaluation
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	public Evaluation[] findByAnnee_PrevAndNext(
			long id, int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Removes all the evaluations where annee = &#63; from the database.
	 *
	 * @param annee the annee
	 */
	public void removeByAnnee(int annee);

	/**
	 * Returns the number of evaluations where annee = &#63;.
	 *
	 * @param annee the annee
	 * @return the number of matching evaluations
	 */
	public int countByAnnee(int annee);

	/**
	 * Returns all the evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the matching evaluations
	 */
	public java.util.List<Evaluation> findByC_A(long commercialId, int annee);

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
	public java.util.List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end);

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
	public java.util.List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

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
	public java.util.List<Evaluation> findByC_A(
		long commercialId, int annee, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public Evaluation findByC_A_First(
			long commercialId, int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Returns the first evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public Evaluation fetchByC_A_First(
		long commercialId, int annee,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation
	 * @throws NoSuchEvaluationException if a matching evaluation could not be found
	 */
	public Evaluation findByC_A_Last(
			long commercialId, int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Returns the last evaluation in the ordered set where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public Evaluation fetchByC_A_Last(
		long commercialId, int annee,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

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
	public Evaluation[] findByC_A_PrevAndNext(
			long id, long commercialId, int annee,
			com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
				orderByComparator)
		throws NoSuchEvaluationException;

	/**
	 * Removes all the evaluations where commercialId = &#63; and annee = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 */
	public void removeByC_A(long commercialId, int annee);

	/**
	 * Returns the number of evaluations where commercialId = &#63; and annee = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @return the number of matching evaluations
	 */
	public int countByC_A(long commercialId, int annee);

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
	public Evaluation findByC_A_M_P(
			long commercialId, int annee, int mois, String periode)
		throws NoSuchEvaluationException;

	/**
	 * Returns the evaluation where commercialId = &#63; and annee = &#63; and mois = &#63; and periode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param periode the periode
	 * @return the matching evaluation, or <code>null</code> if a matching evaluation could not be found
	 */
	public Evaluation fetchByC_A_M_P(
		long commercialId, int annee, int mois, String periode);

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
	public Evaluation fetchByC_A_M_P(
		long commercialId, int annee, int mois, String periode,
		boolean useFinderCache);

	/**
	 * Removes the evaluation where commercialId = &#63; and annee = &#63; and mois = &#63; and periode = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param periode the periode
	 * @return the evaluation that was removed
	 */
	public Evaluation removeByC_A_M_P(
			long commercialId, int annee, int mois, String periode)
		throws NoSuchEvaluationException;

	/**
	 * Returns the number of evaluations where commercialId = &#63; and annee = &#63; and mois = &#63; and periode = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param annee the annee
	 * @param mois the mois
	 * @param periode the periode
	 * @return the number of matching evaluations
	 */
	public int countByC_A_M_P(
		long commercialId, int annee, int mois, String periode);

	/**
	 * Caches the evaluation in the entity cache if it is enabled.
	 *
	 * @param evaluation the evaluation
	 */
	public void cacheResult(Evaluation evaluation);

	/**
	 * Caches the evaluations in the entity cache if it is enabled.
	 *
	 * @param evaluations the evaluations
	 */
	public void cacheResult(java.util.List<Evaluation> evaluations);

	/**
	 * Creates a new evaluation with the primary key. Does not add the evaluation to the database.
	 *
	 * @param id the primary key for the new evaluation
	 * @return the new evaluation
	 */
	public Evaluation create(long id);

	/**
	 * Removes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation that was removed
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	public Evaluation remove(long id) throws NoSuchEvaluationException;

	public Evaluation updateImpl(Evaluation evaluation);

	/**
	 * Returns the evaluation with the primary key or throws a <code>NoSuchEvaluationException</code> if it could not be found.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation
	 * @throws NoSuchEvaluationException if a evaluation with the primary key could not be found
	 */
	public Evaluation findByPrimaryKey(long id)
		throws NoSuchEvaluationException;

	/**
	 * Returns the evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation, or <code>null</code> if a evaluation with the primary key could not be found
	 */
	public Evaluation fetchByPrimaryKey(long id);

	/**
	 * Returns all the evaluations.
	 *
	 * @return the evaluations
	 */
	public java.util.List<Evaluation> findAll();

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
	public java.util.List<Evaluation> findAll(int start, int end);

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
	public java.util.List<Evaluation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator);

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
	public java.util.List<Evaluation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Evaluation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the evaluations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of evaluations.
	 *
	 * @return the number of evaluations
	 */
	public int countAll();

}