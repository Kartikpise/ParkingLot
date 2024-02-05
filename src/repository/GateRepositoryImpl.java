package repository;

import model.Gate;

import java.util.HashMap;

public class GateRepositoryImpl implements GateRepository {

    private HashMap<Long, Gate> gates;
    private static GateRepository gateRepository;

    public GateRepositoryImpl() {
        this.gates = new HashMap<>();
    }

    @Override
    public void saveGate(long gateId, Gate gate) {
        gates.put(gateId, gate);
    }

    @Override
    public Gate getGate(long gateId) {
        return gates.get(gateId);
    }

    public static GateRepository getInstance() {
        if (gateRepository == null) {
            synchronized (GateRepository.class) {
                if (gateRepository == null) {
                    gateRepository = new GateRepositoryImpl();
                }
            }
        }
        return gateRepository;
    }
}
