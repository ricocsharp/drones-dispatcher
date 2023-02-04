package com.musalasoft.dronesdispatcher.service;

import com.musalasoft.dronesdispatcher.data.model.Medication;
import com.musalasoft.dronesdispatcher.data.repository.MedicationRepository;
import com.musalasoft.dronesdispatcher.util.ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;

@Service
@Slf4j
public class MedicationServiceImp implements MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;
    private static final Logger logger = LoggerFactory.getLogger(MedicationServiceImp.class);
    public Medication SaveMedication(Medication medication) throws IOException {
       Medication savedMedication = medicationRepository.save(Medication.builder()
                .name(medication.getName())
                .code(medication.getCode())
                .weight(medication.getWeight())
                .medicationImage(ImageUtil.compressImage(medication.getMedicationImage())).build());
        return savedMedication;
    }
    @Transactional
    public Medication GetInfoById(Long id) {
        Optional<Medication> medication = Optional.of(medicationRepository.getById(id));
        return Medication.builder()
                .name(medication.get().getName())
                .code(medication.get().getCode())
                .weight(medication.get().getWeight())
                .medicationImage(ImageUtil.decompressImage(medication.get().getMedicationImage())).build();
    }
    @Transactional
    public byte[] GetImage(Long id) {
        Optional<Medication> medication = medicationRepository.findById(id);
        byte[] image = ImageUtil.decompressImage(medication.get().getMedicationImage());
        return image;
    }
    @Override
    public List<Medication> GetMedications(String name) {
        List<Medication> medications = new ArrayList<>();
        try {
            if (name == null)
               medicationRepository.findAll().forEach(medications::add);
            else
                medicationRepository.findByNameContaining(name).forEach(medications::add);
            return medications;
        } catch (Exception ex) {
            logger.error("Error detected gettting medication's list",ex);
        }
        return medications;
    }
    @Override
    public void Delete(long id) {
        medicationRepository.deleteById(id);
    }
    @Override
    public void DeleteAll() {
        medicationRepository.deleteAll();
    }
}
