/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.model.ConcessionnaireProduit;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the concessionnaire produit service. This utility wraps <code>com.df.lonis.ventesservice.service.persistence.impl.ConcessionnaireProduitPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireProduitPersistence
 * @generated
 */
public class ConcessionnaireProduitUtil {

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
	public static void clearCache(
		ConcessionnaireProduit concessionnaireProduit) {

		getPersistence().clearCache(concessionnaireProduit);
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
	public static Map<Serializable, ConcessionnaireProduit> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ConcessionnaireProduit> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConcessionnaireProduit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConcessionnaireProduit> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ConcessionnaireProduit update(
		ConcessionnaireProduit concessionnaireProduit) {

		return getPersistence().update(concessionnaireProduit);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ConcessionnaireProduit update(
		ConcessionnaireProduit concessionnaireProduit,
		ServiceContext serviceContext) {

		return getPersistence().update(concessionnaireProduit, serviceContext);
	}

	/**
	 * Returns all the concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the matching concessionnaire produits
	 */
	public static List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId) {

		return getPersistence().findByConcessionnaireId(concessionnaireId);
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
	public static List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end) {

		return getPersistence().findByConcessionnaireId(
			concessionnaireId, start, end);
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
	public static List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return getPersistence().findByConcessionnaireId(
			concessionnaireId, start, end, orderByComparator);
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
	public static List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByConcessionnaireId(
			concessionnaireId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit findByConcessionnaireId_First(
			long concessionnaireId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().findByConcessionnaireId_First(
			concessionnaireId, orderByComparator);
	}

	/**
	 * Returns the first concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit fetchByConcessionnaireId_First(
		long concessionnaireId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return getPersistence().fetchByConcessionnaireId_First(
			concessionnaireId, orderByComparator);
	}

	/**
	 * Returns the last concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit findByConcessionnaireId_Last(
			long concessionnaireId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().findByConcessionnaireId_Last(
			concessionnaireId, orderByComparator);
	}

	/**
	 * Returns the last concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit fetchByConcessionnaireId_Last(
		long concessionnaireId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return getPersistence().fetchByConcessionnaireId_Last(
			concessionnaireId, orderByComparator);
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
	public static ConcessionnaireProduit[] findByConcessionnaireId_PrevAndNext(
			long id, long concessionnaireId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().findByConcessionnaireId_PrevAndNext(
			id, concessionnaireId, orderByComparator);
	}

	/**
	 * Removes all the concessionnaire produits where concessionnaireId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 */
	public static void removeByConcessionnaireId(long concessionnaireId) {
		getPersistence().removeByConcessionnaireId(concessionnaireId);
	}

	/**
	 * Returns the number of concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the number of matching concessionnaire produits
	 */
	public static int countByConcessionnaireId(long concessionnaireId) {
		return getPersistence().countByConcessionnaireId(concessionnaireId);
	}

	/**
	 * Returns all the concessionnaire produits where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produits
	 */
	public static List<ConcessionnaireProduit> findByProduitId(long produitId) {
		return getPersistence().findByProduitId(produitId);
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
	public static List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end) {

		return getPersistence().findByProduitId(produitId, start, end);
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
	public static List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return getPersistence().findByProduitId(
			produitId, start, end, orderByComparator);
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
	public static List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProduitId(
			produitId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit findByProduitId_First(
			long produitId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().findByProduitId_First(
			produitId, orderByComparator);
	}

	/**
	 * Returns the first concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit fetchByProduitId_First(
		long produitId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return getPersistence().fetchByProduitId_First(
			produitId, orderByComparator);
	}

	/**
	 * Returns the last concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit findByProduitId_Last(
			long produitId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().findByProduitId_Last(
			produitId, orderByComparator);
	}

	/**
	 * Returns the last concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit fetchByProduitId_Last(
		long produitId,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return getPersistence().fetchByProduitId_Last(
			produitId, orderByComparator);
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
	public static ConcessionnaireProduit[] findByProduitId_PrevAndNext(
			long id, long produitId,
			OrderByComparator<ConcessionnaireProduit> orderByComparator)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().findByProduitId_PrevAndNext(
			id, produitId, orderByComparator);
	}

	/**
	 * Removes all the concessionnaire produits where produitId = &#63; from the database.
	 *
	 * @param produitId the produit ID
	 */
	public static void removeByProduitId(long produitId) {
		getPersistence().removeByProduitId(produitId);
	}

	/**
	 * Returns the number of concessionnaire produits where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @return the number of matching concessionnaire produits
	 */
	public static int countByProduitId(long produitId) {
		return getPersistence().countByProduitId(produitId);
	}

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or throws a <code>NoSuchConcessionnaireProduitException</code> if it could not be found.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit findByC_P(
			long concessionnaireId, long produitId)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().findByC_P(concessionnaireId, produitId);
	}

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit fetchByC_P(
		long concessionnaireId, long produitId) {

		return getPersistence().fetchByC_P(concessionnaireId, produitId);
	}

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public static ConcessionnaireProduit fetchByC_P(
		long concessionnaireId, long produitId, boolean useFinderCache) {

		return getPersistence().fetchByC_P(
			concessionnaireId, produitId, useFinderCache);
	}

	/**
	 * Removes the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the concessionnaire produit that was removed
	 */
	public static ConcessionnaireProduit removeByC_P(
			long concessionnaireId, long produitId)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().removeByC_P(concessionnaireId, produitId);
	}

	/**
	 * Returns the number of concessionnaire produits where concessionnaireId = &#63; and produitId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the number of matching concessionnaire produits
	 */
	public static int countByC_P(long concessionnaireId, long produitId) {
		return getPersistence().countByC_P(concessionnaireId, produitId);
	}

	/**
	 * Caches the concessionnaire produit in the entity cache if it is enabled.
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 */
	public static void cacheResult(
		ConcessionnaireProduit concessionnaireProduit) {

		getPersistence().cacheResult(concessionnaireProduit);
	}

	/**
	 * Caches the concessionnaire produits in the entity cache if it is enabled.
	 *
	 * @param concessionnaireProduits the concessionnaire produits
	 */
	public static void cacheResult(
		List<ConcessionnaireProduit> concessionnaireProduits) {

		getPersistence().cacheResult(concessionnaireProduits);
	}

	/**
	 * Creates a new concessionnaire produit with the primary key. Does not add the concessionnaire produit to the database.
	 *
	 * @param id the primary key for the new concessionnaire produit
	 * @return the new concessionnaire produit
	 */
	public static ConcessionnaireProduit create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the concessionnaire produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit that was removed
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	public static ConcessionnaireProduit remove(long id)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().remove(id);
	}

	public static ConcessionnaireProduit updateImpl(
		ConcessionnaireProduit concessionnaireProduit) {

		return getPersistence().updateImpl(concessionnaireProduit);
	}

	/**
	 * Returns the concessionnaire produit with the primary key or throws a <code>NoSuchConcessionnaireProduitException</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	public static ConcessionnaireProduit findByPrimaryKey(long id)
		throws com.df.lonis.ventesservice.exception.
			NoSuchConcessionnaireProduitException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the concessionnaire produit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit, or <code>null</code> if a concessionnaire produit with the primary key could not be found
	 */
	public static ConcessionnaireProduit fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the concessionnaire produits.
	 *
	 * @return the concessionnaire produits
	 */
	public static List<ConcessionnaireProduit> findAll() {
		return getPersistence().findAll();
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
	public static List<ConcessionnaireProduit> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ConcessionnaireProduit> findAll(
		int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ConcessionnaireProduit> findAll(
		int start, int end,
		OrderByComparator<ConcessionnaireProduit> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the concessionnaire produits from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of concessionnaire produits.
	 *
	 * @return the number of concessionnaire produits
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConcessionnaireProduitPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ConcessionnaireProduitPersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ConcessionnaireProduitPersistence _persistence;

}