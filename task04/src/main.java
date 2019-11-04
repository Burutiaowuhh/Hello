public class main {

//    deposit: 存款方法,参数是double型的金额,返回Account对象
//withdraw:取款方法,参数是double型的金额, 返回Account对象

    public static void main(String[] args) {


        Account account0 = new CreditAccount("456", "shan", "543", "poi", 5000, true);
        Account account1 = new SavingAccount("43456", "mao", "543", "poi", 30, false);
        Account account2 = new CreditAccount("43456", "shi", "543", "poi", 30, true);


        Bank bank = Bank.getBank();  //Bank单例模式
        Account[] accounts = bank.getAccounts();
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

        accounts[0] = account0;
        accounts[1] = account1;
        accounts[2] = account2;

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
//        CreditAccount a=bank.getCa();
//        System.out.println(a);
        bank.loanMoney(100001, 1000);
        bank.loanMoney(100002, 2000);
        bank.loanMoney(100003, 3000);
//        bank.payloan(100001,3000);
        bank.totalloan();


//        System.out.println(accounts[0]);
//        System.out.println(accounts[1]);
//        System.out.println(accounts[2]);
    }

}
