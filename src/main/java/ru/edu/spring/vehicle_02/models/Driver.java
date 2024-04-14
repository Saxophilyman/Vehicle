package ru.edu.spring.vehicle_02.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "driver_id")
//@JsonIdentityReference(alwaysAsId = true)
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Driver")
public class Driver {

    @Id
    @Column(name = "driver_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long driver_id;

    @Column(name = "name_of_driver")
    @NotBlank
    private String name_of_driver;

    @NotNull
    @Min(value = 1)
    @Column(name = "salary_of_driver")
    private int salary_of_driver;

    @ManyToOne
    @JoinColumn(name = "enterprise_owner_of_driver", referencedColumnName = "enterprise_id")
    private Enterprise enterpriseOwnerOfDriver;


    @ManyToMany
    @JoinTable(name = "driver_vehicle",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private List<Vehicle> vehicles_list;

    @Column(name = "active_vehicle_of_driver")
    private Long active_vehicle_of_driver;
}
