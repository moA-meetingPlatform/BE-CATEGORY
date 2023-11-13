package com.moa.category.infrastructure;

import com.moa.category.domain.CategoryMeetingList;
import com.moa.category.domain.MeetingThemeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryMeetingListRepository extends JpaRepository<CategoryMeetingList,Long>{
    List<CategoryMeetingList> findBySubCategoryIdAndEnableIsTrue(Integer subCategoryId);
    int countByTopCategoryIdAndEnableIsTrue(Integer topCategoryId);
    List<Long> findMeetingsByCategoryAndPreferences(int categoryId, String birthYear, Character gender, String company);

    List<Long> findMeetingsByUserPreferences(String birthYear, Character gender, String company);
}