package controller;

import dto.ParkingChargeRequestDto;
import dto.ParkingChargeResponseDto;
import service.CalculateChargeService;
import service.CalculateChargeServiceImpl;

public class CalculateFeesController {

    private CalculateChargeService calculateChargeService;

    public CalculateFeesController() {
        this.calculateChargeService = new CalculateChargeServiceImpl();
    }

    public ParkingChargeResponseDto getParkingCharge(ParkingChargeRequestDto parkingChargeRequestDto) {

        double parkingCharge = calculateChargeService.getParkingCharge(parkingChargeRequestDto.getTicketId(), parkingChargeRequestDto.getSurge());

        ParkingChargeResponseDto parkingChargeResponseDto = new ParkingChargeResponseDto();
        parkingChargeResponseDto.setParkingCharge(parkingCharge);

        return parkingChargeResponseDto;
    }
}
