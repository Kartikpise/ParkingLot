package strategy.FeesCalculation;

import model.VehicleType;

import java.time.LocalDateTime;

public interface FeesCalculationStrategy {
    double calculateFees(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime, double surge);
}
