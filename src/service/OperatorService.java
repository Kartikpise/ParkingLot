package service;

import model.Operator;

public interface OperatorService {

    Operator saveOperator(long operatorId, String operatorName);
    Operator getOperator(long operatorId);
}
