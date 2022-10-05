package com.example.pizasson.Model.Payment;

import java.time.LocalDate;

/**
 * This class implements the methods of payment Manageable interface and extends of payment is used to
 * create a method of pay in this case Credit Card method.
 *
 * @see Payment
 * @see PaymentManagable
 */

public class PayCreditCard extends Payment implements PaymentManagable{

    /**
     * This is a constructor method where initializes the values of variables.
     *
     * @param namePaymentMethod the value will be change when will bee want a create this method.
     */
    public PayCreditCard(String namePaymentMethod) {
        super(namePaymentMethod);
    }


    @Override
    public String getDayOfPay() {
        return String.valueOf(LocalDate.now());
    }

}

