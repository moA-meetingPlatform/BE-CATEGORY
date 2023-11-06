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
    private Long meetingId; //모임 id
    @Column(nullable = false, name = "enable", columnDefinition = "TINYINT(1) default 1")
    private Boolean enable;     //모임 종료, 모임 취소, 모임 삭제시 : 0으로 바꾸기

    public void disable() {
        this.enable = false;
    }
}