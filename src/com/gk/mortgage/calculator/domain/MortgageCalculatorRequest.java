package com.gk.mortgage.calculator.domain;

/*
Implemented slightly different than in their example.  I don't return a builder.
 */
public class MortgageCalculatorRequest {

    public MortgageCalculatorRequest(double principalAmount, double interestRate, int lengthOfTermInYears) {
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.lengthOfTermInYears = lengthOfTermInYears;
    }

    private int lengthOfTermInYears;
    private double principalAmount;
    private double interestRate;

    public int getLengthOfTermInYears() {
        return lengthOfTermInYears;
    }

    public void setLengthOfTermInYears(int lengthOfTermInYears) {
        this.lengthOfTermInYears = lengthOfTermInYears;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


}
