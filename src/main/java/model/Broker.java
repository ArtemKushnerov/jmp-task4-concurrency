package model;

import clojure.lang.LockingTransaction;
import org.apache.log4j.Logger;
import utilities.Exchanger;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Callable;

import static utilities.RandomGenerator.getRandomFromZeroTo;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Broker {
    private Exchanger exchanger = new Exchanger();
    Logger logger = Logger.getLogger(Broker.class);
    public void makeRandomTransfer(final Client firstClient, final Client secondClient) throws Exception {
        System.out.println("Starting a deal between client #" + firstClient.getId() + " and client #" + secondClient.getId());
        final Account fromAccount = chooseRandomAccount(firstClient);
        final BigDecimal amountToWithdraw = getRandomFromZeroTo(fromAccount.getCurrencyAmount());

        final Account toAccount = chooseRandomAccount(secondClient);
        LockingTransaction.runInTransaction(new Callable<Void>() {
            public Void call() throws Exception {
                CurrencyType fromCurrency = fromAccount.getCurrencyType();
                CurrencyType toCurrency = toAccount.getCurrencyType();
                if (fromAccount.withdrawMoney(amountToWithdraw)) {
                    logger.info("Get  " + amountToWithdraw + " " + fromCurrency + " from  client #" + firstClient.getId());
                    BigDecimal amountToDeposit = exchanger.exchange(amountToWithdraw, fromCurrency, toCurrency);
                    logger.info("Give " + amountToDeposit + " " + toCurrency + " to  client #" + secondClient.getId());
                    toAccount.depositMoney(amountToDeposit);
                }
                return null;
            }
        });
    }

    private Account chooseRandomAccount(Client client) {
        List<Account> clientAccounts = client.getAccounts();
        return clientAccounts.get((getRandomFromZeroTo(clientAccounts.size() - 1)));
    }

}
