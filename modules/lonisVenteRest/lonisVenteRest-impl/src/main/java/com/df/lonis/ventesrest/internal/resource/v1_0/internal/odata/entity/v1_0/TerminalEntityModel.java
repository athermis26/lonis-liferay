package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0;

import com.liferay.portal.odata.entity.DateTimeEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.IntegerEntityField;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class TerminalEntityModel implements EntityModel {

	public TerminalEntityModel() {
		_entityFieldsMap = EntityModel.toEntityFieldsMap(
			new IntegerEntityField("id", locale -> "id"),
			new StringEntityField("codeTerminal", locale -> "codeTerminal"),
			new IntegerEntityField(
				"concessionnaireId", locale -> "concessionnaireId"),
			new StringEntityField(
				"concessionnaireCode", locale -> "concessionnaireCode"),
			new IntegerEntityField("produitId", locale -> "produitId"),
			new IntegerEntityField("siteId", locale -> "siteId"),
			new StringEntityField(
				"concessionnaireProduitCode",
				locale -> "concessionnaireProduitCode"),
			new DateTimeEntityField(
				"createdAt", locale -> "createdAt", locale -> "createdAt"));
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	@Override
	public String getName() {
		return "Terminal";
	}

	private final Map<String, EntityField> _entityFieldsMap;

}
