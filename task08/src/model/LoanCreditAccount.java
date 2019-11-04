package model;

import service.Loanable;

public class LoanCreditAccount extends CreditAccount implements Loanable {

<<<<<<< HEAD
    private boolean overdraw = true;
    private double overdrawCount;


=======
    private boolean overdraw=true;
    private double overdrawCount;



>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
    public boolean isOverdraw() {
        return overdraw;
    }

    public void setOverdraw(boolean overdraw) {
        this.overdraw = overdraw;
    }

    public double getOverdrawCount() {
        return overdrawCount;
    }

    public void setOverdrawCount(double overdrawCount) {
        this.overdrawCount = overdrawCount;
    }

    @Override
    public String toString() {
        return "model.LoanCreditAccount{" +
                "overdraw=" + overdraw +
                ", overdrawCount=" + overdrawCount +
                '}';
    }

    @Override
    public double requestLoan(double money) {
        return money;
    }

    @Override
    public void payLoan(double money) {
<<<<<<< HEAD
        setBalance(getBalance() - money);
        setLoanMoney(getLoanMoney() - money);
=======
        setBalance(getBalance()-money);
        setLoanMoney(getLoanMoney()-money);
>>>>>>> 1d839758c064bd0339102d3081928eceb4779d1c
    }

    @Override
    public double getLoan() {
        return 5000;
    }


}
