package com.moa.category.vo.response;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingListOut {
    private List<Long> meetingIdList; // 모임 Id 리스트
    private Integer count; // 모임의 갯수
}
