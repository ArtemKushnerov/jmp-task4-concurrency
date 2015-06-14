package model;

import exceptions.NoSuchAccountCurrencyType;
import exceptions.NotEnoughMoneyForWithdrawal;
import model.enums.CurrencyType;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Client {
    private int id;
    private List<Account> accounts = new ArrayList<Account>();
    private Logger logger = Logger.getLogger(Client.class);

    public Client(Account money) {

    }

    public Client() {

    }

    public void depositMoney(Account accountToDeposit) {
        for (Account cur : accounts) {
            if (cur.getCurrencyType() == accountToDeposit.getCurrencyType()) {
                cur.setCurrencyAmount(cur.getCurrencyAmount().add(accountToDeposit.getCurrencyAmount()));
                return;
            }
        }
        accounts.add(accountToDeposit);
    }


    public Account withdrawMoney(CurrencyType type, BigDecimal amount) {
        for (Account cur : accounts) {
            if (cur.getCurrencyType() == type) {
                if (cur.getCurrencyAmount().compareTo(amount) < 0 ) {
                    throw new NotEnoughMoneyForWithdrawal("Account id :" + id + ". You want to withdraw: " + amount + "but there are only: " + cur.getCurrencyAmount());
                }
                cur.setCurrencyAmount(cur.getCurrencyAmount().subtract(amount));
                return new Account(type, amount);
            }
        }
        throw new NoSuchAccountCurrencyType("Account id:" + id);
    }
}
