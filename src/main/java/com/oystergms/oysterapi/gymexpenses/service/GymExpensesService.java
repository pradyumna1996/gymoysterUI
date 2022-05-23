package com.oystergms.oysterapi.gymexpenses.service;

import com.oystergms.oysterapi.gymexpenses.model.GymExpenses;
import com.oystergms.oysterapi.gymexpenses.repository.GymExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymExpensesService {

    private final GymExpensesRepository gymExpensesRepository;

    public GymExpensesService(GymExpensesRepository gymExpensesRepository) {
        this.gymExpensesRepository = gymExpensesRepository;
    }


    public List<GymExpenses> getAllExpenses() {

        return  gymExpensesRepository.findAll();
    }

    public GymExpenses addExpense(GymExpenses gymExpenses) {

        return gymExpensesRepository.save(gymExpenses);
    }


    public String deleteExpense(Integer expenseId) {
        gymExpensesRepository.deleteById(expenseId);
        return "Expense is Deleted";
    }
}
