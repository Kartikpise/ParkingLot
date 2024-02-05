import controller.BillController;
import controller.CalculateFeesController;
import controller.PaymentController;
import controller.TicketController;
import dto.*;
import factory.ParkingLotFactory;
import model.Bill;
import model.Operator;
import model.PaymentMode;
import model.Ticket;
import repository.TicketRepository;
import repository.TicketRepositoryImpl;

public class Client {

    public static void main(String[] args) {

        ParkingLotFactory parkingLotFactory = ParkingLotFactory.getInstance();

        TicketGenerateRequestDto ticketGenerateRequestDto = new TicketGenerateRequestDto();
        ticketGenerateRequestDto.setGateId(1000L);
        ticketGenerateRequestDto.setOperatorId(1001L);
        ticketGenerateRequestDto.setVehicleNumber("AP12B1215");
        ticketGenerateRequestDto.setVehicleType("Electric");
        ticketGenerateRequestDto.setVehicleSize("Four Wheeler");

        TicketController ticketController =  new TicketController();
        TicketGenerateResponseDto ticketGenerateResponseDto = ticketController.generateTicket(ticketGenerateRequestDto);

        long ticketId = ticketGenerateResponseDto.getTicket().getId();
        System.out.println("Ticket Id : " + ticketId);
        System.out.println("Ticket Response :  " + ticketGenerateResponseDto.getTicketResponseStatus());

        System.out.println("-------------------------------------------------------------------------------");
        TicketRepository ticketRepo = TicketRepositoryImpl.getInstance();
        Ticket ticket =  ticketRepo.getTicket(ticketId);

        System.out.println(ticket.getId());
        System.out.println(ticket.getVehicle().getVehicleNumber());
        System.out.println(ticket.getVehicle().getVehicleSize());
        System.out.println(ticket.getVehicle().getVehicleType());

        ParkingChargeRequestDto parkingChargeRequestDto = new ParkingChargeRequestDto();
        parkingChargeRequestDto.setSurge(1L);
        parkingChargeRequestDto.setTicketId(ticketId);

        CalculateFeesController calculateFeesController = new CalculateFeesController();
        ParkingChargeResponseDto parkingChargeResponseDto = calculateFeesController.getParkingCharge(parkingChargeRequestDto);

        double amount  = parkingChargeResponseDto.getParkingCharge();
        System.out.println("Parking Fee : "  + amount);

        System.out.println("-------------------------------------------------------------------------------");

        Operator operator = new Operator();
        operator.setId(1002);
        operator.setName("Operator_2");

        CashPaymentModeDto cashPaymentMode = new CashPaymentModeDto();
        cashPaymentMode.setPaidAmount(1000);
        cashPaymentMode.setPaymentMode(PaymentMode.CASH);

        OnlinePaymentModeDto onlinePaymentMode = new OnlinePaymentModeDto();
        onlinePaymentMode.setPaymentMode(PaymentMode.ONLINE);
        onlinePaymentMode.setPaidAmount(1000);

        BalanceCardPaymentModeDto balanceCardPaymentMode = new BalanceCardPaymentModeDto();
        balanceCardPaymentMode.setPaidAmount(1600);
        balanceCardPaymentMode.setPaymentMode(PaymentMode.BALANCE_CARD);


        PaymentRequestDto paymentRequestDto = new PaymentRequestDto();
        paymentRequestDto.setTicketId(ticketId);
        paymentRequestDto.setOperator(operator);
        paymentRequestDto.setCashPaymentModeDto(cashPaymentMode);
        paymentRequestDto.setOnlinePaymentModeDto(onlinePaymentMode);
        paymentRequestDto.setBalanceCardPaymentModeDto(balanceCardPaymentMode);


        PaymentController paymentController = new PaymentController();
        PaymentResponseDto paymentResponseDto = paymentController.doPayment((int)amount, paymentRequestDto);

        System.out.println("Payment Status : " + paymentResponseDto.getPaymentStatus());
        System.out.println(paymentResponseDto.getPaymentResponse());
        System.out.println("-------------------------------------------------------------------------------");
        BillRequestDto billRequestDto = new BillRequestDto();
        billRequestDto.setTicketId(ticketId);

        BillController billController = new BillController();
        BillResponseDto  billResponseDto =  billController.getBill(billRequestDto);
        Bill bill = billResponseDto.getBill();

        System.out.println("Bill Id : " + bill.getId());
        System.out.println("Entry Time : "  + bill.getTicket().getEntryTime());
        System.out.println("Exit Time : " + bill.getExitTime());
        System.out.println("Bill Status  : " + bill.getBillStatus());
        System.out.println("Vehicle Type : " + bill.getTicket().getVehicle().getVehicleType());
        System.out.println("Vehicle Size : " + bill.getTicket().getVehicle().getVehicleSize());
    }
}
