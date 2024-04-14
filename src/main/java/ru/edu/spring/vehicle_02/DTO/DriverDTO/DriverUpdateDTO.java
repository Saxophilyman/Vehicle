package ru.edu.spring.vehicle_02.DTO.DriverDTO;

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
public class DriverUpdateDTO {
    @NotBlank
    private String name_of_driver;
    @NotNull
    @Min(value = 1)
    private int salary_of_driver;
    private String driver_active_vehicle;
    private Enterprise enterpriseOwnerOfDriver;
    private String active_vehicle_of_driver;
}
