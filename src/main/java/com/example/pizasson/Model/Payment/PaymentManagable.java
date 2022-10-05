package com.example.pizasson.Model.Payment;

/**
 * This class is an interface, which one is used to its methods are implement in other classes.
 *
 */
public interface PaymentManagable {

    /**
     * This method return the day in the user is doing the pay.
     *
     * @return the day.
     */
    String getDayOfPay();
}