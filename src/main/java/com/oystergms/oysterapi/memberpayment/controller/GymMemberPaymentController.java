package com.oystergms.oysterapi.memberpayment.controller;


import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.memberpayment.model.DueAmountResponse;
import com.oystergms.oysterapi.memberpayment.model.GymMemberPayment;
import com.oystergms.oysterapi.memberpayment.service.GymMemberPaymentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GymMemberPaymentController {


    private final GymMemberPaymentService gymMemberPaymentService;

    public GymMemberPaymentController(GymMemberPaymentService gymMemberPaymentService) {
        this.gymMemberPaymentService = gymMemberPaymentService;
    }

    @GetMapping("/gymMemberPayments")
    public ResponseEntity<Object> getAllMemberPayments(){
        try{
        List<GymMemberPayment> gymMemberPayments = gymMemberPaymentService.getAllGymMemberPayment();
        if (gymMemberPayments.size()<=0){
            return GymResponseHandler.generateResponse("Nothing in Payments",HttpStatus.OK,null);
        }else{
            return  GymResponseHandler.generateResponse("Member Payments Fetched Successfull.",HttpStatus.OK,gymMemberPayments);

        }
        }catch(Exception e){
            return  GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }


    @PostMapping("/gymMemberPayments/addPayment")
    public ResponseEntity<?>  addGymMemberPayment( @RequestBody GymMemberPayment gymMemberPayment){
        if (gymMemberPayment.toString().equals("{}")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing insert in form");

        }

        if (gymMemberPayment !=null){
            gymMemberPaymentService.addGymMemberPayment(gymMemberPayment);
            return ResponseEntity.status(HttpStatus.OK).body("Payment added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in request");
    }

    @GetMapping("/gymMemberPayment/{memberId}")
    public ResponseEntity<Object> memberPaymentById(@PathVariable("memberId") Integer memberId) {

        try {
            GymMemberPayment gymMemberPayment = gymMemberPaymentService.getGymMemberPaymentByMemberId(memberId);
            System.out.println(gymMemberPayment);
            Double dueAmount = gymMemberPayment.getGymPackageSubCategory().getGymPackageSubCategoryPrice() - gymMemberPayment.getGymPackagePaidAmount();
            DueAmountResponse dueAmountResponse = new DueAmountResponse();
            dueAmountResponse.setDueAmount(dueAmount);

            return GymResponseHandler.generateResponse("Successfully Retrieved Data !" , HttpStatus.OK, dueAmountResponse);
        } catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);

        }
    }

}
