package one.digitalinovation.cloudparking.controller;

import one.digitalinovation.cloudparking.entity.Parking;
import one.digitalinovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinovation.cloudparking.service.ParkingService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService service;
    private final ModelMapper mapper;

    public ParkingController(ParkingService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<ParkingDTO> getAll(){
       return service.findAll()
               .stream()
               .map(this::toParkingDTO).toList();
    }

    @PostMapping("/new")
    public ParkingDTO createParking(@RequestBody Parking parking){
        parking = service.create(parking);
        return toParkingDTO(parking);
    }

    @GetMapping("/{id}")
    public ParkingDTO getId(@PathVariable("id") String id){
        Parking parking = service.findById(id);
        return toParkingDTO(parking);
    }

//    Aqui transformaremos cada parking em sua DTO
    private ParkingDTO toParkingDTO(Parking parking){
        return mapper.map(parking, ParkingDTO.class);
    }

}
