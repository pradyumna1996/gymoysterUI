package com.oystergms.oysterapi.gymstaff.repository;

import com.oystergms.oysterapi.gymstaff.model.GymStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymStaffRepository extends JpaRepository<GymStaff , Integer> {
}
