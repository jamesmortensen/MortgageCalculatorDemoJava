package com.gk;

import com.gk.mortgage.calculator.controller.MortgageCalculatorControllerConsole;
import com.gk.mortgage.calculator.domain.MortgageCalculatorRequest;
import com.gk.mortgage.calculator.domain.MortgageCalculatorResponse;
import com.gk.mortgage.calculator.task.AdjustableRateMortgageCalculatorTaskImpl;
import com.gk.mortgage.calculator.task.MortgageProcessorTaskImpl;
import com.gk.mortgage.calculator.task.ValidateInputTaskImpl;

public class SomeOtherApplication {

    private static MortgageCalculatorRequest request;
    private static MortgageCalculatorResponse response;

    public static void main(String args[]) {

        request = new MortgageCalculatorRequest(250000, 5.0, 30);

        // run the calculator with Dependency injection. Note how we can pass in different implementations here.
        response = (new MortgageCalculatorControllerConsole(
                new MortgageProcessorTaskImpl(
                        new AdjustableRateMortgageCalculatorTaskImpl()
                ),
                new ValidateInputTaskImpl()
        )).calculateMonthlyPayment(request);
        assertResponse("", request, response);

    }

    /*
   Quick and dirty test written to "drive" the development.
    */
    private static void assertResponse(String type, MortgageCalculatorRequest req, MortgageCalculatorResponse res) {
        System.out.println(request);
        System.out.println(response.getMonthlyPayment());

            if(request.getLengthOfTermInYears() == 30) {
                if (response.getMonthlyPayment() == 1976.984066853866)
                    System.out.println("Pass");
                else
                    System.out.println("FAIL! expect 1976 but got " + response.getMonthlyPayment());
            }

    }
}
