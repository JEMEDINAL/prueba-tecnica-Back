package com.masalcance.pruebatecnica.exception;


import com.masalcance.pruebatecnica.exception.logs.LogNotFound;
import com.masalcance.pruebatecnica.exception.logs.ThereAreNotLogs;
import com.masalcance.pruebatecnica.exception.remoteapi.NoRecordId;
import com.masalcance.pruebatecnica.exception.remoteapi.ThereAreNoPost;
import com.masalcance.pruebatecnica.exception.remoteapi.ThereAreNoUsers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvisorExceptions {
    private static final String MESSAGE = "Message";
    private static final String STATUS = "Status";
    private static final String TIMESTAMP = "TimeStamp";

    @ExceptionHandler(ThereAreNoUsers.class)
    public ResponseEntity<Map<String,String>> thereAreNoUsers(ThereAreNoUsers thereAreNoUsers){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE,thereAreNoUsers.getMessage());
        errorDetails.put(STATUS, HttpStatus.NO_CONTENT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorDetails);
    }

    @ExceptionHandler(ThereAreNoPost.class)
    public ResponseEntity<Map<String,String>> thereAreNoPost(ThereAreNoPost thereAreNoPost){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, thereAreNoPost.getMessage());
        errorDetails.put(STATUS, HttpStatus.NO_CONTENT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorDetails);
    }

    @ExceptionHandler(NoRecordId.class)
    public ResponseEntity<Map<String,String>> noRecordId(NoRecordId noRecordId){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, noRecordId.getMessage());
        errorDetails.put(STATUS, HttpStatus.NOT_FOUND.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(LogNotFound.class)
    public ResponseEntity<Map<String,String>> longNotFound(LogNotFound logNotFound){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, logNotFound.getMessage());
        errorDetails.put(STATUS, HttpStatus.NOT_FOUND.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(ThereAreNotLogs.class)
    public ResponseEntity<Map<String,String>> thereAreNotLogs(ThereAreNotLogs thereAreNotLogs){
        Map<String,String> errorDetails = new HashMap<>();
        errorDetails.put(MESSAGE, thereAreNotLogs.getMessage());
        errorDetails.put(STATUS, HttpStatus.NO_CONTENT.toString());
        errorDetails.put(TIMESTAMP, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> validationException(MethodArgumentNotValidException ex){
        Map<String, String> errorDetails = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            errorDetails.put(((FieldError)error).getField(),error.getDefaultMessage());
            errorDetails.put(STATUS,HttpStatus.BAD_REQUEST.toString());
            errorDetails.put(TIMESTAMP,LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
