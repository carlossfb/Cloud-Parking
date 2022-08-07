package one.digitalinovation.cloudparking.service;

import one.digitalinovation.cloudparking.entity.Parking;
import one.digitalinovation.cloudparking.exception.ParkingNotFoundException;
import one.digitalinovation.cloudparking.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
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
    public Parking create(@Valid Parking parkingCreate){

        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now().toLocalDate());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    public Parking updateParking(String id, Parking update){
        Parking old = findById(id);

        if(update.getBill() != 0.0){
            old.setBill(update.getBill());
        }
       if(update.getColor() != null){
           old.setColor(update.getColor());
       }
       if(update.getLicence() != null){
           old.setLicence(update.getLicence());
       }
       if(update.getModel() != null){
           old.setModel(update.getModel());
       }
       if(update.getState() != null){
           old.setState(update.getState());
       }
        if(old.getExitDate() != null){
            old.setExitDate(update.getExitDate());
        }
        return parkingRepository.save(old);
    }

    public void delete(String id){
        findById(id);
        parkingRepository.deleteById(id);
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
