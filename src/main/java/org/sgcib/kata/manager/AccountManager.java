package org.sgcib.kata.manager;

import org.sgcib.kata.entity.Account;
import org.sgcib.kata.entity.BasicAccount;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountManager {

    private static AccountManager instance;

    private Map<Long, Account> managedAccounts;

    private AccountManager() {
        this.managedAccounts = new HashMap<>();
    }

    public static AccountManager getInstance() {

        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }

    public Map<Long, Account> getManagedAccounts() {
        return managedAccounts;
    }

    public Account createAccount(Long id) {

        if (!managedAccounts.containsKey(id)) {
            Account newAccount = new BasicAccount(id);
            managedAccounts.put(id, newAccount);
            return newAccount;
        }
        return managedAccounts.get(id);

    }

    public List<Long> listAccounts() {
        return new ArrayList<>(getManagedAccounts()
                .keySet());
    }
}
