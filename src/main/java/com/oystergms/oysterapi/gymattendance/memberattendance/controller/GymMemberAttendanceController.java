package com.oystergms.oysterapi.gymattendance.memberattendance.controller;

import com.oystergms.oysterapi.gymattendance.memberattendance.model.GymMemberAttendance;
import com.oystergms.oysterapi.gymattendance.memberattendance.service.GymMemberAttendanceService;
import com.oystergms.oysterapi.gymevents.model.GymEvents;
import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MemberAttendanceController {

    @Autowired
    private GymMemberAttendanceService gymMemberAttendanceService;

    @GetMapping("/gymMemberAttendance")
    public ResponseEntity<Object> getAllAttendanceList(){

        try {
            List<GymMemberAttendance> gymMemberAttendances = gymMemberAttendanceService.getAttendanceList();
            if(gymMemberAttendances.size()<=0){
                return GymResponseHandler.generateResponse("No data Found !", HttpStatus.OK, null);
            }else {
                return GymResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, gymMemberAttendances);
            }

        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @GetMapping("/gymMemberAttendance/{today}")
    public ResponseEntity<Object> getTodaysAttendanceList(@PathVariable("today") String today){

        try {
            List<GymMemberAttendance> gymMemberAttendances = gymMemberAttendanceService.getTodayAttendanceList(today);
            return GymResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, gymMemberAttendances);
        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    @PostMapping("/gymMemberAttendance")
    public ResponseEntity<Object> addMemberAttendance(@RequestBody List<GymMemberAttendance> gymMemberAttendances){

        try {
            gymMemberAttendances.forEach(
                    gymMemberAttendance -> gymMemberAttendanceService.saveMemberAttendance(gymMemberAttendance));

            return GymResponseHandler.generateResponse("Member Attendance Added !" , HttpStatus.OK , gymMemberAttendances);
        }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS ,null);
        }
    }

    @PutMapping("/gymMemberAttendance/{memberAttendanceId}")
    public void updateMemberAttendance(@RequestBody GymMemberAttendance gymMemberAttendance , @PathVariable("memberAttendanceId") Integer memberAttendanceId){
        gymMemberAttendanceService.updateMemberAttendance(gymMemberAttendance);
    }

    @DeleteMapping("/gymMemberAttendance/{memberAttendanceId}")
    public ResponseEntity<Object> deleteMemberAttendance(@PathVariable("memberAttendanceId") Integer memberAttendanceId){

        try {
            String result = gymMemberAttendanceService.deleteMemberAttendance(memberAttendanceId);
            return GymResponseHandler.generateResponse("Attendance Deleted !", HttpStatus.OK, result);
        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }


    }
}
