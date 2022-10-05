package com.example.pizasson.Model.Payment;

import java.time.LocalDate;

/**
 * This class implements the methods of payment Manageable interface and extends of payment is used to
 * create a method of pay in this case Tigo Money method.
 *
 * @see Payment
 * @see PaymentManagable
 */
public class PayTigoMoney extends Payment implements PaymentManagable{
    private int phoneNumber;
    private int nit;

    /**
     * This is a constructor method where initializes the values of variables.
     *
     * @param namePaymentMethod the value will be change when will bee want a create this method.
     */
    public PayTigoMoney(String namePaymentMethod) {
        super(namePaymentMethod);
        phoneNumber = 0;
        nit = 0;
    }

    /**
     * This method is implemented by the interface PaymentManagable is used to get the day of doing the pay.
     *
     * @return the day of pay
     */
    @Override
    public String getDayOfPay() {
        return String.valueOf(LocalDate.now());
    }

}
