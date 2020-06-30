

function MortgageProcessorTask(mortgageCalculatorTask) {
    'use strict';

    function process(principalAmount, interestRate, lengthOfTermInYears) {
        return mortgageCalculatorTask.calculateMonthlyPayment(principalAmount, interestRate, lengthOfTermInYears);
    }

    // make it public
    MortgageProcessorTask.prototype.process = process;
}


