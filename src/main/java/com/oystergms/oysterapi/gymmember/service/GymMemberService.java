package com.oystergms.oysterapi.gymmember.service;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gymmember.repository.GymMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymMemberService {

    private final GymMemberRepository gymMemberRepository;

    public GymMemberService(GymMemberRepository gymMemberRepository) {
        this.gymMemberRepository = gymMemberRepository;
    }


    public List<GymMember> getAllGymMembers() {
        return gymMemberRepository.findAll();
    }

    public void addGymMember(GymMember gymMember) {
        gymMemberRepository.save(gymMember);
    }

    public String deleteGymMemberById(Integer gymMemberId) {
        gymMemberRepository.deleteById(gymMemberId);
        return "Selected Member Deleted !";
    }
}
