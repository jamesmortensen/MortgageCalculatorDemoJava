package com.gk.mortgage.calculator.task;

public class MortgageProcessorTaskImpl implements MortgageProcessorTask {

    private MortgageCalculatorTask mortgageCalculatorTask;

    public MortgageProcessorTaskImpl(MortgageCalculatorTask mortgageCalculatorTask) {
        this.mortgageCalculatorTask = mortgageCalculatorTask;
    }

    public double process(double principalAmount, double interestRate, int lengthOfTermInYears) {
        return mortgageCalculatorTask.calculateMonthlyPayment(principalAmount, interestRate, lengthOfTermInYears);
    }

}
