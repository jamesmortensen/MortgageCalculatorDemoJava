package com.gk.mortgage.calculator.task;

public interface MortgageProcessorTask {

    public double process(double principalAmount, double interestRate, int lengthOfTermInYears);

}
