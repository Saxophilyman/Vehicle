package ru.edu.spring.vehicle_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.edu.spring.vehicle_02.models.Enterprise;
@Repository
public interface EnterpriseRepository extends JpaRepository< Enterprise,Long> {

}
