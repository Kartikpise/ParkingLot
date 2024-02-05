package repository;

import model.Bill;

import java.util.HashMap;

public interface BillRepository {
    long saveBill(Bill bill);
    Bill getBill(long billId);

    HashMap<Long, Bill> getBillMap();
}
