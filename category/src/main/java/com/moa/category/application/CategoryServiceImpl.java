package com.moa.category.application;


import com.moa.category.domain.QCategoryMeetingList;
import com.moa.category.domain.QThemeCategory;
import com.moa.category.domain.ThemeCategory;
import com.moa.category.infrastructure.ThemeCategoryRepository;
import com.moa.category.vo.CategoriesListOut;
import com.querydsl.core.group.GroupBy;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService{
    private final JPAQueryFactory query;
    private final ThemeCategoryRepository themeCategoryRepository;
    @Override
    public List<CategoriesListOut> categoriesList() {
        List<ThemeCategory> themeCategories = themeCategoryRepository.findAllByCategoryUseTrue();

        Map<Integer, List<ThemeCategory>> groupedData = themeCategories.stream()
                .filter(tc -> tc.getTopCategory() != null && tc.getId() != null) // 상위 카테고리가 null이 아닌 것만 필터링
                .collect(Collectors.groupingBy(tc -> tc.getTopCategory().getId()));

        return groupedData.values().stream()
                .map(tcs -> {
                    ThemeCategory topCategory = tcs.get(0).getTopCategory();
                    List<CategoriesListOut.SubCategory> subCategories = tcs.stream()
                            .map(tc -> new CategoriesListOut.SubCategory(tc.getId(), tc.getCategoryName()))
                            .collect(Collectors.toList());
                    return new CategoriesListOut(topCategory.getId(), topCategory.getCategoryName(), subCategories);
                })
                .collect(Collectors.toList());
    }


}
