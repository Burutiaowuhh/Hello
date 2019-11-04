public abstract class Account {
    static long pid = 100000;
    private long id;
    private String password;
    private String name;
    private String personId;
    private String email;
    private double balance;
    private boolean AccountType;


    public Account(String password, String name, String personId, String email, double balance, boolean accountType) {
        id = ++pid;     //静态，让id每次加1
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
        id = ++pid;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", personId='" + personId + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", AccountType=" + AccountType +
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


    public final void deposit(double m) {
        this.balance = balance + m;
    }

    public abstract void withdraw(double m);
}
