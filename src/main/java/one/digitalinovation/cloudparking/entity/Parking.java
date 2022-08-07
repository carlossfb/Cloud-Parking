package one.digitalinovation.cloudparking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;
    private String uuid;
    private String licence;
    private String state;
    private String model;
    private String color;
    private LocalDate entryDate;
    private LocalDate exitDate;
    private double bill;
}
