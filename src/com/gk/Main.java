package com.gk;

import com.gk.mortgage.calculator.controller.MortgageCalculatorControllerConsole;
import com.gk.mortgage.calculator.controller.MortgageCalculatorControllerConsoleNoDI;
import com.gk.mortgage.calculator.domain.MortgageCalculatorRequest;
import com.gk.mortgage.calculator.domain.MortgageCalculatorResponse;
import com.gk.mortgage.calculator.task.FixedRateMortageCalculatorTaskImpl;
import com.gk.mortgage.calculator.task.InterestOnlyMortgageCalculatorTaskImpl;
import com.gk.mortgage.calculator.task.MortgageProcessorTaskImpl;
import com.gk.mortgage.calculator.task.ValidateInputTaskImpl;

public class Main {

    private static MortgageCalculatorRequest request;
    private static MortgageCalculatorResponse response;

    /*
    These constants, at least right now, are specific to this class. Putting all constants in a big
    massive Constants class breaks single-responsibility. If we later find we need to use these elsewhere,
    then we refactor the code to increase their visibility. See "Single Responsibility" and "YAGNI" principles.
     */
    private static final String FIXED = "Fixed";
    private static final String INTEREST_ONLY = "Interest";

    public static void main(String[] args) {

        request = new MortgageCalculatorRequest(250000, 5.0, 15);


        // run the calculator without Dependency injection.
        response = (new MortgageCalculatorControllerConsoleNoDI()).calculateMonthlyPayment(request);
        assertResponse(FIXED, request, response);


        // run the calculator with Dependency injection. Note how we can pass in different implementations here.
        response = (new MortgageCalculatorControllerConsole(
                new MortgageProcessorTaskImpl(
                        new FixedRateMortageCalculatorTaskImpl()
                ),
                new ValidateInputTaskImpl()
        )).calculateMonthlyPayment(request);
        assertResponse(FIXED, request, response);

        // now run with a different MortgageCalculatorTask implementation
        response = (new MortgageCalculatorControllerConsole(
                new MortgageProcessorTaskImpl(
                        new InterestOnlyMortgageCalculatorTaskImpl()
                ),
                new ValidateInputTaskImpl()
        )).calculateMonthlyPayment(request);
        assertResponse(INTEREST_ONLY, request, response);
    }

    /*
    Quick and dirty test written to "drive" the development.
     */
    private static void assertResponse(String type, MortgageCalculatorRequest req, MortgageCalculatorResponse res) {
        System.out.println(request);
        System.out.println(response);
        if(type.equals(FIXED))
            if(response.getMonthlyPayment() == 2547)
                System.out.println("Pass");
            else
                System.out.println("FAIL! expect 2547 but got " + response.getMonthlyPayment());
        else if(type.equals(INTEREST_ONLY))
            if(response.getMonthlyPayment() == 1041.67)
                System.out.println("Pass");
            else
                System.out.println("FAIL! expect 1041.67 but got " + response.getMonthlyPayment());

    }
}
