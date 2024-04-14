package ru.edu.spring.vehicle_02.mapper;

import org.mapstruct.*;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverCreateDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverUpdateDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseCreateDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseDTO;
import ru.edu.spring.vehicle_02.DTO.EnterpriseDTO.EnterpriseUpdateDTO;
import ru.edu.spring.vehicle_02.models.Driver;
import ru.edu.spring.vehicle_02.models.Enterprise;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class EnterpriseMapper {
    public abstract Enterprise map(EnterpriseCreateDTO dto);
    public abstract void update(EnterpriseUpdateDTO dto, @MappingTarget Enterprise model);
    public abstract EnterpriseDTO map(Enterprise model);
}
