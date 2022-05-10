package com.oystergms.oysterapi.gymhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class GymResponseHandler {

    public static ResponseEntity<Object> generateResponse(String responseMessage, HttpStatus httpStatus , Object responseObject) {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("message",responseMessage);
        map.put("status",httpStatus.value());
        map.put("data",responseObject);

        return new ResponseEntity<Object>(map,httpStatus);
    }


}
