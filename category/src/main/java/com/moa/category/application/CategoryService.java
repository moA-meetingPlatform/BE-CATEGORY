package com.moa.category.application;

import com.moa.category.dto.CategoryMeetingGetDto;
import com.moa.category.dto.UserInterestGetDto;
import com.moa.category.vo.CategoriesListOut;
import com.moa.category.vo.CreateThemeCategoryIn;
import com.moa.category.vo.DisableMeetingCategoryIn;

import java.util.List;

public interface CategoryService {
    List<CategoriesListOut> categoriesList();

    void createUserInterests(UserInterestGetDto UserInterestGetDto);

    void createThemeCategory(CreateThemeCategoryIn createThemeCategoryIn);

    void createMeetingCategory(CategoryMeetingGetDto categoryMeetingGetDto);

    void disableMeetingCategory(Long meetingId);

    void updateUserInterests(UserInterestGetDto map);
}
