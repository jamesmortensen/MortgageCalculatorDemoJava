

function MortgageCalculatorControllerConsole(mortgageProcessorTask, validateInputTask) {
    'use strict';

    function calculateMonthlyPayment(request) {
        validateInputTask.validate(request);
        return new MortgageCalculatorResponse(
                mortgageProcessorTask.process(
                        request.getPrincipalAmount(),
                        request.getInterestRate(),
                        request.getLengthOfTermInYears()
                )
        );
    }

    // make this public
    MortgageCalculatorControllerConsole.prototype.calculateMonthlyPayment = calculateMonthlyPayment;

}


