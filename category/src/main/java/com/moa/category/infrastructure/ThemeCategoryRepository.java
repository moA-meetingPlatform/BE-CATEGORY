package com.moa.category.infrastructure;

import com.moa.category.domain.MeetingThemeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeCategoryRepository extends JpaRepository<MeetingThemeCategory,Integer> {
    @Query("SELECT tc FROM MeetingThemeCategory tc WHERE tc.categorySoftDelete = true")
    List<MeetingThemeCategory> findAllByCategoryNotDeleted();
}