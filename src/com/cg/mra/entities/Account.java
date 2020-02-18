package com.cg.mra.entities;
public class Account//bean,dtop,vo,pojo,entity
{
    private String accountType;
    private double accountBalance;
    private String customerName;
    public String getAccountType(){
        return accountType;
    }
    public void setAccountType(final String accountType){
        this.accountType=accountType;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(final String customerName){
        this.customerName=customerName;
    }
    public double getAccountBalance(){
        return accountBalance;
    }
    public void setAccountBalance(final double balance){
        this.accountBalance=balance;
    }
    public Account(final String accountType,final String customerName,final double balance){
        this.accountType=accountType;
        this.customerName=customerName;
        this.accountBalance=balance;
    }
}
