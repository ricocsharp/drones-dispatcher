package com.musalasoft.dronesdispatcher.controller;

import com.musalasoft.dronesdispatcher.data.model.Medication;
import com.musalasoft.dronesdispatcher.service.MedicationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.Pattern;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
@Validated
public class MedicationController {
    @Autowired
    private MedicationServiceImp medicationService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/medication")
    public ResponseEntity<Medication> CreateMedication(@RequestParam @Pattern(regexp="^[a-zA-Z0-9_-]*$",message=" The name field must be letters, numbers, underscores, and dashes") String name, @RequestParam Double weight, @RequestParam @Pattern(regexp="^[A-Z0-9_-]*$",message=" the code allowed only upper case letters, underscore and numbers") String code, @RequestParam MultipartFile file) throws IOException
    {
        Medication medication= new Medication();
        medication.setCode(code);
        medication.setName(name);
        medication.setWeight(weight);
        medication.setMedicationImage(file.getBytes());
        Medication returnMedication=medicationService.SaveMedication(medication);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(returnMedication);
    }
    @GetMapping("/mediation/{id}")
    public ResponseEntity<Medication> GetMedication(@PathVariable Long id) {
        Medication result = medicationService.GetInfoById(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @PutMapping("/mediation/{id}")
    public ResponseEntity<Medication> UpdateMedication(@PathVariable("id") long id, @RequestBody Medication medication) throws IOException {
        Optional<Medication> medicationData = Optional.ofNullable(medicationService.GetInfoById(id));
        if (medicationData.isPresent()) {
            Medication _medication = medicationData.get();
            _medication.setName(medication.getName());
            _medication.setCode(medication.getCode());
            _medication.setWeight(medication.getWeight());
            return new ResponseEntity<>(medicationService.SaveMedication(_medication), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/mediation")
    public ResponseEntity<List<Medication>> getAllMedications(@RequestParam(required = false) String name) {
        try {
            List<Medication> medications = medicationService.GetMedications(name);
            if(medications.isEmpty()){
                return new ResponseEntity<>(medications, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(medications, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/medication/{id}")
    public ResponseEntity<HttpStatus> deleteMedication(@PathVariable("id") long id) {
        try {
            medicationService.Delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            medicationService.DeleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
