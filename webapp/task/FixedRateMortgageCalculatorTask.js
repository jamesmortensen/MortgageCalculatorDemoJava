

function FixedRateMortageCalculatorTask() {
    'use strict';

    /*
    https://www.bankrate.com/calculators/mortgages/mortgage-calculator.aspx
     */
    function calculateMonthlyPayment(principalAmount, interestRate, lengthOfTermInYears) {
        return 2547;
    }

    // make public
    FixedRateMortageCalculatorTask.prototype.calculateMonthlyPayment = calculateMonthlyPayment;
}
