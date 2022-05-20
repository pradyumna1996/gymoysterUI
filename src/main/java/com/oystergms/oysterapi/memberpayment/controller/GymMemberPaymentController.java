package com.oystergms.oysterapi.memberpayment.controller;


import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gymmember.service.GymMemberService;
import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import com.oystergms.oysterapi.gympackagescategory.subcategories.service.GymPackageSubCategoryService;
import com.oystergms.oysterapi.memberpayment.model.DueAmountResponse;
import com.oystergms.oysterapi.memberpayment.model.GymMemberPayment;
import com.oystergms.oysterapi.memberpayment.model.MemberPackageDueAmount;
import com.oystergms.oysterapi.memberpayment.model.MemberPackagePaymentHead;
import com.oystergms.oysterapi.memberpayment.service.GymMemberPaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
public class GymMemberPaymentController {


    private final GymMemberPaymentService gymMemberPaymentService;

    public GymMemberPaymentController(GymMemberPaymentService gymMemberPaymentService) {
        this.gymMemberPaymentService = gymMemberPaymentService;
    }

    @Autowired
    GymPackageSubCategoryService gymPackageSubCategoryService;

    @Autowired
    GymMemberService gymMemberService;

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

    @GetMapping("/gymMemberPayment/packagePaidAmount/{memberId}/{subPackageId}")
    @CrossOrigin
    public ResponseEntity<Object> packagePaymentAmount(@PathVariable("memberId") Integer memberId , @PathVariable("subPackageId") Integer subPackageId) {

        try{
           Double package_paid_amount= gymMemberPaymentService.gymMemberPackagePaidAmount(memberId,subPackageId);
           DueAmountResponse due_amount= new DueAmountResponse();
           due_amount.setDueAmount(package_paid_amount);
           return GymResponseHandler.generateResponse("Successfully Retrieved Data !" , HttpStatus.OK, due_amount);
        } catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }


    @PostMapping("/gymMemberPayment/packagePaidAmount")
    @CrossOrigin
    public ResponseEntity<Object> gymPackagePaymentAmount(@RequestBody MemberPackageDueAmount memberPackageDueAmount ) {

        try{
                Integer memberId = memberPackageDueAmount.getGymMemberId();
                Integer packageId = memberPackageDueAmount.getGymSubPackageId();
                Double due_amount = gymMemberPaymentService.gymMemberPackagePaidAmount(memberId,packageId);
                memberPackageDueAmount.setGymDueAmount(due_amount);

            return GymResponseHandler.generateResponse("Successfully Retrieved Data !" , HttpStatus.OK,memberPackageDueAmount);
        } catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

        @GetMapping("/gymMemberPaymentHead")
        @CrossOrigin
        public ResponseEntity<Object> gymMemberPaymentHead() {

        List<MemberPackagePaymentHead> memberPackagePaymentHead = new ArrayList<>();

        List<GymMember> gymMember = gymMemberService.getAllGymMembers();

        List<GymPackageSubCategory> gymPackageSubCategories =gymPackageSubCategoryService.getSubCategories();
        List<Double> PaidAmountList = new ArrayList<>();

        for(GymMember gymMemberDetails: gymMember){
            MemberPackagePaymentHead memberHead = new MemberPackagePaymentHead();
            memberHead.setGymMemberFullName(gymMemberDetails.getGymMemberFullName());
            memberHead.setGymMemberId(gymMemberDetails.getGymMemberId());

            for(GymPackageSubCategory gymPackageSubCategory :gymPackageSubCategories){
                memberHead.setGymSubPackageId(gymPackageSubCategory.getGymPackageSubCategoryId());
                Double getAmount = gymMemberPaymentService.gymMemberPackagePaidAmount(gymMemberDetails.getGymMemberId(),gymPackageSubCategory.getGymPackageSubCategoryId());
                PaidAmountList.add(getAmount);
            }

            for(Double pa:PaidAmountList){
                memberHead.setGymTotalPaidAmount(pa);
            }
            System.out.println(memberHead);

            memberPackagePaymentHead.add(memberHead);


            }

            System.out.println(PaidAmountList);
            System.out.println(memberPackagePaymentHead);

        return GymResponseHandler.generateResponse("Data Fetched", HttpStatus.MULTI_STATUS,memberPackagePaymentHead);

    }




}
