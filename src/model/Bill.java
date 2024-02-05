package model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {
    private Ticket ticket;
    private LocalDateTime exitTime;
    private int amount;
    private Operator operator;
    private List<PaymentMode> payments;
    private BillStatus billStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public List<PaymentMode> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentMode> payments) {
        this.payments = payments;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
