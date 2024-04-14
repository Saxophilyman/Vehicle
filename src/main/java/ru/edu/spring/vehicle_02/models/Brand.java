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
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "brand_id")
//@JsonIdentityReference(alwaysAsId = true)
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Brand")
public class Brand {

    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brand_id;

    @Column(name = "brand_name")
    @NotBlank
    private String brand_name;

    @Enumerated
    @NotBlank
    @Min(value = 0)
    @Max(value = 4)
    @Column(name = "type")
    private Type type;

    @NotNull
    @Min(value = 0)
    @Column(name = "capacity_fuel_tank")
    private int capacity_fuel_tank;

    @NotNull
    @Min(value = 100)
    @Column(name = "load_capacity")
    private int load_capacity;

    @NotNull
    @Min(value = 0)
    @Column(name = "number_of_seats")
    private int number_of_seats;

    //@JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "brandOwner", cascade = CascadeType.PERSIST)
    private List<Vehicle> vehicles;
}
