package com.example.demo.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleCityNotFoundException(
	        Exception ex) {
            ex.printStackTrace();
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "City not found");

	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
}
