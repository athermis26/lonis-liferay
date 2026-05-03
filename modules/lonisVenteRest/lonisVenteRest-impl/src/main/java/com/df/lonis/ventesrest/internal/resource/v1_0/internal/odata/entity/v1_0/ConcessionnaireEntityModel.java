package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0;

import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.IntegerEntityField;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class ConcessionnaireEntityModel implements EntityModel {

	public ConcessionnaireEntityModel() {
		_entityFieldsMap = EntityModel.toEntityFieldsMap(
			new IntegerEntityField("id", locale -> "id"),
			new StringEntityField("uid", locale -> "uid"),
			new StringEntityField("nom", locale -> "nom"),
			new StringEntityField("prenoms", locale -> "prenoms"),
			new StringEntityField("telephone", locale -> "telephone"),
			new StringEntityField("email", locale -> "email"));
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	@Override
	public String getName() {
		return "Concessionnaire";
	}

	private final Map<String, EntityField> _entityFieldsMap;

}
