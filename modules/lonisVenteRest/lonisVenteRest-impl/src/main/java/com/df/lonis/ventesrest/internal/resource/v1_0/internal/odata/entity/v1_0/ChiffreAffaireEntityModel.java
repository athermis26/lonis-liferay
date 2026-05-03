package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0;

import com.liferay.portal.odata.entity.*;

import java.util.Map;

public class ChiffreAffaireEntityModel implements EntityModel {
    public ChiffreAffaireEntityModel() {
        _entityFieldsMap = EntityModel.toEntityFieldsMap(
                new IntegerEntityField("terminalId", locale -> "terminalId"),
                new DateTimeEntityField(
                        "date",
                        locale -> "date",
                        locale -> "date"),
                new StringEntityField("codeTerminal", locale -> "codeTerminal"));
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return _entityFieldsMap;
    }

    @Override
    public String getName() {
        return "ChiffreAffaire";
    }

    private final Map<String, EntityField> _entityFieldsMap;
}
