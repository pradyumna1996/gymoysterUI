package com.oystergms.oysterapi.memberpayment.controller;


import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.memberpayment.model.DueAmountResponse;
import com.oystergms.oysterapi.memberpayment.model.GymMemberPayment;
import com.oystergms.oysterapi.memberpayment.service.GymMemberPaymentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class GymMemberPaymentController {


    private final GymMemberPaymentService gymMemberPaymentService;

    public GymMemberPaymentController(GymMemberPaymentService gymMemberPaymentService) {
        this.gymMemberPaymentService = gymMemberPaymentService;
    }

    @GetMapping("/gymMemberPayments")
    @CrossOrigin
    public ResponseEntity<Object> getAllMemberPayments(){
        try{
        List<GymMemberPayment> gymMemberPayments = gymMemberPaymentService.getAllGymMemberPayment();
        if (gymMemberPayments.size()<=0){
            return GymResponseHandler.generateResponse("Nothing in Payments",HttpStatus.OK,null);
        }else{
            return  GymResponseHandler.generateResponse("Member Payments Fetched Successful.",HttpStatus.OK,gymMemberPayments);
        }
        }catch(Exception e){
            return  GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }


    @PostMapping("/gymMemberPayments/addPayment")
    @CrossOrigin
    public ResponseEntity<?>  addGymMemberPayment( @RequestBody GymMemberPayment gymMemberPayment) {

        try {

            if (gymMemberPayment.toString().equals("{}")) {

                return GymResponseHandler.generateResponse("Please Check Your Data", HttpStatus.OK,null);
            } else {
                gymMemberPaymentService.addGymMemberPayment(gymMemberPayment);
                return GymResponseHandler.generateResponse("Payment Saved Successful !", HttpStatus.OK,gymMemberPayment);
            }
        }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }

    @GetMapping("/gymMemberPayment/{memberId}")
    @CrossOrigin
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
