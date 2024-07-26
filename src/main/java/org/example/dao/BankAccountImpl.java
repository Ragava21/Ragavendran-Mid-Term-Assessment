package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.example.config.Util1;
import org.example.dto.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccountImpl implements BankAccountDao{
    @Override
    public boolean addBankAccount(BankAccount bankAccount) {
        EntityManager em= Util1.createEntityManager();
        em.getTransaction().begin();
        em.persist(bankAccount);
        em.getTransaction().commit();
        System.out.println("bankaccount added....");
        return true;
    }

    @Override
    public void updateBankAccount(BankAccount bankAccount) {
        EntityManager em =Util1.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();
        em.merge(bankAccount);
        et.commit();

    }

    @Override
    public BankAccount getBankAccount(int id) {
        EntityManager em =Util1.createEntityManager();
        em.getTransaction().begin();
        BankAccount bankAccount=null;
        bankAccount=em.find(BankAccount.class, id);
        return bankAccount;
    }

    @Override
    public void deleteBankAccount(int id) {
        EntityManager em =Util1.createEntityManager();
      EntityTransaction et=em.getTransaction();
       et.begin();
        BankAccount bankAccount=em.find(BankAccount.class, id);
        em.remove(bankAccount);
        et.commit();

    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        EntityManager em =Util1.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();
        Query q=em.createQuery("select c from BankAccount AS c");
        List<BankAccount> l=q.getResultList();
        return l;

    }

    @Override
    public List<BankAccount>getBankAccountByAccountName(String custName) {
        EntityManager em =Util1.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();
       Query q = em.createQuery("SELECT e from BankAccount AS e WHERE e.custName = :name");
        q.setParameter("name",custName);
        List<BankAccount> bankAccountList = q.getResultList();
        return bankAccountList;
    }


    @Override
    public List<Object[]> displayBankAccountGroupBy() {
    EntityManager em =Util1.createEntityManager();
        return  em.createQuery("select c.city,c.branchCode from BankAccount as c GROUP BY c.city,c.branchCode").getResultList();

    }

    @Override
    public List<BankAccount> getBankAccountByBranch(int code) {
        EntityManager em =Util1.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT e from BankAccount AS e WHERE e.branchCode = :branchcode");
        q.setParameter("branchcode",code);
        List<BankAccount> bankAccountList = q.getResultList();
        return bankAccountList;
    }

}
