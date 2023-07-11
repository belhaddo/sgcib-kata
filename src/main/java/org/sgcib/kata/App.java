package org.sgcib.kata;

import org.sgcib.kata.entity.Account;
import org.sgcib.kata.manager.AccountManager;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AccountManager am = AccountManager.getInstance();
        Account acc1 = am.createAccount("BASIC", 1L);
        Account acc2 = am.createAccount("BASIC", 2L);
        System.out.println("Available Accounts : " + am.listAccounts());

        acc1.deposit(BigDecimal.TEN);
        acc1.deposit(BigDecimal.TEN);
        acc1.withdraw(BigDecimal.ONE);

        System.out.println(acc1.printStatementsHistory());


        acc2.deposit(BigDecimal.ONE);
        acc2.withdraw(BigDecimal.TEN);
    }
}
