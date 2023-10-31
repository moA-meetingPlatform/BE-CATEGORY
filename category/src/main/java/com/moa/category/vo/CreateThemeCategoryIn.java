package com.moa.category.vo;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateThemeCategoryIn {
    private Integer topCategoryId;   //상위카테고리 Id
    private String topCategoryName;  //상위 카테고리 이름
    private String subCategoryName;  //하위 카테고리 이름
}
