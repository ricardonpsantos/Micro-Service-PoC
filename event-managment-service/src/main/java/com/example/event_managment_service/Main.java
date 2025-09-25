package com.example.event_managment_service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        System.out.println(money2("100"));
        System.out.println(money2(100));
        System.out.println(money2(new BigDecimal("210.5")));

    }

    public static String money2(Object v) {
        if (v == null) return null;
        BigDecimal bd = (v instanceof BigDecimal) ? (BigDecimal) v : new BigDecimal(v.toString());
        return bd.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}
