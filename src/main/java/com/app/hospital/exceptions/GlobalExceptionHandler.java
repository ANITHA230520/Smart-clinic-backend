package com.app.hospital.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> objectBody = new LinkedHashMap<>();
        objectBody.put("Timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
        objectBody.put("errorCode", status.value());
        List<String> exceptions = ex.getBindingResult().getFieldErrors().stream().map(m -> m.getDefaultMessage())
                .collect(Collectors.toList());
        objectBody.put("errorMessages", exceptions);
        return new ResponseEntity<Object>(objectBody, status);
    }
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(DoctorNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(PatientNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(AppointmentNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(ScheduleNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(ScheduleNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.NOT_FOUND);
		return response;
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(AdminNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response = new ResponseEntity<ExceptionResponse>(exception,
				HttpStatus.NOT_FOUND);
		return response;
	}

}
