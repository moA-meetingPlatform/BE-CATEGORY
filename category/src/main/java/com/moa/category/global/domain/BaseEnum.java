package com.moa.category.global.domain;


public interface BaseEnum<T, K> {

	T getCode();
	K getTitle();

}