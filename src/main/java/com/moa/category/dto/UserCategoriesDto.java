package com.moa.category.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCategoriesDto {
    private UUID userUUID;
    private String birthYear;
    private Character Gender;
    private String company;
}
