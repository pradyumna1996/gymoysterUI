package com.oystergms.oysterapi.gymmember.controller;

import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gymmember.service.GymMemberService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GymMemberController {

    private final GymMemberService gymMemberService;

    public GymMemberController(GymMemberService gymMemberService) {
        this.gymMemberService = gymMemberService;
    }

    @GetMapping("/gymMembers")
    @CrossOrigin
    public ResponseEntity<Object> getAllMembers(){
        List<GymMember> gymMembers = gymMemberService.getAllGymMembers();
        if (gymMembers.size()<=0){
            return GymResponseHandler.generateResponse("No Members in the List", HttpStatus.OK,"No Content");
        }else{
            return  GymResponseHandler.generateResponse("Member Fetched Successfully",HttpStatus.OK,gymMembers);
        }
    }

    @GetMapping("/gymMembers/{gymMemberId}")
    @CrossOrigin
    public ResponseEntity<Object> getMemberById(@PathVariable("gymMemberId") Integer gymMemberId){
        GymMember gymMembers = gymMemberService.getGymMemberById(gymMemberId);
        if (gymMembers==null){
            return GymResponseHandler.generateResponse("No Members in the List", HttpStatus.OK,"No Content");
        }else{
            return  GymResponseHandler.generateResponse("Member Fetched Successfully",HttpStatus.OK,gymMembers);
        }
    }


    @PostMapping("/gymMembers/addMember")
    @CrossOrigin
    public ResponseEntity<Object>  addGymMember( @RequestBody GymMember gymMember) {

        try {
            if (gymMember == null) {
                return GymResponseHandler.generateResponse("Request Error ! Please Check Your Data",HttpStatus.OK,null);
            } else {
                gymMemberService.addGymMember(gymMember);
                return GymResponseHandler.generateResponse("Member Added Successfully", HttpStatus.OK, gymMember);
            }
        }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/gymMembers/updateMember")
    @CrossOrigin
    public ResponseEntity<Object>  updateGymMember( @RequestBody GymMember gymMember) {

        try {
            if (gymMember == null) {
                return GymResponseHandler.generateResponse("Request Error ! Please Check Your Data",HttpStatus.OK,null);
            } else {
                String result = gymMemberService.updateGymMember(gymMember);
                return GymResponseHandler.generateResponse("Member Updated Successful", HttpStatus.OK, result
                );
            }
        }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }


    @DeleteMapping("/gymMembers/deleteGymMember/{gymMemberId}")
    @CrossOrigin
    public ResponseEntity<Object> deleteGymMember(@PathVariable("gymMemberId") Integer gymMemberId){

        try {
            String result = gymMemberService.deleteGymMemberById(gymMemberId);
            return GymResponseHandler.generateResponse("Selected Member is Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}

