package com.musalasoft.dronesdispatcher.controller;

import com.musalasoft.dronesdispatcher.data.entities.Drone;
import com.musalasoft.dronesdispatcher.service.DroneServiceImp;
import com.musalasoft.dronesdispatcher.service.OperationsServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Validated
public class DronesController {
    private DroneServiceImp droneService;
    private OperationsServiceImp operationsService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/drone")
    public ResponseEntity<Drone> CreateMedication(@RequestBody Drone drone) throws IOException
    {
        Drone droneToSave= new Drone();
        droneToSave.setModel(drone.getModel());
        droneToSave.setState(drone.getState());
        droneToSave.setBatteryCapacity(drone.getBatteryCapacity());
        droneToSave.setWeightLimit(drone.getWeightLimit());
        droneToSave.setSerialNumber(drone.getSerialNumber());
        Drone returnDrone=droneService.SaveDrone(droneToSave);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(returnDrone);
    }
    @GetMapping("/drone/{id}")
    public ResponseEntity<Drone> GetDrone(@PathVariable Long id) {
        Drone result = droneService.GetInfoById(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(result);
    }
    @PutMapping("/drone/{id}")
    public ResponseEntity<Drone> UpdateMedication(@PathVariable("id") long id, @RequestBody Drone drone) throws IOException {
        Optional<Drone> droneData = Optional.ofNullable(droneService.GetInfoById(id));
        if (droneData.isPresent()) {
            Drone _drone = droneData.get();
            _drone.setSerialNumber(drone.getSerialNumber());
            _drone.setWeightLimit(drone.getWeightLimit());
            _drone.setModel(drone.getModel());
            _drone.setBatteryCapacity(drone.getBatteryCapacity());
            _drone.setState(drone.getState());
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(droneService.SaveDrone(_drone));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/drone")
    public ResponseEntity<List<Drone>> GetAllDrones(@RequestParam(required = false) String name) {
        try {
            List<Drone> drones = droneService.GetDrones(name);
            if(drones.isEmpty()){
                return new ResponseEntity<>(drones, HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(drones);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/drone/{id}")
    public ResponseEntity<HttpStatus> DeleteDrone(@PathVariable("id") long id) {
        try {
            droneService.Delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/drone")
    public ResponseEntity<HttpStatus> DeleteAllTutorials() {
        try {
            droneService.DeleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/drone/checkbattery/{id}")
    public ResponseEntity<Boolean> CheckBatteryLevel(@RequestParam(required = true) Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(operationsService.CheckBattery(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
