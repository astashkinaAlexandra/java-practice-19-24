package com.example.practice_15.service.impl;

import com.example.practice_15.logging.LogExecutionTime;
import com.example.practice_15.model.Worker;
import com.example.practice_15.repository.WorkerRepository;
import com.example.practice_15.service.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    @LogExecutionTime
    public List<Worker> getAllWorkers() {
        log.info("find all workers");
        return workerRepository.findAll();
    }

    @Override
    @LogExecutionTime
    public Worker getWorker(int id) {
        log.info("find worker with id {}", id);
        return workerRepository.getOne(id);
    }

    @Override
    @LogExecutionTime
    public Worker createWorker(Worker worker) {
        log.info("create new worker");
        return workerRepository.save(worker);
    }

    @Override
    @LogExecutionTime
    public void deleteWorker(int id) {
        log.info("delete worker with id {}", id);
        if (workerRepository.existsById(id)) {
            workerRepository.deleteById(id);
        }
    }
}
