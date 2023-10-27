package com.moa.category.infrastructure;

import com.moa.category.domain.ThemeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThemeCategoryRepository extends JpaRepository<ThemeCategory,Integer> {
}
