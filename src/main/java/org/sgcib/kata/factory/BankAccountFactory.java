package org.sgcib.kata.factory;

import org.sgcib.kata.entity.Account;
import org.sgcib.kata.entity.BasicAccount;

public class BankAccountFactory {

    private static BankAccountFactory factory;

    public static BankAccountFactory getInstance() {
        if(factory == null) {
            factory = new BankAccountFactory();
        }

        return factory;
    }

    /**
     * Factory method which return the right object
     * @param accountType
     * @param id
     * @return
     */
    public Account getAccount(String accountType, long id) {
        switch (accountType) {
            case "BASIC":
                return new BasicAccount(id);
        }

        throw new IllegalArgumentException("Type '"+ accountType + "' can't be resolved !");

    }

}
