import model.Broker;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Main {

    public static void main(String[] args) {
        //TODO make thread daemon that ensure that all is ok
/*
        Exchanger exchanger = new Exchanger();

        Currency euros = new Currency(CurrencyType.EUR, new BigDecimal(1000));

        BigDecimal quotient = new BigDecimal(1.13);
        ExchangeRate eurosToDollarsRate = new ExchangeRate(CurrencyType.EUR, CurrencyType.USD, quotient);

        Currency dollars = exchanger.exchange(euros, eurosToDollarsRate);

        Account myAccount = new Account(dollars);
        BigDecimal dollarsToWithdraw = new BigDecimal(100);
        Currency fewDollars = myAccount.withdrawMoney(CurrencyType.USD, dollarsToWithdraw);
        Account anotherAccount = new Account();
        anotherAccount.depositMoney(fewDollars);
*/

        initialize();
        new Broker.ma
    }

    private static void initialize() {

    }
}
