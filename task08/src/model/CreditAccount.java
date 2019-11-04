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
<<<<<<< HEAD
        return super.toString() + "   model.CreditAccount{" +
                "ceiling=" + ceiling +
                '}';
=======
       return super.toString()+"   model.CreditAccount{" +
               "ceiling=" + ceiling +
               '}';
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
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
<<<<<<< HEAD
        setBalance(getBalance() - m);
=======
        setBalance(getBalance()-m);
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
    }

//    @Override
//    public void withdraw(double m) {
//        super.withdraw(m);
//    }

}
