package service;

import Excepton.BalanceNotEnoughException;
import Excepton.LoginException;
import Excepton.RegisterException;
import model.Account;
import model.CreditAccount;
import model.SavingAccount;
import model.Userbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {

    private List<Account> list = new ArrayList<Account>();


    //单例模式
    private Bank() {
    }

    private static Bank bank = new Bank();

    public static Bank getBank() {
        return bank;
    }

    public List<Account> getList() {
        return list;
    }

    public void setList(List<Account> list) {
        this.list = list;
    }

    //    :id,密码(2),姓名,身份证号码,邮箱,账户类型
    public Account register(String password, String name, String personId, String email, boolean accounttpye) throws RegisterException {
        if (accounttpye == true) {
            Account account = new CreditAccount();
            account.setEmail(email);
            account.setName(name);
            account.setPassword(password);
            account.setPersonId(personId);
            account.setAccountType(accounttpye);
            list.add(account);
            System.out.println(account);
        } else {
            Account account = new SavingAccount();
            account.setEmail(email);
            account.setName(name);
            account.setPassword(password);
            account.setPersonId(personId);
            account.setAccountType(accounttpye);
            list.add(account);
            System.out.println(account);
//            throw new RegisterException("iii");
        }
        return null;
    }

//    2.用户登录(login)
//    参数:id,密码
//            返回Account对象

    public Account login(long id, String password) throws LoginException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                if (list.get(i).getPassword().equals(password)) {
                    System.out.println(list.get(i));
                    return list.get(i);
                } else {
                    System.out.println("账户或密码错误");
                    throw new LoginException("账户或密码错误");
                }
            }
        }
        return null;
    }

    //3.用户存款(deposit)
//    参数:id,存款数额
//            返回修改过的Account对象

    public Account deposit(long id, double balance) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.get(i).deposit(balance);
                System.out.println(list.get(i));
                return list.get(i);
            }
        }
        return null;
    }

    //4.用户取款(withdraw)
//    参数:id,取款数额
//            返回修改过的Account对象
    public Account withdraw(long id, double money) throws BalanceNotEnoughException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                if (list.get(i).getBalance() < money) {
                    throw new BalanceNotEnoughException("余额不足");
                } else {
                    list.get(i).withdraw(money);
                    System.out.println(list.get(i));
                    return list.get(i);
                }
            }
        }

        return null;
    }

    //    //5.设置透支额度()
//    参数:id,新的额度
//  返回修改过的Account对象.(这个方法需要验证账户是否是信用账户)

    public Account over(long id, double overmoney) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                if (list.get(i).isAccountType() == true) {
                    CreditAccount ca = new CreditAccount();
                    ca.setId(list.get(i).getId());
                    ca.setName(list.get(i).getName());
                    ca.setBalance(list.get(i).getBalance());
                    ca.setPassword(list.get(i).getPassword());
                    ca.setEmail(list.get(i).getEmail());
                    ca.setPersonId(list.get(i).getPersonId());
                    ca.setAccountType(list.get(i).isAccountType());
                    ca.setCeiling(overmoney);
                    list.set(i, ca);
                    System.out.println(list.get(i));
                    return list.get(i);
                } else {
                    System.out.println("不好意思，你的信用额度不够");
                }
            }
        }
        return null;
    }

    //6.转账功能transfer(long from, long to, double money)
//    参数：from转出账户，to转入账户，money要转账的金额
//    返回值：boolean
//    业务说明：转出账户的余额一定要大于等于将要转账的金额，不能使用信用额度转账即信用卡不能转账，
//    避免套现的情况发生。
    public boolean transfer(long from, long to, double money) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == from) {
                if (list.get(i).getBalance() >= money) {
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).getId() == to) {
                            list.get(i).withdraw(money);
                            list.get(j).deposit(money);
                            System.out.println(list.get(i));
                            System.out.println(list.get(j));
                            return true;
                        }
                    }
                } else {
                    System.out.println("对不起，账户余额不足");
                }
            }
        }
        return false;
    }

    //账户余额统计
    public double totalbalance() {
        double totalbalance = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                System.out.println(totalbalance);
                return totalbalance;
            } else {
                totalbalance = list.get(i).getBalance() + totalbalance;
            }
        }
        System.out.println(totalbalance);
        return totalbalance;
    }

    public double totalceiling() {
        double totalCeiling = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                if (list.get(i).isAccountType() == true) {
                    CreditAccount creditAccount;
                    creditAccount = (CreditAccount) list.get(i);
                    totalCeiling = creditAccount.getCeiling() + totalCeiling;
                    System.out.println(totalCeiling);
                    return totalCeiling;
                } else {
                    System.out.println(totalCeiling);
                    return totalCeiling;
                }

            } else {
                if (list.get(i).isAccountType() == true) {
                    CreditAccount creditAccount;
                    creditAccount = (CreditAccount) list.get(i);
                    totalCeiling = creditAccount.getCeiling() + totalCeiling;
                }
            }
        }
        return -1;
    }

    //    贷  款: 参数 id,贷款额,返回修改过的Account对象
    public Account loanMoney(long id, double loanmoney) throws LoginException {
        if (loanmoney < 0) {
            throw new LoginException("贷款值不能为负数");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == id) {
                    list.get(i).setLoanMoney(loanmoney);
                    System.out.println(list.get(i));
                    return list.get(i);
                }
            }
        }
        return null;
    }

    //    还贷款: 参数 id,还款额,返回修改过的Account对象
    public Account payloan(long id, double payloanmoney) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                if (list.get(i).getBalance() < payloanmoney) {
                    System.out.println("余额不足");
                    break;
                } else {
                    double cha = list.get(i).getLoanMoney() - payloanmoney;
                    if (cha >= 0) {
                        list.get(i).setLoanMoney(cha);
                        list.get(i).setBalance(list.get(i).getBalance() - payloanmoney);
                        System.out.println(list.get(i));
                        return list.get(i);
                    } else {
                        list.get(i).setLoanMoney(0);
                        list.get(i).setBalance(list.get(i).getBalance() - payloanmoney - cha);
                        System.out.println(list.get(i));
                        return list.get(i);
                    }

                }
            }
        }
        return null;
    }

    //统计所有账户贷款的总数
    public double totalloan() {
        double totalloanM = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                totalloanM = totalloanM + list.get(i).getLoanMoney();
                System.out.println(totalloanM);
                return totalloanM;
            } else {
                totalloanM = totalloanM + list.get(i).getLoanMoney();
//                continue;
            }
        }
        return -1;
    }

    //打印所有用户的总资产排名
    public void totalbalanceRank() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();   //map(1,"身份证号码")
        HashMap<String, Double> map1 = new HashMap<>();                  //map1("身份证号码"，资产)
        Userbalance userbalance = new Userbalance();
        for (int i = 0; i < list.size(); i++) {
            map.put(i, list.get(i).getPersonId());           //map(1,"身份证号码")
            for (int k = 0; k < i; k++) {
                if (map.get(i) == map.get(k)) {
                    map.remove(i);
                } else {

                }
            }

            for (int j = list.size() - 1; j > i; j--) {
                if (map.get(i) == list.get(j).getPersonId()) {  //如果找到两个身份证号相同
                    String personId = list.get(i).getPersonId();//获取当前身份证号
                    if (map1.get(personId) == null) {          //如果当前身份证资产没有记录
                        double a = list.get(i).getBalance() + list.get(j).getBalance();
                        map1.put(personId, a);
                    } else {                                   //如果当前身份证资产记录过了
                        double b = map1.get(personId) + list.get(j).getBalance();
                        map1.put(personId, b);                 //覆盖之前身份证资产记录
                    }
                }
            }
        }
    }
}
