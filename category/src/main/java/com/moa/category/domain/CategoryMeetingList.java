package com.moa.category.domain;

import com.moa.global.domain.BaseDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryMeetingList extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //카테고리 모임 리스트
    @Column(nullable = false, name = "top_category_id")
    private Integer topCategoryId;   //상위카테고리 id
    @Column(nullable = false, name = "sub_category_id")
    private Integer subCategoryId;   //하위카테고리 id
    @Column(nullable = false, name = "meeting_id")
    private Long meetingId;
    //todo : 모임 종료, 모임 취소시 delete : 강사님이 말씀핟셨던것처럼 지우는것보다 tinyint로해서 종료나 취소나 삭제시 0으로 바꾸는게 어떨까
}