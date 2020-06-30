


/*
This demonstrates the way NOT to do this.  We cannot test this and mock any dependencies. We also cannot
replace them at runtime with different implementations.  We also cannot change the behavior of the controller
without touching the code.  This violates the open-closed principle.
 */
function MortgageCalculatorControllerConsoleNoDI() {
    'use strict';

    function calculateMonthlyPayment(request) {

        // However, the processors still take whatever dependency we pass into the constructor.
        const mortgageProcessorTask = new MortgageProcessorTask(new FixedRateMortageCalculatorTask());
        const validateInputTask = new ValidateInputTask();

        validateInputTask.validate(request);
        return new MortgageCalculatorResponse(
                mortgageProcessorTask.process(
                        request.getPrincipalAmount(),
                        request.getInterestRate(),
                        request.getLengthOfTermInYears()
                )
        );
    }

    // make it public
    MortgageCalculatorControllerConsoleNoDI.prototype.calculateMonthlyPayment = calculateMonthlyPayment;
}
