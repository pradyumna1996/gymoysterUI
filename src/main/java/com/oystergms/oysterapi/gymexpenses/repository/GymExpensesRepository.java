package com.oystergms.oysterapi.gymexpenses.repository;

import com.oystergms.oysterapi.gymexpenses.model.GymExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymExpensesRepository extends JpaRepository<GymExpenses,Integer> {
}
