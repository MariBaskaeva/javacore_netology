public class Main {
    public static void main(String[] args) {
        Account savingsAccount = new SavingsAccount(200);
        Account checkingAccount = new CheckingAccount(1100);
        Account creditAccount = new CreditAccount();

        savingsAccount.addMoney(100);
        checkingAccount.pay(400);
        savingsAccount.transfer(checkingAccount, 400);

        System.out.println();

        creditAccount.addMoney(100);
        creditAccount.pay(1000);
        creditAccount.transfer(savingsAccount, 500);
        creditAccount.addMoney(1200);
    }
}