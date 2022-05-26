package com.example.practice_15.service;

import com.example.practice_15.model.Manufacture;

import java.util.List;

public interface ManufactureService {
    List<Manufacture> getAllManufactures();

    Manufacture getManufacture(int id);

    Manufacture createManufacture(Manufacture manufacture);

    void deleteManufacture(int id);
}
