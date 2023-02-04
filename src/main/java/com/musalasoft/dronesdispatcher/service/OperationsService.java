package com.musalasoft.dronesdispatcher.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class OperationsService {

    @Scheduled(cron = "0 0/10 * * * ?")
    public void CheckBatteriesLevel() throws InterruptedException {

    }


}
