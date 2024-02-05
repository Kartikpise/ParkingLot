package service;

import factory.FeesCalculationFactory;
import model.Ticket;
import model.VehicleSize;
import model.VehicleType;
import repository.TicketRepository;
import repository.TicketRepositoryImpl;
import strategy.FeesCalculation.FeesCalculationStrategy;

import java.time.LocalDateTime;

public class CalculateChargeServiceImpl implements CalculateChargeService {

    private TicketRepository ticketRepository;
    private FeesCalculationStrategy feesCalculationStrategy;

    public CalculateChargeServiceImpl() {
        this.ticketRepository = TicketRepositoryImpl.getInstance();
    }

    @Override
    public double getParkingCharge(long ticketId, long surge) {
        Ticket ticket = ticketRepository.getTicket(ticketId);

        VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        VehicleSize vehicleSize = ticket.getVehicle().getVehicleSize();
        feesCalculationStrategy = FeesCalculationFactory.getFeesCalculationStrategyInstance(vehicleSize);
        LocalDateTime exitTime = LocalDateTime.now();

        double parkingCharge = feesCalculationStrategy.calculateFees(vehicleType, ticket.getEntryTime(), exitTime, surge);

        return parkingCharge;
    }
}
