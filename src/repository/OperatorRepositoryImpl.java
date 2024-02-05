package repository;

import model.Operator;

import java.util.HashMap;

public class OperatorRepositoryImpl implements OperatorRepository {
    private HashMap<Long, Operator> operators;
    private static OperatorRepository operatorRepository;

    public OperatorRepositoryImpl() {
        this.operators = new HashMap<>();
    }

    @Override
    public void saveOperator(long operatorId, Operator operator) {
        operators.put(operatorId, operator);
    }

    @Override
    public Operator getOperator(long operatorId) {
        return operators.get(operatorId);
    }

    public static OperatorRepository getInstance() {
        if (operatorRepository == null) {
            synchronized (OperatorRepository.class) {
                if (operatorRepository == null) {
                    operatorRepository = new OperatorRepositoryImpl();
                }
            }
        }
        return operatorRepository;
    }
}
