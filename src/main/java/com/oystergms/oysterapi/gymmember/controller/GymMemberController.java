package com.oystergms.oysterapi.gymmember.controller;

import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gymmember.service.GymMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GymMemberController {

    @Autowired
    private  GymMemberService gymMemberService;

    @GetMapping("/gymMembers")
    public ResponseEntity<Object> getAllMembers(){
        List<GymMember> gymMembers = gymMemberService.getAllGymMembers();
        if (gymMembers.size()<=0){
            return GymResponseHandler.generateResponse("No Members in the List", HttpStatus.NO_CONTENT,"No Content");
        }else{
            return  GymResponseHandler.generateResponse("Member Fetched Successfully",HttpStatus.OK,gymMembers);
        }
    }


    @PostMapping("/gymMembers/addMember")
    public ResponseEntity<Object>  addGymMember( @RequestBody GymMember gymMember){
        if (gymMember.toString().equals("{}")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing insert in form");

        }
        if (gymMember ==null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing inset in form");
        }
        if (gymMember !=null){
            gymMemberService.addGymMember(gymMember);
            return GymResponseHandler.generateResponse("Member Added Successfully", HttpStatus.OK,gymMember);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in request");
    }
}
