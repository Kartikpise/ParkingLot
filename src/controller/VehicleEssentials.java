package controller;

import model.VehicleSize;
import model.VehicleType;

public class VehicleEssentials {

    public static VehicleType getVehicleType(String vehicleType) {
        return switch (vehicleType.toUpperCase()) {
            case "FUEL" -> VehicleType.FUEL;
            case "ELECTRIC" -> VehicleType.ELECTRIC;
            default -> null;
        };
    }

    public static VehicleSize getVehicleSize(String vehicleSize) {
        return switch (vehicleSize.toUpperCase()) {
            case "BICYCLE" -> VehicleSize.BICYCLE;
            case "TWO WHEELER" -> VehicleSize.TWO_WHEELER;
            case "FOUR WHEELER" -> VehicleSize.FOUR_WHEELER;
            case "HEAVY" -> VehicleSize.HEAVY;
            default -> null;
        };
    }
}
