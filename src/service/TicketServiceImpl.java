package service;

import model.*;
import repository.TicketRepository;
import repository.TicketRepositoryImpl;
import strategy.SlotAssignment.FindNearestParkingSlot;
import strategy.SlotAssignment.SlotAssignmentStrategy;

import java.time.LocalDateTime;

public class TicketServiceImpl implements TicketService {
    private TicketRepository ticketRepository;
    private VehicleService vehicleService;
    private GateService gateService;
    private Operator operator;
    private SlotAssignmentStrategy slotAssignmentStrategy;

    public TicketServiceImpl() {
        this.ticketRepository = TicketRepositoryImpl.getInstance();
        this.vehicleService = VehicleServiceImpl.getInstance();
        this.gateService = GateServiceImpl.getInstance();
        this.slotAssignmentStrategy = FindNearestParkingSlot.getInstance();
    }

    @Override
    public Ticket generateTicket(String vehicleNumber, long gateId, VehicleType vehicleType, VehicleSize vehicleSize) {

        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if (vehicle == null) {
            vehicle = vehicleService.saveVehicle(vehicleNumber, vehicleType, vehicleSize);
        }

        Gate gate = gateService.getGate(gateId);
        operator = gate.getOperator();
        ParkingSpot parkingSpot = slotAssignmentStrategy.assignParkingSpot(vehicleType, vehicleSize);

        if (parkingSpot == null) {
            return null;
        }

        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setVehicle(vehicle);

        LocalDateTime entryTime = LocalDateTime.now();

        ticket.setEntryTime(entryTime);
        ticket.setParkingSpot(parkingSpot);
        long id = ticketRepository.saveTicket(ticket);
        ticket.setId(id);

        return ticket;
    }

    @Override
    public Ticket getTicket(long ticketId) {
        return ticketRepository.getTicket(ticketId);
    }
}
