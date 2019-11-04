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

//    @Override
//    public void withdraw(double m) {
//        return super.withdraw(m);
//    }


    @Override
    public String toString() {
        return "CreditAccount{" +
                "ceiling=" + ceiling +
                '}';
    }

    @Override
    public void withdraw(double m) {
        super.withdraw(m);
    }
}
