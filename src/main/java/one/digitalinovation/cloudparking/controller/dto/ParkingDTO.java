package one.digitalinovation.cloudparking.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ParkingDTO {

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
