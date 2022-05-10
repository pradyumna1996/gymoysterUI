package com.oystergms.oysterapi.gymattendance.staffattendance.service;

import com.oystergms.oysterapi.gymattendance.staffattendance.model.GymStaffAttendance;
import com.oystergms.oysterapi.gymattendance.staffattendance.repository.GymStaffAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymStaffAttendanceService {


    @Autowired
    private GymStaffAttendanceRepository gymStaffAttendanceRepository;


    public List<GymStaffAttendance> getStaffAttendance() {
    return gymStaffAttendanceRepository.findAll();
    }

    public void updateStaffAttendance(GymStaffAttendance gymStaffAttendance) {
        gymStaffAttendanceRepository.save(gymStaffAttendance);
    }

    public void addStaffAttendance(GymStaffAttendance gymStaffAttendance) {
        gymStaffAttendanceRepository.save(gymStaffAttendance);
    }
}
