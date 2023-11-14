package ru.otus.jdbc.mapper;

import java.lang.reflect.Field;
import java.util.List;

public class EntitySQLMetaDataImpl implements EntitySQLMetaData {
    private EntityClassMetaData entityMetaData;

    public EntitySQLMetaDataImpl(EntityClassMetaData entityMetaData) {
        this.entityMetaData = entityMetaData;
    }

    @Override
    public String getSelectAllSql() {
        String fieldsName = "";
        Boolean flFirst = false;
        for (Field field : (List<Field>) entityMetaData.getAllFields()
        ) {
            fieldsName = fieldsName + (flFirst == true ? ", " : "") + field.getName();
            flFirst = true;
        }
        return "select " + fieldsName + " from " + entityMetaData.getName();
    }

    @Override
    public String getSelectByIdSql() {
        String fieldsName = "";
        Boolean flFirst = false;
        for (Field field : (List<Field>) entityMetaData.getAllFields()
        ) {
            fieldsName = fieldsName + (flFirst == true ? ", " : "") + field.getName();
            flFirst = true;
        }
        return "select " + fieldsName + " from " + entityMetaData.getName() + " where " + entityMetaData.getIdField().getName() + " = ?";
    }

    @Override
    public String getInsertSql() {
        String fieldsName = "";
        Boolean flFirst = false;
        for (Field field : (List<Field>) entityMetaData.getFieldsWithoutId()
        ) {
            fieldsName = fieldsName + (flFirst == true ? ", " : "") + field.getName();
            flFirst = true;
        }
        fieldsName =  "insert into " + entityMetaData.getName() + "(" + fieldsName + ") values (";
        flFirst = false;
        for (Field field : (List<Field>) entityMetaData.getFieldsWithoutId()
        ) {
            fieldsName = fieldsName + (flFirst == true ? ",?" : "?");
            flFirst = true;
        }
        return fieldsName + ")";
    }

    @Override
    public String getUpdateSql() {
        String fieldsName = "";
        for (Field field : (List<Field>) entityMetaData.getFieldsWithoutId()
        ) {
            fieldsName = fieldsName + field.getName() + " = ? ";
        }
        return "update " + entityMetaData.getName() + " set " + fieldsName + " where " + entityMetaData.getIdField().getName() + " = ?";
    }

    @Override
    public EntityClassMetaData getEntityClassMetaData() {
        return entityMetaData;
    }

}
