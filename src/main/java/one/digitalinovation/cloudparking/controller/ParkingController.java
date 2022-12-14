package one.digitalinovation.cloudparking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinovation.cloudparking.entity.Parking;
import one.digitalinovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinovation.cloudparking.service.ParkingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    private final ParkingService service;
    private final ModelMapper mapper;

    public ParkingController(ParkingService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @ApiOperation("Find all Parkings")
    @GetMapping("all")
    public ResponseEntity<List<ParkingDTO>> getAll(){
       List<ParkingDTO> response = service
               .findAll()
               .stream()
               .map(this::toParkingDTO).toList();

       return ResponseEntity.ok(response);
    }

    @ApiOperation("Create a new Parking")
    @PostMapping("/new")
    public ResponseEntity<ParkingDTO> createParking(@RequestBody Parking parking){
        parking = service.create(parking);
        ParkingDTO response = toParkingDTO(parking);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation("Find Parking by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> getId(@PathVariable("id") String id){
        Parking parking = service.findById(id);
        ParkingDTO response = toParkingDTO(parking);

        return ResponseEntity.ok(response);
    }

    @ApiOperation("Delete Parking by ID")
    @DeleteMapping("/delete/{id}")
    public void deleteId(@PathVariable("id") String id){
        service.delete(id);
    }

    @ApiOperation("Update Parking by ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<ParkingDTO> updateId(@PathVariable("id") String id, @RequestBody Parking edit){
        service.findById(id);
        Parking parking = service.updateParking(id, edit);
        ParkingDTO response = toParkingDTO(parking);

        return ResponseEntity.ok(response);
    }

    @ApiOperation("Checkout Parking by ID")
    @PostMapping("/checkout/{id}")
    public ResponseEntity<ParkingDTO> checkoutId(@PathVariable("id") String id){
        Parking parking = service.checkout(id);
        ParkingDTO response = toParkingDTO(parking);

        return ResponseEntity.ok(response);
    }

//    Aqui transformaremos cada parking em sua DTO
    private ParkingDTO toParkingDTO(Parking parking){
        return mapper.map(parking, ParkingDTO.class);
    }

}
