package com.example.practice_15.service.impl;

import com.example.practice_15.logging.LogExecutionTime;
import com.example.practice_15.model.Manufacture;
import com.example.practice_15.repository.ManufactureRepository;
import com.example.practice_15.service.ManufactureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class ManufactureServiceImpl implements ManufactureService {

    private final ManufactureRepository manufactureRepository;

    @Autowired
    public ManufactureServiceImpl(ManufactureRepository manufactureRepository) {
        this.manufactureRepository = manufactureRepository;
    }

    @Override
    @LogExecutionTime
    public List<Manufacture> getAllManufactures() {
        log.info("find all manufactures");
        return manufactureRepository.findAll();
    }

    @Override
    @LogExecutionTime
    public Manufacture getManufacture(int id) {
        log.info("find manufacture with id {}", id);
        return manufactureRepository.getOne(id);
    }

    @Override
    @LogExecutionTime
    public Manufacture createManufacture(Manufacture manufacture) {
        log.info("create new manufacture");
        return manufactureRepository.save(manufacture);
    }

    @Override
    @LogExecutionTime
    public void deleteManufacture(int id) {
        log.info("delete manufacture with id {}", id);
        manufactureRepository.deleteById(id);
    }
}
