package dto;

public class ParkingChargeRequestDto {

    private long ticketId;;
    private long surge;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getSurge() {
        return surge;
    }

    public void setSurge(long surge) {
        this.surge = surge;
    }
}
