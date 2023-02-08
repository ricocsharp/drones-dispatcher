package com.musalasoft.dronesdispatcher.service;

import com.musalasoft.dronesdispatcher.data.entities.Medication;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

public interface MedicationService {
    Medication SaveMedication(Medication medication) throws IOException;
    Medication GetInfoById(Long id);
    byte[] GetImage(Long id);
    List<Medication> GetMedications(@RequestParam(required = false) String name);
    void Delete(long id);
    void DeleteAll();
}
