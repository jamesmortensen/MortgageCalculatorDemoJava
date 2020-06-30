

/*
Implemented slightly different than in their example.  I don't return a builder.
 */
function MortgageCalculatorRequest(principalAmount, interestRate, lengthOfTermInYears) {
    'use strict';

    // holder for all privileged methods.
    var _self = this;

    _self.getLengthOfTermInYears = () => {
        return lengthOfTermInYears;
    }

    _self.setLengthOfTermInYears = function (lengthOfTermInYears) {
        this.lengthOfTermInYears = lengthOfTermInYears;
    }

    _self.getPrincipalAmount = () => {
        return principalAmount;
    }

    _self.setPrincipalAmount = (principalAmount) => {
        this.principalAmount = principalAmount;
    }

    _self.getInterestRate = () => {
        return interestRate;
    }

    _self.setInterestRate = (interestRate) => {
        this.interestRate = interestRate;
    }
}
