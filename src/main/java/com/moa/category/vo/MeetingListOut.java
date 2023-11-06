package com.moa.category.vo;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingListOut {
    private List<Long> meetingIdList; // 모임 Id 리스트
}
