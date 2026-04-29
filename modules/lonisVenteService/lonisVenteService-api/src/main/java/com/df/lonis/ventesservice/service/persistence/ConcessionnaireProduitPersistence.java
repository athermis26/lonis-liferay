/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchConcessionnaireProduitException;
import com.df.lonis.ventesservice.model.ConcessionnaireProduit;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the concessionnaire produit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireProduitUtil
 * @generated
 */
@ProviderType
public interface ConcessionnaireProduitPersistence
	extends BasePersistence<ConcessionnaireProduit> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConcessionnaireProduitUtil} to access the concessionnaire produit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the concessionnaire produit where code = &#63; or throws a <code>NoSuchConcessionnaireProduitException</code> if it could not be found.
	 *
	 * @param code the code
	 * @return the matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit findByCode(String code)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the concessionnaire produit where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit fetchByCode(String code);

	/**
	 * Returns the concessionnaire produit where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit fetchByCode(
		String code, boolean useFinderCache);

	/**
	 * Removes the concessionnaire produit where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the concessionnaire produit that was removed
	 */
	public ConcessionnaireProduit removeByCode(String code)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the number of concessionnaire produits where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching concessionnaire produits
	 */
	public int countByCode(String code);

	/**
	 * Returns all the concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the matching concessionnaire produits
	 */
	public java.util.List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId);

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
	public java.util.List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end);

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
	public java.util.List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator);

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
	public java.util.List<ConcessionnaireProduit> findByConcessionnaireId(
		long concessionnaireId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit findByConcessionnaireId_First(
			long concessionnaireId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the first concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit fetchByConcessionnaireId_First(
		long concessionnaireId,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator);

	/**
	 * Returns the last concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit findByConcessionnaireId_Last(
			long concessionnaireId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the last concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit fetchByConcessionnaireId_Last(
		long concessionnaireId,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator);

	/**
	 * Returns the concessionnaire produits before and after the current concessionnaire produit in the ordered set where concessionnaireId = &#63;.
	 *
	 * @param id the primary key of the current concessionnaire produit
	 * @param concessionnaireId the concessionnaire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	public ConcessionnaireProduit[] findByConcessionnaireId_PrevAndNext(
			long id, long concessionnaireId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Removes all the concessionnaire produits where concessionnaireId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 */
	public void removeByConcessionnaireId(long concessionnaireId);

	/**
	 * Returns the number of concessionnaire produits where concessionnaireId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @return the number of matching concessionnaire produits
	 */
	public int countByConcessionnaireId(long concessionnaireId);

	/**
	 * Returns all the concessionnaire produits where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produits
	 */
	public java.util.List<ConcessionnaireProduit> findByProduitId(
		long produitId);

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
	public java.util.List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end);

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
	public java.util.List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator);

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
	public java.util.List<ConcessionnaireProduit> findByProduitId(
		long produitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit findByProduitId_First(
			long produitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the first concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit fetchByProduitId_First(
		long produitId,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator);

	/**
	 * Returns the last concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit findByProduitId_Last(
			long produitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the last concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit fetchByProduitId_Last(
		long produitId,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator);

	/**
	 * Returns the concessionnaire produits before and after the current concessionnaire produit in the ordered set where produitId = &#63;.
	 *
	 * @param id the primary key of the current concessionnaire produit
	 * @param produitId the produit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	public ConcessionnaireProduit[] findByProduitId_PrevAndNext(
			long id, long produitId,
			com.liferay.portal.kernel.util.OrderByComparator
				<ConcessionnaireProduit> orderByComparator)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Removes all the concessionnaire produits where produitId = &#63; from the database.
	 *
	 * @param produitId the produit ID
	 */
	public void removeByProduitId(long produitId);

	/**
	 * Returns the number of concessionnaire produits where produitId = &#63;.
	 *
	 * @param produitId the produit ID
	 * @return the number of matching concessionnaire produits
	 */
	public int countByProduitId(long produitId);

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or throws a <code>NoSuchConcessionnaireProduitException</code> if it could not be found.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit findByC_P(
			long concessionnaireId, long produitId)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit fetchByC_P(
		long concessionnaireId, long produitId);

	/**
	 * Returns the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching concessionnaire produit, or <code>null</code> if a matching concessionnaire produit could not be found
	 */
	public ConcessionnaireProduit fetchByC_P(
		long concessionnaireId, long produitId, boolean useFinderCache);

	/**
	 * Removes the concessionnaire produit where concessionnaireId = &#63; and produitId = &#63; from the database.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the concessionnaire produit that was removed
	 */
	public ConcessionnaireProduit removeByC_P(
			long concessionnaireId, long produitId)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the number of concessionnaire produits where concessionnaireId = &#63; and produitId = &#63;.
	 *
	 * @param concessionnaireId the concessionnaire ID
	 * @param produitId the produit ID
	 * @return the number of matching concessionnaire produits
	 */
	public int countByC_P(long concessionnaireId, long produitId);

	/**
	 * Caches the concessionnaire produit in the entity cache if it is enabled.
	 *
	 * @param concessionnaireProduit the concessionnaire produit
	 */
	public void cacheResult(ConcessionnaireProduit concessionnaireProduit);

	/**
	 * Caches the concessionnaire produits in the entity cache if it is enabled.
	 *
	 * @param concessionnaireProduits the concessionnaire produits
	 */
	public void cacheResult(
		java.util.List<ConcessionnaireProduit> concessionnaireProduits);

	/**
	 * Creates a new concessionnaire produit with the primary key. Does not add the concessionnaire produit to the database.
	 *
	 * @param id the primary key for the new concessionnaire produit
	 * @return the new concessionnaire produit
	 */
	public ConcessionnaireProduit create(long id);

	/**
	 * Removes the concessionnaire produit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit that was removed
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	public ConcessionnaireProduit remove(long id)
		throws NoSuchConcessionnaireProduitException;

	public ConcessionnaireProduit updateImpl(
		ConcessionnaireProduit concessionnaireProduit);

	/**
	 * Returns the concessionnaire produit with the primary key or throws a <code>NoSuchConcessionnaireProduitException</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit
	 * @throws NoSuchConcessionnaireProduitException if a concessionnaire produit with the primary key could not be found
	 */
	public ConcessionnaireProduit findByPrimaryKey(long id)
		throws NoSuchConcessionnaireProduitException;

	/**
	 * Returns the concessionnaire produit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the concessionnaire produit
	 * @return the concessionnaire produit, or <code>null</code> if a concessionnaire produit with the primary key could not be found
	 */
	public ConcessionnaireProduit fetchByPrimaryKey(long id);

	/**
	 * Returns all the concessionnaire produits.
	 *
	 * @return the concessionnaire produits
	 */
	public java.util.List<ConcessionnaireProduit> findAll();

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
	public java.util.List<ConcessionnaireProduit> findAll(int start, int end);

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
	public java.util.List<ConcessionnaireProduit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator);

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
	public java.util.List<ConcessionnaireProduit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConcessionnaireProduit>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the concessionnaire produits from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of concessionnaire produits.
	 *
	 * @return the number of concessionnaire produits
	 */
	public int countAll();

}