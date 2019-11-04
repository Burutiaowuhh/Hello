package model;

import model.Account;

public class CreditAccount extends Account {
    private double ceiling;

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }

    public CreditAccount() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + "   model.CreditAccount{" +
                "ceiling=" + ceiling +
                '}';
//        return "model.CreditAccount{}";
    }


//    @Override
//    public void withdraw(double m) {
//        return super.withdraw(m);
//    }


    public CreditAccount(String password, String name, String personId, String email, double balance, boolean accountType) {
        super(password, name, personId, email, balance, accountType);
    }

    @Override
    public void withdraw(double m) {
        setBalance(getBalance() - m);
    }

//    @Override
//    public void withdraw(double m) {
//        super.withdraw(m);
//    }

}
