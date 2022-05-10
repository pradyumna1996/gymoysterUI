package com.oystergms.oysterapi.gymattendance.staffattendance.repository;

import com.oystergms.oysterapi.gymattendance.staffattendance.model.GymStaffAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymStaffAttendanceRepository extends JpaRepository<GymStaffAttendance, Integer> {
}
