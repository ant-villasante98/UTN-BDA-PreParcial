package com.utn.bda.biblioteca.medios.digitales.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message , HttpStatus status , Object responseObj){
        Map<String,Object> response = new HashMap<>();
        if (isNotBlank(message)){
            response.put("message",message);
        }
        if (responseObj != null) {
            response.put("data", responseObj);
        }
        return new ResponseEntity<>(response, status);
    }
    public static ResponseEntity<Object> success() {
        return generateResponse(null, HttpStatus.OK, null);
    }

    public static ResponseEntity<Object> success(Object responseObj) {
        return generateResponse(null, HttpStatus.OK, responseObj);
    }

    public static ResponseEntity<Object> created(Object responseObj) {
        return generateResponse(null, HttpStatus.CREATED, responseObj);
    }

    public static ResponseEntity<Object> badRequest(String message) {
        return generateResponse(message, HttpStatus.BAD_REQUEST, null);
    }

    public static ResponseEntity<Object> noContent() {
        return generateResponse(null, HttpStatus.NO_CONTENT, null);
    }


}
