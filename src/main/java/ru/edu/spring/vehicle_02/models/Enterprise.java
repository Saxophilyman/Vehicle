package ru.edu.spring.vehicle_02.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "enterprise_id")
//@JsonIdentityReference(alwaysAsId = true)
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Enterprise")
public class Enterprise {

    @Id
    @Column(name = "enterprise_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long enterprise_id;



    @Column(name = "name_of_enterprise")
    @NotBlank
    private String name_of_enterprise;

    @Column(name = "city_of_enterprise")
    @NotBlank
    private String city_of_enterprise;

    //@JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "enterpriseOwnerOfVehicles", cascade = CascadeType.PERSIST)
    private List<Vehicle> vehiclesOfEnterprise;

    //@JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "enterpriseOwnerOfDriver", cascade = CascadeType.PERSIST)
    private List<Driver> driversOfEnterprise;

}
