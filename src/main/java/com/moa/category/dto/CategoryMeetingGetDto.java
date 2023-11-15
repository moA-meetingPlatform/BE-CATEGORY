package com.moa.category.dto;

import com.moa.category.domain.enums.CanParticipateGender;
import com.moa.category.domain.enums.CompanyCategory;
import lombok.*;

import java.util.List;
import java.util.Set;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// 모임 생성시 db에 저장되는 정보
public class CategoryMeetingGetDto {
    private Long categoryMeetingId; //카테고리 모임 리스트 Id
    private Integer topCategoryId;   //상위카테고리 Id
    private Integer subCategoryId;  //하위 카테고리 Id
    private Integer maxAge;    //나이 상한선
    private Integer minAge;    //나이 하한선
    private CanParticipateGender participateGender; //참여가능한 성별
    private String participateCompanies;  //참여가능한 기업 리스트
    private Boolean enable;     //모임 종료, 모임 취소, 모임 삭제시 : 0으로 바꾸기
}