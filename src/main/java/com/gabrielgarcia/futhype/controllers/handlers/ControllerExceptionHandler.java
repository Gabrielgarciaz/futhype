package com.gabrielgarcia.futhype.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gabrielgarcia.futhype.dto.ErroCustomizado;
import com.gabrielgarcia.futhype.dto.ValidacaoErro;
import com.gabrielgarcia.futhype.services.exceptions.DataBaseException;
import com.gabrielgarcia.futhype.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErroCustomizado> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroCustomizado err = new ErroCustomizado(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<ErroCustomizado> dataBaseError(DataBaseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroCustomizado err = new ErroCustomizado(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErroCustomizado> methodArgumentValidation(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidacaoErro err = new ValidacaoErro(Instant.now(), status.value(), "Dados inválidos", request.getRequestURI());
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addErro(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(err);
		}
}
