package service;

import model.Operator;
import model.PaymentMode;
import model.PaymentStatus;

import java.util.HashMap;

public interface PaymentService {
    PaymentStatus payAmount(long ticketId, int totalAmount, HashMap<PaymentMode, Integer> paymentMap, Operator operator);
}
