package com.oystergms.oysterapi.gymattendance.staffattendance.controller;


import com.oystergms.oysterapi.gymattendance.staffattendance.model.GymStaffAttendance;
import com.oystergms.oysterapi.gymattendance.staffattendance.service.GymStaffAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StaffAttendanceController {

    @Autowired
    private GymStaffAttendanceService gymStaffAttendanceService;

    @GetMapping("/staffAttendance")
    @CrossOrigin
    public List<GymStaffAttendance> getAllAttendanceList(){
        return gymStaffAttendanceService.getStaffAttendance();
    }

    @PostMapping("/staffAttendance")
    @CrossOrigin
    public void addAttendance(@RequestBody GymStaffAttendance gymStaffAttendance){
        gymStaffAttendanceService.addStaffAttendance(gymStaffAttendance);
    }

    @PutMapping("/staffAttendance/{staffId}")
    @CrossOrigin
public void updateAttendance(@RequestBody GymStaffAttendance gymStaffAttendance , @PathVariable("staffId") Integer staffId){
        gymStaffAttendanceService.updateStaffAttendance(gymStaffAttendance);
    }

}
