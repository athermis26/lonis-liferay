/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ChiffreAffairesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChiffreAffairesLocalService
 * @generated
 */
public class ChiffreAffairesLocalServiceWrapper
	implements ChiffreAffairesLocalService,
			   ServiceWrapper<ChiffreAffairesLocalService> {

	public ChiffreAffairesLocalServiceWrapper() {
		this(null);
	}

	public ChiffreAffairesLocalServiceWrapper(
		ChiffreAffairesLocalService chiffreAffairesLocalService) {

		_chiffreAffairesLocalService = chiffreAffairesLocalService;
	}

	/**
	 * Adds the chiffre affaires to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChiffreAffairesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chiffreAffaires the chiffre affaires
	 * @return the chiffre affaires that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.ChiffreAffaires addChiffreAffaires(
		com.df.lonis.ventesservice.model.ChiffreAffaires chiffreAffaires) {

		return _chiffreAffairesLocalService.addChiffreAffaires(chiffreAffaires);
	}

	/**
	 * Creates a new chiffre affaires with the primary key. Does not add the chiffre affaires to the database.
	 *
	 * @param id the primary key for the new chiffre affaires
	 * @return the new chiffre affaires
	 */
	@Override
	public com.df.lonis.ventesservice.model.ChiffreAffaires
		createChiffreAffaires(long id) {

		return _chiffreAffairesLocalService.createChiffreAffaires(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiffreAffairesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the chiffre affaires from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChiffreAffairesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chiffreAffaires the chiffre affaires
	 * @return the chiffre affaires that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.ChiffreAffaires
		deleteChiffreAffaires(
			com.df.lonis.ventesservice.model.ChiffreAffaires chiffreAffaires) {

		return _chiffreAffairesLocalService.deleteChiffreAffaires(
			chiffreAffaires);
	}

	/**
	 * Deletes the chiffre affaires with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChiffreAffairesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires that was removed
	 * @throws PortalException if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.ChiffreAffaires
			deleteChiffreAffaires(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiffreAffairesLocalService.deleteChiffreAffaires(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiffreAffairesLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _chiffreAffairesLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _chiffreAffairesLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _chiffreAffairesLocalService.dynamicQuery();
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

		return _chiffreAffairesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ChiffreAffairesModelImpl</code>.
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

		return _chiffreAffairesLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ChiffreAffairesModelImpl</code>.
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

		return _chiffreAffairesLocalService.dynamicQuery(
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

		return _chiffreAffairesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _chiffreAffairesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.ChiffreAffaires
		fetchChiffreAffaires(long id) {

		return _chiffreAffairesLocalService.fetchChiffreAffaires(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _chiffreAffairesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the chiffre affaires with the primary key.
	 *
	 * @param id the primary key of the chiffre affaires
	 * @return the chiffre affaires
	 * @throws PortalException if a chiffre affaires with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.ChiffreAffaires getChiffreAffaires(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiffreAffairesLocalService.getChiffreAffaires(id);
	}

	/**
	 * Returns a range of all the chiffre affaireses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ChiffreAffairesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chiffre affaireses
	 * @param end the upper bound of the range of chiffre affaireses (not inclusive)
	 * @return the range of chiffre affaireses
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.ChiffreAffaires>
		getChiffreAffaireses(int start, int end) {

		return _chiffreAffairesLocalService.getChiffreAffaireses(start, end);
	}

	/**
	 * Returns the number of chiffre affaireses.
	 *
	 * @return the number of chiffre affaireses
	 */
	@Override
	public int getChiffreAffairesesCount() {
		return _chiffreAffairesLocalService.getChiffreAffairesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _chiffreAffairesLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chiffreAffairesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _chiffreAffairesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the chiffre affaires in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ChiffreAffairesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param chiffreAffaires the chiffre affaires
	 * @return the chiffre affaires that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.ChiffreAffaires
		updateChiffreAffaires(
			com.df.lonis.ventesservice.model.ChiffreAffaires chiffreAffaires) {

		return _chiffreAffairesLocalService.updateChiffreAffaires(
			chiffreAffaires);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _chiffreAffairesLocalService.getBasePersistence();
	}

	@Override
	public ChiffreAffairesLocalService getWrappedService() {
		return _chiffreAffairesLocalService;
	}

	@Override
	public void setWrappedService(
		ChiffreAffairesLocalService chiffreAffairesLocalService) {

		_chiffreAffairesLocalService = chiffreAffairesLocalService;
	}

	private ChiffreAffairesLocalService _chiffreAffairesLocalService;

}