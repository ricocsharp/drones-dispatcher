package com.musalasoft.dronesdispatcher.service;

import com.musalasoft.dronesdispatcher.data.entities.Drone;
import com.musalasoft.dronesdispatcher.data.repository.DronesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationsServiceImp implements OperationsService {

    @Autowired
    private DronesRepository dronesRepository;
    private static final Logger logger = LoggerFactory.getLogger(DroneServiceImp.class);

    @Scheduled(cron = "0 0/10 * * * ?")
    @Override
    public Boolean CheckBattery(Long id) {
        Optional<Drone> drone = Optional.of(dronesRepository.getById(id));
        if(!drone.isPresent())
            return false;
        return drone.get().getBatteryCapacity()<25?Boolean.FALSE:Boolean.TRUE;
    }


}
