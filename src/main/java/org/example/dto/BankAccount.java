package org.example.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BankAccount {
  @Id
    private int actNumber;
   private String custName;
   private double accountBalance;
   private String city;
   private int branchCode;

    public BankAccount() {
    }

    public BankAccount(int actNumber, String custName, double accountBalance, String city, int branchCode) {
        this.actNumber = actNumber;
        this.custName = custName;
        this.accountBalance = accountBalance;
        this.city = city;
        this.branchCode = branchCode;
    }

    public int getActNumber() {
        return actNumber;
    }

    public void setActNumber(int actNumber) {
        this.actNumber = actNumber;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(int branchCode) {
        this.branchCode = branchCode;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "actNumber=" + actNumber +
                ", custName='" + custName + '\'' +
                ", accountBalance=" + accountBalance +
                ", city='" + city + '\'' +
                ", branchCode=" + branchCode +
                '}';
    }
}
