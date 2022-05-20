package com.oystergms.oysterapi.memberpayment.service;

import com.oystergms.oysterapi.memberpayment.model.GymMemberPayment;
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

    public GymMemberPayment getGymMemberPaymentByMemberId(Integer memberId) {
        return gymMemberPaymentRepository.getMemberPaymentById(memberId);
    }

    public Double gymMemberPackagePaidAmount(Integer memberId, Integer subPackageId){
        return gymMemberPaymentRepository.getMemberPaidAmountByMemberIdAndGymSubPackage(memberId,subPackageId);
    }
}
