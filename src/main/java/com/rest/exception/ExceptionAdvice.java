package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Throwable.class)
	protected ResponseEntity<Object> handleException(Exception ex) {

		System.out.println(ex);
		StackTraceElement[] st = ex.getStackTrace();
		int x = 1;
		for (StackTraceElement stackTraceElement : st) {
			System.out.println(x++ + " : " + stackTraceElement.toString());
		}

		ApiError apiError = new ApiError(HttpStatus.CHECKPOINT);
		apiError.setMessage(ex.getMessage());
		return ResponseEntity.ok(apiError);
	}

	@ExceptionHandler(CustomCheckedException.class)
	protected ResponseEntity<Object> handleException(CustomCheckedException ex) {

		// return handleExceptionInternal(ex, null, headers, status, request);

		System.out.println(ex);
		StackTraceElement[] st = ex.getStackTrace();
		int x = 1;
		for (StackTraceElement stackTraceElement : st) {
			System.out.println(x++ + " : " + stackTraceElement.toString());
		}

		ApiError apiError = new ApiError(HttpStatus.CHECKPOINT);
		apiError.setMessage(ex.getMessage());
		return ResponseEntity.ok(apiError);
	}

	@ExceptionHandler(CustomRuntimeException.class)
	protected ResponseEntity<Object> handleException(CustomRuntimeException ex) {

		// return handleExceptionInternal(ex, null, headers, status, request);

		System.out.println(ex);
		StackTraceElement[] st = ex.getStackTrace();
		int x = 1;
		for (StackTraceElement stackTraceElement : st) {
			System.out.println(x++ + " : " + stackTraceElement.toString());
		}

		ApiError apiError = new ApiError(HttpStatus.CHECKPOINT);
		apiError.setMessage(ex.getMessage());
		return ResponseEntity.ok(apiError);
	}
}
