package ru.edu.spring.vehicle_02.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "vehicle_id")
//@JsonIdentityReference(alwaysAsId = true)
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicle_id;

    @NotBlank
    @Column(name = "name_of_vehicle")
    private String name_of_vehicle;

    @NotNull
    @Column(name = "vehicle_cost")
    @Min(value = 0)
    private int vehicle_cost;

    @NotNull
    @Min(value = 1900)
    @Max(value = 2024)
    @Column(name = "year_of_release")
    private int year_of_release;
    //@JsonBackReference
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "enterprise_owner_of_vehicles", referencedColumnName = "enterprise_id")
    private Enterprise enterpriseOwnerOfVehicles;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "brand_owner", referencedColumnName = "brand_id")
    private Brand brandOwner;

    //    @JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "vehicles_list")
    private List<Driver> drivers_list;

    @Column(name = "has_active_driver")
    private boolean has_active_driver;

}
//vehicle_id brandOwner name_of_vehicle vehicle_cost  year_of_release