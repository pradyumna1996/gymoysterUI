package com.oystergms.oysterapi.memberpayment.repository;

import com.oystergms.oysterapi.memberpayment.model.GymMemberPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  GymMemberPaymentRepository extends JpaRepository<GymMemberPayment , Integer> {
    @Query(value = "SELECT * FROM gym_member_payment WHERE gym_member_id=gym_member_id",nativeQuery = true)
    GymMemberPayment getMemberPaymentById(Integer memberId);
}
