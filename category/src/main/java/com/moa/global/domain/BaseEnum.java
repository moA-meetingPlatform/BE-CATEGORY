package com.moa.global.domain;


public interface BaseEnum<T, K> {

	T getCode();
	K getTitle();

}