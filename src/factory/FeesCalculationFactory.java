package factory;

import model.VehicleSize;
import strategy.FeesCalculation.*;

public class FeesCalculationFactory {

    public static FeesCalculationStrategy getFeesCalculationStrategyInstance(VehicleSize vehicleSize) {
        return switch (vehicleSize) {
            case BICYCLE -> BicycleFeesCalculationStrategy.getInstance();
            case TWO_WHEELER -> BikeFeesCalculationStrategy.getInstance();
            case FOUR_WHEELER -> CarFeesCalculationStrategy.getInstance();
            case HEAVY -> HeavyFeesCalculationStrategy.getInstance();
        };
    }
}
