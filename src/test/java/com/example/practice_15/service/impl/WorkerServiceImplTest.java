package com.example.practice_15.service.impl;

import com.example.practice_15.model.Worker;
import com.example.practice_15.repository.WorkerRepository;
import com.example.practice_15.service.WorkerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class WorkerServiceImplTest {

    @Mock
    private WorkerRepository workerRepository;

    @Test
    void getAllWorkers() {
        Worker worker1 = new Worker();
        worker1.setFirstName("Sasha");
        Worker worker2 = new Worker();
        worker2.setFirstName("Misha");
        Mockito.when(workerRepository.findAll()).thenReturn(List.of(worker1, worker2));
        WorkerService workerService = new WorkerServiceImpl(workerRepository);
        Assertions.assertEquals(2, workerService.getAllWorkers().size());
        Assertions.assertEquals("Sasha", workerService.getAllWorkers().get(0).getFirstName());
    }

    @Test
    void getWorker() {
        Worker worker = new Worker();
        worker.setId(1);
        Mockito.when(workerRepository.getOne(1)).thenReturn(worker);
        WorkerService workerService = new WorkerServiceImpl(workerRepository);
        Assertions.assertEquals(1, workerService.getWorker(1).getId());
    }

    @Test
    void createWorker() {
        Worker worker = new Worker();
        worker.setId(1);
        Mockito.when(workerRepository.save(worker)).thenReturn(worker);
        WorkerService workerService = new WorkerServiceImpl(workerRepository);
        Assertions.assertEquals(1, workerService.createWorker(worker).getId());
    }
}