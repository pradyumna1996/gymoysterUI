package com.oystergms.oysterapi.gymstaff.controller;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gymstaff.model.GymStaff;
import com.oystergms.oysterapi.gymstaff.service.GymStaffRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GymStaffController {

    private final GymStaffRepositoryService gymStaffRepositoryService;

    public GymStaffController(GymStaffRepositoryService gymStaffRepositoryService) {
        this.gymStaffRepositoryService = gymStaffRepositoryService;
    }

    @GetMapping("/gymStaffs")
    public ResponseEntity<List<GymStaff>> getAllStaffs(){
        List<GymStaff> gymStaffs = gymStaffRepositoryService.getAllGymStaffs();
        if (gymStaffs.size()<=0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return  ResponseEntity.of(Optional.of(gymStaffs));
        }
    }


    @PostMapping("/gymStaffs/addStaff")
    public ResponseEntity<?>  addGymStaff( @RequestBody GymStaff gymStaff){

        if (gymStaff.toString().equals("{}")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing insert in form");
        }
        if (gymStaff ==null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing inset in form");
        }

        if (gymStaff !=null){
            gymStaffRepositoryService.addGymStaff(gymStaff);
            return ResponseEntity.status(HttpStatus.OK).body("Staff added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in request");
    }
}
