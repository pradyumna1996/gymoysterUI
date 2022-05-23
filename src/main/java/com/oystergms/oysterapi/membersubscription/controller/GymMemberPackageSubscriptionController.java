package com.oystergms.oysterapi.membersubscription.controller;

import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.membersubscription.model.GymMemberPackageSubscription;
import com.oystergms.oysterapi.membersubscription.service.GymMemberPackageSubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GymMemberPackageSubscriptionController {


    private final GymMemberPackageSubscriptionService gymMemberPackageSubscriptionService;

    public GymMemberPackageSubscriptionController(GymMemberPackageSubscriptionService gymMemberPackageSubscriptionService) {
        this.gymMemberPackageSubscriptionService = gymMemberPackageSubscriptionService;
    }


    @GetMapping("/memberSubscriptions")
    @CrossOrigin
    public ResponseEntity<Object> getAllMemberSubscriptions(){
        List<GymMemberPackageSubscription> gymMemberPackageSubscriptions = gymMemberPackageSubscriptionService.getAllGymMemberSubscriptions();
        try{

        if (gymMemberPackageSubscriptions.size()<=0){
            return GymResponseHandler.generateResponse("No Subscriptions Added", HttpStatus.OK,null);
        }else{
            return  GymResponseHandler.generateResponse("Member Subscriptions Fetched Successfully !",HttpStatus.OK,gymMemberPackageSubscriptions);
        }
        }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }


    @PostMapping("/memberSubscriptions/addSubscription")
    @CrossOrigin
    public ResponseEntity<Object>  addGymMemberPackageSubscription( @RequestBody GymMemberPackageSubscription gymMemberPackageSubscription){

        try{
        if (gymMemberPackageSubscription.toString().equals("{}")) {
            return GymResponseHandler.generateResponse("Error in Request",HttpStatus.OK,null);
        }else {
            gymMemberPackageSubscriptionService.addGymMemberPackageSubscription(gymMemberPackageSubscription);
            return GymResponseHandler.generateResponse("Member Subscription added successfully", HttpStatus.OK, gymMemberPackageSubscription);
        }
        }catch(Exception e){
        return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.OK,null);
    }
    }


    @PutMapping("/memberSubscriptions/updateSubscription")
    @CrossOrigin
    public ResponseEntity<Object>  updateSubscription( @RequestBody GymMemberPackageSubscription gymMemberPackageSubscription) {

        try{
            if (gymMemberPackageSubscription == null) {
                return GymResponseHandler.generateResponse("Request Error ! Please Check Your Data",HttpStatus.OK,null);
            } else {
                String result = gymMemberPackageSubscriptionService.updateGymMemberSubscription(gymMemberPackageSubscription);
                return GymResponseHandler.generateResponse("Member Updated Successful", HttpStatus.OK, result
                );
            }
        }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }



}
