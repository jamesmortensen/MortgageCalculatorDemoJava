package com.gk;

import com.gk.mortgage.calculator.controller.MortgageCalculatorControllerConsole;
import com.gk.mortgage.calculator.controller.MortgageCalculatorControllerConsoleNoDI;
import com.gk.mortgage.calculator.domain.MortgageCalculatorRequest;
import com.gk.mortgage.calculator.domain.MortgageCalculatorResponse;

public class Main {

    private static MortgageCalculatorRequest request;
    private static MortgageCalculatorResponse response;

    public static void main(String[] args) {

        request = new MortgageCalculatorRequest(250000, 5.0, 15);

        // run the calculator without Dependency injection.
        response = (new MortgageCalculatorControllerConsoleNoDI()).calculateMonthlyPayment(request);




        // run the calculator with Dependency injection.
        //response = (new MortgageCalculatorControllerConsole(/* MortgageProcessorTask and ValidateInputTask */null,null)).calculateMonthlyPayment();

        System.out.println(response);
    }

}
