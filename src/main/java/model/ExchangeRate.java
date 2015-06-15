package model;

import java.math.BigDecimal;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class ExchangeRate {

    private CurrencyType from;
    private CurrencyType to;

    public ExchangeRate() {

    }

    public BigDecimal getQuotient() {
        return quotient;
    }

    public CurrencyType getTo() {
        return to;
    }

    public CurrencyType getFrom() {
        return from;
    }

    private BigDecimal quotient;

    public ExchangeRate(final CurrencyType us, final CurrencyType eur, final BigDecimal quotient) {
        this.from = us;
        this.to = eur;
        this.quotient = quotient;
    }
}
