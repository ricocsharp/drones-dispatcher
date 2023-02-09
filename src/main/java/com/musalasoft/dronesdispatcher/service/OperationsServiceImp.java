package com.musalasoft.dronesdispatcher.service;

import com.musalasoft.dronesdispatcher.config.DroneStateEnum;
import com.musalasoft.dronesdispatcher.data.entities.Drone;
import com.musalasoft.dronesdispatcher.data.repository.DronesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperationsServiceImp implements OperationsService {

    @Autowired
    private DronesRepository dronesRepository;

    private static final Logger logger = LoggerFactory.getLogger(DroneServiceImp.class);

    @Scheduled(cron = "0 0/10 * * * ?")
    public void CheckBattery() {
        List<Drone> drones = new ArrayList<>();
        dronesRepository.findAll().forEach(drones::add);
        for(Drone droneItem:drones){
            if(droneItem.getBatteryCapacity()<25){
                droneItem.setState(DroneStateEnum.EXHAUSTED);
                logger.info("Drone {} reached the allowed limit of battery charge",droneItem.getSerialNumber());
            }
            else if(droneItem.getState()==DroneStateEnum.EXHAUSTED && droneItem.getBatteryCapacity()>25){
                droneItem.setState(DroneStateEnum.IDLE);
            }
        }
    }
    public Double CheckBatteryCharge(Long id){
        return dronesRepository.getById(id).getBatteryCapacity();
    }
    public List<Drone> GetAvailableDrones(String state){
        return dronesRepository.findByState(state);
    }
}
