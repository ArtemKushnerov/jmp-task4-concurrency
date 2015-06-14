package model;

import model.enums.CurrencyType;

import java.math.BigDecimal;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class ExchangeRate {

    private final CurrencyType from;
    private final CurrencyType to;
    private final BigDecimal quotient;

    public ExchangeRate(final CurrencyType us, final CurrencyType eur, final BigDecimal quotient) {
        this.from = us;
        this.to = eur;
        this.quotient = quotient;
    }
}
