

function MortgageCalculatorResponse(monthlyPayment) {
    'use strict';

    // holder for privileged methods.
    var _self = this;

    _self.getMonthlyPayment = () => {
        return monthlyPayment;
    }

    _self.setMonthlyPayment = (monthlyPayment) => {
        this.monthlyPayment = monthlyPayment;
    }
}
