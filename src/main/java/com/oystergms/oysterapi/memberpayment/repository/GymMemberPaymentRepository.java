package com.oystergms.oysterapi.memberpayment.repository;

import com.oystergms.oysterapi.memberpayment.model.GymMemberPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  GymMemberPaymentRepository extends JpaRepository<GymMemberPayment , Integer> {
    @Query(value = "SELECT * FROM gym_member_payment WHERE gym_member_id=gym_member_id",nativeQuery = true)
    GymMemberPayment getMemberPaymentById(Integer memberId);

    @Query(value = "SELECT SUM(gym_package_paid_amount) FROM gym_member_payment WHERE gym_member_id=:gym_member_id and gym_package_sub_category_id=:gym_package_sub_category_id",nativeQuery = true)
    Double getMemberPaidAmountByMemberIdAndGymSubPackage(@Param("gym_member_id") Integer memberId,@Param("gym_package_sub_category_id")  Integer subPackageId);
}
