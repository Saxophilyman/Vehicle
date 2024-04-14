package ru.edu.spring.vehicle_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.spring.vehicle_02.models.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
}
