package com.moa.category.domain.converter;

import com.moa.global.AbstractBaseEnumConverter;
import com.moa.category.domain.enums.CanParticipateGender;

public class CanParticipateGenderConverter extends AbstractBaseEnumConverter<CanParticipateGender, Character, String> {

    public CanParticipateGenderConverter() {
        super(CanParticipateGender.class);
    }
}
