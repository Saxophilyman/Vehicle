package ru.edu.spring.vehicle_02.mapper;

import org.mapstruct.*;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseCreateDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseUpdateDTO;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleCreateDTO;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleDTO;
import ru.edu.spring.vehicle_02.DTO.VehicleDTO.VehicleUpdateDTO;
import ru.edu.spring.vehicle_02.models.Enterprise;
import ru.edu.spring.vehicle_02.models.Vehicle;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class VehicleMapper {
    public abstract Vehicle map(VehicleCreateDTO dto);

    public abstract void update(VehicleUpdateDTO dto, @MappingTarget Vehicle model);

    public abstract VehicleDTO map(Vehicle model);
}
