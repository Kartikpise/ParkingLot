package service;

public interface CalculateChargeService {
    double getParkingCharge(long ticketId, long surge);
}
