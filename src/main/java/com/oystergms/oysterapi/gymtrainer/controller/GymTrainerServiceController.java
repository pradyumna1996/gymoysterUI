package com.oystergms.oysterapi.gymtrainer.controller;

import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.gymtrainer.model.GymTrainer;
import com.oystergms.oysterapi.gymtrainer.service.GymTrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GymTrainerServiceController {


    private final GymTrainerService gymTrainerService;

    public GymTrainerServiceController(GymTrainerService gymTrainerService) {
        this.gymTrainerService = gymTrainerService;
    }

    @GetMapping("/gymTrainers")
    @CrossOrigin
    public ResponseEntity<Object> getAllGymTrainer(){

        List<GymTrainer> gymTrainerList = gymTrainerService.getAllTrainers();
        if(gymTrainerList.size()<=0){
        return GymResponseHandler.generateResponse("No Trainers Please Add", HttpStatus.OK,null);
    }else{
            return GymResponseHandler.generateResponse("Data fetched",HttpStatus.OK,gymTrainerList);
        }

    }

    @PostMapping("/gymTrainers")
    @CrossOrigin
    public ResponseEntity<Object> getAllGymTrainer(@RequestBody GymTrainer gymTrainer){

           GymTrainer trainer =  gymTrainerService.addGymTrainer(gymTrainer);
            return GymResponseHandler.generateResponse("No Trainers Please Add", HttpStatus.OK,trainer);

    }


}
