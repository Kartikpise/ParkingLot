package service;

import model.Gate;
import model.GateType;

public interface GateService {
    void saveGate(long gateId, GateType gateType, long operatorId);
    Gate getGate(long gateId);
}
