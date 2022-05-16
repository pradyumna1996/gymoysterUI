package com.oystergms.oysterapi.gymfollowup.controller;

import com.oystergms.oysterapi.gymfollowup.model.GymMemberFollowUp;
import com.oystergms.oysterapi.gymfollowup.service.GymMemberFollowUpService;
import com.oystergms.oysterapi.gymhandler.GymResponseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GymMemberFollowUpController {

    private final GymMemberFollowUpService gymMemberFollowUpService;

    public GymMemberFollowUpController(GymMemberFollowUpService gymMemberFollowUpService) {
        this.gymMemberFollowUpService = gymMemberFollowUpService;
    }

    @GetMapping("/gymMemberFollowUp")
    @CrossOrigin
    public ResponseEntity<Object> getAllMemberFollowUp() {

        try {
            List<GymMemberFollowUp> gymMemberFollowUpList = gymMemberFollowUpService.getAllMemberFollowUp();

            if (gymMemberFollowUpList.size() <= 0) {
                return GymResponseHandler.generateResponse("Nothing in Database", HttpStatus.OK, null);
            } else {
                return GymResponseHandler.generateResponse("Member Follow Up Fetched", HttpStatus.OK, gymMemberFollowUpList);
            }
        }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PostMapping("/gymMemberFollowUp/addFollowUp")
    @CrossOrigin
    public ResponseEntity<Object> saveMemberFollowUp(@RequestBody GymMemberFollowUp gymMemberFollowUp){
        try{
            if (gymMemberFollowUp ==null) {
                return GymResponseHandler.generateResponse("No Content !",HttpStatus.OK,null);
            }
            gymMemberFollowUpService.saveMemberFollowUp(gymMemberFollowUp);
            return GymResponseHandler.generateResponse("Follow Up Table", HttpStatus.OK, gymMemberFollowUp);
        }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

}


