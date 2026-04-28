/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TerminalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TerminalLocalService
 * @generated
 */
public class TerminalLocalServiceWrapper
	implements ServiceWrapper<TerminalLocalService>, TerminalLocalService {

	public TerminalLocalServiceWrapper() {
		this(null);
	}

	public TerminalLocalServiceWrapper(
		TerminalLocalService terminalLocalService) {

		_terminalLocalService = terminalLocalService;
	}

	/**
	 * Adds the terminal to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TerminalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @return the terminal that was added
	 */
	@Override
	public com.df.lonis.ventesservice.model.Terminal addTerminal(
		com.df.lonis.ventesservice.model.Terminal terminal) {

		return _terminalLocalService.addTerminal(terminal);
	}

	@Override
	public int countByConcessionnaireId(long concessionnaireId) {
		return _terminalLocalService.countByConcessionnaireId(
			concessionnaireId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _terminalLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new terminal with the primary key. Does not add the terminal to the database.
	 *
	 * @param id the primary key for the new terminal
	 * @return the new terminal
	 */
	@Override
	public com.df.lonis.ventesservice.model.Terminal createTerminal(long id) {
		return _terminalLocalService.createTerminal(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _terminalLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the terminal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TerminalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal that was removed
	 * @throws PortalException if a terminal with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Terminal deleteTerminal(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _terminalLocalService.deleteTerminal(id);
	}

	/**
	 * Deletes the terminal from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TerminalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @return the terminal that was removed
	 */
	@Override
	public com.df.lonis.ventesservice.model.Terminal deleteTerminal(
		com.df.lonis.ventesservice.model.Terminal terminal) {

		return _terminalLocalService.deleteTerminal(terminal);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _terminalLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _terminalLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _terminalLocalService.dynamicQuery();
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

		return _terminalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.TerminalModelImpl</code>.
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

		return _terminalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.TerminalModelImpl</code>.
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

		return _terminalLocalService.dynamicQuery(
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

		return _terminalLocalService.dynamicQueryCount(dynamicQuery);
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

		return _terminalLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.df.lonis.ventesservice.model.Terminal fetchTerminal(long id) {
		return _terminalLocalService.fetchTerminal(id);
	}

	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Terminal>
		findByConcessionnaireId(long concessionnaireId) {

		return _terminalLocalService.findByConcessionnaireId(concessionnaireId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _terminalLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _terminalLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _terminalLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _terminalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the terminal with the primary key.
	 *
	 * @param id the primary key of the terminal
	 * @return the terminal
	 * @throws PortalException if a terminal with the primary key could not be found
	 */
	@Override
	public com.df.lonis.ventesservice.model.Terminal getTerminal(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _terminalLocalService.getTerminal(id);
	}

	/**
	 * Returns a range of all the terminals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.df.lonis.ventesservice.model.impl.TerminalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of terminals
	 * @param end the upper bound of the range of terminals (not inclusive)
	 * @return the range of terminals
	 */
	@Override
	public java.util.List<com.df.lonis.ventesservice.model.Terminal>
		getTerminals(int start, int end) {

		return _terminalLocalService.getTerminals(start, end);
	}

	/**
	 * Returns the number of terminals.
	 *
	 * @return the number of terminals
	 */
	@Override
	public int getTerminalsCount() {
		return _terminalLocalService.getTerminalsCount();
	}

	/**
	 * Updates the terminal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TerminalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @return the terminal that was updated
	 */
	@Override
	public com.df.lonis.ventesservice.model.Terminal updateTerminal(
		com.df.lonis.ventesservice.model.Terminal terminal) {

		return _terminalLocalService.updateTerminal(terminal);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _terminalLocalService.getBasePersistence();
	}

	@Override
	public TerminalLocalService getWrappedService() {
		return _terminalLocalService;
	}

	@Override
	public void setWrappedService(TerminalLocalService terminalLocalService) {
		_terminalLocalService = terminalLocalService;
	}

	private TerminalLocalService _terminalLocalService;

}