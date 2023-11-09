package com.moa.global;


import jakarta.persistence.AttributeConverter;

import java.util.Arrays;
import java.util.Objects;


/**
 * BaseEnum을 구현한 Enum 클래스를 DB에 저장하기 위해 AttributeConverter를 구현한 추상 클래스, BaseEnum의 code 값을 DB에 저장한다.
 * <p>
 * 구현 및 사용 방법:
 * <br><br>
 *
 * - BaseEnum를 구현한 Enum 클래스를 생성하고, 이 클래스를 상속받는 Converter를 생성한다. <br>
 * - Converter를 생성할 때, BaseEnum을 구현한 Enum 클래스를 제네릭으로 넘겨준다. <br>
 * - (Enum이 아니거나 BaseEnum을 구현하지 않았을 경우 E 위치에 들어갈 수 없다. ) <br>
 * - 부모 생성자를 호출하는 기본 생성자를 만들어준다. <br>
 * </p>
 *
 * @param <E> BaseEnum을 구현한 Enum 클래스
 * @param <T> BaseEnum의 code 타입
 * @param <K> BaseEnum의 title 타입
 */
public abstract class AbstractBaseEnumConverter<E extends Enum<E> & BaseEnum<T, K>, T, K> implements AttributeConverter<E, T> {

	private final Class<E> clazz;


	/**
	 * BaseEnum을 구현한 Enum 클래스를 제네릭으로 받아서, Converter를 생성한다.
	 * 리플렉션을 활용하면 파라미터를 받지 않고 구현할 수 있지만 성능이 떨어지며 로직이 복잡해지므로
	 * 파라미터를 받아서 구현한다.
	 *
	 * @param clazz BaseEnum을 구현한 Enum 클래스
	 */
	protected AbstractBaseEnumConverter(Class<E> clazz) {
		this.clazz = clazz;
	}


	/**
	 * BaseEnum의 code 값을 DB에 저장한다.
	 *
	 * @param attribute BaseEnum을 구현한 Enum 클래스
	 * @return BaseEnum의 code 값
	 */
	@Override
	public final T convertToDatabaseColumn(E attribute) {
		return attribute.getCode();
	}


	/**
	 * DB에서 읽어온 code 값을 BaseEnum의 code 값과 비교하여,
	 * 일치하는 Enum 클래스를 반환한다.
	 *
	 * @param dbData DB에서 읽어온 code 값, enum으로 바꿀 데이터
	 * @return BaseEnum을 구현한 Enum
	 */
	@Override
	public final E convertToEntityAttribute(T dbData) {
		// DB에서 읽어온 값이 null이면 null을 반환한다.
		if (Objects.isNull(dbData)) {
			return null;
		}

		/*
			DB에서 읽어온 값이 BaseEnum의 code 값과 일치하는 Enum 클래스를 찾아서 반환한다.
			getEnumConstants()는 Enum 클래스의 모든 상수를 배열로 반환한다.
			일치하는 값이 없으면 IllegalArgumentException을 발생시킨다.
		 */
		return Arrays.stream(clazz.getEnumConstants())
				.filter(e -> e.getCode().equals(dbData))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Unknown code: " + dbData));
	}

}