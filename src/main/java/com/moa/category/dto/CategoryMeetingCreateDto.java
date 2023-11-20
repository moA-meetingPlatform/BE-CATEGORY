package com.moa.category.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.moa.category.domain.enums.CanParticipateGender;
import lombok.*;


@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// 모임 생성시 db에 저장되는 정보
public class CategoryMeetingCreateDto {

	private Long categoryMeetingId; //카테고리 모임 리스트 Id

	private Integer subCategoryId;  //하위 카테고리 Id

	private Integer maxAge;    //나이 상한선

	private Integer minAge;    //나이 하한선

	private CanParticipateGender participateGender; //참여가능한 성별

	private String participateCompanies;  //참여가능한 기업 리스트


}