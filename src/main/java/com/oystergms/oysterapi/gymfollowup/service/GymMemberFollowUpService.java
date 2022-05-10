package com.oystergms.oysterapi.gymfollowup.service;

import com.oystergms.oysterapi.gymfollowup.model.GymMemberFollowUp;
import com.oystergms.oysterapi.gymfollowup.repository.GymMemberFollowUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymMemberFollowUpService {

    private final GymMemberFollowUpRepository gymMemberFollowUpRepository;

    public GymMemberFollowUpService(GymMemberFollowUpRepository gymMemberFollowUpRepository) {
        this.gymMemberFollowUpRepository = gymMemberFollowUpRepository;
    }


    public List<GymMemberFollowUp> getAllMemberFollowUp() {
        return gymMemberFollowUpRepository.findAll();
    }

    public void saveMemberFollowUp(GymMemberFollowUp gymMemberFollowUp) {
        gymMemberFollowUpRepository.save(gymMemberFollowUp);
    }
}
