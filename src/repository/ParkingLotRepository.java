package repository;

import model.ParkingFloor;
import model.ParkingSpot;

import java.util.List;

public interface ParkingLotRepository {
    List<List<ParkingSpot>> getParkingSpots();
    void setParkingSpots(List<List<ParkingSpot>> parkingSpots);
    List<ParkingFloor> getParkingFloors();
    void setParkingFloors(List<ParkingFloor> parkingFloors);
}
