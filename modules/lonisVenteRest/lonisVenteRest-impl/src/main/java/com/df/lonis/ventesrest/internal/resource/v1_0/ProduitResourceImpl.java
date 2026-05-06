package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Produit;
import com.df.lonis.ventesrest.internal.backend.service.BackendProduitService;
import com.df.lonis.ventesrest.resource.v1_0.ProduitResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/produit.properties",
		scope = ServiceScope.PROTOTYPE,
		service = ProduitResource.class
)
public class ProduitResourceImpl extends BaseProduitResourceImpl {

	@Override
	public Page<Produit> getAllProduits() {
		return Page.of(_backend.listAll());
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Produit>,
					UnsafeFunction<Produit, Produit, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	@Reference
	private BackendProduitService _backend;
}
