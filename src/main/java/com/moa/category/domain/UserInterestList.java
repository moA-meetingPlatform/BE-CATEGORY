package com.moa.category.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInterestList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //카테고리 모임 리스트
    @Column(nullable = false, name = "user_uuid")
    private UUID userUuid;   //유저 uuid
    @Column(nullable = false, name = "user_category_id")
    private Integer userCategoryId;   //주제카테고리 id
}