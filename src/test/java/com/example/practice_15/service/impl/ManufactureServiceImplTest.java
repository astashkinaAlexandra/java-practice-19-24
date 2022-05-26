package com.example.practice_15.service.impl;

import com.example.practice_15.model.Manufacture;
import com.example.practice_15.repository.ManufactureRepository;
import com.example.practice_15.service.ManufactureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ManufactureServiceImplTest {

    @Mock
    private ManufactureRepository manufactureRepository;

    @Test
    void getAllManufactures() {
        Manufacture manufacture1 = new Manufacture();
        manufacture1.setId(1);
        Manufacture manufacture2 = new Manufacture();
        manufacture2.setId(2);
        Mockito.when(manufactureRepository.findAll()).thenReturn(List.of(manufacture1, manufacture2));
        ManufactureService manufactureService = new ManufactureServiceImpl(manufactureRepository);
        Assertions.assertEquals(2, manufactureService.getAllManufactures().size());
        Assertions.assertEquals(1, manufactureService.getAllManufactures().get(0).getId());
    }

    @Test
    void getManufacture() {
        Manufacture manufacture = new Manufacture();
        manufacture.setId(1);
        Mockito.when(manufactureRepository.getOne(1)).thenReturn(manufacture);
        ManufactureService manufactureService = new ManufactureServiceImpl(manufactureRepository);
        Assertions.assertEquals(1, manufactureService.getManufacture(1).getId());
    }

    @Test
    void createManufacture() {
        Manufacture manufacture = new Manufacture();
        manufacture.setId(1);
        Mockito.when(manufactureRepository.save(manufacture)).thenReturn(manufacture);
        ManufactureService manufactureService = new ManufactureServiceImpl(manufactureRepository);
        Assertions.assertEquals(1, manufactureService.createManufacture(manufacture).getId());
    }
}