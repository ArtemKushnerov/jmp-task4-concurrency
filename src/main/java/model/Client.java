package model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Client {
    private static int clientsAtAll;
    private int id;
    private Logger logger = Logger.getLogger(Client.class);

    private List<Account> accounts = new ArrayList<Account>();

    public List<Account> getAccounts() {
        return accounts;
    }


    public Client() {
        id = ++clientsAtAll;
        logger.info("Client with id " + getId() + " created.");
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public int getId() {
        return id;
    }
}
