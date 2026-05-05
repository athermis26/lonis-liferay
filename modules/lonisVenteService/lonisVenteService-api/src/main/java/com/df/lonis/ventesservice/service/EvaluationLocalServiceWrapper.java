/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EvaluationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EvaluationLocalService
 * @generated
 */
public class EvaluationLocalServiceWrapper
	implements EvaluationLocalService, ServiceWrapper<EvaluationLocalService> {

	public EvaluationLocalServiceWrapper() {
		this(null);
	}

	public EvaluationLocalServiceWrapper(
		EvaluationLocalService evaluationLocalService) {

		_evaluationLocalService = evaluationLocalService;
	}

	/**
	 * Adds the evaluation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EvaluationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evaluation the evaluation
	 * @return the evaluation that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.Evaluation addEvaluation(
		com.df.lonis.ventesservice.model.Evaluation evaluation) {

		return _evaluationLocalService.addEvaluation(evaluation);
	}

	/**
	 * Creates a new evaluation with the primary key. Does not add the evaluation to the database.
	 *
	 * @param id the primary key for the new evaluation
	 * @return the new evaluation
	 */
	@Override
	public com.df.lonis.ventesservice.model.Evaluation createEvaluation(
		long id) {

		return _evaluationLocalService.createEvaluation(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evaluationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the evaluation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EvaluationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evaluation the evaluation
	 * @return the evaluation that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.Evaluation deleteEvaluation(
		com.df.lonis.ventesservice.model.Evaluation evaluation) {

		return _evaluationLocalService.deleteEvaluation(evaluation);
	}

	/**
	 * Deletes the evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EvaluationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation that was removed
	 * @throws PortalException if a evaluation with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Evaluation deleteEvaluation(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evaluationLocalService.deleteEvaluation(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evaluationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _evaluationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _evaluationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _evaluationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _evaluationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _evaluationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _evaluationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _evaluationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _evaluationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.Evaluation fetchEvaluation(
		long id) {

		return _evaluationLocalService.fetchEvaluation(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _evaluationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the evaluation with the primary key.
	 *
	 * @param id the primary key of the evaluation
	 * @return the evaluation
	 * @throws PortalException if a evaluation with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Evaluation getEvaluation(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evaluationLocalService.getEvaluation(id);
	}

	/**
	 * Returns a range of all the evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.EvaluationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluations
	 * @param end the upper bound of the range of evaluations (not inclusive)
	 * @return the range of evaluations
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Evaluation>
		getEvaluations(int start, int end) {

		return _evaluationLocalService.getEvaluations(start, end);
	}

	/**
	 * Returns the number of evaluations.
	 *
	 * @return the number of evaluations
	 */
	@Override
	public int getEvaluationsCount() {
		return _evaluationLocalService.getEvaluationsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _evaluationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _evaluationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _evaluationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the evaluation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EvaluationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param evaluation the evaluation
	 * @return the evaluation that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.Evaluation updateEvaluation(
		com.df.lonis.ventesservice.model.Evaluation evaluation) {

		return _evaluationLocalService.updateEvaluation(evaluation);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _evaluationLocalService.getBasePersistence();
	}

	@Override
	public EvaluationLocalService getWrappedService() {
		return _evaluationLocalService;
	}

	@Override
	public void setWrappedService(
		EvaluationLocalService evaluationLocalService) {

		_evaluationLocalService = evaluationLocalService;
	}

	private EvaluationLocalService _evaluationLocalService;

}