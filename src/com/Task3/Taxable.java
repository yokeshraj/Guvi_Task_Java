package com.Task3;

public interface Taxable {
    double SALES_TAX_RATE = 0.07;
    double INCOME_TAX_RATE = 0.105;

    double calcTax();
}
