package com.moa.category.category.infrastructure;

import com.moa.category.category.domain.CategoryMeetingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryMeetingListDto extends JpaRepository<CategoryMeetingList,Long>{

}
