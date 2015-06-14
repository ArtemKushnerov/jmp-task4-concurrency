package model;

import model.enums.CurrencyType;

import java.math.BigDecimal;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Account {
    private BigDecimal currencyAmount;
    private CurrencyType currencyType;

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public BigDecimal getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(BigDecimal currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public Account(CurrencyType currencyType, BigDecimal currencyAmount) {
        this.currencyType = currencyType;
        this.currencyAmount = currencyAmount;
    }
}
