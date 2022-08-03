public class BankAccountTest {

    public static void main(String[] args) {

        BankAccount shrimpton = new BankAccount(12345);
        System.out.println(shrimpton.getAccountNum());
        System.out.println(BankAccount.numberOfAccounts); // 1

        shrimpton.depositCheck("checking", 10);
        System.out.println(shrimpton.getCheckingAcctBalance()); // 10
        System.out.println(BankAccount.totalMoney); // 10

        shrimpton.depositCheck("savings", 11.1);
        System.out.println(shrimpton.getSavingsAcctBalance()); // 11.1
        System.out.println(BankAccount.totalMoney); //21.1

        shrimpton.depositCheck("shrimp account", 300); //else statement

        shrimpton.withdrawMoney("checking", 100); //else - not enoug in checking

        shrimpton.withdrawMoney("savings", 6.1); //should be fine
        System.out.println(BankAccount.totalMoney); // 21.1 - 6.1 = 15.0

        System.out.println(shrimpton.getSavingsAcctBalance()); //5
        System.out.println(shrimpton.getCheckingAcctBalance()); //10
        System.out.println(shrimpton.getTotol()); // 15.0
    }
}
