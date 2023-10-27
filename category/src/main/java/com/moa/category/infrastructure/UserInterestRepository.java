package com.moa.category.infrastructure;

import com.moa.category.domain.UserInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterestRepository extends JpaRepository<UserInterest,Long> {
}
