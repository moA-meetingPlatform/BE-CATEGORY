package com.moa.category.domain.converter;

import com.moa.category.domain.enums.CompanyCategory;
import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.EnumSet;
import java.util.stream.Collectors;

@Converter
public class CompanyCategoryConverter implements AttributeConverter<EnumSet<CompanyCategory>, String> {

    @Override
    public String convertToDatabaseColumn(EnumSet<CompanyCategory> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }

        // EnumSet을 문자열로 변환
        return attribute.stream()
                .map(CompanyCategory::getCode)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @Override
    public EnumSet<CompanyCategory> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return EnumSet.noneOf(CompanyCategory.class);
        }

        // 문자열을 EnumSet으로 변환
        return Arrays.stream(dbData.split(","))
                .map(Integer::parseInt)
                .map(code -> CompanyCategory.fromCode(code))
                .collect(Collectors.toCollection(() -> EnumSet.noneOf(CompanyCategory.class)));
    }
}

