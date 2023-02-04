package com.musalasoft.dronesdispatcher.data.repository;

import com.musalasoft.dronesdispatcher.data.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findByNameContaining(String title);
}
