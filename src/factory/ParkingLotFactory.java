package factory;

import model.*;
import repository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotFactory {

    private static ParkingLotFactory parkingLotFactory;
    private ParkingLot parkingLot;

    List<List<ParkingSpot>> parkingSpots;
    List<ParkingFloor> parkingFloors;
    List<Operator> operators;
    List<Gate> gates;


    public ParkingLotFactory() {
        this.parkingLot = new ParkingLot();
        this.parkingFloors = new ArrayList<>();
        this.parkingSpots = new ArrayList<>();
        this.operators = new ArrayList<>();
        this.gates = new ArrayList<>();

        addParkingFloors();
        addParkingSpots();
        addOperators();
        addGates();

        parkingLot.setName("Local Parking Lot");
        parkingLot.setAddress("Electronic City, Bengaluru");
        parkingLot.setParkingFloor(parkingFloors);
        parkingLot.setGates(gates);
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);

        ParkingLotRepository parkingLotRepository = ParkingLotRepositoryImpl.getInstance();
        parkingLotRepository.setParkingFloors(parkingFloors);
        parkingLotRepository.setParkingSpots(parkingSpots);
    }

    private List<ParkingFloor> addParkingFloors() {

        for (int i = 0; i <= 4; i++) {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setParkingState(ParkingState.AVAILABLE);
            parkingFloors.add(parkingFloor);
        }

        return parkingFloors;
    }

    private void addParkingSpots() {

        for (int i = 0; i < parkingFloors.size(); i++) {

            List<VehicleType> vehicleTypes = Arrays.asList(VehicleType.FUEL, VehicleType.ELECTRIC);
            parkingSpots.add(new ArrayList<ParkingSpot>());

            for (int j = 1; j <= 20; j++) {
                ParkingSpot parkingSpot = createObject(Long.valueOf((100 * i) + j), VehicleSize.BICYCLE, vehicleTypes, parkingFloors.get(i), ParkingState.AVAILABLE);
                parkingSpots.get(i).add(parkingSpot);
            }
            for (int j = 21; j <= 40; j++) {
                ParkingSpot parkingSpot = createObject(Long.valueOf((100 * i) + j), VehicleSize.HEAVY, vehicleTypes, parkingFloors.get(i), ParkingState.AVAILABLE);
                parkingSpots.get(i).add(parkingSpot);
            }
            for (int j = 41; j <= 60; j++) {
                ParkingSpot parkingSpot = createObject(Long.valueOf((100 * i) + j), VehicleSize.TWO_WHEELER, vehicleTypes, parkingFloors.get(i), ParkingState.AVAILABLE);
                parkingSpots.get(i).add(parkingSpot);
            }
            for (int j = 61; j <= 80; j++) {
                ParkingSpot parkingSpot = createObject(Long.valueOf((100 * i) + j), VehicleSize.FOUR_WHEELER, vehicleTypes, parkingFloors.get(i), ParkingState.AVAILABLE);
                parkingSpots.get(i).add(parkingSpot);
            }
            for (int j = 81; j <= 100; j++) {
                ParkingSpot parkingSpot = createObject(Long.valueOf((100 * i) + j), VehicleSize.FOUR_WHEELER, vehicleTypes, parkingFloors.get(i), ParkingState.AVAILABLE);
                parkingSpots.get(i).add(parkingSpot);
            }
        }
    }

    private ParkingSpot createObject(long id, VehicleSize vehicleSize, List<VehicleType> vehicleTypes, ParkingFloor parkingFloor, ParkingState parkingState) {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setId(id);
        parkingSpot.setParkingFloor(parkingFloor);
        parkingSpot.setParkingState(parkingState);
        parkingSpot.setSupportedVehicleSize(vehicleSize);
        parkingSpot.setSupportedVehicleType(vehicleTypes);

        return parkingSpot;
    }

    private void addOperators() {
        OperatorRepository operatorRepository = OperatorRepositoryImpl.getInstance();
        for (int i = 1; i <= 10; i++) {
            Operator operator = new Operator();
            operator.setId(1000 + i);
            operator.setName("Operator " + i);
            operators.add(operator);
            operatorRepository.saveOperator(operator.getId(), operator);
        }
    }

    private void addGates() {
        GateRepository gateRepository = GateRepositoryImpl.getInstance();

        for (int i = 1; i <= 5; i++) {
            Gate gate = new Gate();
            gate.setGateType(GateType.ENTRY);
            gate.setId(2000 + i);
            gate.setOperator(operators.get(i - 1));
            gates.add(gate);
            gateRepository.saveGate(gate.getId(), gate);
        }

        for (int i = 6; i <= 10; i++) {
            Gate gate = new Gate();
            gate.setGateType(GateType.EXIT);
            gate.setId(2000 + i);
            gate.setOperator(operators.get(i - 1));
            gates.add(gate);
            gateRepository.saveGate(gate.getId(), gate);
        }
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<List<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<List<ParkingSpot>> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public static ParkingLotFactory getInstance() {
        if (parkingLotFactory == null) {
            synchronized (ParkingLotFactory.class) {
                if (parkingLotFactory == null) {
                    parkingLotFactory = new ParkingLotFactory();
                }
            }
        }
        return parkingLotFactory;
    }
}
