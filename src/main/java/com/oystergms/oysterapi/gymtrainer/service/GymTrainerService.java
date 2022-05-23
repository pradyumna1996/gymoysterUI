package com.oystergms.oysterapi.gymtrainer.service;

import com.oystergms.oysterapi.gymtrainer.model.GymTrainer;
import com.oystergms.oysterapi.gymtrainer.repository.GymTrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymTrainerService {

    private final GymTrainerRepository gymTrainerRepository;

    public GymTrainerService(GymTrainerRepository gymTrainerRepository) {
        this.gymTrainerRepository = gymTrainerRepository;
    }

    public List<GymTrainer> getAllTrainers() {
        return gymTrainerRepository.findAll();
    }

    public GymTrainer addGymTrainer(GymTrainer gymTrainer) {
        return gymTrainerRepository.save(gymTrainer);
    }


}
