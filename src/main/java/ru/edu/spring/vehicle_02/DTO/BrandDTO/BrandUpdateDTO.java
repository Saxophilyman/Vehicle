package ru.edu.spring.vehicle_02.DTO.BrandDTO;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.edu.spring.vehicle_02.models.Type;
import ru.edu.spring.vehicle_02.models.Vehicle;

import java.util.List;

@Getter
@Setter
public class BrandUpdateDTO {
    @NotBlank
    private String brand_name;
    @Enumerated
    @NotBlank
    @Min(value = 0)
    @Max(value = 4)
    private Type type;
    @NotNull
    @Min(value = 0)
    private int capacity_fuel_tank;
    @NotNull
    @Min(value = 100)
    private int load_capacity;
    @NotNull
    @Min(value = 0)
    private int number_of_seats;
}
