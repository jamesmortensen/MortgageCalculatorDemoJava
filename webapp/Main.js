// Main.js

// self executing module - nothing pollutes the global namespace.
(function() {

    /*
     this makes sure I cannot create global variables inside this module
     by throwing ReferenceErrors if I don't use var, let, const, etc.
    */
    'use strict';


    /*
    These constants, at least right now, are specific to this class. Putting all constants in a big
    massive Constants class breaks single-responsibility. If we later find we need to use these elsewhere,
    then we refactor the code to increase their visibility. See "Single Responsibility" and "YAGNI" principles.
    */
    const FIXED = "Fixed";
    const INTEREST_ONLY = "Interest";

    // Main entry point
    window.addEventListener('load', () => {
        console.log('loaded');

        const request = new MortgageCalculatorRequest(250000, 5.0, 15);

        // run the calculator without Dependency injection.
        var response = (new MortgageCalculatorControllerConsoleNoDI()).calculateMonthlyPayment(request);
        assertResponse(FIXED, request, response);


        // run the calculator with Dependency injection. Note how we can pass in different implementations here.
        response = (new MortgageCalculatorControllerConsole(
            new MortgageProcessorTask(
                    new FixedRateMortageCalculatorTask()
            ),
            new ValidateInputTask()
        )).calculateMonthlyPayment(request);
        assertResponse(FIXED, request, response);


        // now run with a different MortgageCalculatorTask implementation
        response = (new MortgageCalculatorControllerConsole(
                new MortgageProcessorTask(
                        new InterestOnlyMortgageCalculatorTask()
                ),
                new ValidateInputTask()
        )).calculateMonthlyPayment(request);
        assertResponse(INTEREST_ONLY, request, response);

    }, false);


    /*
    Quick and dirty test written to "drive" the development.
     */
    function assertResponse(type, request, response) {
        System.out.println(request);
        System.out.println(response);
        if(type === FIXED)
            if(response.getMonthlyPayment() == 2547)
                System.out.println("Pass");
            else
                System.out.println("FAIL! expect 2547 but got " + response.getMonthlyPayment());
        else if(type === INTEREST_ONLY)
            if(response.getMonthlyPayment() == 1041.67)
                System.out.println("Pass");
            else
                System.out.println("FAIL! expect 1041.67 but got " + response.getMonthlyPayment());

    }


    /*
    Easier to make the JavaScript code fit what was written in Java than to change
    every single System.out...

    - Demonstrates the concept of substituting an implementation with another centrally.
    - This example not recommended for production for logging.

    */
    const System = {
        out: {
            println: (str) => {
                console.log(str);
            }
        }
    }

})();