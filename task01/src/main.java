public class main {

//    deposit: 存款方法,参数是double型的金额,返回Account对象
//withdraw:取款方法,参数是double型的金额, 返回Account对象

    public static void main(String[] args) {

        Account account = new Account(1, "456", "shan", "543", "poi", 50, true);
        Account account1 = new Account(12, "43456", "mao", "543", "poi", 30, false);

        Bank bank = new Bank();
        Account[] accounts = bank.getAccounts();
//        int i=accounts.length;
//        accounts[i]=account;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[0] == null) {
                accounts[0] = account;
            } else if (accounts[i] == null) {
                accounts[i] = account1;
                break;
            } else {
                continue;
            }
//            if(accounts[i].getName()==null){
//                accounts[i]=account;
//            }
        }

//        bank.register(12,"123","mao","124","asdad",true);
//        bank.login(1,"456");
//        System.out.println(account);
//        bank.login(1,"456");
//        bank.deposit(1,30);
//        bank.withdraw(1,10);
//        bank.over(1,10);
        bank.transfer(1, 12, 5);
    }

}
