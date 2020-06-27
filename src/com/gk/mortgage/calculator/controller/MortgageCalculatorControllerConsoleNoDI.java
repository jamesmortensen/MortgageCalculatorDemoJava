package com.gk.mortgage.calculator.controller;

import com.gk.mortgage.calculator.domain.MortgageCalculatorRequest;
import com.gk.mortgage.calculator.domain.MortgageCalculatorResponse;
import com.gk.mortgage.calculator.task.*;


/*
This demonstrates the way NOT to do this.  We cannot test this and mock any dependencies. We also cannot
replace them at runtime with different implementations.  We also cannot change the behavior of the controller
without touching the code.  This violates the open-closed principle.
 */
public class MortgageCalculatorControllerConsoleNoDI {

    public MortgageCalculatorResponse calculateMonthlyPayment(MortgageCalculatorRequest request) {

        // However, the processors still take whatever dependency we pass into the constructor.
        MortgageProcessorTask mortgageProcessorTask = new MortgageProcessorTaskImpl(new FixedRateMortageCalculatorTaskImpl());
        ValidateInputTask validateInputTask = new ValidateInputTaskImpl();

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
