package com.moa.category.vo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingCategoryIn {
    private Long categoryMeetingId; //카테고리 모임 리스트 Id
    private Integer topCategoryId;   //상위카테고리 Id
    private Integer subCategoryId;  //하위 카테고리 Id
}
