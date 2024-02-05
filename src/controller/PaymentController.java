package controller;

import dto.*;
import model.PaymentMode;
import model.PaymentStatus;
import service.PaymentService;
import service.PaymentServiceImpl;

import java.util.HashMap;

public class PaymentController {

    private PaymentService paymentService;

    public PaymentController() {
        this.paymentService = new PaymentServiceImpl();
    }

    public PaymentResponseDto doPayment(int totalAmount, PaymentRequestDto paymentRequestDto) {

        CashPaymentModeDto cashPaymentModeDto = paymentRequestDto.getCashPaymentModeDto();
        OnlinePaymentModeDto onlinePaymentModeDto = paymentRequestDto.getOnlinePaymentModeDto();
        BalanceCardPaymentModeDto balanceCardPaymentModeDto = paymentRequestDto.getBalanceCardPaymentModeDto();

        HashMap<PaymentMode, Integer> paymentModes = new HashMap<>();
        paymentModes.put(cashPaymentModeDto.getPaymentMode(), cashPaymentModeDto.getPaidAmount());
        paymentModes.put(onlinePaymentModeDto.getPaymentMode(), onlinePaymentModeDto.getPaidAmount());
        paymentModes.put(balanceCardPaymentModeDto.getPaymentMode(), balanceCardPaymentModeDto.getPaidAmount());

        PaymentStatus paymentStatus = paymentService.payAmount(paymentRequestDto.getTicketId(), totalAmount, paymentModes, paymentRequestDto.getOperator());

        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setPaymentStatus(paymentStatus);

        if (paymentStatus.equals(PaymentStatus.SUCCESS)) {
            paymentResponseDto.setPaymentResponse("Payment completed successfully. Thank you for using our services.");
        } else {
            paymentResponseDto.setPaymentResponse("Payment failed due to some technical issues. Please try again.");
        }

        return paymentResponseDto;
    }
}
