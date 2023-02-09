package com.musalasoft.dronesdispatcher.service;

import com.musalasoft.dronesdispatcher.data.entities.Drone;
import com.musalasoft.dronesdispatcher.data.repository.DronesRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DroneServiceImp implements DroneService {
    @Autowired
    private DronesRepository dronesRepository;
    private static final Logger logger = LoggerFactory.getLogger(DroneServiceImp.class);


    @Override
    public Drone SaveDrone(Drone drone) throws IOException {
       return dronesRepository.save(Drone.builder()
                .serialNumber(drone.getSerialNumber())
                .model(drone.getModel())
                .batteryCapacity(drone.getBatteryCapacity())
                .weightLimit(drone.getWeightLimit())
                .state(drone.getState()).build());
    }

    @Override
    public Drone GetInfoById(Long id) {
        Optional<Drone> drone = Optional.of(dronesRepository.getById(id));
        return Drone.builder()
                .serialNumber(drone.get().getSerialNumber())
                .model(drone.get().getModel())
                .batteryCapacity(drone.get().getBatteryCapacity())
                .weightLimit(drone.get().getWeightLimit())
                .state(drone.get().getState()).build();
    }

    @Override
    public List<Drone> GetDrones(String name) {
        List<Drone> drones = new ArrayList<>();
        try {
            if (name == null)
                dronesRepository.findAll().forEach(drones::add);
            else
                dronesRepository.findByModelContaining(name).forEach(drones::add);
            return drones;
        } catch (Exception ex) {
            logger.error("Error detected gettting medication's list",ex);
        }
        return drones;
    }
    @Override
    public void Delete(Long id) {
        dronesRepository.deleteById(id);
    }
    @Override
    public void DeleteAll() {
        dronesRepository.deleteAll();
    }
}
