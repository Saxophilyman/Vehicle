package ru.edu.spring.vehicle_02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandCreateDTO;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandDTO;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandUpdateDTO;
import ru.edu.spring.vehicle_02.exeption.ResourceNotFoundException;
import ru.edu.spring.vehicle_02.mapper.BrandMapper;
import ru.edu.spring.vehicle_02.models.Brand;
import ru.edu.spring.vehicle_02.models.Vehicle;
import ru.edu.spring.vehicle_02.repository.BrandRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    @Autowired
    public BrandService(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(brandMapper::map).toList();
    }
    //---------------------------------

    public BrandDTO getBrandById(long id) {
        Brand brand = brandRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Brand with id " + id + " not found"));
        return brandMapper.map(brand);
    }

    @Transactional
    public BrandDTO createBrand(BrandCreateDTO brandData) {
        Brand brand = brandMapper.map(brandData);
        brandRepository.save(brand);
        return brandMapper.map(brand);
    }

    @Transactional
    public BrandDTO updateBrand(long id, BrandUpdateDTO updatedBrandData) {
        Brand brand = brandRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Brand with id " + id + " not found"));
        brandMapper.update(updatedBrandData, brand);
        brandRepository.save(brand);
        return brandMapper.map(brand);

    }

    @Transactional
    public void deleteBrand(long id) {
        brandRepository.deleteById(id);
    }
}
