package com.oystergms.oysterapi.gymattendance.memberattendance.repository;

import com.oystergms.oysterapi.gymattendance.memberattendance.model.GymMemberAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymMemberAttendanceRepository extends JpaRepository<GymMemberAttendance,Integer> {

    @Query(value = "SELECT * FROM gym_member_attendance  WHERE gym_attendance_date LIKE %:today%", nativeQuery = true)
    List<GymMemberAttendance> findByAttendanceDateLike(@Param("today") String today);
}
