package com.oystergms.oysterapi.gymfollowup.repository;

import com.oystergms.oysterapi.gymfollowup.model.GymMemberFollowUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymMemberFollowUpRepository extends JpaRepository<GymMemberFollowUp,Integer> {

    @Query(value = "SELECT * FROM gym_member_follow_up WHERE gym_member_id=gym_member_id",nativeQuery = true)
    List<GymMemberFollowUp> findByGymMemberId(Integer gymMemberId);
}
