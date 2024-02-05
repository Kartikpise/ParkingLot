package strategy.SlotAssignment;

import model.ParkingSpot;
import model.VehicleSize;
import model.VehicleType;

public interface SlotAssignmentStrategy {
    ParkingSpot assignParkingSpot(VehicleType vehicleType, VehicleSize vehicleSize);
}
