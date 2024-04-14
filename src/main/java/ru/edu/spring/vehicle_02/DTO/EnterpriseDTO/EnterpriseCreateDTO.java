package ru.edu.spring.vehicle_02.DTO.EnterpriseDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import ru.edu.spring.vehicle_02.models.Driver;
import ru.edu.spring.vehicle_02.models.Vehicle;

import java.util.List;

@Getter
@Setter
public class EnterpriseCreateDTO {
    @NotBlank
    private String name_of_enterprise;
    @NotBlank
    private String city_of_enterprise;
}
