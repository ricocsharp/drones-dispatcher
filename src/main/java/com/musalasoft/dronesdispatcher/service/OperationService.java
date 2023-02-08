package com.musalasoft.dronesdispatcher.service;

import org.springframework.scheduling.annotation.Scheduled;

public interface OperationService {
  Boolean CheckBattery(Long id);
}
