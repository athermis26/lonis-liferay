package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0;

import com.liferay.portal.odata.entity.BooleanEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.IntegerEntityField;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class SiteEntityModel implements EntityModel {

	public SiteEntityModel() {
		_entityFieldsMap = EntityModel.toEntityFieldsMap(
			new IntegerEntityField("id", locale -> "id"),
			new StringEntityField("libelle", locale -> "libelle"),
			new IntegerEntityField("type", locale -> "type"),
			new IntegerEntityField("parentId", locale -> "parentId"),
			new StringEntityField("code", locale -> "code"),
			new StringEntityField("codeProvinov", locale -> "codeProvinov"),
			new BooleanEntityField("status", locale -> "status"));
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	@Override
	public String getName() {
		return "Site";
	}

	private final Map<String, EntityField> _entityFieldsMap;

}
