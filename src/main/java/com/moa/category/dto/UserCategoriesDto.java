package com.moa.category.dto;

import com.moa.category.domain.enums.CanParticipateGender;
import com.moa.category.domain.enums.CompanyCategory;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCategoriesDto {
    private UUID userUUID;
    private Integer age;
    private CanParticipateGender canParticipateGender;
    private CompanyCategory canParticipateCompany;
}
