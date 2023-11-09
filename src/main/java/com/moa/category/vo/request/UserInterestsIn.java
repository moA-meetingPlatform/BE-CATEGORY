package com.moa.category.vo.request;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInterestsIn {
    private UUID userUuid;
    private List<Integer> user_category_id;
}
