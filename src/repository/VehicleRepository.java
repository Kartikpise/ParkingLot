package repository;

import model.Vehicle;

public interface VehicleRepository {
    void saveVehicle(Vehicle vehicle);
    Vehicle getVehicle(String vehicleNumber);
}
