package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.Operator;
import calculator.domain.Splitter;
import calculator.domain.Validator;

import java.util.List;

public class CalculatorController {

    public CalculatorController(String expression) {
        Validator.validateExpression(expression);
    }

    public int calculate(String expression) {
        List<Integer> numbers = Splitter.splitNumbers(expression);
        List<Operator> operators = Splitter.splitOperators(expression);

        return Calculator.calculate(numbers, operators);
    }
}
