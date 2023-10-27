package com.moa.category.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserInterestDto {
    private Long userInterest; //사용자관심사리스트Id
    private Long userUuid;   //유저 uuid
    private Integer user_category_id;  // 유저가 선택한 주제카테고리id
    private LocalDateTime regDate;  //유저가 관심사를 선택한 일자
}