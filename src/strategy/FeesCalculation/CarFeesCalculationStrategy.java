package strategy.FeesCalculation;

import model.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CarFeesCalculationStrategy implements FeesCalculationStrategy {

    private double chargePerHour;
    private static FeesCalculationStrategy feesCalculationStrategy;

    @Override
    public double calculateFees(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime, double surge) {
        chargePerHour = getVehicleChargePerHourByType(vehicleType);
        long hours = exitTime.until(entryTime, ChronoUnit.HOURS);
        double totalFees = chargePerHour * hours;
        totalFees *= surge;
        return totalFees;
    }

    private double getVehicleChargePerHourByType(VehicleType vehicleType) {
        return switch (vehicleType) {
            case FUEL -> 80;
            case ELECTRIC -> 100;
        };
    }

    public static FeesCalculationStrategy getInstance() {
        if (feesCalculationStrategy == null) {
            synchronized (FeesCalculationStrategy.class) {
                if (feesCalculationStrategy == null) {
                    feesCalculationStrategy = new CarFeesCalculationStrategy();
                }
            }
        }
        return feesCalculationStrategy;
    }
}
