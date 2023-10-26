package com.moa.category.category.infrastructure;

import com.moa.category.category.domain.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestRepository extends JpaRepository<UserInterest,Long> {
}
