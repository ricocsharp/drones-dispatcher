package com.musalasoft.dronesdispatcher.service;

import com.musalasoft.dronesdispatcher.data.entities.Drone;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface OperationsService {
    @Scheduled(cron = "0 0/10 * * * ?")
    void CheckBattery();
    Double CheckBatteryCharge(Long id);
    List<Drone> GetAvailableDrones(String state);
}
