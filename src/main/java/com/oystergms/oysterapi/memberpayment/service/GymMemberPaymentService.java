package com.oystergms.oysterapi.memberpayment.service;

import com.oystergms.oysterapi.memberpayment.model.GymMemberPayment;
import com.oystergms.oysterapi.memberpayment.model.PaymentHead;
import com.oystergms.oysterapi.memberpayment.repository.GymMemberPaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymMemberPaymentService {

    private final GymMemberPaymentRepository gymMemberPaymentRepository;

    public GymMemberPaymentService(GymMemberPaymentRepository gymMemberPaymentRepository) {
        this.gymMemberPaymentRepository = gymMemberPaymentRepository;
    }


    public List<GymMemberPayment> getAllGymMemberPayment() {
        return gymMemberPaymentRepository.findAll();
    }

    public void addGymMemberPayment(GymMemberPayment gymMemberPayment) {
        gymMemberPaymentRepository.save(gymMemberPayment);
    }

    public List<GymMemberPayment> getGymMemberPaymentByMemberId(Integer memberId) {
        return gymMemberPaymentRepository.getMemberPaymentById(memberId);
    }

    public Double gymMemberPackagePaidAmount(Integer memberId, Integer subPackageId){
        return gymMemberPaymentRepository.getMemberPaidAmountByMemberIdAndGymSubPackage(memberId,subPackageId);
    }

    public Double gymMemberPackagePaidAmountByMemberId(Integer gymMemberId) {
        return  gymMemberPaymentRepository.getMemberPaidAmountByMemberId(gymMemberId);
    }
    public PaymentHead gymMemberHead(){
        return gymMemberPaymentRepository.getPaymentHead();
    }

    public Double getTotaPaidAmount() {
        return gymMemberPaymentRepository.getTotalPayment();
    }
}
