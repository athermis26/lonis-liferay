package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Terminal;
import com.df.lonis.ventesrest.dto.v1_0.TerminauxConcessionnaire;
import com.df.lonis.ventesrest.internal.resource.v1_0.mapper.TerminalMapper;
import com.df.lonis.ventesrest.resource.v1_0.TerminalResource;
import com.df.lonis.ventesservice.model.*;
import com.df.lonis.ventesservice.service.*;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.NotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/terminal.properties",
	scope = ServiceScope.PROTOTYPE, service = TerminalResource.class
)
public class TerminalResourceImpl extends BaseTerminalResourceImpl {

	@Override
	public Page<Terminal> getTerminauxPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		List<com.df.lonis.ventesservice.model.Terminal> entries = _terminalLocalService.getTerminals(pagination.getStartPosition(), pagination.getEndPosition());

		return Page.of(
				entries.stream().map(_terminalMapper::toDto).collect(java.util.stream.Collectors.toList()), pagination, _terminalLocalService.getTerminalsCount()
		);
	}

	@Override
	public Page<Terminal> getConcessionnaireTerminaux(Long id, String concessionnaireProduitCode, String dateDebut, String dateFin) {

		com.df.lonis.ventesservice.model.Concessionnaire c = _concessionnaireLocalService.fetchConcessionnaire(id);

		if (c == null) {
			throw new NotFoundException("Concessionnaire introuvable: " + id);
		}

		List<com.df.lonis.ventesservice.model.Terminal> entries = _terminalLocalService.findByConcessionnaireId(id);

		return Page.of(
				entries.stream().map(_terminalMapper::toDto).collect(Collectors.toList())
		);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Terminal>, UnsafeFunction<Terminal, Terminal, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	@Reference
	private TerminalMapper _terminalMapper;

	@Reference
	private TerminalLocalService _terminalLocalService;

	@Reference
	private ConcessionnaireLocalService _concessionnaireLocalService;
}