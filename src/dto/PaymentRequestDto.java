package dto;

import model.Operator;

public class PaymentRequestDto {

    private long ticketId;
    private Operator operator;
    private CashPaymentModeDto cashPaymentModeDto;
    private OnlinePaymentModeDto onlinePaymentModeDto;
    private BalanceCardPaymentModeDto balanceCardPaymentDto;

    public PaymentRequestDto() {
        this.cashPaymentModeDto = new CashPaymentModeDto();
        this.onlinePaymentModeDto = new OnlinePaymentModeDto();
        this.balanceCardPaymentDto = new BalanceCardPaymentModeDto();
    }

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public CashPaymentModeDto getCashPaymentModeDto() {
        return cashPaymentModeDto;
    }

    public void setCashPaymentModeDto(CashPaymentModeDto cashPaymentModeDto) {
        this.cashPaymentModeDto = cashPaymentModeDto;
    }

    public OnlinePaymentModeDto getOnlinePaymentModeDto() {
        return onlinePaymentModeDto;
    }

    public void setOnlinePaymentModeDto(OnlinePaymentModeDto onlinePaymentModeDto) {
        this.onlinePaymentModeDto = onlinePaymentModeDto;
    }

    public BalanceCardPaymentModeDto getBalanceCardPaymentModeDto() {
        return balanceCardPaymentDto;
    }

    public void setBalanceCardPaymentModeDto(BalanceCardPaymentModeDto balanceCardPaymentModeDto) {
        this.balanceCardPaymentDto = balanceCardPaymentModeDto;
    }
}
