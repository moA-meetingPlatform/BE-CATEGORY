// 패키지 선언: 현재 클래스는 'com.moa.user.config.mapper' 패키지에 위치합니다.
package com.moa.global.config;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

	/**
	 * ModelMapper 객체를 생성하여 반환합니다.
	 * ModelMapper는 객체 간의 자동 매핑을 도와주는 라이브러리로,
	 * 예를 들면, request 객체를 DTO로 변환하거나 그 반대의 작업을 수행할 때 유용합니다.
	 *
	 * @return ModelMapper 객체 (STRICT, PRIVATE 설정)
	 */
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		// ModelMapper 객체의 설정을 변경합니다.
		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT) // 매핑 전략을 엄격하게 설정합니다.
				.setFieldMatchingEnabled(true)  // 필드 매칭을 활성화합니다.
				.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE); // 필드 접근 수준을 PRIVATE로 설정합니다.
		return modelMapper;
	}

}