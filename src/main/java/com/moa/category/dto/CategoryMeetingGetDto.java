package com.moa.category.dto;

import com.moa.category.domain.enums.CanParticipateGender;
import com.moa.category.domain.enums.CompanyCategory;
import lombok.*;


@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// 모임 생성시 db에 저장되는 정보
public class CategoryMeetingGetDto {
    private Long meetingId; //카테고리 모임 리스트 Id
    private Integer topCategoryId;   //상위카테고리 Id
    private Integer subCategoryId;  //하위 카테고리 Id
    private Integer maxAge;    //나이 상한선
    private Integer minAge;    //나이 하한선
    private CanParticipateGender participateGender; //참여가능한 성별
    private String participateCompanies;  //참여가능한 기업 리스트
    private Boolean enable;     //모임 종료, 모임 취소, 모임 삭제시 : 0으로 바꾸기
    public Integer getParticipateCompanies() {
        // Enum의 코드를 정수로 반환
        return CompanyCategory.MAJOR_COMPANY.getCode(); // 예를 들어 MAJOR_COMPANY 코드를 반환
    }
}
