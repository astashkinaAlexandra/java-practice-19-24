package com.example.practice_15.controller;

import com.example.practice_15.model.Manufacture;
import com.example.practice_15.service.ManufactureService;
import com.example.practice_15.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufactures")
public class ManufactureController {

    private final ManufactureService manufactureService;

    private final EmailServiceImpl emailService;

    @Autowired
    public ManufactureController(ManufactureService manufactureService, EmailServiceImpl emailService) {
        this.manufactureService = manufactureService;
        this.emailService = emailService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Manufacture> getAllManufactures() {
        return manufactureService.getAllManufactures();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Manufacture getManufacture(@PathVariable int id) {
        return manufactureService.getManufacture(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Manufacture createManufacture(@RequestBody Manufacture manufacture) {
        emailService.sendSimpleMessage("astashkina_alexandra@mail.ru", "", "added new manufacture with id " + manufacture.getId());
        return manufactureService.createManufacture(manufacture);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteManufacture(@PathVariable int id) {
        manufactureService.deleteManufacture(id);
    }
}
