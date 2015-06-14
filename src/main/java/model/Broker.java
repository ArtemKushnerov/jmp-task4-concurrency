package model;

import model.enums.CurrencyType;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Broker {
    private List<ExchangeRate> exchangeRates;

    public void makeDeal(Client clientThatWantsToSell, Client clientThatWantsToBuy, BigDecimal amount, CurrencyType currencyType) {

    }
}
