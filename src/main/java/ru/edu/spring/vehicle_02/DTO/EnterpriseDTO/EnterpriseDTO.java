package ru.edu.spring.vehicle_02.DTO.EnterpriseDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import ru.edu.spring.vehicle_02.models.Driver;
import ru.edu.spring.vehicle_02.models.Vehicle;

import java.util.List;

@Getter
@Setter
public class EnterpriseDTO {

    private long enterprise_id;
    @NotBlank
    private String name_of_enterprise;
    @NotBlank
    private String city_of_enterprise;
    private List<Vehicle> vehiclesOfEnterprise;
    private List<Driver> driversOfEnterprise;
}
