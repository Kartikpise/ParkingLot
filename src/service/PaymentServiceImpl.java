package service;

import model.*;
import repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;
    private BillService billService;
    private TicketRepository ticketRepository;

    public PaymentServiceImpl() {
        this.paymentRepository = PaymentRepositoryImpl.getInstance();
        this.ticketRepository = TicketRepositoryImpl.getInstance();
        this.billService = BillServiceImpl.getInstance();
    }

    @Override
    public PaymentStatus payAmount(long ticketId, int totalAmount, HashMap<PaymentMode, Integer> paymentMap, Operator operator) {

        int cash = paymentMap.get(PaymentMode.CASH);
        int online = paymentMap.get(PaymentMode.ONLINE);
        int balanceCard = paymentMap.get(PaymentMode.BALANCE_CARD);
        int totalPaid = cash + online + balanceCard;

        System.out.println("Total Amount : " + totalAmount + "\nAmount paid : " + totalPaid);

        if (totalAmount != totalPaid) {
            return PaymentStatus.IN_COMPLETE;
        }

        List<PaymentMode> paymentModes = new ArrayList<>();
        Payment payment = new Payment();
        payment.setId(ticketId);

        if (cash != 0) {
            paymentModes.add(PaymentMode.CASH);
        }
        if (online != 0) {
            paymentModes.add(PaymentMode.ONLINE);
        }
        if (balanceCard != 0) {
            paymentModes.add(PaymentMode.BALANCE_CARD);
        }

        payment.setPaymentModes(paymentModes);
        payment.setPaidAmount(totalPaid);
        payment.setTotalAmount(totalAmount);

        PaymentRepositoryStatus paymentRepositoryStatus = paymentRepository.savePayment(ticketId, payment);

        if (paymentRepositoryStatus.equals(PaymentRepositoryStatus.ERROR)) {
            return PaymentStatus.FAILURE;
        }

        Ticket ticket = ticketRepository.getTicket(ticketId);
        billService.generateBill(ticketId, ticket.getEntryTime(), LocalDateTime.now(), operator, paymentModes);

        return PaymentStatus.SUCCESS;
    }
}
