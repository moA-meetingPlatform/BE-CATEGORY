package com.moa.category.domain.converter;

import com.moa.category.domain.enums.CompanyCategory;
import jakarta.persistence.AttributeConverter;

import java.util.ArrayList;
import java.util.List;

public class CompanyCategoryConverter implements AttributeConverter<List<CompanyCategory>, Integer> {

    @Override
    public Integer convertToDatabaseColumn(List<CompanyCategory> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }

        int result = 0;
        for (CompanyCategory category : attribute) {
            result |= category.getCode();
        }
        return result;
    }

    @Override
    public List<CompanyCategory> convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }

        List<CompanyCategory> categories = new ArrayList<>();
        for (CompanyCategory category : CompanyCategory.values()) {
            if ((dbData & category.getCode()) != 0) {
                categories.add(category);
            }
        }
        return categories;
    }
}
