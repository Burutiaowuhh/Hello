import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bank {
    private Account[] accounts = new Account[100];
    List list = new ArrayList();
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


//    1.用户开户(register)
//    参数:id,密码(2),姓名,身份证号码,邮箱,账户类型；
//    返回新创建的Account对象
//2.用户登录(login)
//    参数:id,密码
//            返回Account对象
//3.用户存款(deposit)
//    参数:id,存款数额
//            返回修改过的Account对象
//4.用户取款(withdraw)
//    参数:id,取款数额
//            返回修改过的Account对象
//5.设置透支额度()
//    参数:id,新的额度
//  返回修改过的Account对象.(这个方法需要验证账户是否是信用账户)

    public Account register(long id, String password, String name, String personId, String email, boolean accounttpye) {

        Account account = new Account();
        account.setId(id);
        account.setEmail(email);
        account.setName(name);
        account.setPassword(password);
        account.setPersonId(personId);
        account.setAccountType(accounttpye);
//        int i=accounts.length;
//        accounts[i]=account;
        accounts[0] = account;
        System.out.println(account);
        return account;
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

    @Override
    public String toString() {
        return "Bank{" +
                "accounts=" + Arrays.toString(accounts) +
                ", UserAccount=" + UserAccount +
                '}';
    }

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


    public int jisuan() {
        int i = 1 + 1;
        return i;
    }

    public Account over(long id, double overmoney) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].getId() == id) {
                if (accounts[i].isAccountType() == true) {
//                    CreditAccount ca=new Account();
                    CreditAccount ca = new CreditAccount();
                    ca.setId(accounts[i].getId());
                    ca.setName(accounts[i].getName());
                    ca.setPassword(accounts[i].getPassword());
                    ca.setPersonId(accounts[i].getPersonId());
                    ca.setEmail(accounts[i].getEmail());
                    ca.setBalance(accounts[i].getBalance());
                    ca.setAccountType(accounts[i].isAccountType());
                    ca.setCeiling(overmoney);
                    System.out.println(ca);
                    return ca;
                } else {
                    System.out.println("账户信用额度过低");
                }
            }
        }
        return null;
    }


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
}
