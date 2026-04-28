/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.df.lonis.ventesservice.model.ConcessionnaireProduit;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ConcessionnaireProduit. This utility wraps
 * <code>com.df.lonis.ventesservice.service.impl.ConcessionnaireProduitLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireProduitLocalService
 * @generated
 */
public class ConcessionnaireProduitLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.df.lonis.ventesservice.service.impl.ConcessionnaireProduitLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the concessionnaire produit to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 * @return the concessionnaire produit that was added
	 */
	public static ConcessionnaireProduit addConcessionnaireProduit(
		ConcessionnaireProduit concessionnaireProduit) {

		return getService().addConcessionnaireProduit(concessionnaireProduit);
	}

	/**
	 * Creates a new concessionnaire produit with the primary key. Does not add the concessionnaire produit to the database.
	 *
	 * @param id the primary key for the new concessionnaire produit
	 * @return the new concessionnaire produit
	 */
	public static ConcessionnaireProduit createConcessionnaireProduit(long id) {
		return getService().createConcessionnaireProduit(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the concessionnaire produit from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 * @return the concessionnaire produit that was removed
	 */
	public static ConcessionnaireProduit deleteConcessionnaireProduit(
		ConcessionnaireProduit concessionnaireProduit) {

		return getService().deleteConcessionnaireProduit(
			concessionnaireProduit);
	}

	/**
	 * Deletes the concessionnaire produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit that was removed
	 * @throws PortalException if a concessionnaire produit with the primary key could not be found
	 */
	public static ConcessionnaireProduit deleteConcessionnaireProduit(long id)
		throws PortalException {

		return getService().deleteConcessionnaireProduit(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ConcessionnaireProduit fetchConcessionnaireProduit(long id) {
		return getService().fetchConcessionnaireProduit(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the concessionnaire produit with the primary key.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit
	 * @throws PortalException if a concessionnaire produit with the primary key could not be found
	 */
	public static ConcessionnaireProduit getConcessionnaireProduit(long id)
		throws PortalException {

		return getService().getConcessionnaireProduit(id);
	}

	/**
	 * Returns a range of all the concessionnaire produits.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of concessionnaire produits
	 * @param end the upper bound of the range of concessionnaire produits (not inclusive)
	 * @return the range of concessionnaire produits
	 */
	public static List<ConcessionnaireProduit> getConcessionnaireProduits(
		int start, int end) {

		return getService().getConcessionnaireProduits(start, end);
	}

	/**
	 * Returns the number of concessionnaire produits.
	 *
	 * @return the number of concessionnaire produits
	 */
	public static int getConcessionnaireProduitsCount() {
		return getService().getConcessionnaireProduitsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the concessionnaire produit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConcessionnaireProduitLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 * @return the concessionnaire produit that was updated
	 */
	public static ConcessionnaireProduit updateConcessionnaireProduit(
		ConcessionnaireProduit concessionnaireProduit) {

		return getService().updateConcessionnaireProduit(
			concessionnaireProduit);
	}

	public static ConcessionnaireProduitLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ConcessionnaireProduitLocalService>
		_serviceSnapshot = new Snapshot<>(
			ConcessionnaireProduitLocalServiceUtil.class,
			ConcessionnaireProduitLocalService.class);

}