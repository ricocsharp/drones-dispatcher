package com.musalasoft.dronesdispatcher.data.repository;

import com.musalasoft.dronesdispatcher.data.entities.Medication;
import org.hibernate.annotations.Cache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findByNameContaining(String title);
}
