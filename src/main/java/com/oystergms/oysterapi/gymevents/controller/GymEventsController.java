package com.oystergms.oysterapi.gymevents.controller;


import com.oystergms.oysterapi.gymevents.model.GymEvents;
import com.oystergms.oysterapi.gymevents.service.GymEventsService;
import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
public class GymEventsController {
    private final GymEventsService gymEventsService;

    public GymEventsController(GymEventsService gymEventsService) {
        this.gymEventsService = gymEventsService;
    }

    @GetMapping("/gymEvents")
    public ResponseEntity<Object> getAllGymEvents(){

        try {
            List<GymEvents> gymEvents = gymEventsService.getAllGymEvents();
            return GymResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, gymEvents);
        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    @PostMapping("/gymEvents/addEvent")
    public ResponseEntity<Object> addGymEvent( @RequestBody GymEvents gymEvents) {
        try {
            if (gymEvents.toString().equals("{}")) {
                return GymResponseHandler.generateResponse("Error in Request", HttpStatus.MULTI_STATUS, null);
            }else {
                gymEventsService.addGymEvent(gymEvents);
                return GymResponseHandler.generateResponse("Events Entered Successful.", HttpStatus.OK, gymEvents);
            }
            }catch (Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }

    @PutMapping("/gymEvents/editEvent/{gymEventId}")
    public void updateGymEvent(@RequestBody GymEvents gymEvents , @PathVariable("gymEventId") Integer gymEventId){
        gymEventsService.updateGymEvent(gymEvents);
    }

    @DeleteMapping("/gymEvents/deleteEvent/{gymEventId}")
    public ResponseEntity<Object> deleteGymEvent(@PathVariable("gymEventId") Integer gymEventId){

        try {
            String result = gymEventsService.deleteGymEvent(gymEventId);
            return GymResponseHandler.generateResponse("Event Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }



}
