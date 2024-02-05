package service;

import model.Operator;
import repository.OperatorRepository;

public class OperatorServiceImpl implements OperatorService {

    private static OperatorService operatorService;
    private OperatorRepository operatorRepository;

    @Override
    public Operator saveOperator(long operatorId, String operatorName) {
        Operator operator = new Operator();
        operator.setId(operatorId);
        operator.setName(operatorName);

        operatorRepository.saveOperator(operatorId, operator);

        return operator;
    }

    @Override
    public Operator getOperator(long operatorId) {
        return operatorRepository.getOperator(operatorId);
    }

    public static OperatorService getInstance() {
        if (operatorService == null) {
            synchronized (OperatorService.class) {
                if (operatorService == null) {
                    operatorService = new OperatorServiceImpl();
                }
            }
        }
        return operatorService;
    }
}
