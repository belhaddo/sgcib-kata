package org.sgcib.kata.service;

import org.sgcib.kata.entity.Account;
import org.sgcib.kata.entity.BasicAccount;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// class created to simulate the persistence in a Map
public class AccountManager {

    private static AccountManager instance;
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
    /**
     * Factory method which return the right object since we could have multiple account types
     * @param accountType
     * @param id
     * @return
     */
    public Account accountFactory(String accountType, long id) {
        switch (accountType) {
            case "BASIC":
                return new BasicAccount(id);
        }

        throw new IllegalArgumentException("Type '"+ accountType + "' can't be resolved !");

    }

    public Account createAccount(String accountType, Long id) {

        if (!managedAccounts.containsKey(id)) {
            Account newAccount = accountFactory(accountType, id);
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
