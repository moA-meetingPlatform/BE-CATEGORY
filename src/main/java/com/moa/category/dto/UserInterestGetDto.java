package com.moa.category.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserInterestGetDto {
    private UUID userUuid;
    private List<Integer> user_category_id;  // 유저가 선택한 주제카테고리id
}