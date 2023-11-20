package com.moa.category.infrastructure.kafka.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moa.category.domain.enums.CanParticipateGender;
import com.moa.category.dto.CategoryMeetingCreateDto;
import com.moa.global.config.exception.CustomException;
import com.moa.global.config.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class CreateMeetingConsumer {

	private final ObjectMapper objectMapper;
	@KafkaListener(topics = "meeting-create", groupId = "meeting-create")
	public void consume(String message){
		log.debug(String.format("Consumed message : %s", message));

		Map<Object, Object> map;

		try {
			map = objectMapper.readValue(message, Map.class);
		} catch (JsonProcessingException e) {
			log.error("JsonProcessingException : {}", e.getMessage() + "\n" + message);
			throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR);
		}
		log.debug("여까진 됨");

		CategoryMeetingCreateDto dto = CategoryMeetingCreateDto.builder()
			.categoryMeetingId(getLong(map.get("categoryMeetingId")))
			.topCategoryId(getInteger(map.get("topCategoryId")))
			.subCategoryId(getInteger(map.get("subCategoryId")))
			.maxAge(getInteger(map.get("maxAge")))
			.minAge(getInteger(map.get("minAge")))
			.participateGender(CanParticipateGender.valueOf(String.valueOf(map.get("participateGender"))))
			.participateCompanies(String.valueOf(map.get("participateCompanies")))
			.build();

		log.debug("dto : {}", dto.toString());

	}

	private Long getLong(Object o) {
		String str = String.valueOf(o);
		if("null".equals(str)) {
			return null;
		}
		return Long.parseLong(str);
	}

	private Integer getInteger(Object o) {
		String str = String.valueOf(o);
		if("null".equals(str)) {
			return null;
		}
		return Integer.parseInt(str);
	}
}
