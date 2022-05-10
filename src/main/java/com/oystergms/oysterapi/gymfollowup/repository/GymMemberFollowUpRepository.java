package com.oystergms.oysterapi.gymfollowup.repository;

import com.oystergms.oysterapi.gymfollowup.model.GymMemberFollowUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymMemberFollowUpRepository extends JpaRepository<GymMemberFollowUp,Integer> {
}
