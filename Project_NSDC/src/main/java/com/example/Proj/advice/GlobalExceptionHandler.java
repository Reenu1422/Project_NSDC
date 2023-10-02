package com.example.Proj.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Proj.exception.UserNotFoundException;

import jakarta.validation.ConstraintViolationException;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvaildArgument(MethodArgumentNotValidException ex){
		Map<String,String> errormsg=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errormsg.put(error.getField(), error.getDefaultMessage());
		});
		return errormsg;
		}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String,String> handleLogicException(UserNotFoundException ex){
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessage", ex.getMessage());
		return errorMap;
	}
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String,String> handleLogicExcept(ConstraintViolationException ee){
		Map<String,String> errorMapp=new HashMap<>();
		errorMapp.put("errorMessage", ee.getLocalizedMessage());
		return errorMapp;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public Map<String,String> handleLogicExc(InvalidDataAccessApiUsageException mk){
		Map<String,String> err=new HashMap<>();
		err.put("Remove all mid", mk.getLocalizedMessage());
		return err;
	}
}
