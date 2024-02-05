package repository;

import model.Operator;

public interface OperatorRepository {
    void saveOperator(long operatorId, Operator operator);
    Operator getOperator(long operatorId);
}
