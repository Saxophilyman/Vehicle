package ru.edu.spring.vehicle_02.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandCreateDTO;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandDTO;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandUpdateDTO;
import ru.edu.spring.vehicle_02.models.Brand;
import ru.edu.spring.vehicle_02.services.BrandService;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping(path = "")
    public List<BrandDTO> index() {
        return brandService.getAllBrands();
    }


    @GetMapping("/{id}")
    public BrandDTO show(@PathVariable long id) {
        return brandService.getBrandById(id);
    }


    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public BrandDTO create(@Valid @RequestBody BrandCreateDTO brandData){
        return brandService.createBrand(brandData);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BrandDTO update(@PathVariable long id, @Valid @RequestBody BrandUpdateDTO brandData){
        return brandService.updateBrand(id, brandData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        brandService.deleteBrand(id);
    }

}
