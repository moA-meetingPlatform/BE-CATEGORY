package com.moa.global.domain;

// JPA (Java Persistence API) 관련 어노테이션을 사용하기 위한 임포트

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


/**
 * AuditingEntityListener를 사용하여 생성 및 수정 날짜를 자동으로 관리하기 위한 BaseEntity 클래스
 * 필요한 Entity에 상속하여 사용
 */
@Getter
@MappedSuperclass // 해당 클래스가 JPA 엔티티의 베이스 클래스로 매핑되기 위한 어노테이션
@EntityListeners(AuditingEntityListener.class) // AuditingEntityListener 클래스를 사용하기 위한 어노테이션
public class BaseDateTime {

	@CreatedDate // 생성 날짜를 자동으로 설정하기 위한 어노테이션
	@Column(name = "create_datetime", updatable = false)
	private LocalDateTime createDatetime;

	@LastModifiedDate // 마지막 수정 날짜를 자동으로 설정하기 위한 어노테이션
	@Column(name = "update_datetime")
	private LocalDateTime updateDatetime;

}