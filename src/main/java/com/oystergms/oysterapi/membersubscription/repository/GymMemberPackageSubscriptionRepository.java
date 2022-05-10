package com.oystergms.oysterapi.membersubscription.repository;

import com.oystergms.oysterapi.membersubscription.model.GymMemberPackageSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymMemberPackageSubscriptionRepository extends JpaRepository<GymMemberPackageSubscription , Integer> {
}
