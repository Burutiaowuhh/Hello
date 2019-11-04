package model;

import model.Account;

public class SavingAccount extends Account {

    public SavingAccount() {
        super();
    }

    public SavingAccount(String password, String name, String personId, String email, double balance, boolean accountType) {
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

}
