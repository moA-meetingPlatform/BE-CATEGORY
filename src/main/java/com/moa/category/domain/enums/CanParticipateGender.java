package com.moa.category.domain.enums;


import com.moa.global.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum CanParticipateGender implements BaseEnum<Character, String> {
	BOTH('B', "둘다"),
	MAN('M', "남자"),
	WOMAN('W', "여자");

	private final Character code;
	private final String title;

}
