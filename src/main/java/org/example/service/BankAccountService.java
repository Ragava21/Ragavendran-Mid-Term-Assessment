package org.example.service;

import org.example.dto.BankAccount;

import java.util.List;

public interface BankAccountService {
    public abstract boolean addBankAccount(BankAccount bankAccount);
    public abstract void updateBankAccount(BankAccount bankAccount);
    public abstract BankAccount getBankAccount(int id);
    public abstract void deleteBankAccount(int id);
    public abstract List<BankAccount> getAllBankAccounts();
    public abstract List< BankAccount> getBankAccountByAccountName(String custname);
    public abstract  List<Object[]> displayBankAccountGroupBy();
    public abstract List<BankAccount> getBankAccountByBranch(int code);
}
