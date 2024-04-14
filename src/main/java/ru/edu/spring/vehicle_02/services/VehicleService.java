package ru.edu.spring.vehicle_02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleCreateDTO;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleDTO;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleUpdateDTO;
import ru.edu.spring.vehicle_02.exeption.ResourceNotFoundException;
import ru.edu.spring.vehicle_02.mapper.VehicleMapper;
import ru.edu.spring.vehicle_02.models.Driver;
import ru.edu.spring.vehicle_02.models.Vehicle;
import ru.edu.spring.vehicle_02.repository.DriverRepository;
import ru.edu.spring.vehicle_02.repository.VehicleRepository;

@Service
@Transactional(
        readOnly = true
)
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper;

    private final DriverRepository driverRepository;
    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, DriverRepository driverRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
        this.driverRepository = driverRepository;
    }

    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(vehicleMapper::map).toList();
    }

    public void setDriverForVehicle(long vehicle_id, long driver_id){

        Vehicle vehicle = vehicleRepository.findById(vehicle_id).orElseThrow(() ->
                new ResourceNotFoundException("Vehicle with id " + vehicle_id + " not found"));
        Driver driver = driverRepository.findById(driver_id).orElseThrow(() ->
                new ResourceNotFoundException("Vehicle with id " + driver_id + " not found"));
        vehicle.getDrivers_list().add(driver);
        driver.getVehicles_list().add(vehicle);
        vehicleRepository.save(vehicle);
        driverRepository.save(driver);
    }
    public VehicleDTO getVehicleById(long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Vehicle with id " + id + " not found"));
        return vehicleMapper.map(vehicle);
    }

    @Transactional
    public VehicleDTO createVehicle(VehicleCreateDTO vehicleData) {
        Vehicle vehicle = vehicleMapper.map(vehicleData);
        vehicleRepository.save(vehicle);
        return vehicleMapper.map(vehicle);
    }

    @Transactional
    public VehicleDTO updateVehicle(long id, VehicleUpdateDTO updatedVehicleData) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Vehicle with id " + id + " not found"));
        vehicleMapper.update(updatedVehicleData, vehicle);
        vehicleRepository.save(vehicle);
        return vehicleMapper.map(vehicle);
    }

    @Transactional
    public void deleteVehicle(long id) {
        vehicleRepository.deleteById(id);
    }
}