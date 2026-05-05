package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Objectif;
import com.df.lonis.reseaurest.resource.v1_0.ObjectifResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/objectif.properties",
	scope = ServiceScope.PROTOTYPE, service = ObjectifResource.class
)
public class ObjectifResourceImpl extends BaseObjectifResourceImpl {
	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Objectif>, UnsafeFunction<Objectif, Objectif, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}
}