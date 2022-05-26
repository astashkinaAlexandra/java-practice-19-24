package com.example.practice_15.service;

import com.example.practice_15.model.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> getAllWorkers();

    Worker getWorker(int id);

    Worker createWorker(Worker worker);

    void deleteWorker(int id);
}
