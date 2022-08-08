package one.digitalinovation.cloudparking.service;

import one.digitalinovation.cloudparking.entity.Parking;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParkingCheckOut {

    public static double getBillID(Parking parking){
        return getBill(parking.getEntryDate(), parking.getExitDate());
    }

    private static double getBill(LocalDateTime entry, LocalDateTime exit){
        long minutes = entry.until(exit, ChronoUnit.MINUTES);
        int hours = (int) minutes/60;
        int days = (int) minutes/(24*60);

        double bill = 0.0;

        if(minutes <= 60){
            bill = 5;
        }
        if(minutes <= (24*60)){
            bill = 5;
            for(int i=0;i<hours;i++){
                bill+=2;
            }
        }
        if(minutes > (24*60)){
            bill = 5;
            for(int i=0;i<days;i++){
                bill+=20;
            }
    }
        return bill;
    }
}
