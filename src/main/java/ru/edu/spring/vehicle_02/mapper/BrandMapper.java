package ru.edu.spring.vehicle_02.mapper;

import org.mapstruct.*;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandCreateDTO;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandDTO;
import ru.edu.spring.vehicle_02.DTO.BrandDTO.BrandUpdateDTO;
import ru.edu.spring.vehicle_02.models.Brand;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class BrandMapper {
    public abstract Brand map(BrandCreateDTO dto);
    public abstract void update(BrandUpdateDTO dto, @MappingTarget Brand model);
    public abstract BrandDTO map(Brand model);

}
