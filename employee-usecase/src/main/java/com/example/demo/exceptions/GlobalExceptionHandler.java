package com.example.demo.exceptions;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;



@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{


@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
HttpHeaders headers, HttpStatus status, WebRequest request) {
//log.error("VALIDATION_FAILED");
logger.error("Error due to validation fail");
List<String> details = ex.getBindingResult().getAllErrors().stream().map(x->x.getDefaultMessage()).toList();
ErrorResponse errors = new ErrorResponse();
return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
}

@ExceptionHandler(value = {EmployeeNotFoundException.class} )
protected ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request){
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
}


}