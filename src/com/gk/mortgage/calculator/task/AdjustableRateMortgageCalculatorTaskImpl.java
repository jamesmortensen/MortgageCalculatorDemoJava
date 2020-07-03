package com.gk.mortgage.calculator.task;

import com.gk.mortgage.calculator.task.MortgageCalculatorTask;

public class AdjustableRateMortgageCalculatorTaskImpl implements MortgageCalculatorTask {

    @Override
    public double calculateMonthlyPayment(double principalAmount, double interestRate, int lengthOfTermInYears) {
        // implementation goes here
        return 20000;
    }
}
