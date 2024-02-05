package controller;

import dto.BillRequestDto;
import dto.BillResponseDto;
import model.Bill;
import service.BillService;
import service.BillServiceImpl;

public class BillController {

    private BillService billService;

    public BillController() {
        this.billService = BillServiceImpl.getInstance();
    }

    public BillResponseDto getBill(BillRequestDto billRequestDto) {

        Bill bill = billService.searchForBill(billRequestDto.getTicketId());

        BillResponseDto billResponseDto = new BillResponseDto();
        billResponseDto.setBill(bill);

        return billResponseDto;
    }
}
