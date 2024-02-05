package service;

import model.Ticket;
import model.VehicleSize;
import model.VehicleType;

public interface TicketService {
    Ticket generateTicket(String vehicleNumber, long gateId, VehicleType vehicleType, VehicleSize vehicleSize);
    Ticket getTicket(long ticketId);
}
