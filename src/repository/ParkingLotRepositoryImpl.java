package repository;

import model.ParkingFloor;
import model.ParkingSpot;

import java.util.List;

public class ParkingLotRepositoryImpl implements ParkingLotRepository {
    private List<List<ParkingSpot>> parkingSpots;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLotRepository parkingLotRepository;

    @Override
    public List<List<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    @Override
    public void setParkingSpots(List<List<ParkingSpot>> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    @Override
    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    @Override
    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLotRepository getInstance() {
        if (parkingLotRepository == null) {
            synchronized (ParkingLotRepository.class) {
                if (parkingLotRepository == null) {
                    parkingLotRepository = new ParkingLotRepositoryImpl();
                }
            }
        }
        return parkingLotRepository;
    }
}
