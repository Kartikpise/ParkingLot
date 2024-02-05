package repository;

import model.Payment;

public interface PaymentRepository {
    PaymentRepositoryStatus savePayment(long ticketId, Payment payment);
    int getPaidAmount(long ticketId);
}
