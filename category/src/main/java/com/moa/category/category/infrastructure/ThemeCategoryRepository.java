package com.moa.category.category.infrastructure;

import com.moa.category.category.domain.ThemeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeCategoryRepository extends JpaRepository<ThemeCategory,Integer> {
}
