package model;

import java.io.Serializable;

<<<<<<< HEAD
public abstract class Account implements Serializable {
    static long pid = 100000;
=======
public abstract class Account implements Serializable{
    static long pid=100000;
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
    private long id;
    private String password;
    private String name;
    private String personId;
    private String email;
    private double balance;
    private boolean AccountType;
    private double loanMoney;


<<<<<<< HEAD
    public Account(String password, String name, String personId, String email, double balance, boolean accountType) {
        id = ++pid;     //静态，让id每次加1
=======

    public Account(String password, String name, String personId, String email, double balance, boolean accountType) {
        id=++pid;     //静态，让id每次加1
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
        this.password = password;
        this.name = name;
        this.personId = personId;
        this.email = email;
        this.balance = balance;
        AccountType = accountType;
    }

    public boolean isAccountType() {

        return AccountType;
    }

    public void setAccountType(boolean accountType) {
        AccountType = accountType;
    }

    public Account() {
<<<<<<< HEAD
        id = ++pid;
=======
        id=++pid;
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
    }


    @Override
    public String toString() {
        return "model.Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", personId='" + personId + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", AccountType=" + AccountType +
                ", loanMoney=" + loanMoney +
                '}';
    }

    public static long getPid() {
        return pid;
    }

    public static void setPid(long pid) {
        Account.pid = pid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPersonId(String personId) {
        this.personId = personId;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(double loanMoney) {
        this.loanMoney = loanMoney;
    }

<<<<<<< HEAD
    public final void deposit(double m) {
        this.balance = balance + m;
=======
    public final void deposit(double m){
        this.balance=balance+m;
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
    }

    public abstract void withdraw(double m);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != account.id) return false;
        if (Double.compare(account.balance, balance) != 0) return false;
        if (AccountType != account.AccountType) return false;
        if (Double.compare(account.loanMoney, loanMoney) != 0) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (personId != null ? !personId.equals(account.personId) : account.personId != null) return false;
        return email != null ? email.equals(account.email) : account.email == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (AccountType ? 1 : 0);
        temp = Double.doubleToLongBits(loanMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
