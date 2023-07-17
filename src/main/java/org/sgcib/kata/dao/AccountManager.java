package org.sgcib.kata.dao;

import org.sgcib.kata.entity.Account;
import org.sgcib.kata.factory.BankAccountFactory;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// class created to simulate the persistence in a Map
public class AccountManager {

    private static AccountManager instance;
    private static BankAccountFactory bankAccountFactory = BankAccountFactory.getInstance();

    private Map<Long, Account> managedAccounts;

    private AccountManager() {
        this.managedAccounts = new HashMap<>();
    }

    /**
     *  Singleton Instance
     * @return
     */
    public static AccountManager getInstance() {

        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public Map<Long, Account> getManagedAccounts() {
        return managedAccounts;
    }

    /**
     *  Creates Account
     * @param id
     * @return
     */

    public Account createAccount(String accountType, Long id) {

        if (!managedAccounts.containsKey(id)) {
            Account newAccount = bankAccountFactory.getAccount(accountType, id);
            managedAccounts.put(id, newAccount);
            return newAccount;
        }
        else {
            throw new IllegalArgumentException("Bank Account of id = '" + id + "' already exist !");
        }
    }

    public List<Long> listAccounts() {
        return new ArrayList<>(getManagedAccounts()
                .keySet());
    }
}
