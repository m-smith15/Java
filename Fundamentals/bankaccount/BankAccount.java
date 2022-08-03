public class BankAccount {
    private int accountNum;
    private int checkingAccount;
    private double checkingAccountBalance;
    private int savingsAccount;
    private double savingsAccountBalance;
    private double total;
    public static int numberOfAccounts = 0;
    public static double totalMoney = 0;


    //constructor
    public BankAccount(int accountNum){
        this.accountNum = accountNum;
        numberOfAccounts++;
    }
//class methods
//deposit check
    public void depositCheck(String account, double amount){
        if(account == "checking"){
            this.checkingAccountBalance += amount;
            totalMoney += amount;
        }
        else if(account == "savings"){
            this.savingsAccountBalance += amount;
            totalMoney += amount;
        }
        else{
            System.out.println("Please specify if this will be deposited to checking or savings account");
        }
    }

    public void withdrawMoney(String account, double amount){
        if(account == "checking"){
            if(this.checkingAccountBalance - amount > 0){
            this.checkingAccountBalance -= amount;
            totalMoney -= amount;
            }
            else{
                System.out.println("You have " + checkingAccountBalance + " please do not withdraw more than that");
            }
        }
        else if(account == "savings"){
            if(this.savingsAccountBalance - amount > 0){
                this.savingsAccountBalance -= amount;
                totalMoney -= amount;
                }
                else{
                    System.out.println("You have " + savingsAccountBalance + " please do not withdraw more than that");
                }
            }
    }



//getters and setters
    //Account num
    public int getAccountNum(){
        return accountNum;
    }
    public void setAccountNum(int accountNumber){
        this.accountNum = accountNumber;
    }

    //checking acct
    public int getCheckingAcct(){
        return checkingAccount;
    }
    public void setCheckingAcct(int checkingAcct){
        this.checkingAccount = checkingAcct;
    }
    //balance
    public double getCheckingAcctBalance(){
        return checkingAccountBalance;
    }
    public void setCheckingAcctBal(double checkingAcctBal){
        this.checkingAccountBalance += checkingAcctBal;
    }

    //savings acct
    public double getSavingsAcct(){
        return savingsAccount;
    }
    public void setSavingsAcct(int savingsAcct){
        this.savingsAccount += savingsAcct;
    }
    //balance
    public double getSavingsAcctBalance(){
        return savingsAccountBalance;
    }
    public void setSavingsAcctBal(double savingsAcctBal){
        this.savingsAccountBalance = savingsAcctBal;
    }

    //total amt
    public double getTotol(){
        this.total = getSavingsAcctBalance() + getCheckingAcctBalance();
        return total;
    }
}

