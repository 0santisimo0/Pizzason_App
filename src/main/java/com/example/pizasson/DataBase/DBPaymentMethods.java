package com.example.pizasson.DataBase;

import com.example.pizasson.Model.Payment.*;

import java.util.ArrayList;
import java.util.List;

public class DBPaymentMethods {
    public PayCreditCard payCreditCard = new PayCreditCard("Credit Card");
    public PayPayPal payPayPal = new PayPayPal("Pay Pal");
    public PayTigoMoney payTigoMoney = new PayTigoMoney("Tigo Money");
    public PayQR payQR = new PayQR("Qr Code");

    public ArrayList<Payment> listOfPayments = new ArrayList<>(List.of(payCreditCard, payPayPal, payTigoMoney, payQR)
    );
}

