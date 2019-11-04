package model;

import service.Loanable;

public class LoanCreditAccount extends CreditAccount implements Loanable {

    private boolean overdraw = true;
    private double overdrawCount;


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
        setBalance(getBalance() - money);
        setLoanMoney(getLoanMoney() - money);
    }

    @Override
    public double getLoan() {
        return 5000;
    }


}
