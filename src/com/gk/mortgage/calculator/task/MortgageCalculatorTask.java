package com.gk.mortgage.calculator.task;

public interface MortgageCalculatorTask {

    public double calculateMonthlyPayment(double principalAmount, double interestRate, int lengthOfTermInYears);

}
