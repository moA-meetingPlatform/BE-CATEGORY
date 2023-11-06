package com.moa.global.vo;


import com.moa.global.config.exception.ErrorCode;


public record ApiResult<T>(
	T result,
	Boolean isSuccess,
	String message

) {

	public static ApiResult<Void> ofError(ErrorCode code) {

		return new ApiResult<>(
				null, false, code.getDescription()
		);
	}


	public static <T> ApiResult<T> ofSuccess(T data) {
		return new ApiResult<>( data,true, "success");
	}

}