package repository;

import model.Ticket;

public interface TicketRepository {
    long saveTicket(Ticket ticket);
    Ticket getTicket(long ticketId);
}
