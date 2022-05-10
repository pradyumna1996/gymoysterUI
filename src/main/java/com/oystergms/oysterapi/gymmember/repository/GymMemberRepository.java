package com.oystergms.oysterapi.gymmember.repository;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymMemberRepository extends JpaRepository<GymMember , Integer> {
}
