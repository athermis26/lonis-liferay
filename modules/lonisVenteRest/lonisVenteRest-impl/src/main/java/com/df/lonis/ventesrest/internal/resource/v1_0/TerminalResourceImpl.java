package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Terminal;
import com.df.lonis.ventesrest.resource.v1_0.TerminalResource;

import com.df.lonis.ventesservice.service.TerminalLocalService;
import com.df.lonis.ventesservice.service.TerminalLocalServiceUtil;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;
import java.util.List;

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
				entries.stream().map(this::_toDto).collect(java.util.stream.Collectors.toList()), pagination, _terminalLocalService.getTerminalsCount()
		);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Terminal>, UnsafeFunction<Terminal, Terminal, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	private Terminal _toDto(com.df.lonis.ventesservice.model.Terminal entry) {
		Terminal dto = new Terminal();
		dto.setId(entry.getId());
		dto.setCodeTerminal(entry.getCodeTerminal());
		dto.setConcessionnaireCode(entry.getConcessionnaireCode());
		dto.setConcessionnaireId(entry.getConcessionnaireId());
		dto.setProduitId(entry.getProduitId());
		dto.setConcessionnaireProduitCode(entry.getConcessionnaireProduitCode());
		dto.setSiteId(entry.getSiteId());
		dto.setCreatedAt(entry.getCreatedAt());
		dto.setUpdatedAt(entry.getUpdatedAt());

		return dto;
	}

	@Reference
	private TerminalLocalService _terminalLocalService;
}