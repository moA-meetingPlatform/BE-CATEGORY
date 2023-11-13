package com.moa.category.vo.request;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCategoriesIn {
    private UUID userUUID;
    private String birthYear;
    private Character gender;
    private String company;
}
