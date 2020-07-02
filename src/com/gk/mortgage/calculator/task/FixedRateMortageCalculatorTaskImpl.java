package com.gk.mortgage.calculator.task;

public class FixedRateMortageCalculatorTaskImpl implements MortgageCalculatorTask {

    /*
    https://www.bankrate.com/calculators/mortgages/mortgage-calculator.aspx
    https://homeguides.sfgate.com/calculate-payments-fixed-rate-mortgage-2963.html
    https://en.wikipedia.org/wiki/Mortgage_calculator
     */
    public double calculateMonthlyPayment(double principalAmount, double interestRate, int lengthOfTermInYears) {
        //interestRate /= 100;
        double monthlyRate = (interestRate / 100) / 12;
        int lengthOfTermInMonths = lengthOfTermInYears * 12;

        return ((monthlyRate * principalAmount) * Math.pow(1 + monthlyRate, lengthOfTermInMonths)) /
                (Math.pow(1 + monthlyRate, lengthOfTermInMonths) - 1);
    }
}
