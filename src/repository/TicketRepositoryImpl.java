package repository;

import model.Ticket;

import java.util.HashMap;

public class TicketRepositoryImpl implements TicketRepository {
    private HashMap<Long, Ticket> tickets;
    private long ticketId;
    private static TicketRepository ticketRepository;

    public TicketRepositoryImpl() {
        this.tickets = new HashMap<>();
        this.ticketId = 1000L;
    }

    @Override
    public long saveTicket(Ticket ticket) {
        long currentTicketId = ticketId;
        this.tickets.put(currentTicketId, ticket);
        ticketId++;
        return currentTicketId;
    }

    @Override
    public Ticket getTicket(long ticketId) {
        return tickets.get(ticketId);
    }

    public static TicketRepository getInstance() {
        if (ticketRepository == null) {
            synchronized (TicketRepository.class) {
                if (ticketRepository == null) {
                    ticketRepository = new TicketRepositoryImpl();
                }
            }
        }
        return ticketRepository;
    }
}
