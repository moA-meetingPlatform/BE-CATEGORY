package com.moa.category.infrastructure;

import com.moa.category.domain.CategoryMeetingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryMeetingListRepository extends JpaRepository<CategoryMeetingList,Long>{
    List<CategoryMeetingList> findByTopCategoryIdAndEnableIsTrue(Integer topCategoryId);
    List<CategoryMeetingList> findBySubCategoryIdAndEnableIsTrue(Integer subCategoryId);
}