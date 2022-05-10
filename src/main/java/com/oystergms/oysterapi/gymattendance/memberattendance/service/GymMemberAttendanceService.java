package com.oystergms.oysterapi.gymattendance.memberattendance.service;


import com.oystergms.oysterapi.gymattendance.memberattendance.model.GymMemberAttendance;
import com.oystergms.oysterapi.gymattendance.memberattendance.repository.GymMemberAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymMemberAttendanceService {

    @Autowired
    private GymMemberAttendanceRepository gymMemberAttendanceRepository;

    public List<GymMemberAttendance> getAttendanceList() {
        return gymMemberAttendanceRepository.findAll();
    }

    public void saveMemberAttendance(GymMemberAttendance gymMemberAttendance) {
        gymMemberAttendanceRepository.save(gymMemberAttendance);
    }

    public void updateMemberAttendance(GymMemberAttendance gymMemberAttendance) {
        gymMemberAttendanceRepository.save(gymMemberAttendance);
    }


    public void deleteMemberAttendance(Integer gymMemberAttendanceId) {
        gymMemberAttendanceRepository.deleteById(gymMemberAttendanceId);
    }

    public List<GymMemberAttendance> getTodayAttendanceList(String today) {
    return gymMemberAttendanceRepository.findByAttendanceDateLike(today);
    }
}
