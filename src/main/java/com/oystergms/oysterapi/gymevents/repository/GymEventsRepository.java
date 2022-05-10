package com.oystergms.oysterapi.gymevents.repository;


import com.oystergms.oysterapi.gymevents.model.GymEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymEventsRepository extends JpaRepository<GymEvents, Integer> {
}
