package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Evaluation;
import com.df.lonis.reseaurest.resource.v1_0.EvaluationResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/evaluation.properties",
	scope = ServiceScope.PROTOTYPE, service = EvaluationResource.class
)
public class EvaluationResourceImpl extends BaseEvaluationResourceImpl {
	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Evaluation>, UnsafeFunction<Evaluation, Evaluation, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}
}