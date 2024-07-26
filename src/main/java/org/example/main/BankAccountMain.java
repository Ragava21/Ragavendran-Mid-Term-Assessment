package org.example.main;

import org.example.dto.BankAccount;
import org.example.service.BankAccountService;
import org.example.service.BankAccountServiceImpl;

import java.util.List;
import java.util.Scanner;

public class BankAccountMain {
   public static  BankAccountService bankAccountService=new BankAccountServiceImpl();
    public static void main(String[] args) {
        System.out.println("Choose one of the options:");
        System.out.println("1. Add BankAccount");
        System.out.println("2. Display all BankAccounts");
        System.out.println("3. Display a single account with id");
        System.out.println("4. Update bankAccount");
        System.out.println("5. Delete bankAccount");
        System.out.println("6. Display a single account with name");
        System.out.println("7. Display all actnum,custname,city grouped by ");
        System.out.println("8. Display a account whrere branchcode");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
            {
                System.out.println("Enter the bakaccount details:");
                System.out.println("Enter banknum ");
                BankAccount bankAccount = new BankAccount(91900,"rey",600000,"thanjavur",89002);
                BankAccount bankAccount1 = new BankAccount(914399,"keeks",90000,"chennai",6002);
                boolean status =bankAccountService.addBankAccount(bankAccount);
                boolean status1=bankAccountService.addBankAccount(bankAccount1);
                if (status) System.out.println("added bankaccount successfully");
                else System.out.println("failed to add bankaccount");

                break;

            }
            case 2:{
                List<BankAccount> l=bankAccountService.getAllBankAccounts();
                for (BankAccount bankAccount : l) {
                    System.out.println(bankAccount);

                }
                break;

            }
            case 3:{
                int id=sc.nextInt();
               BankAccount bankAccount=bankAccountService.getBankAccount(id);
               System.out.println(bankAccount);
               break;
            }
            case 4:{
                System.out.println("Select the fields that you want to change:");
                System.out.println("1. Update actnum");
                System.out.println("2. Update custname");
                System.out.println("3. Update city");
                System.out.println("4. Update branchcode");
                System.out.println("5. Update accountbalance");

                int c = sc.nextInt();
                System.out.println("Enter account number:");
                int id=sc.nextInt();

                BankAccount bankAccount=bankAccountService.getBankAccount(id);
                //System.out.println(bankAccount);
                switch (c){
                    case 1:{
                        System.out.println("actnum");
                        int actnum=sc.nextInt();
                        bankAccount.setActNumber(actnum);
                        break;
                    }
                    case 2:{
                        System.out.println("custname");
                        String custname=sc.next();
                        bankAccount.setCustName(custname);
                        break;
                    }
                    case 3:{
                        System.out.println("city");
                        System.out.println("enter city");
                        String city=sc.next();
                        bankAccount.setCity(city);
                        break;
                    }
                    case 4:{
                        System.out.println("branchcode");
                        int branchcode=sc.nextInt();
                        bankAccount.setBranchCode(branchcode);
                        break;

                    }
                    case 5:{
                        System.out.println("accountbalance");
                        int accountbalance=sc.nextInt();
                        bankAccount.setAccountBalance(accountbalance);
                        break;
                    }


                }
                bankAccountService.updateBankAccount(bankAccount);
                break;

            }

            case 5:{
                int id=sc.nextInt();
                bankAccountService.deleteBankAccount(id);
                break;
            }
            case 6:{
                System.out.println("enter the custname");
                sc.nextLine();
                String name=sc.nextLine();
                List<BankAccount> bankAccount=bankAccountService.getBankAccountByAccountName(name);
                System.out.println(bankAccount);
                break;
            }
            case 7:{
              List<Object[]> l=bankAccountService.displayBankAccountGroupBy();
              for (Object[] objects : l) {
                  System.out.println(objects[0]+" "+objects[1]);
              }
              break;
            }
            case 8:{
                System.out.println("Enter the branch code");
                int code=sc.nextInt();
                List<BankAccount>l=bankAccountService.getBankAccountByBranch(code);
                for (BankAccount bankAccount : l) {
                    System.out.println(bankAccount);
                }
                break;
            }
        }
    }
}
