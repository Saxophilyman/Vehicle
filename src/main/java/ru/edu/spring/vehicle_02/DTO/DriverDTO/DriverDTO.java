package ru.edu.spring.vehicle_02.DTO.DriverDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.edu.spring.vehicle_02.models.Enterprise;
import ru.edu.spring.vehicle_02.models.Vehicle;

import java.util.List;

@Getter
@Setter
public class DriverDTO {
    private long driver_id;
    @NotBlank
    @NotNull
    @Min(value = 1)
    private String name_of_driver;
    private int salary_of_driver;
    private Enterprise enterpriseOwnerOfDriver;
    private List<Vehicle> vehicles_list;
    private String active_vehicle_of_driver;
}
