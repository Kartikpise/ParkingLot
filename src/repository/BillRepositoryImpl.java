package repository;

import model.Bill;

import java.util.HashMap;

public class BillRepositoryImpl implements BillRepository {

    private HashMap<Long, Bill> billMap;
    private long billId;
    private static BillRepository billRespository;

    public BillRepositoryImpl() {
        this.billMap = new HashMap<>();
        this.billId = 1000L;
    }

    @Override
    public long saveBill(Bill bill) {
        long currentBillId = billId;
        billMap.put(currentBillId, bill);
        billId++;
        return currentBillId;
    }

    @Override
    public Bill getBill(long billId) {
        return billMap.get(billId);
    }

    @Override
    public HashMap<Long, Bill> getBillMap() {
        return billMap;
    }

    public static BillRepository getInstance() {
        if (billRespository == null) {
            synchronized (BillRepository.class) {
                if (billRespository == null) {
                    billRespository = new BillRepositoryImpl();
                }
            }
        }
        return billRespository;
    }
}
