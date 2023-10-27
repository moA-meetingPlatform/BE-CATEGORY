package com.moa.category.infrastructure;

import com.moa.category.domain.CategoryMeetingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMeetingListDto extends JpaRepository<CategoryMeetingList,Long>{

}