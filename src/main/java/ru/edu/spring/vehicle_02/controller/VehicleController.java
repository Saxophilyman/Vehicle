package ru.edu.spring.vehicle_02.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleCreateDTO;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleDTO;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleDTOForSetDriver;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleUpdateDTO;
import ru.edu.spring.vehicle_02.exeption.PersonNotCreatedException;
import ru.edu.spring.vehicle_02.models.Vehicle;
import ru.edu.spring.vehicle_02.services.BrandService;
import ru.edu.spring.vehicle_02.services.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {


    private final VehicleService vehicleService;
    private final BrandService brandService;

    @Autowired
    public VehicleController(VehicleService vehicleService, BrandService brandService) {
        this.vehicleService = vehicleService;
        this.brandService = brandService;
    }

    @GetMapping(path = "")
    public List<VehicleDTO> index() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public VehicleDTO show(@PathVariable("id") long id) {
        return vehicleService.getVehicleById(id);
    }


    @PostMapping(path = "/{id}/setDriver/{id}")
    public void setDriverForVehicle(@PathVariable("id") long vehicle_id, @PathVariable("id") long driver_id){
        vehicleService.setDriverForVehicle(vehicle_id, driver_id);
    }


    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleDTO create(@Valid @RequestBody VehicleCreateDTO vehicleData,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder er = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                er.append(error.getField()).append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }
            throw new PersonNotCreatedException(er.toString());
        }

        return vehicleService.createVehicle(vehicleData);
    }


    @PutMapping("/{id}")
    public VehicleDTO update(@PathVariable long id, @Valid @RequestBody VehicleUpdateDTO vehicleData) {
        return vehicleService.updateVehicle(id, vehicleData);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        vehicleService.deleteVehicle(id);
    }

}
