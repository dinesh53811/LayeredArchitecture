
package com.cg.mra.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.dao.AccountNotFoundException;
import com.cg.mra.dao.IncorrectMobileNoException;
import com.cg.mra.entities.Account;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUi
{
       public void showMenu() //5
       {
        System.out.println("Press 1 for Account Balance Enquiry");
        System.out.println("Press 2 for Recharge Account");
        System.out.println("Press 3 for exit");
    }
       public int getOption(Scanner scanner)//7
       {
           try {
               int option = scanner.nextInt();
               return option;
           } catch (Throwable e) {
               e.printStackTrace();
               return -1;
           }
       }
       private AccountService accountService = new AccountServiceImpl(new AccountDaoImpl());
       
       public AccountService getAccountService() {
           return accountService;
       }
       public void select()//3
       {
           boolean run = true;
           while (run) 
           {
               showMenu();//4
               Scanner scanner = new Scanner(System.in);
               int option = getOption(scanner);//6 1
               if (option == -1)
               {
                   run = false;
               }
               switch (option)//input=1, flow-8
               {
                   case 1: {
                       try {
                           System.out.println("Enter mobile no");
                           String mobileNo = scanner.next();//
                           AccountService service = getAccountService();//accountservice (I)
                           Account account = service.getAccountDetails(mobileNo);
                           System.out.println("Customer Name=" + account.getCustomerName());
                           System.out.println("Account Type=" + account.getAccountType());
                           System.out.println("Balance=" + account.getAccountBalance());
                           
                       } catch (AccountNotFoundException e) {
                           System.out.println("Mobile No does not exist");
                       } catch (IncorrectMobileNoException e) {
                           System.out.println("Mobile number is not a correct mobile number");
                       } catch (InputMismatchException e) {
                           System.out.println("sorry something went wrong");
                       }
                       break;
                   }
                   case 2: {
                       try {
                           System.out.println("Enter mobile no");
                           String mobileNo = scanner.next();
                           System.out.println("Enter recharge amount");
                           double rechargeAmount = scanner.nextDouble();
                           
                           AccountService service = getAccountService();
                           Account account = service.getAccountDetails(mobileNo);
                           int balanceNow = service.rechargeAccount(mobileNo, rechargeAmount);
                           System.out.println("Your Acccount Recharged successfully");
                           System.out.println("Hello   " + account.getCustomerName() + " Available Balance=" + balanceNow);
                       } catch (AccountNotFoundException e) {
                           e.printStackTrace();
                           System.out.println("Can not recharge as Mobile No does not exist");
                       } catch (IncorrectMobileNoException e) {
                           System.out.println("incorrect mobile number");
                       } catch (Throwable e) {
                           e.printStackTrace();
                           System.out.println("sorry something went wrong");
                       }
                       break;}
                   default: {
                       run = false;
                       System.out.println("Thank you for Using Application !");
                   }}}}
    public static void main(String[] args) {
        MainUi ui = new MainUi();//1
        ui.select();//2
    }
   
}