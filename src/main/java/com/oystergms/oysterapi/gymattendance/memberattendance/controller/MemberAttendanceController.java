package com.oystergms.oysterapi.gymattendance.memberattendance.controller;

import com.oystergms.oysterapi.gymattendance.memberattendance.model.GymMemberAttendance;
import com.oystergms.oysterapi.gymattendance.memberattendance.service.GymMemberAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MemberAttendanceController {

    @Autowired
    private GymMemberAttendanceService gymMemberAttendanceService;

    @GetMapping("/gymMemberAttendance")
    public List<GymMemberAttendance> getAllAttendanceList(){

        return gymMemberAttendanceService.getAttendanceList();
    }

    @GetMapping("/gymMemberAttendance/{today}")
    public List<GymMemberAttendance> getTodaysAttendanceList(@PathVariable("today") String today){
        return
                gymMemberAttendanceService.getTodayAttendanceList(today);
    }

    @PostMapping("/gymMemberAttendance")
    public void addMemberAttendance(@RequestBody List<GymMemberAttendance> gymMemberAttendances){

        gymMemberAttendances.forEach(
                gymMemberAttendance ->gymMemberAttendanceService.saveMemberAttendance(gymMemberAttendance));

    }

    @PutMapping("/gymMemberAttendance/{memberAttendanceId}")
    public void updateMemberAttendance(@RequestBody GymMemberAttendance gymMemberAttendance , @PathVariable("memberAttendanceId") Integer memberAttendanceId){
        gymMemberAttendanceService.updateMemberAttendance(gymMemberAttendance);
    }

    @DeleteMapping("/memberAttendance/{memberAttendanceId}")
    public void deleteMemberAttendace(@PathVariable("memberAttendanceId") Integer memberAttendanceId){
        gymMemberAttendanceService.deleteMemberAttendance(memberAttendanceId);
    }
}
