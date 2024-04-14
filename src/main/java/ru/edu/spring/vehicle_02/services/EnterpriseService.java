package ru.edu.spring.vehicle_02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseCreateDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseUpdateDTO;
import ru.edu.spring.vehicle_02.exeption.ResourceNotFoundException;
import ru.edu.spring.vehicle_02.mapper.EnterpriseMapper;
import ru.edu.spring.vehicle_02.models.Enterprise;
import ru.edu.spring.vehicle_02.repository.EnterpriseRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    private final EnterpriseMapper enterpriseMapper;

    @Autowired
    public EnterpriseService(EnterpriseRepository enterpriseRepository, EnterpriseMapper enterpriseMapper) {
        this.enterpriseRepository = enterpriseRepository;
        this.enterpriseMapper = enterpriseMapper;
    }

    public List<EnterpriseDTO> getAllEnterprises() {
        List<Enterprise> enterprises = enterpriseRepository.findAll();
        return enterprises.stream().map(enterpriseMapper::map).toList();
    }

    public EnterpriseDTO getEnterpriseById(long id) {
        Enterprise enterprise = enterpriseRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Enterprise with id " + id + " not found"));
        return enterpriseMapper.map(enterprise);
    }

    @Transactional
    public EnterpriseDTO createEnterprise(EnterpriseCreateDTO enterpriseData) {
        Enterprise enterprise = enterpriseMapper.map(enterpriseData);
        enterpriseRepository.save(enterprise);
        return enterpriseMapper.map(enterprise);
    }

    @Transactional
    public EnterpriseDTO updateEnterprise(long id, EnterpriseUpdateDTO updatedEnterpriseData) {
        Enterprise enterprise = enterpriseRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Enterprise with id " + id + " not found"));
        enterpriseMapper.update(updatedEnterpriseData, enterprise);
        enterpriseRepository.save(enterprise);
        return enterpriseMapper.map(enterprise);
    }

    @Transactional
    public void deleteEnterprise(long id) {
        enterpriseRepository.deleteById(id);
    }


}
