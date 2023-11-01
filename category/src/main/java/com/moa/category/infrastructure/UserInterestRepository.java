package com.moa.category.infrastructure;

import com.moa.category.domain.UserInterestList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestRepository extends JpaRepository<UserInterestList,Long> {
}