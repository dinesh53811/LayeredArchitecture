package com.cg.mra.dao;

import com.cg.mra.entities.Account;

public interface AccountDao 
{

    Account getAccountDetails(String mobileNo);

    int rechargeAccount(String mobileNo,double rechargeAmount);
}
