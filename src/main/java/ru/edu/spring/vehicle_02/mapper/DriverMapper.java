package ru.edu.spring.vehicle_02.mapper;

import org.mapstruct.*;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandCreateDTO;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandDTO;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandUpdateDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverCreateDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverDTO;
import ru.edu.spring.vehicle_02.DTO.DriverDTO.DriverUpdateDTO;
import ru.edu.spring.vehicle_02.models.Brand;
import ru.edu.spring.vehicle_02.models.Driver;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class DriverMapper {
    
    public abstract Driver map(DriverCreateDTO dto);
    public abstract void update(DriverUpdateDTO dto, @MappingTarget Driver model);
    public abstract DriverDTO map(Driver model);
}
