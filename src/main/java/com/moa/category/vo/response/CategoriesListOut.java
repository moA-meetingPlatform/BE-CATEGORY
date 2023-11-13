package com.moa.category.vo.response;

import com.moa.category.domain.enums.CompanyCategory;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesListOut {
    private Integer topCategoryId;   // 상위 카테고리 Id
    private String topCategoryName;  // 상위 카테고리 이름
    private List<SubCategory> subCategories; // 하위 카테고리 리스트
    private Integer meetingCount;    // 해당 상위 카테고리에 포함되는 모임의 개수
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubCategory {
        private Integer id;   // 하위 카테고리 Id
        private String name;  // 하위 카테고리 이름
    }
}
