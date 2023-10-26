package com.moa.category.category.dto;

import lombok.*;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThemeCategoryDto {
    private Integer themeCategoryId;    //주제 카테고리 Id
    private String categoryName;    // 주제 카테고리 이름
    private Boolean categoryUse;    //카테고리 사용여부 1: 사용 0:사용X
//    private Integer categoryId;     //상위카테고리 id -> 자기참조
    //todo : 자기 참조 일경우에도 dto를 작성해야하나요 ?
}
