package repository;

import model.Gate;

public interface GateRepository {
    void saveGate(long gateId, Gate gate);
    Gate getGate(long gateId);
}
