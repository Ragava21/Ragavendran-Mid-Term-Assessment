package org.example.service;

import org.example.dao.BankAccountDao;
import org.example.dto.BankAccount;

import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {

    BankAccountDao bankAccountDao = new org.example.dao.BankAccountImpl();

    @Override
    public boolean addBankAccount(BankAccount bankAccount) {
        bankAccountDao.addBankAccount(bankAccount);
        return true;
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        bankAccountDao.updateBankAccount(bankAccount);


    }

    @Override
    public BankAccount getBankAccount(int id) {
        bankAccountDao.getBankAccount(id);
        return bankAccountDao.getBankAccount(id);
    }

    @Override
    public void deleteBankAccount(int id) {
        bankAccountDao.deleteBankAccount(id);

    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        List<BankAccount>l=bankAccountDao.getAllBankAccounts();

        return l;
    }

    @Override
    public List< BankAccount> getBankAccountByAccountName(String custname) {
        return bankAccountDao.getBankAccountByAccountName(custname);

    }

    @Override
    public List<Object[]> displayBankAccountGroupBy() {
        List<Object[]>l=bankAccountDao.displayBankAccountGroupBy();
        return l;
    }

    @Override
    public List<BankAccount> getBankAccountByBranch(int code) {
        List<BankAccount>l=bankAccountDao.getBankAccountByBranch(code);
        return l;
    }
}



