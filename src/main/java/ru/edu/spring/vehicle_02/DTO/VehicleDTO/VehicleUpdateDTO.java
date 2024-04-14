package ru.edu.spring.vehicle_02.DTO.VehicleDTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.edu.spring.vehicle_02.models.Brand;
import ru.edu.spring.vehicle_02.models.Enterprise;

@Getter
@Setter
public class VehicleUpdateDTO {

    @NotBlank
    private String name_of_vehicle;
    @NotNull
    @Min(value = 0)
    private int vehicle_cost;
    @NotNull
    @Min(value = 1900)
    @Max(value = 2024)
    private int year_of_release;
    private Enterprise enterpriseOwnerOfVehicles;
    private Brand brandOwner;
}
