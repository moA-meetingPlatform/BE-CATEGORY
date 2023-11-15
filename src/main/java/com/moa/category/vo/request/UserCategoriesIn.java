package com.moa.category.vo.request;

import com.moa.category.domain.enums.CanParticipateGender;
import com.moa.category.domain.enums.CompanyCategory;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCategoriesIn {
    private UUID userUUID;
    private Integer age;
    private CanParticipateGender participateGender; //참여가능한 성별
    private String participateCompanies;  //참여가능한 기업 리스트
}
