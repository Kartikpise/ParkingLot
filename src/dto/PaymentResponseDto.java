package dto;

import model.Operator;
import model.PaymentStatus;

public class PaymentResponseDto {

    private PaymentStatus paymentStatus;
    private String paymentResponse;

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentResponse() {
        return paymentResponse;
    }

    public void setPaymentResponse(String paymentResponse) {
        this.paymentResponse = paymentResponse;
    }
}
