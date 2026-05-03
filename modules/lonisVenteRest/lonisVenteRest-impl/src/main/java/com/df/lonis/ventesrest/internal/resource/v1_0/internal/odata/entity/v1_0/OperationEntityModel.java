package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0;

import com.liferay.portal.odata.entity.DateTimeEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.IntegerEntityField;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class OperationEntityModel implements EntityModel {

	public OperationEntityModel() {
		_entityFieldsMap = EntityModel.toEntityFieldsMap(
			new IntegerEntityField("id", locale -> "id"),
			new StringEntityField("code", locale -> "code"),
			new StringEntityField("reference", locale -> "reference"),
			new IntegerEntityField("montant", locale -> "montant"),
			new IntegerEntityField("montantReel", locale -> "montantReel"),
			new StringEntityField("statut", locale -> "statut"),
			new IntegerEntityField("terminalId", locale -> "terminalId"),
			new StringEntityField("guichet", locale -> "guichet"),
			new DateTimeEntityField(
				"dateOperation", locale -> "dateOperation",
				locale -> "dateOperation"));
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	@Override
	public String getName() {
		return "Operation";
	}

	private final Map<String, EntityField> _entityFieldsMap;

}
