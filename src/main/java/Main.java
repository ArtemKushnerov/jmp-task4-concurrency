import model.Account;
import model.Broker;
import model.Client;
import model.CurrencyType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static utilities.RandomGenerator.getRandomFromZeroTo;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public class Main {

    private static final int ACCOUNTS_NUMBER = 10;
    private static final int CLIENTS_NUMBER = 3;

    public static void main(String[] args) {
        //TODO make thread daemon that ensure that all is ok
        final List<Client> clients = new ArrayList<Client>();
        List<Account> accounts = new ArrayList<Account>();
        initialize(clients, accounts);
        final Broker broker = new Broker();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        startDeals(clients, broker);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static void startDeals(List<Client> clients, Broker broker) throws Exception {
        while (true) {
            Client firstClient = getRandomClient(clients);
            Client secondClient = getRandomClient(clients);
            if (firstClient != secondClient) {
                broker.makeRandomTransfer(firstClient, secondClient);
            }
        }
    }

    private static void initialize(List<Client> clients, List<Account> accounts) {
        for (int i = 0; i < ACCOUNTS_NUMBER; i++) {
            int numberOfCurrencies = CurrencyType.values().length;
            CurrencyType randomCurrency = CurrencyType.values()[getRandomFromZeroTo(numberOfCurrencies - 1)];
            BigDecimal randomAmount = new BigDecimal(getRandomFromZeroTo(1000));
            accounts.add(new Account(randomCurrency, randomAmount));
        }
        for (int i = 0; i < CLIENTS_NUMBER; i++) {
            clients.add(new Client());
        }
        for (Account account : accounts) {
            final Client randomClient = getRandomClient(clients);
            randomClient.addAccount(account);
        }
    }

    private static Client getRandomClient(List<Client> clients) {
        return clients.get(getRandomFromZeroTo(clients.size() - 1));
    }

}
