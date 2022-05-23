package com.oystergms.oysterapi.memberpayment.repository;

import com.oystergms.oysterapi.memberpayment.model.GymMemberPayment;
import com.oystergms.oysterapi.memberpayment.model.PaymentHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  GymMemberPaymentRepository extends JpaRepository<GymMemberPayment , Integer> {
    @Query(value = "SELECT * FROM gym_member_payment WHERE gym_member_id=:gym_member_id",nativeQuery = true)
    List<GymMemberPayment> getMemberPaymentById(@Param("gym_member_id") Integer gym_member_id);

    @Query(value = "SELECT SUM(gym_package_paid_amount) FROM gym_member_payment WHERE gym_member_id=:gym_member_id and gym_package_sub_category_id=:gym_package_sub_category_id",nativeQuery = true)
    Double getMemberPaidAmountByMemberIdAndGymSubPackage(@Param("gym_member_id") Integer memberId,@Param("gym_package_sub_category_id")  Integer subPackageId);

    @Query(value = "SELECT SUM(gym_package_paid_amount) FROM gym_member_payment WHERE gym_member_id=:gym_member_id",nativeQuery = true)
    Double getMemberPaidAmountByMemberId(@Param("gym_member_id") Integer gymMemberId);

    @Query(value = " SELECT gym_member_payment.gym_member_id ,gym_member_payment.gym_package_paid_amount ,gym_package_sub_category.gym_package_sub_category_price FROM gym_member_payment INNER JOIN gym_package_sub_category ON gym_member_payment.gym_package_sub_category_id  = gym_package_sub_category.gym_package_sub_category_id ",nativeQuery = true)
    PaymentHead getPaymentHead();

    @Query(value = "SELECT SUM(gym_package_paid_amount) FROM gym_member_payment",nativeQuery = true)
    Double getTotalPayment();
}
