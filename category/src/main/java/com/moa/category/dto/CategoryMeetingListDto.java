package com.moa.category.dto;

import lombok.*;
import java.time.LocalDateTime;
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryMeetingListDto {
    private Long categoryMeetingListId; //카테고리 모임 리스트 Id
    private Integer topCategoryId;   //상위카테고리 Id
    private Integer subCategoryId;  //하위 카테고리 Id
    private LocalDateTime regDate;  //모임 생성일자
}
