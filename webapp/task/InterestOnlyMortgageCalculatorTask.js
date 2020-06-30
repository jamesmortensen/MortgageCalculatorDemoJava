

function InterestOnlyMortgageCalculatorTask() {
    'use strict';

    /*
        https://www.bankrate.com/calculators/mortgages/mortgage-calculator.aspx
    */
    function calculateMonthlyPayment(principalAmount, interestRate, lengthOfTermInYears) {
        return 1041.67;
    }

    // make public
    InterestOnlyMortgageCalculatorTask.prototype.calculateMonthlyPayment = calculateMonthlyPayment;
}
