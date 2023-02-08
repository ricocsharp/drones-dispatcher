package com.musalasoft.dronesdispatcher.data.repository;

import com.musalasoft.dronesdispatcher.data.dto.BateryChargeLogDto;
import com.musalasoft.dronesdispatcher.data.entities.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BateryChargeLogRepository extends JpaRepository<BateryChargeLogDto, Long> {
    Double GetChargeLevel(Long droneId);
}
