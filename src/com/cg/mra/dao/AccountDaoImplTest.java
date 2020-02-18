package com.cg.mra.dao;

import com.cg.mra.entities.Account;

import org.junit.Assert;
import org.junit.Test;
public class AccountDaoImplTest 
{
    AccountDaoImpl dao =new AccountDaoImpl();
    /**
     * test uses
     * 1) mobile no=1234567890
     * 2) recharge Amount =15
     * expected result=637
     */
    @Test
    public void testRechargeAccount_1() 
    {
        String mobileNo = "1234567890";
        Account accountBefore=dao.getAccount(mobileNo);
        System.out.println("account="+accountBefore.getAccountBalance());
        int result = dao.rechargeAccount(mobileNo, 15);
        int expectedResult = 215;
        Assert.assertEquals(expectedResult, result);
        //
        //restoring old state
        //
        dao.rechargeAccount(mobileNo,-15);
    }
    /**
     * test uses
     * 1) mobile no=1234567890
     * 2) recharge Amount =15
     * expected result=637
     */
    /*@Test
    public void testRechargeAccount_2() 
    {
        String mobileNo = "2345678901";
        int result = dao.rechargeAccount(mobileNo, 10);
        int expectedResult = 460;
        Assert.assertEquals(expectedResult, result);
        //
        //restoring old state
        //
        dao.rechargeAccount(mobileNo,-10);

    }
*/
    }
