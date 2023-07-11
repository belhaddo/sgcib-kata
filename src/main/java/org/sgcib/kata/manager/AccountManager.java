package org.sgcib.kata.manager;

import org.sgcib.kata.entity.Account;

import java.util.*;

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
