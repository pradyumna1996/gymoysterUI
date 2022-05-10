package com.oystergms.oysterapi.gymstaff.service;

import com.oystergms.oysterapi.gymstaff.model.GymStaff;
import com.oystergms.oysterapi.gymstaff.repository.GymStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymStaffRepositoryService {

    private final GymStaffRepository gymStaffRepository;

    public GymStaffRepositoryService(GymStaffRepository gymStaffRepository) {
        this.gymStaffRepository = gymStaffRepository;
    }


    public List<GymStaff> getAllGymStaffs() {
        return  gymStaffRepository.findAll();
    }

    public void addGymStaff(GymStaff gymStaff) {
        gymStaffRepository.save(gymStaff);
    }
}
