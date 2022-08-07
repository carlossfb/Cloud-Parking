package one.digitalinovation.cloudparking.repository;

import one.digitalinovation.cloudparking.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, String> {
}
