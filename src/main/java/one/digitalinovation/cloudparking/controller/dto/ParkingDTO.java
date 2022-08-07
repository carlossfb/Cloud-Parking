package one.digitalinovation.cloudparking.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class ParkingDTO {

    private String id;
    @Size(min = 3, message = "Digite uma licenca valida")
    @NotBlank(message = "Informe a licenca do veiculo")
    private String licence;

    @Size(min = 2, message = "Digite um Estado valido")
    @NotBlank(message = "Informe o Estado correspondente")
    private String state;

    @Size(min = 3, message = "Digite um modelo valido")
    @NotBlank(message = "Informe o modelo do veiculo")
    private String model;

    @Size(min = 3, message = "Digite uma cor valida")
    @NotBlank(message = "Informe a cor do veiculo")
    private String color;

    private LocalDate entryDate;
    private LocalDate exitDate;
    private double bill;

}
