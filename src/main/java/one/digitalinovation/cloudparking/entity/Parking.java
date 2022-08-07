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
    @Column(updatable = false, unique = true, nullable = false)
    private String id;
    private String licence;
    private String state;
    private String model;
    private String color;
    private LocalDate entryDate;
    private LocalDate exitDate;
    private double bill;
}
