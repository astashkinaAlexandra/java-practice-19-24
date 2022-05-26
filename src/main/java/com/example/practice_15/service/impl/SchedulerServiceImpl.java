package com.example.practice_15.service.impl;

import com.example.practice_15.model.Manufacture;
import com.example.practice_15.model.Worker;
import com.example.practice_15.repository.ManufactureRepository;
import com.example.practice_15.repository.WorkerRepository;
import com.example.practice_15.service.SchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@ManagedResource
public class SchedulerServiceImpl implements SchedulerService {

    private final WorkerRepository workerRepository;

    private final ManufactureRepository manufactureRepository;

    public SchedulerServiceImpl(WorkerRepository workerRepository, ManufactureRepository manufactureRepository) {
        this.workerRepository = workerRepository;
        this.manufactureRepository = manufactureRepository;
    }

    @ManagedOperation
    @Scheduled(fixedDelay = 60000)
    @Override
    public void saveEntities() {
        try {
            FileWriter workerFile = new FileWriter("/Users/alexandra/Desktop/db_workers.txt");
            FileWriter manufactureFile = new FileWriter("/Users/alexandra/Desktop/db_manufactures.txt");

            List<Manufacture> manufactures = manufactureRepository.findAll();
            List<Worker> workers = workerRepository.findAll();

            log.info("lists created");

            for (Manufacture manufacture : manufactures) {
                workerFile.write(manufacture + "\n");
            }

            log.info("manufactures added to manufactureFile");

            for (Worker worker : workers) {
                manufactureFile.write(worker + "\n");
            }

            log.info("workers added to workerFile");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}