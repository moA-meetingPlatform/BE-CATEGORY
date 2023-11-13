package com.moa.category.vo.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipateMeetingOut {
    private Long meetingId; // 모임 Id
    private Integer maxAgeLimit; // 최대 나이 제한
    private Integer minAgeLimit; // 최소 나이 제한
    private Character canParticipantGender; // 참여 가능한 성별
    private Integer canParticipateCompanyList; // 참여 가능한 기업 리스트
}
