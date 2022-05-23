package com.oystergms.oysterapi.gymtrainer.repository;

import com.oystergms.oysterapi.gymtrainer.model.GymTrainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymTrainerRepository  extends JpaRepository<GymTrainer,Integer> {

}
