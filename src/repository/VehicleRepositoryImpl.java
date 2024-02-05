package repository;

import model.Vehicle;

import java.util.HashMap;

public class VehicleRepositoryImpl implements VehicleRepository {

    private HashMap<String, Vehicle> vehicles;
    private static VehicleRepository vehicleRepository;

    public VehicleRepositoryImpl() {
        this.vehicles = new HashMap<>();
    }

    @Override
    public void saveVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.getVehicleNumber(), vehicle);
    }

    @Override
    public Vehicle getVehicle(String vehicleNumber) {
        return vehicles.get(vehicleNumber);
    }

    public static VehicleRepository getInstance() {
        if (vehicleRepository == null) {
            synchronized (VehicleRepository.class) {
                if (vehicleRepository == null) {
                    vehicleRepository = new VehicleRepositoryImpl();
                }
            }
        }
        return vehicleRepository;
    }
}
