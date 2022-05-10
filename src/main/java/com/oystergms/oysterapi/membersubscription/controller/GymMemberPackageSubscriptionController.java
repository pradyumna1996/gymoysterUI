package com.oystergms.oysterapi.membersubscription.controller;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.membersubscription.model.GymMemberPackageSubscription;
import com.oystergms.oysterapi.membersubscription.service.GymMemberPackageSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GymMemberPackageSubscriptionController {


    private final GymMemberPackageSubscriptionService gymMemberPackageSubscriptionService;

    public GymMemberPackageSubscriptionController(GymMemberPackageSubscriptionService gymMemberPackageSubscriptionService) {
        this.gymMemberPackageSubscriptionService = gymMemberPackageSubscriptionService;
    }


    @GetMapping("/memberSubscriptions")
    public ResponseEntity<List<GymMemberPackageSubscription>> getAllMemberSubscriptions(){
        List<GymMemberPackageSubscription> gymMemberPackageSubscriptions = gymMemberPackageSubscriptionService.getAllGymMemberSubscriptions();
        if (gymMemberPackageSubscriptions.size()<=0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return  ResponseEntity.of(Optional.of(gymMemberPackageSubscriptions));
        }
    }


    @PostMapping("/memberSubscriptions/addSubscription")
    public ResponseEntity<?>  addGymMemberPackageSubscription( @RequestBody GymMemberPackageSubscription gymMemberPackageSubscription){
        if (gymMemberPackageSubscription.toString().equals("{}")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing insert in form");

        }
        if (gymMemberPackageSubscription ==null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing inset in form");
        }
        if (gymMemberPackageSubscription !=null){
            gymMemberPackageSubscriptionService.addGymMemberPackageSubscription(gymMemberPackageSubscription);
            return ResponseEntity.status(HttpStatus.OK).body("Member Subscription added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in request");
    }
}
