package com.musalasoft.dronesdispatcher.service;

import org.springframework.scheduling.annotation.Scheduled;

public interface OperationsService {
    @Scheduled(cron = "0 0/10 * * * ?")
    Boolean CheckBattery(Long id);
}
