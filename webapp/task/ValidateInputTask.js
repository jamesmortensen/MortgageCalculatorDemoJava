

function ValidateInputTask() {
    'use strict';

    /*
    These are private because we don't need them anywhere else but here.  A big massive Constants.java file is
    actually a code smell. Encapsulate constants just like you would anything else.

    Keep the things that change together in the same place together. If I need to change the message, I can do it
    right here.

    If I later have other validators that need these constants, then I can create an
    AbstractValidateInputTaskImpl class to store them and then each implementation subclasses them.
    The idea is we refactor as we go and as we see a need for code reuse.
     */
    const NON_NULL_REQUEST = "MortgageCalculatorRequest must not be null.";
    const NO_NEGATIVE_INTEREST_RATE = "Negative interest rates not allowed. Interest rate must be greater than or equal to zero.";
    const NO_NEGATIVE_TERM = "Negative term lengths not allowed. Term length must be greater than or equal to zero.";
    const PRINCIPAL_MUST_BE_GREATER_THAN_ZERO = "Negative or zero principal amounts not allowed. Principal must be greater than zero.";

    /*
    This throws an exception if the request doesn't validate. Don't let null travel throughout your app
    and wreak havoc.  Instead, throw exceptions.
     */
    function validate(mortgageCalculatorRequest) {

        if(mortgageCalculatorRequest == null)
            throw new Error(NON_NULL_REQUEST);
        if(mortgageCalculatorRequest.getInterestRate() < 0)
            throw new Error(NO_NEGATIVE_INTEREST_RATE);
        if(mortgageCalculatorRequest.getLengthOfTermInYears() < 0)
            throw new Error(NO_NEGATIVE_TERM);
        if(mortgageCalculatorRequest.getPrincipalAmount() <= 0) {
            throw new Error(PRINCIPAL_MUST_BE_GREATER_THAN_ZERO);
        }

    }

    // make it public
    ValidateInputTask.prototype.validate = validate;

}

