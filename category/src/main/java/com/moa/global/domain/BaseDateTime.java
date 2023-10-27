package com.moa.global.domain;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDateTime {

	@Column(name = "create_datetime", updatable = false)
	@CreatedDate
	private LocalDateTime createDatetime;

	@Column(name = "update_datetime")
	@LastModifiedDate
	private LocalDateTime updateDatetime;

}