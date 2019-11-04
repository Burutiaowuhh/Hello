package Test;

import Excepton.ATMException;
import Excepton.BalanceNotEnoughException;
import Excepton.LoginException;
import model.Account;
import model.CreditAccount;
import model.SavingAccount;
import service.Bank;

import java.util.List;

public class test {

//    deposit: 存款方法,参数是double型的金额,返回Account对象
//withdraw:取款方法,参数是double型的金额, 返回Account对象

    public static void main(String[] args) throws ATMException {


        Account account0 = new CreditAccount("456", "shan", "321201", "poi", 5000, true);
        Account account1 = new SavingAccount("43456", "mao", "321101", "poi", 30, false);
        Account account2 = new CreditAccount("43456", "shi", "321201", "poi", 30, true);


//        BankPre bank1 = BankPre.getBank();  //Bank单例模式
//        model.Account[] accounts= bank1.getAccounts();
//        int i=accounts.length;
//        accounts[i]=account;
//        for (int i=0;i<accounts.length;i++){
//            if(accounts[0]==null){
//                accounts[0]=account;
//            }else if(accounts[i]==null){
//                String a= account+"i";
//                accounts[i]=account1;
//                break;
//            }else {
//                continue;
//            }

//            accounts[0]=account0;
//            accounts[1]=account1;
//            accounts[2]=account2;

//        }

//        bank.register("123","wu","124","asdad",true);
//        bank.login(1,"456");
//        System.out.println(account);
//        bank.login(1,"456");
//        bank.deposit(1,30);
//        bank.withdraw(100001,10);
//        bank.over(1,3000);
//        bank.over(3,5000);
//        bank.transfer(1,12,5);
//        System.out.println(accounts[2]);
//        double a=bank.totalbalance();
//        double b=bank.totalceiling();
//        System.out.println(b);
//        model.CreditAccount a=bank.getCa();
//        System.out.println(a);
//        bank1.loanMoney(100001,1000);
//        bank1.loanMoney(100002,2000);
//        bank1.loanMoney(100003,3000);
//        bank.payloan(100001,3000);
//        bank1.totalloan();


//        System.out.println(accounts[0]);
//        System.out.println(accounts[1]);
//        System.out.println(accounts[2]);

        Bank bank = Bank.getBank();
        List list = bank.getList();
        list.add(account0);
        list.add(account1);
        list.add(account2);
//        bank.register("456", "shan", "543", "poi", true);
        bank.login(100001, "456");
//        bank.deposit(100001,1000);
        bank.withdraw(100001, 9000);
//        bank.over(100001,300);
//        bank.over(100003,200);
//        System.out.println(list);
//        bank.transfer(100001,100002,200);
//        bank.totalbalance();
//        bank.totalceiling();
        bank.loanMoney(100001, -1);
//        bank.totalloan();
//        HashMap<Integer,String> map=new HashMap<>();
//        map.put(1,"2");
//        String a=map.get(1);
//        String b=map.get(2);
//        System.out.println("a="+a+"  b="+b);
    }

}
