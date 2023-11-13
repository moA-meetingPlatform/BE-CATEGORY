package com.moa.category.dto;

import com.moa.category.domain.enums.CanParticipateGender;
import com.moa.category.domain.enums.CompanyCategory;
import lombok.*;

import java.util.List;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryMeetingGetDto {
    private Long categoryMeetingId; //카테고리 모임 리스트 Id
    private Integer topCategoryId;   //상위카테고리 Id
    private Integer subCategoryId;  //하위 카테고리 Id
    private Integer maxAgeLimit;    //나이 상한선
    private Integer minAgeLimit;    //나이 하한선
    private CanParticipateGender canParticipateGender; //참여가능한 성별
    private List<CompanyCategory> canParticipateCompanyList;  //참여가능한 기업 리스트
    private Boolean enable;     //모임 종료, 모임 취소, 모임 삭제시 : 0으로 바꾸기
}