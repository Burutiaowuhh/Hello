public class BankPre {
    private Account[] accounts = new Account[100];
    private CreditAccount[] creditAccounts = new CreditAccount[100];
    private CreditAccount ca;


    //    单例三要素：
//    1.私有的构造方法；
//    2.指向自己实例的私有静态引用；
//    3.以自己实例为返回值的静态的公有方法。
    /*
    饿汉机制和懒汉机制：饿汉式单例在单例类被加载时候，就实例化一个对象并交给自己的引用；
                    而懒汉式单例只有在真正使用的时候才会实例化一个对象并交给自己的引用。
     */
    private BankPre() {
    }

    // 指向自己实例的私有静态引用，主动创建
    private static BankPre bank = new BankPre();

    // 以自己实例为返回值的静态的公有方法，静态工厂方法
    public static BankPre getBank() {
        return bank;
    }


    @Override
    public String toString() {
        return "BankPre{" +
                "ca=" + ca +
                '}';
    }


    public CreditAccount getCa() {
        return ca;
    }

    public void setCa(CreditAccount ca) {
        this.ca = ca;
    }

    private int UserAccount;

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public int getUserAccount() {
        return UserAccount;
    }

    public void setUserAccount(int userAccount) {
        UserAccount = userAccount;
    }


    public Account register(String password, String name, String personId, String email, boolean accounttpye) {

        if (accounttpye == true) {
            Account account = new CreditAccount();
            account.setEmail(email);
            account.setName(name);
            account.setPassword(password);
            account.setPersonId(personId);
            account.setAccountType(accounttpye);
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] == null) {   //如果用户不存在
                    accounts[i] = account;
                    System.out.println(accounts[i]);
                    return accounts[i];
                } else {
                    continue;
                }
            }
        } else {
            Account account = new SavingAccount();
            account.setEmail(email);
            account.setName(name);
            account.setPassword(password);
            account.setPersonId(personId);
            account.setAccountType(accounttpye);
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] == null) {   //如果用户不存在
                    accounts[i] = account;
                    System.out.println(accounts[i]);
                    return accounts[i];
                } else {
                    continue;
                }
            }
        }

        return null;
    }


    //2.用户登录(login)
//    参数:id,密码
//            返回Account对象
    public Account login(long id, String password) {

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == id) {
                if (accounts[i].getPassword().equals(password)) {
                    System.out.println(accounts[i]);
                    return accounts[i];
                }
            }
        }

        return null;
    }

    //3.用户存款(deposit)
//    参数:id,存款数额
//            返回修改过的Account对象

    public Account deposit(long id, double balance) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == id) {
                accounts[i].deposit(balance);
                System.out.println(accounts[i]);
                return accounts[i];
            }
        }
        return null;
    }

    //4.用户取款(withdraw)
//    参数:id,取款数额
//            返回修改过的Account对象
    public Account withdraw(long id, double money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == id) {
                accounts[i].withdraw(money);
                System.out.println(accounts[i]);
                return accounts[i];
            }
        }
        return null;
    }


    //5.设置透支额度()
//    参数:id,新的额度
//  返回修改过的Account对象.(这个方法需要验证账户是否是信用账户)
    public Account over(long id, double overmoney) {
        for (int i = 0; i < accounts.length; i++) {

            if (accounts[i] == null) {          //判断用户是否存在
                System.out.println("没有此用户");
                return null;
            } else if (accounts[i].getId() == id) {    //如果用户存在
                if (accounts[i].isAccountType() == true) {   //判断用户是否为信用用户
//                    CreditAccount ca=new Account();
                    ca = new CreditAccount();
                    ca.setId(accounts[i].getId());
                    ca.setName(accounts[i].getName());
                    ca.setPassword(accounts[i].getPassword());
                    ca.setPersonId(accounts[i].getPersonId());
                    ca.setEmail(accounts[i].getEmail());
                    ca.setBalance(accounts[i].getBalance());
                    ca.setAccountType(accounts[i].isAccountType());
                    ca.setCeiling(overmoney);
                    for (int j = 0; j < creditAccounts.length; j++) {
                        if (creditAccounts[j] == null) {
                            creditAccounts[j] = ca;
                            break;
                        } else {
                            continue;
                        }
                    }
                    System.out.println(ca);
                    return ca;
                } else {          //不是信用用户
                    System.out.println("账户信用额度过低");
                    return null;
                }
            } else if (accounts != null && accounts[i].getId() != id) {
                continue;
            } else {
                System.out.println("???");
                return null;
            }
        }
        return null;
    }

    //6.转账功能transfer(long from, long to, double money)
//    参数：from转出账户，to转入账户，money要转账的金额
//    返回值：boolean
    public boolean transfer(long from, long to, double money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == from) {
                if (accounts[i].getBalance() >= money) {
                    for (int j = 0; j < accounts.length; j++) {
                        if (accounts[j].getId() == to) {
                            accounts[i].withdraw(money);
                            accounts[j].deposit(money);
                            System.out.println("from的余额" + accounts[i].getBalance());
                            System.out.println("to的余额" + accounts[j].getBalance());
                            return true;
                        }
                    }
                } else {
                    System.out.println("对不起，账户余额不足！");
                }
            }
        }
        return false;
    }


    //账户余额统计
    public double totalbalance() {
        double totalbalance = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                return totalbalance;
            } else {
                totalbalance = accounts[i].getBalance() + totalbalance;
            }
        }
        return -1;
    }

    //    2.统计所有信用账户透支额度总数
    public double totalceiling() {
        double totalceiling = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                return totalceiling;
            } else {
                if (accounts[i].isAccountType() == true) {
                    for (int j = 0; j < creditAccounts.length; j++) {
                        if (creditAccounts[j] == null) {
                            break;
                        } else if (accounts[i].getId() == creditAccounts[j].getId()) {
                            totalceiling = totalceiling + creditAccounts[j].getCeiling();
                            break;
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return -1;
    }

    //    贷  款: 参数 id,贷款额,返回修改过的Account对象
    public Account loanMoney(long id, double loanmoney) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == id) {
                accounts[i].setLoanMoney(loanmoney);
                System.out.println(accounts[i]);
                return accounts[i];
            }
        }
        return null;
    }

    //    还贷款: 参数 id,还款额,返回修改过的Account对象
    public Account payloan(long id, double payloanmoney) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == id) {
                if (accounts[i].getBalance() < payloanmoney) {
                    System.out.println("余额不足");
                    break;
                } else {
                    double cha = accounts[i].getLoanMoney() - payloanmoney;
                    if (cha >= 0) {
                        accounts[i].setLoanMoney(cha);
                        accounts[i].setBalance(accounts[i].getBalance() - payloanmoney);
                        System.out.println(accounts[i]);
                        return accounts[i];
                    } else {
                        accounts[i].setLoanMoney(0);
                        accounts[i].setBalance(accounts[i].getBalance() - payloanmoney - cha);
                        System.out.println(accounts[i]);
                        return accounts[i];
                    }

                }
            }
        }
        return null;
    }

    //统计所有账户贷款的总数
    public double totalloan() {
        double totalloanM = 0;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                System.out.println(totalloanM);
                return totalloanM;
            } else {
                totalloanM = totalloanM + accounts[i].getLoanMoney();
                continue;
            }

        }
        return -1;
    }
}
