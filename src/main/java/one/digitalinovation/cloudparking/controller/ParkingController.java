package one.digitalinovation.cloudparking.controller;

import one.digitalinovation.cloudparking.entity.Parking;
import one.digitalinovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinovation.cloudparking.service.ParkingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class ParkingController {

    private final ParkingService service;
    private final ModelMapper mapper;

    public ParkingController(ParkingService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingDTO>> getAll(){
       List<ParkingDTO> response = service
               .findAll()
               .stream()
               .map(this::toParkingDTO).toList();

       return ResponseEntity.ok(response);
    }

    @PostMapping("/new")
    public ResponseEntity<ParkingDTO> createParking(@RequestBody Parking parking){
        parking = service.create(parking);
        ParkingDTO response = toParkingDTO(parking);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> getId(@PathVariable("id") String id){
        Parking parking = service.findById(id);
        ParkingDTO response = toParkingDTO(parking);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/delete/{id}")
    public void deleteId(@PathVariable("id") String id){
        service.delete(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ParkingDTO> updateId(@PathVariable("id") String id, @RequestBody Parking edit){
        Parking parking = service.updateParking(id, edit);
        ParkingDTO response = toParkingDTO(parking);

        return ResponseEntity.ok(response);
    }

//    Aqui transformaremos cada parking em sua DTO
    private ParkingDTO toParkingDTO(Parking parking){
        return mapper.map(parking, ParkingDTO.class);
    }

}
