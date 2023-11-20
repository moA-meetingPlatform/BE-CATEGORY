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

		CategoryMeetingCreateDto dto = CategoryMeetingCreateDto.builder()
			.categoryMeetingId((Long) map.get("categoryMeetingId"))
			.topCategoryId((Integer) map.get("topCategoryId"))
			.subCategoryId((Integer) map.get("subCategoryId"))
			.maxAge((Integer) map.get("maxAge"))
			.minAge((Integer) map.get("minAge"))
			.participateGender((CanParticipateGender) map.get("participateGender"))
			.participateCompanies((String) map.get("participateCompanies"))
			.build();

		log.debug("dto : {}", dto.toString());

	}
}
