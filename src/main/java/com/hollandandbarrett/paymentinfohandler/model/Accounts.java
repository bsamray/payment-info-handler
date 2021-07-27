package com.hollandandbarrett.paymentinfohandler.model;

import java.util.ArrayList;
import java.util.List;

public class Accounts {

    private List<Account> accountList;

    public Accounts() {
        this.accountList = new ArrayList<>();
    }

    public Accounts(List<Account> accounts) {
        this.accountList = accounts;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}