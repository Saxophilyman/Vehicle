package ru.edu.spring.vehicle_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.edu.spring.vehicle_02.models.Driver;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

//    @Query("select b from Band b where b.name = :name")
//    fun filterByName(name: String): List<Band>
//"SELECT u.* FROM Vehicle u join driver b on u.vehicle_id = b.driver_id  where u.name_of_vehicle = :name and b.is_driver_active =:name2"
}
