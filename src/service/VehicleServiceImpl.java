package service;

import model.Vehicle;
import model.VehicleSize;
import model.VehicleType;
import repository.VehicleRepository;
import repository.VehicleRepositoryImpl;

public class VehicleServiceImpl implements VehicleService {

    private static VehicleService vehicleService;
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl() {
        this.vehicleRepository = VehicleRepositoryImpl.getInstance();
    }

    @Override
    public Vehicle saveVehicle(String vehicleNumber, VehicleType vehicleType, VehicleSize vehicleSize) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setVehicleType(vehicleType);
        vehicle.setVehicleSize(vehicleSize);
        vehicleRepository.saveVehicle(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle getVehicle(String vehicleNumber) {
        return vehicleRepository.getVehicle(vehicleNumber);
    }

    public static VehicleService getInstance() {
        if (vehicleService == null) {
            synchronized (VehicleService.class) {
                if (vehicleService == null) {
                    vehicleService = new VehicleServiceImpl();
                }
            }
        }
        return vehicleService;
    }
}
