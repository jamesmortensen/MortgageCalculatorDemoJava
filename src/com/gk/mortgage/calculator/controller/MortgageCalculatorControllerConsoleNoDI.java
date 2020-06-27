package com.gk.mortgage.calculator.controller;

import com.gk.mortgage.calculator.domain.MortgageCalculatorRequest;
import com.gk.mortgage.calculator.domain.MortgageCalculatorResponse;
import com.gk.mortgage.calculator.task.MortgageProcessorTask;
import com.gk.mortgage.calculator.task.MortgageProcessorTaskImpl;
import com.gk.mortgage.calculator.task.ValidateInputTask;
import com.gk.mortgage.calculator.task.ValidateInputTaskImpl;


/*
This demonstrates the way NOT to do this.  We cannot test this and mock any dependencies. We also cannot
replace them at runtime with different implementations.  We also cannot change the behavior of the controller
without touching the code.  This violates the open-closed principle.
 */
public class MortgageCalculatorControllerConsoleNoDI {

    public MortgageCalculatorResponse calculateMonthlyPayment(MortgageCalculatorRequest request) {

        /*MortgageProcessorTask mortgageProcessorTask = new MortgageProcessorTaskImpl();
        ValidateInputTask validateInputTask = new ValidateInputTaskImpl();

        validateInputTask.validate(request);
        return mortgageProcessorTask.process(
                request.getPrincipalAmount(),
                request.getInterestRate(),
                request.getLengthOfTermInYears());

         */
        return null;
    }
}
