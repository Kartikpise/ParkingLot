package service;

import model.Bill;
import model.Operator;
import model.PaymentMode;

import java.time.LocalDateTime;
import java.util.List;

public interface BillService {
    Bill generateBill(long ticketId, LocalDateTime entryTime, LocalDateTime exitTime, Operator operator, List<PaymentMode> payments);
    Bill getBill(long billId);
    Bill searchForBill(long tcketId);
}
