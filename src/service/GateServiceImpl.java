package service;

import model.Gate;
import model.GateType;
import model.Operator;
import repository.GateRepository;
import repository.GateRepositoryImpl;

public class GateServiceImpl implements GateService {

    private static GateService gateService;
    private GateRepository gateRepository;
    private OperatorService operatorService;

    public GateServiceImpl() {
        this.gateRepository = GateRepositoryImpl.getInstance();
        this.operatorService = OperatorServiceImpl.getInstance();
    }

    @Override
    public void saveGate(long gateId, GateType gateType, long operatorId) {
        Operator operator = operatorService.getOperator(operatorId);
        Gate gate = new Gate();
        gate.setId(gateId);
        gate.setGateType(gateType);
        gate.setOperator(operator);

        gateRepository.saveGate(gateId, gate);
    }

    @Override
    public Gate getGate(long gateId) {
        return gateRepository.getGate(gateId);
    }

    public static GateService getInstance() {
        if (gateService == null) {
            synchronized (GateService.class) {
                if (gateService == null) {
                    gateService = new GateServiceImpl();
                }
            }
        }
        return gateService;
    }
}
