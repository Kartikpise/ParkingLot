package dto;

import model.Ticket;

public class TicketGenerateResponseDto {
    private TicketResponseStatus ticketResponseStatus;
    private Ticket ticket;

    public TicketResponseStatus getTicketResponseStatus() {
        return ticketResponseStatus;
    }

    public void setTicketResponseStatus(TicketResponseStatus ticketResponseStatus) {
        this.ticketResponseStatus = ticketResponseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
