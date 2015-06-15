package model;

import java.math.BigDecimal;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Account {
    private BigDecimal currencyAmount;
    private CurrencyType currencyType;

    public void depositMoney(BigDecimal amountToDeposit) {
        currencyAmount.add(amountToDeposit);
    }

    public boolean withdrawMoney(BigDecimal amountToWithdraw) {
        final boolean haveMoney = currencyAmount.compareTo(amountToWithdraw) > 0;
        if (haveMoney){
            currencyAmount.subtract(amountToWithdraw);
        }
        return haveMoney;
    }

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
        System.out.println("Account with " + currencyAmount + " " + currencyType + "created" );
        this.currencyType = currencyType;
        this.currencyAmount = currencyAmount;
    }


}
