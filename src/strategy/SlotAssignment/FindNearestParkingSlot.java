package strategy.SlotAssignment;

import model.ParkingFloor;
import model.ParkingSpot;
import model.VehicleSize;
import model.VehicleType;
import repository.ParkingLotRepository;
import repository.ParkingLotRepositoryImpl;

import java.util.List;

public class FindNearestParkingSlot implements SlotAssignmentStrategy {

    private static SlotAssignmentStrategy slotAssignmentStrategy;

    private ParkingLotRepository parkingLotRepository;
    private List<ParkingFloor> parkingFloors;
    private List<List<ParkingSpot>> parkingSpots;

    public FindNearestParkingSlot() {
        parkingLotRepository = ParkingLotRepositoryImpl.getInstance();
        parkingFloors = parkingLotRepository.getParkingFloors();
        parkingSpots = parkingLotRepository.getParkingSpots();
    }

    @Override
    public ParkingSpot assignParkingSpot(VehicleType vehicleType, VehicleSize vehicleSize) {

        parkingSpots = parkingLotRepository.getParkingSpots();

        for (int i = 0; i < parkingSpots.size(); i++) {
            for (ParkingSpot parkingSpot : parkingSpots.get(i)) {
                if (parkingSpot.getSupportedVehicleType().equals(vehicleType) && parkingSpot.getSupportedVehicleSize().equals(vehicleSize)) {
                    return parkingSpot;
                }
            }
        }

        for (int i = 0; i < parkingSpots.size(); i++) {
            for (ParkingSpot parkingSpot : parkingSpots.get(i)) {
                if (parkingSpot.getSupportedVehicleSize().equals(vehicleSize) && !parkingSpot.getSupportedVehicleType().equals(vehicleType)) {
                    return parkingSpot;
                }
            }
        }

        return null;
    }

    public static SlotAssignmentStrategy getInstance() {
        if (slotAssignmentStrategy == null) {
            synchronized (SlotAssignmentStrategy.class) {
                if (slotAssignmentStrategy == null) {
                    slotAssignmentStrategy = new FindNearestParkingSlot();
                }
            }
        }
        return slotAssignmentStrategy;
    }
}
