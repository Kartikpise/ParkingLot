package service;

import model.Vehicle;
import model.VehicleSize;
import model.VehicleType;

public interface VehicleService {
    Vehicle saveVehicle(String vehicleNumber, VehicleType vehicleType, VehicleSize vehicleSize);
    Vehicle getVehicle(String vehicleNumber);
}
