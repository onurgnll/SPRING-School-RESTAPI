package com.school.schoolproject.responses;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(int status){
        HttpStatus httpStatus = HttpStatus.valueOf(status);

        Map<String, Object> map = new HashMap<String , Object>();
        map.put("status", status);
        if(status > 399){
            map.put("success", false);
        }else {
            map.put("success", true);
        }
        map.put("status", status);

        return new ResponseEntity<Object>(map,httpStatus);

    }
    public static ResponseEntity<Object> generateResponse(int status, Object responseObj){
        HttpStatus httpStatus = HttpStatus.valueOf(status);

        Map<String, Object> map = new HashMap<String , Object>();
        map.put("status", status);
        map.put("data", responseObj);
        if(status > 399){
            map.put("success", false);
        }else {
            map.put("success", true);
        }

        return new ResponseEntity<Object>(map,httpStatus);

    }


    public static ResponseEntity<Object> generateResponse(int status, String message){
        HttpStatus httpStatus = HttpStatus.valueOf(status);

        Map<String, Object> map = new HashMap<String , Object>();
        map.put("message", message);
        map.put("status", status);
        if(status > 399){
            map.put("success", false);
        }else {
            map.put("success", true);
        }

        return new ResponseEntity<Object>(map,httpStatus);

    }

}
