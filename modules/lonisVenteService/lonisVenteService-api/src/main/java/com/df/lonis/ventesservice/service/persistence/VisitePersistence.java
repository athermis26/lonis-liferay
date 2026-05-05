/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence;

import com.df.lonis.ventesservice.exception.NoSuchVisiteException;
import com.df.lonis.ventesservice.model.Visite;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the visite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VisiteUtil
 * @generated
 */
@ProviderType
public interface VisitePersistence extends BasePersistence<Visite> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VisiteUtil} to access the visite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the visites where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the matching visites
	 */
	public java.util.List<Visite> findByCommercialId(long commercialId);

	/**
	 * Returns a range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public java.util.List<Visite> findByCommercialId(
		long commercialId, int start, int end);

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByCommercialId(
		long commercialId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByCommercialId(
		long commercialId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByCommercialId_First(
			long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByCommercialId_First(
		long commercialId,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByCommercialId_Last(
			long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByCommercialId_Last(
		long commercialId,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public Visite[] findByCommercialId_PrevAndNext(
			long id, long commercialId,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Removes all the visites where commercialId = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 */
	public void removeByCommercialId(long commercialId);

	/**
	 * Returns the number of visites where commercialId = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @return the number of matching visites
	 */
	public int countByCommercialId(long commercialId);

	/**
	 * Returns all the visites where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the matching visites
	 */
	public java.util.List<Visite> findByTerminalId(long terminalId);

	/**
	 * Returns a range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public java.util.List<Visite> findByTerminalId(
		long terminalId, int start, int end);

	/**
	 * Returns an ordered range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByTerminalId(
		long terminalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visites where terminalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param terminalId the terminal ID
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByTerminalId(
		long terminalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByTerminalId_First(
			long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the first visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByTerminalId_First(
		long terminalId,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the last visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByTerminalId_Last(
			long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the last visite in the ordered set where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByTerminalId_Last(
		long terminalId,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the visites before and after the current visite in the ordered set where terminalId = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param terminalId the terminal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public Visite[] findByTerminalId_PrevAndNext(
			long id, long terminalId,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Removes all the visites where terminalId = &#63; from the database.
	 *
	 * @param terminalId the terminal ID
	 */
	public void removeByTerminalId(long terminalId);

	/**
	 * Returns the number of visites where terminalId = &#63;.
	 *
	 * @param terminalId the terminal ID
	 * @return the number of matching visites
	 */
	public int countByTerminalId(long terminalId);

	/**
	 * Returns all the visites where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the matching visites
	 */
	public java.util.List<Visite> findByStatut(String statut);

	/**
	 * Returns a range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public java.util.List<Visite> findByStatut(
		String statut, int start, int end);

	/**
	 * Returns an ordered range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByStatut(
		String statut, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visites where statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByStatut(
		String statut, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByStatut_First(
			String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the first visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByStatut_First(
		String statut,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the last visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByStatut_Last(
			String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the last visite in the ordered set where statut = &#63;.
	 *
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByStatut_Last(
		String statut,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the visites before and after the current visite in the ordered set where statut = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public Visite[] findByStatut_PrevAndNext(
			long id, String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Removes all the visites where statut = &#63; from the database.
	 *
	 * @param statut the statut
	 */
	public void removeByStatut(String statut);

	/**
	 * Returns the number of visites where statut = &#63;.
	 *
	 * @param statut the statut
	 * @return the number of matching visites
	 */
	public int countByStatut(String statut);

	/**
	 * Returns all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @return the matching visites
	 */
	public java.util.List<Visite> findByC_S(long commercialId, String statut);

	/**
	 * Returns a range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public java.util.List<Visite> findByC_S(
		long commercialId, String statut, int start, int end);

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByC_S(
		long commercialId, String statut, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and statut = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByC_S(
		long commercialId, String statut, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByC_S_First(
			long commercialId, String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByC_S_First(
		long commercialId, String statut,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByC_S_Last(
			long commercialId, String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByC_S_Last(
		long commercialId, String statut,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63; and statut = &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public Visite[] findByC_S_PrevAndNext(
			long id, long commercialId, String statut,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Removes all the visites where commercialId = &#63; and statut = &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 */
	public void removeByC_S(long commercialId, String statut);

	/**
	 * Returns the number of visites where commercialId = &#63; and statut = &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param statut the statut
	 * @return the number of matching visites
	 */
	public int countByC_S(long commercialId, String statut);

	/**
	 * Returns all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @return the matching visites
	 */
	public java.util.List<Visite> findByC_D(long commercialId, Date dateVisite);

	/**
	 * Returns a range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of matching visites
	 */
	public java.util.List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end);

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching visites
	 */
	public java.util.List<Visite> findByC_D(
		long commercialId, Date dateVisite, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByC_D_First(
			long commercialId, Date dateVisite,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the first visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByC_D_First(
		long commercialId, Date dateVisite,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite
	 * @throws NoSuchVisiteException if a matching visite could not be found
	 */
	public Visite findByC_D_Last(
			long commercialId, Date dateVisite,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Returns the last visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching visite, or <code>null</code> if a matching visite could not be found
	 */
	public Visite fetchByC_D_Last(
		long commercialId, Date dateVisite,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns the visites before and after the current visite in the ordered set where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param id the primary key of the current visite
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public Visite[] findByC_D_PrevAndNext(
			long id, long commercialId, Date dateVisite,
			com.liferay.portal.kernel.util.OrderByComparator<Visite>
				orderByComparator)
		throws NoSuchVisiteException;

	/**
	 * Removes all the visites where commercialId = &#63; and dateVisite &ge; &#63; from the database.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 */
	public void removeByC_D(long commercialId, Date dateVisite);

	/**
	 * Returns the number of visites where commercialId = &#63; and dateVisite &ge; &#63;.
	 *
	 * @param commercialId the commercial ID
	 * @param dateVisite the date visite
	 * @return the number of matching visites
	 */
	public int countByC_D(long commercialId, Date dateVisite);

	/**
	 * Caches the visite in the entity cache if it is enabled.
	 *
	 * @param visite the visite
	 */
	public void cacheResult(Visite visite);

	/**
	 * Caches the visites in the entity cache if it is enabled.
	 *
	 * @param visites the visites
	 */
	public void cacheResult(java.util.List<Visite> visites);

	/**
	 * Creates a new visite with the primary key. Does not add the visite to the database.
	 *
	 * @param id the primary key for the new visite
	 * @return the new visite
	 */
	public Visite create(long id);

	/**
	 * Removes the visite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the visite
	 * @return the visite that was removed
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public Visite remove(long id) throws NoSuchVisiteException;

	public Visite updateImpl(Visite visite);

	/**
	 * Returns the visite with the primary key or throws a <code>NoSuchVisiteException</code> if it could not be found.
	 *
	 * @param id the primary key of the visite
	 * @return the visite
	 * @throws NoSuchVisiteException if a visite with the primary key could not be found
	 */
	public Visite findByPrimaryKey(long id) throws NoSuchVisiteException;

	/**
	 * Returns the visite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the visite
	 * @return the visite, or <code>null</code> if a visite with the primary key could not be found
	 */
	public Visite fetchByPrimaryKey(long id);

	/**
	 * Returns all the visites.
	 *
	 * @return the visites
	 */
	public java.util.List<Visite> findAll();

	/**
	 * Returns a range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @return the range of visites
	 */
	public java.util.List<Visite> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of visites
	 */
	public java.util.List<Visite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator);

	/**
	 * Returns an ordered range of all the visites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VisiteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of visites
	 * @param end the upper bound of the range of visites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of visites
	 */
	public java.util.List<Visite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Visite>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the visites from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of visites.
	 *
	 * @return the number of visites
	 */
	public int countAll();

}