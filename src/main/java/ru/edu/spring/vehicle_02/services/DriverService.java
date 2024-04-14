package ru.edu.spring.vehicle_02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverCreateDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverUpdateDTO;
import ru.edu.spring.vehicle_02.exeption.ResourceNotFoundException;
import ru.edu.spring.vehicle_02.mapper.DriverMapper;
import ru.edu.spring.vehicle_02.models.Driver;
import ru.edu.spring.vehicle_02.models.Vehicle;
import ru.edu.spring.vehicle_02.repository.DriverRepository;
import ru.edu.spring.vehicle_02.repository.VehicleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DriverService {
    private final DriverRepository driverRepository;

    private final DriverMapper driverMapper;

    private final VehicleRepository vehicleRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository, DriverMapper driverMapper, VehicleRepository vehicleRepository) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
        this.vehicleRepository = vehicleRepository;
    }

    public List<DriverDTO> getAllDrivers() {
        List<Driver> drivers = driverRepository.findAll();
        return drivers.stream().map(driverMapper::map).toList();
    }

    public DriverDTO getDriverById(long id) {
        Driver driver = driverRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Driver with id " + id + " not found"));
        return driverMapper.map(driver);
    }

    @Transactional
    public DriverDTO createDriver(DriverCreateDTO driverData) {
        Driver driver = driverMapper.map(driverData);
        //Создаваемый водитель исходно ни к какой машине не привязан.
        driver.setActive_vehicle_of_driver(null);
        driverRepository.save(driver);
        return driverMapper.map(driver);
    }

    @Transactional
    public DriverDTO updateDriver(long id, DriverUpdateDTO updatedDriverData) {
        Driver driver = driverRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Driver with id " + id + " not found"));
        Vehicle vehicle = vehicleRepository.findById(updatedDriverData.get);
        if (vehicle == null || !vehicle.getDrivers_list().contains(driver) || vehicle.isHas_active_driver()) {
            throw new ResourceNotFoundException("Vehicles not found in reserve");
        }
        vehicle.setHas_active_driver(true);
        vehicleRepository.save(vehicle);
        driverMapper.update(updatedDriverData, driver);
        driverRepository.save(driver);
        return driverMapper.map(driver);
    }

    @Transactional
    public void deleteDriver(long id) {
        this.driverRepository.deleteById(id);
    }
}
