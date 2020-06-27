package com.gk.mortgage.calculator.domain;

public class MortgageCalculatorResponse {

    private double monthlyPayment;

    public MortgageCalculatorResponse(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
}
