package com.example.practice_15.controller;

import com.example.practice_15.model.Worker;
import com.example.practice_15.service.WorkerService;
import com.example.practice_15.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    private final EmailServiceImpl emailService;

    @Autowired
    public WorkerController(WorkerService workerService, EmailServiceImpl emailService) {
        this.workerService = workerService;
        this.emailService = emailService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Worker createWorker(@PathVariable("id") int id) {
        return workerService.getWorker(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Worker createWorker(@RequestBody Worker worker) {
        emailService.sendSimpleMessage("astashkina_alexandra@mail.ru", "", "added new worker with id " + worker.getId());
        return workerService.createWorker(worker);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteWorker(@PathVariable int id) {
        workerService.deleteWorker(id);
    }
}

