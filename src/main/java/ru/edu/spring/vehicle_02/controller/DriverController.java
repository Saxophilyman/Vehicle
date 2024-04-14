package ru.edu.spring.vehicle_02.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverCreateDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverUpdateDTO;
import ru.edu.spring.vehicle_02.models.Driver;
import ru.edu.spring.vehicle_02.services.DriverService;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;


    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(path = "")
    public List<DriverDTO> index() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public DriverDTO show(@PathVariable long id) {
        return driverService.getDriverById(id);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO create(@Valid @RequestBody DriverCreateDTO driverData) {
        return driverService.createDriver(driverData);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DriverDTO update(@PathVariable long id, @Valid @RequestBody DriverUpdateDTO driverData) {
        return driverService.updateDriver(id, driverData);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        driverService.deleteDriver(id);
    }
}
