package com.te.stores.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.stores.bean.StoresResponse;
import com.te.stores.exception.CustomException;

@RestControllerAdvice
public class StoresControllerAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<StoresResponse> handleException(CustomException exception) {
		StoresResponse response = new StoresResponse(true, exception.getMessage());
		return new ResponseEntity<StoresResponse>(response, HttpStatus.NOT_FOUND);
	}

}
