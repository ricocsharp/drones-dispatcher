package com.musalasoft.dronesdispatcher.controller;

import com.musalasoft.dronesdispatcher.service.DroneServiceImp;
import com.musalasoft.dronesdispatcher.service.MedicationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Validated
public class OperationsController {
    @Autowired
    private DroneServiceImp droneService;
    @Autowired
    private MedicationServiceImp medicationService;


}
