package com.gk.mortgage.calculator.controller;

/*
We only need to include the interfaces as dependencies. We don't need to include the implementations if
they are injected.
 */
import com.gk.mortgage.calculator.domain.MortgageCalculatorRequest;
import com.gk.mortgage.calculator.domain.MortgageCalculatorResponse;
import com.gk.mortgage.calculator.task.MortgageProcessorTask;
import com.gk.mortgage.calculator.task.ValidateInputTask;


public class MortgageCalculatorControllerConsole {

    private final MortgageProcessorTask mortgageProcessorTask;
    private final ValidateInputTask validateInputTask;

    /*
    The constructor takes the dependencies as arguments. Here, we "inject" them into the class.  This
    allows us to change the behavior of this class later, without changing a single line in this code.
     */
    public MortgageCalculatorControllerConsole(MortgageProcessorTask mortgageProcessorTask, ValidateInputTask validateInputTask) {
        this.mortgageProcessorTask = mortgageProcessorTask;
        this.validateInputTask = validateInputTask;
    }

    /*
     * This uses the validator and mortgage processor passed into the constructor. More than one implementation
     * can be passed into the constructor.q
     */
    public MortgageCalculatorResponse calculateMonthlyPayment(MortgageCalculatorRequest request) {
        validateInputTask.validate(request);
        return new MortgageCalculatorResponse(
                mortgageProcessorTask.process(
                        request.getPrincipalAmount(),
                        request.getInterestRate(),
                        request.getLengthOfTermInYears()
                )
        );

    }

}
