package com.moa.category.infrastructure;

import com.moa.category.domain.CategoryMeetingList;
import com.moa.category.domain.MeetingThemeCategory;
import com.moa.category.domain.enums.CanParticipateGender;
import com.moa.category.domain.enums.CompanyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CategoryMeetingListRepository extends JpaRepository<CategoryMeetingList,Long>, JpaSpecificationExecutor<CategoryMeetingList> {
    int countByTopCategoryIdAndEnableIsTrue(Integer topCategoryId);

}