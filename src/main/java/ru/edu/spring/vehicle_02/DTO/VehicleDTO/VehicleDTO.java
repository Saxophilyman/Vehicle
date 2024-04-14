package ru.edu.spring.vehicle_02.DTO.VehicleDTO;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import ru.edu.spring.vehicle_02.models.Brand;
import ru.edu.spring.vehicle_02.models.Driver;
import ru.edu.spring.vehicle_02.models.Enterprise;

import java.util.List;

@Getter
@Setter
public class VehicleDTO {
    private long vehicle_id;
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
    private List<Driver> drivers;
    private boolean has_active_driver;
}
