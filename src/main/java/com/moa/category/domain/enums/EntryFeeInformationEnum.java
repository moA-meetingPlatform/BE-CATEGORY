package com.moa.category.domain.enums;

import com.moa.global.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum EntryFeeInformationEnum implements BaseEnum<String, String> {
    CONTENTS("C", "콘텐츠 제작비", "운영비"),
    HOST("H", "호스트 수고비", "운영비"),
    NO_SHOW("N", "노쇼 방지비", "모임비"),
    SPACE("S", "대관료", "모임비"),
    MATERIAL("M", "재료비", "모임비"),
    REFRESHMENT("R", "다과비", "모임비"),
    PLATFORM("P", "플랫폼 수수료", "기타");
    private final String code;
    private final String title;
    private final String topEntryFeeName;
}
