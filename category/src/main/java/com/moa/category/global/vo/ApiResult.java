package com.moa.category.global.vo;


import com.moa.category.global.domain.ErrorCode;


public record ApiResult<T>(
	T result,
	Boolean isSuccess,
	String message

) {

	public static ApiResult<Void> ofError(ErrorCode code) {
		return new ApiResult<>(null, false, code.getDescription());
	}


	public static <T> ApiResult<T> ofSuccess(T data) {
		return new ApiResult<>(data, true, "success");
	}

}