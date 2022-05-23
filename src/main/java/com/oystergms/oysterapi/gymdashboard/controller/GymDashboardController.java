package com.oystergms.oysterapi.gymdashboard.controller;

import com.oystergms.oysterapi.gymdashboard.model.GymDashboardResponse;
import com.oystergms.oysterapi.gymdashboard.service.GymDashboardService;
import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class GymDashboardController {


    @Autowired
    private GymDashboardService gymDashboardService;

    @GetMapping("/gymDashboard")
    public ResponseEntity<Object> gymDashboard(){

        GymDashboardResponse gymDashboardContents = gymDashboardService.gymMemberDashboardView();

        return GymResponseHandler.generateResponse("Dashboard Contents", HttpStatus.OK,gymDashboardContents);
    }

}
