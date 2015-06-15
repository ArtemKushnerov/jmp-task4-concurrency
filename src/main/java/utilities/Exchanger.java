package utilities;

import model.ExchangeRate;
import model.CurrencyType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Exchanger {
    private List<ExchangeRate> rates = new ArrayList<ExchangeRate>(Arrays.asList(
            new ExchangeRate(CurrencyType.EUR, CurrencyType.USD, new BigDecimal(1.13)),
            new ExchangeRate(CurrencyType.USD, CurrencyType.EUR, new BigDecimal(.88)),
            new ExchangeRate(CurrencyType.USD, CurrencyType.USD, new BigDecimal(1)),
            new ExchangeRate(CurrencyType.EUR, CurrencyType.EUR, new BigDecimal(1))
    ));

    public BigDecimal exchange(BigDecimal amount, CurrencyType from, CurrencyType to) {
        ExchangeRate rate = pickAppropriateRate(from, to);
        return amount.multiply(rate.getQuotient());
    }

    private ExchangeRate pickAppropriateRate(CurrencyType from, CurrencyType to) {
        for (ExchangeRate rate : rates) {
            if (rate.getFrom() == from && rate.getTo() == to) {
                return rate;
            }
        }
        return null;
    }
}
