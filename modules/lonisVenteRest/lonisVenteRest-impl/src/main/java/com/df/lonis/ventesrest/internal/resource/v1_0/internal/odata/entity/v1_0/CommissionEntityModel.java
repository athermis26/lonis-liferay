package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0;

import com.liferay.portal.odata.entity.BooleanEntityField;
import com.liferay.portal.odata.entity.DateTimeEntityField;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.IntegerEntityField;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.Map;

public class CommissionEntityModel implements EntityModel {

	public CommissionEntityModel() {
		_entityFieldsMap = EntityModel.toEntityFieldsMap(
			new IntegerEntityField("id", locale -> "id"),
			new StringEntityField("code", locale -> "code"),
			new IntegerEntityField("terminalId", locale -> "terminalId"),
			new StringEntityField("status", locale -> "status"),
			new BooleanEntityField("paye", locale -> "paye"),
			new DateTimeEntityField(
				"createdAt", locale -> "createdAt", locale -> "createdAt"));
	}

	@Override
	public Map<String, EntityField> getEntityFieldsMap() {
		return _entityFieldsMap;
	}

	@Override
	public String getName() {
		return "Commission";
	}

	private final Map<String, EntityField> _entityFieldsMap;

}
