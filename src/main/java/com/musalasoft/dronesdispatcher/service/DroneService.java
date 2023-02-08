package com.musalasoft.dronesdispatcher.service;

import com.musalasoft.dronesdispatcher.data.entities.Drone;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

public interface DroneService {
    Drone SaveDrone(Drone drone) throws IOException;
    Drone GetInfoById(Long id);
    List<Drone> GetDrones(@RequestParam(required = false) String name);
    void Delete(Long id);
    void DeleteAll();

}
