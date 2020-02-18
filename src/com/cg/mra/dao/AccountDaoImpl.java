package com.cg.mra.dao;

import com.cg.mra.entities.Account;

import java.util.HashMap;
import java.util.Map;


public class AccountDaoImpl implements AccountDao {

    private Map<String, Account> accountEntry;

    protected Map<String, Account> getAccountEntry() {
        return accountEntry;
    }
    public AccountDaoImpl()
    {
        accountEntry = new HashMap<>();
        Account account1 = new Account("prepaid", "Ramesh", 200);
        accountEntry.put("1234567890", account1);
        Account account2 = new Account("prepaid", "Suresh", 450);
        accountEntry.put("2345678901", account2);
        Account account3 = new Account("prepaid", "Mahesh", 631);
        accountEntry.put("3456789012", account3);
        /*Account account4 = new Account("prepaid", "ajay", 521);
        accountEntry.put("7799379839", account4);
        Account account5 = new Account("prepaid", "dinesh", 632);
        accountEntry.put("6305221137", account5);*/

    }
    public Account getAccount(final String mobileNo)
    {
        return getAccountEntry().get(mobileNo);
    }
    /**
     *  fetches account details
     *
     * @param mobileNo
     * @return Account related to mobileno
     */
    @Override
    public Account getAccountDetails(final String mobileNo)
    {
        validationCheck(mobileNo);
        Account account = getAccount(mobileNo);
        return account;
    }

    /**
     *  method which will throw exception if number is NOT Found
     *  Done separately so we can reuse it
     *
     * @param mobileNo
     */
    public void validationCheck(final String mobileNo) 
    {
        boolean noExists = getAccountEntry().containsKey(mobileNo);
        if (!noExists) {
            throw new AccountNotFoundException("No Account found for this number=" + mobileNo);
        }

    }

    /**
     * We can return the balance after recharge in double but in the question integer is used so
     * using integer for total balance
     *
     */
    @Override
    public int rechargeAccount(final String mobileNo, final double rechargeAmount) {
        validationCheck(mobileNo);
        Account account = getAccount(mobileNo);
        double initialBalance = account.getAccountBalance();
        double balanceNow = initialBalance + rechargeAmount;
        return (int) balanceNow;
    }


}
