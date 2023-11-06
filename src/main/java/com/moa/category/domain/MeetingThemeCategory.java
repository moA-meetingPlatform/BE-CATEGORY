package com.moa.category.domain;

import com.moa.global.domain.BaseDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingThemeCategory extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //주제카테고리 id
    @Column(nullable = false, length =45, name = "category_name")
    private String categoryName;   //카테고리명
    @Column(nullable = false, name = "category_soft_delete", columnDefinition = "TINYINT(1)")
    private Boolean categorySoftDelete;    // 카테고리 사용여부 -사용중:1 사용X:0
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="top_category_id")
    private MeetingThemeCategory topCategory;    //자기 참조 : 상위카테고리 id, null 가능
}