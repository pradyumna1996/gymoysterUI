package com.oystergms.oysterapi.memberpayment.controller;


import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gymmember.service.GymMemberService;
import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import com.oystergms.oysterapi.gympackagescategory.subcategories.service.GymPackageSubCategoryService;
import com.oystergms.oysterapi.memberpayment.model.*;
import com.oystergms.oysterapi.memberpayment.service.GymMemberPaymentService;
import com.oystergms.oysterapi.membersubscription.model.GymMemberPackageSubscription;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
public class GymMemberPaymentController {


    private final GymMemberPaymentService gymMemberPaymentService;


    final GymPackageSubCategoryService gymPackageSubCategoryService;

    final GymMemberService gymMemberService;

    public GymMemberPaymentController(GymMemberPaymentService gymMemberPaymentService, GymPackageSubCategoryService gymPackageSubCategoryService, GymMemberService gymMemberService) {
        this.gymMemberPaymentService = gymMemberPaymentService;
        this.gymPackageSubCategoryService = gymPackageSubCategoryService;
        this.gymMemberService = gymMemberService;
    }


    //1. Getting all Payment List
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

    @GetMapping("/gymMemberPayments/{memberId}")
    @CrossOrigin
    public ResponseEntity<Object> getMemberPaymentById(@PathVariable("memberId") Integer memberId){

        try{
            List<GymMemberPayment> gymMemberPayments = gymMemberPaymentService.getGymMemberPaymentByMemberId(memberId);
            if (gymMemberPayments ==null){
                return GymResponseHandler.generateResponse("Nothing in Payments",HttpStatus.OK,null);
            }else{
                return  GymResponseHandler.generateResponse("Member Payments Fetched Successful.",HttpStatus.OK,gymMemberPayments);
            }
        }catch(Exception e){
            return  GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }


    //2. Posting Payments
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

    @GetMapping("/gymMemberDueAmount/{memberId}/{subPackageId}")
    @CrossOrigin
    public ResponseEntity<Object> packagePaymentAmount(@PathVariable("memberId") Integer memberId , @PathVariable("subPackageId") Integer subPackageId) {

        try{

           Double package_paid_amount= gymMemberPaymentService.gymMemberPackagePaidAmount(memberId,subPackageId);
           DueAmountResponse due_amount= new DueAmountResponse();
           Double gymPackagePrice=null;
           due_amount.setPaidAmount(package_paid_amount);
           List<GymPackageSubCategory> gymPackageSubCategory = gymPackageSubCategoryService.getSubCategories();

           for( GymPackageSubCategory gymSubPackage:gymPackageSubCategory){
               gymPackagePrice = gymSubPackage.getGymPackageSubCategoryPrice();
               Double dueAmount = gymPackagePrice-package_paid_amount;
               due_amount.setDueAmount(dueAmount);
           }


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

        List<MemberPackagePaymentHead> memberPackagePaymentHeadList = new ArrayList<>();

        List<GymMember> gymMemberList = gymMemberService.getAllGymMembers();

        List<GymPackageSubCategory> gymPackageSubCategoriesList = gymPackageSubCategoryService.getSubCategories();

        List<Integer> gymMemberIdFetched = new ArrayList<>();

        List<Double> paidAmountList = new ArrayList<>();

        List<Double> gymPackagePriceList = new ArrayList<>();

            for (GymMember gymMemberDetails : gymMemberList) {

                MemberPackagePaymentHead memberPackageHead = new MemberPackagePaymentHead();

                gymMemberIdFetched.add(gymMemberDetails.getGymMemberId());

                memberPackageHead.setGymMemberId(gymMemberDetails.getGymMemberId());

                memberPackageHead.setGymMemberFullName(gymMemberDetails.getGymMemberFullName());

                Double totalPaidAmount = null;
                //Total Paid Amount By Member
                for (Integer memberIdList : gymMemberIdFetched) {
                    totalPaidAmount = gymMemberPaymentService.gymMemberPackagePaidAmountByMemberId(memberIdList);
                    if(totalPaidAmount==null){
                        totalPaidAmount=0.0;
                    }
                }



                memberPackageHead.setGymTotalPaidAmount(totalPaidAmount);
                paidAmountList.add(totalPaidAmount);


                for(Double paidAmount: paidAmountList){

                    List<GymPackageSubCategory> gymPackageSubCategory = gymPackageSubCategoryService.getSubCategories();

                    for( GymPackageSubCategory gymSubPackage:gymPackageSubCategory){
                        Double gymPackagePrice = gymSubPackage.getGymPackageSubCategoryPrice();
                        Double dueAmount = gymPackagePrice-paidAmount;
                        memberPackageHead.setGymTotalDueAmount(dueAmount);
                    }
                }

                 memberPackagePaymentHeadList.add(memberPackageHead);
            }


            System.out.println("Package Category Price:"+gymPackagePriceList);
            System.out.println("Paid Amount List:" + paidAmountList);
            System.out.println("MemberId : " + gymMemberIdFetched);

            return GymResponseHandler.generateResponse("Data Fetched", HttpStatus.MULTI_STATUS,memberPackagePaymentHeadList);
    }

    @GetMapping("/paymentHead")
    @CrossOrigin
    public ResponseEntity<Object> getPaymentHead(){

       List <PaymentHead> paymentHead = (List<PaymentHead>) gymMemberPaymentService.gymMemberHead();

        return GymResponseHandler.generateResponse("Data",HttpStatus.OK,paymentHead);
    }

}
