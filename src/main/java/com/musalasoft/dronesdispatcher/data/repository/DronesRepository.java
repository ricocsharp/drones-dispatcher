package com.musalasoft.dronesdispatcher.data.repository;

import com.musalasoft.dronesdispatcher.data.model.Drone;
import com.musalasoft.dronesdispatcher.data.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DronesRepository extends JpaRepository<Drone, Long> {
    List<Drone> findByNameContaining(String title);
}
