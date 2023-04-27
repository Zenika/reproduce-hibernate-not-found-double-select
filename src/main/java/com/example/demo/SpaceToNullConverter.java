package com.example.demo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SpaceToNullConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return " ".equals(attribute) ? null : attribute;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}