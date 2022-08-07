package one.digitalinovation.cloudparking.service;

import one.digitalinovation.cloudparking.entity.Parking;
import one.digitalinovation.cloudparking.exception.ParkingNotFoundException;
import one.digitalinovation.cloudparking.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public List<Parking> findAll(){
        return parkingRepository.findAll();
    }
    public Parking findById(String id){
        return parkingRepository.findById(id).orElseThrow(()->
                new ParkingNotFoundException(id));
    }
    public Parking create(Parking parkingCreate){

        String uuid = getUUID();
        parkingCreate.setUuid(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now().toLocalDate());
        parkingRepository.save(parkingCreate);

        return parkingCreate;
    }
    public void delete(String id){
        findById(id);
        parkingRepository.deleteById(id);
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
