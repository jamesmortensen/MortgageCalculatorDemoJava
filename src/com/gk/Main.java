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

        assertResponse(request, response);


        // run the calculator with Dependency injection.
        response = (new MortgageCalculatorControllerConsole(/* MortgageProcessorTask and ValidateInputTask */null,null)).calculateMonthlyPayment(request);

        assertResponse(request, response);
    }

    /*
    Quick and dirty test written to "drive" the development.
     */
    private static void assertResponse(MortgageCalculatorRequest req, MortgageCalculatorResponse res) {
        System.out.println(request);
        System.out.println(response);
        if(response.getMonthlyPayment() == 2547)
            System.out.println("Pass");
        else
            System.out.println("FAIL! expect 2547 but got " + response.getMonthlyPayment());
    }

}
