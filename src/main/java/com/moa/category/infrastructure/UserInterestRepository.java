package com.moa.category.infrastructure;

import com.moa.category.domain.UserInterestList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserInterestRepository extends JpaRepository<UserInterestList,Long> {
    List<UserInterestList> findByUserUuid(UUID userUuid);
    void delete(UserInterestList userInterestList);
}