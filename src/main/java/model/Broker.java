package model;

import utilities.Exchanger;

import java.math.BigDecimal;
import java.util.List;

import static utilities.RandomGenerator.getRandomFromZeroTo;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Broker {
    private Exchanger exchanger = new Exchanger();

    public void makeRandomTransfer(Client firstClient, Client secondClient) {
        System.out.println("Starting a deal between client #" + firstClient.getId() + " and client #" + secondClient.getId());
        Account fromAccount = chooseRandomAccount(firstClient);
        BigDecimal amountToWithdraw = getRandomFromZeroTo(fromAccount.getCurrencyAmount());

        Account toAccount = chooseRandomAccount(secondClient);
        synchronized (fromAccount) {
            synchronized (toAccount) {
                CurrencyType fromCurrency = fromAccount.getCurrencyType();
                CurrencyType toCurrency = toAccount.getCurrencyType();
                if (fromAccount.withdrawMoney(amountToWithdraw)) {
                    System.out.println("Get  " + amountToWithdraw + " " + fromCurrency + " from  client #" + firstClient.getId());
                    BigDecimal amountToDeposit = exchanger.exchange(amountToWithdraw, fromCurrency, toCurrency);
                    System.out.println("Give " + amountToDeposit + " " + toCurrency + " to  client #" + secondClient.getId());
                    toAccount.depositMoney(amountToDeposit);
                }
            }
        }
    }

    private Account chooseRandomAccount(Client client) {
        List<Account> clientAccounts = client.getAccounts();
        return clientAccounts.get((getRandomFromZeroTo(clientAccounts.size() - 1)));
    }

}
