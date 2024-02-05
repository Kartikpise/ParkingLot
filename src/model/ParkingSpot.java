package model;

import java.util.List;

public class ParkingSpot extends BaseModel {
    private ParkingFloor parkingFloor;
    private List<VehicleType> supportedVehicleType;
    private VehicleSize supportedVehicleSize;
    private ParkingState parkingState;
    private int spotNumber;

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public List<VehicleType> getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public void setSupportedVehicleType(List<VehicleType> supportedVehicleType) {
        this.supportedVehicleType = supportedVehicleType;
    }

    public VehicleSize getSupportedVehicleSize() {
        return supportedVehicleSize;
    }

    public void setSupportedVehicleSize(VehicleSize supportedVehicleSize) {
        this.supportedVehicleSize = supportedVehicleSize;
    }

    public ParkingState getParkingState() {
        return parkingState;
    }

    public void setParkingState(ParkingState parkingState) {
        this.parkingState = parkingState;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}
