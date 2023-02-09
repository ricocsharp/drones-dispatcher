package com.musalasoft.dronesdispatcher.controller;

import com.musalasoft.dronesdispatcher.data.dto.DroneDto;
import com.musalasoft.dronesdispatcher.data.entities.Drone;
import com.musalasoft.dronesdispatcher.data.mapper.DroneMapper;
import com.musalasoft.dronesdispatcher.service.DroneServiceImp;
import com.musalasoft.dronesdispatcher.service.OperationsServiceImp;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class DronesController {
    @Autowired
    private DroneServiceImp droneService;
    @Autowired
    private OperationsServiceImp operationsService;
    @Autowired
    private DroneMapper droneMapper;

    @ApiOperation(value = "Creates a Drone", response = Drone.class, notes = "Drone must exist")
    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/drones")
    public ResponseEntity<DroneDto> CreateDrone(@RequestBody DroneDto drone) throws IOException
    {
        Drone droneToSave= droneMapper.toEntity(drone);
        Drone savedDrone =droneService.SaveDrone(droneToSave);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(droneMapper.toDto(savedDrone));
    }

    @ApiOperation(value = "Gets Drone by ID",response = Drone.class, notes = "Drone must exist")
    @GetMapping("/drones/{id}")
    public ResponseEntity<Drone> GetDrone(@PathVariable Long id) {
        Drone result = droneService.GetInfoById(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(result);
    }

    @ApiOperation(value = "Update Drone",response = Drone.class, notes = "Drone must exist")
    @PutMapping("/drones/{id}")
    public ResponseEntity<DroneDto> UpdateDrone(@PathVariable("id") long id, @RequestBody DroneDto drone) throws IOException {
        Optional<Drone> droneData = Optional.ofNullable(droneService.GetInfoById(id));
        if (droneData.isPresent()) {
            Drone _drone = droneData.get();
            _drone.setSerialNumber(drone.getSerialNumber());
            _drone.setWeightLimit(drone.getWeightLimit());
            _drone.setModel(drone.getModel());
            _drone.setBatteryCapacity(drone.getBatteryCapacity());
            _drone.setState(drone.getState());
            Drone droneUpdated = droneService.SaveDrone(_drone);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(droneMapper.toDto(droneUpdated));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Gets Drone by Name",response = DroneDto.class,notes = "Drone must exist")
    @GetMapping("/drones")
    public ResponseEntity<List<DroneDto>> GetAllDrones(@RequestParam(required = false) String name) {
        try {
            List<Drone> drones = droneService.GetDrones(name);
            List<DroneDto> result= droneMapper.toDtoList(drones);
            if(drones.isEmpty()){
                return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
            }
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(result);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Deletes a Drone by ID", notes = "Drone must exist")
    @DeleteMapping("/drones/{id}")
    public ResponseEntity<HttpStatus> DeleteDrone(@PathVariable("id") long id) {
        try {
            droneService.Delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Deletes all Drones")
    @DeleteMapping("/drones")
    public ResponseEntity<HttpStatus> DeleteAllDrones() {
        try {
            droneService.DeleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
