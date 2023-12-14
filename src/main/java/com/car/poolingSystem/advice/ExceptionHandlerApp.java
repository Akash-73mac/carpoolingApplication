package com.car.poolingSystem.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerApp {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> exceptionOfValid(MethodArgumentNotValidException  ex){
		HashMap <String,String> notValid= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			notValid.put(error.getField(), error.getDefaultMessage());
		});
		return notValid;
		
	}
	

}
