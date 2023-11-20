package com.moa.category.vo.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingDetailOut {
    private Long meetingId; //카테고리 모임 리스트 Id
    private Integer maxAge;    //나이 상한선
    private Integer minAge;    //나이 하한선
    private String participateGender; //참여가능한 성별
}
