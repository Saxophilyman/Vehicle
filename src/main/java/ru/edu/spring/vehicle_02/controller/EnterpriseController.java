package ru.edu.spring.vehicle_02.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseCreateDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseUpdateDTO;
import ru.edu.spring.vehicle_02.models.Enterprise;
import ru.edu.spring.vehicle_02.services.EnterpriseService;

import java.util.List;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {
    private final EnterpriseService enterpriseService;

    @Autowired
    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    //get_all
    @GetMapping(path = "")
    public List<EnterpriseDTO> index() {
        return enterpriseService.getAllEnterprises();
    }

    @GetMapping("/{id}")
    public EnterpriseDTO show(@PathVariable long id) {
        return enterpriseService.getEnterpriseById(id);
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public EnterpriseDTO create(@Valid @RequestBody EnterpriseCreateDTO enterpriseData) {
        return enterpriseService.createEnterprise(enterpriseData);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EnterpriseDTO update(@PathVariable long id, @Valid @RequestBody EnterpriseUpdateDTO enterpriseData) {
        return enterpriseService.updateEnterprise(id, enterpriseData);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        enterpriseService.deleteEnterprise(id);
    }

}
