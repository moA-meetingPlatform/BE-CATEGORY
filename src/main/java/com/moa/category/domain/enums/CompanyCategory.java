package com.moa.category.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CompanyCategory {
    MAJOR_COMPANY(1, "대기업"),
    MAJOR_COMPANY_SUBSIDIARY(2, "대기업 자회사"),
    MEDIUM_COMPANY(3, "중견기업"),
    PUBLIC_CORPORATION(4, "공공기관"),
    PUBLIC_INSTITUTION(5, "공기업"),
    FOREIGN_COMPANY(6, "외국계기업"),
    VENTURE_COMPANY(7, "벤처기업"),
    SMALL_COMPANY(8, "중소기업");


    private final Integer code;
    private final String title;
}
