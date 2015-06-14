package dao;

import model.Client;

/**
 * @author Artsiom Kushniarou
 * @since June 10, 2015
 */
public interface AccountDao {

    void create(Client account);
    void read(int accountId);
    void update(int accountId);
    void delete(int accoutnId);
}
