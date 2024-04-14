package ru.edu.spring.vehicle_02.DTO.DriverDTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.edu.spring.vehicle_02.models.Enterprise;

@Getter
@Setter
public class DriverCreateDTO {
    @NotBlank
    private String name_of_driver;

    @NotNull
    @Min(value = 1)
    private int salary_of_driver;
    private Enterprise enterpriseOwnerOfDriver;
}
