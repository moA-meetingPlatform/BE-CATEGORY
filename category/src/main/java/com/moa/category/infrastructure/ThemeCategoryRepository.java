package com.moa.category.infrastructure;

import com.moa.category.domain.ThemeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeCategoryRepository extends JpaRepository<ThemeCategory,Integer> {
    @Query("SELECT tc FROM ThemeCategory tc WHERE tc.categorySoftDelete = true")
    List<ThemeCategory> findAllByCategoryUseTrue();
}