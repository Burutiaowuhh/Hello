public class main {

//    deposit: 存款方法,参数是double型的金额,返回Account对象
//withdraw:取款方法,参数是double型的金额, 返回Account对象

    public static void main(String[] args) {

        Account account0 = new Account(1, "456", "shan", "543", "poi", 50, true);
        Account account1 = new Account(2, "43456", "mao", "543", "poi", 30, false);
        Account account2 = new Account(3, "43456", "shi", "543", "poi", 30, true);

        Bank bank = new Bank();
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

//        bank.register(2,"123","mao","124","asdad",true);
//        bank.login(1,"456");
//        System.out.println(account);
//        bank.login(1,"456");
//        bank.deposit(1,30);
//        bank.withdraw(1,10);
        bank.over(1, 3000);
        bank.over(3, 5000);
//        bank.transfer(1,12,5);
//        System.out.println(accounts[2]);
//        double a=bank.totalbalance();
        double b = bank.totalceiling();
        System.out.println(b);
//        CreditAccount a=bank.getCa();
//        System.out.println(a);
    }

}
