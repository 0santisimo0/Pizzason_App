package com.example.pizasson.Model.Payment;

import java.time.LocalDate;

/**
 * This class is an abstract class, which one is used to extend its attributes.
 *
 */
public abstract class Payment {

    private String namePaymentMethod;
    private final LocalDate dayOfPayment;

    /**
     * This is a constructor method where initializes the values of variables.
     *
     * @param namePaymentMethod the value will be change when will bee want a create this method.
     */
    public Payment(String namePaymentMethod) {
        this.namePaymentMethod = namePaymentMethod;
        dayOfPayment = LocalDate.now();
    }

    /**
     * This method is used to get the name of payment method.
     *
     * @return the name of payment method.
     */
    public String getNamePaymentMethod() {
        return namePaymentMethod;
    }
}