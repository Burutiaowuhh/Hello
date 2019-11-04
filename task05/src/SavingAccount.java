public class SavingAccount extends Account {

    public SavingAccount() {
        super();
    }

    public SavingAccount(String password, String name, String personId, String email, double balance, boolean accountType) {
        super(password, name, personId, email, balance, accountType);
    }

    @Override
    public void withdraw(double m) {
        setBalance(getBalance() - m);
    }

}
