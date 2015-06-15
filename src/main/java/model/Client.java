package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Client {
    private static int clientsAtAll;
    private int id;

    private List<Account> accounts = new ArrayList<Account>();

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Client(Account... accounts) {
        for (Account account : accounts) {
            this.accounts.add(account);
        }
    }

    public Client() {
        id = ++clientsAtAll;
        System.out.println("Client with id " + getId() + " created.");
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public int getId() {
        return id;
    }
}
