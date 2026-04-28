package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Produit;
import com.df.lonis.ventesrest.resource.v1_0.ProduitResource;

import com.df.lonis.ventesservice.service.ProduitLocalService;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.vulcan.pagination.Page;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/produit.properties",
	scope = ServiceScope.PROTOTYPE, service = ProduitResource.class
)
public class ProduitResourceImpl extends BaseProduitResourceImpl {
	@Override
	public Page<Produit> getAllProduits() throws Exception {
        List<com.df.lonis.ventesservice.model.Produit> entries =_produitLocalService.getProduits(-1, -1);

		return Page.of(
			entries.stream().map(this::_toDto).collect(Collectors.toList())
		);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Produit>, UnsafeFunction<Produit, Produit, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	private Produit _toDto(com.df.lonis.ventesservice.model.Produit entry) {
		Produit dto = new Produit();
		dto.setId(entry.getId());
		dto.setCode(entry.getCode());
		dto.setAbreviation(entry.getAbreviation());
		dto.setLibelle(entry.getLibelle());
		dto.setActive(entry.isActive());
		dto.setCreatedAt(entry.getCreatedAt());
		dto.setUpdatedAt(entry.getUpdatedAt());

		return dto;
	}

	@Reference
	private ProduitLocalService _produitLocalService;
}