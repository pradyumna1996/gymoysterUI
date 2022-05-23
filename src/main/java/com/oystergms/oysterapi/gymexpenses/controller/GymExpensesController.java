package com.oystergms.oysterapi.gymexpenses.controller;

import com.oystergms.oysterapi.gymexpenses.model.GymExpenses;
import com.oystergms.oysterapi.gymexpenses.service.GymExpensesService;
import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GymExpensesController {

    private final GymExpensesService gymExpensesService;

    public GymExpensesController(GymExpensesService gymExpensesService) {
        this.gymExpensesService = gymExpensesService;
    }

    @GetMapping("/gymExpenses")
    public ResponseEntity<Object> getAllGymExpenses(){

        List<GymExpenses> gymExpensesList = gymExpensesService.getAllExpenses();
        return GymResponseHandler.generateResponse("Data Fetched" , HttpStatus.OK ,gymExpensesList);
    }

    @PostMapping("/gymExpenses")
    public ResponseEntity<Object> addGymExpense(@RequestBody GymExpenses gymExpenses){

        GymExpenses gymExp= gymExpensesService.addExpense(gymExpenses);
        return GymResponseHandler.generateResponse("Data Inserted", HttpStatus.OK,gymExp);
    }

    @PutMapping("/gymExpenses")
    public ResponseEntity<Object> updateGymExpense(@RequestBody GymExpenses gymExpenses){

        GymExpenses gymExp= gymExpensesService.addExpense(gymExpenses);
        return GymResponseHandler.generateResponse("Data Modified", HttpStatus.OK,gymExp);
    }

    @DeleteMapping("/gymExpenses/{gymExpenseId}")
    public ResponseEntity<Object> deleteGymExpense(@PathVariable("gymExpenseId") Integer expenseId){

        String result = gymExpensesService.deleteExpense(expenseId);

        return GymResponseHandler.generateResponse("Deleted", HttpStatus.OK , result);
    }

}
