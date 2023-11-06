package com.moa.global.config.exception;


import com.moa.global.vo.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/* Custom Exception */
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<ApiResult<Void>> handleCustomException(final CustomException e) {
		log.error("handleCustomException: {}", e.getErrorCode());
		return new ResponseEntity<>(ApiResult.ofError(e.getErrorCode()), e.getErrorCode().getStatus());
	}


	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ApiResult<Void>> handleHttpRequestMethodNotSupportedException() {
		return new ResponseEntity<>(ApiResult.ofError(ErrorCode.METHOD_NOT_ALLOWED), ErrorCode.METHOD_NOT_ALLOWED.getStatus());
	}

	// security
	//	@ExceptionHandler(BadCredentialsException.class)
	//	protected ResponseEntity<ErrorResponse> handleBadCredentialsException() {
	//		return new ResponseEntity<>(ApiResponse.ofError(ErrorCode.FAIL_LOGIN), ErrorCode.FAIL_LOGIN.getStatus());
	//	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResult<Void>> methodArgumentValidException() {
		return new ResponseEntity<>(ApiResult.ofError(ErrorCode.BAD_REQUEST), ErrorCode.BAD_REQUEST.getStatus());
	}


	@ExceptionHandler(QueryTimeoutException.class)
	public ResponseEntity<ApiResult<Void>> handleQueryTimeoutException(QueryTimeoutException e) {
		log.error("fail to execute query, {}", e.getMessage());
		return new ResponseEntity<>(ApiResult.ofError(ErrorCode.INTERNAL_SERVER_ERROR), ErrorCode.INTERNAL_SERVER_ERROR.getStatus());
	}


	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<ApiResult<Void>> handleRuntimeException(final RuntimeException e) {
		log.error(e.getMessage(), e);
		return new ResponseEntity<>(ApiResult.ofError(ErrorCode.INTERNAL_SERVER_ERROR), ErrorCode.INTERNAL_SERVER_ERROR.getStatus());
	}

}