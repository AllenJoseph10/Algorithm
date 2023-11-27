public class BankAccount {
    public String clientName;
    public int clientID;
    public double accountBalance;
    public boolean closed;

    public BankAccount(String clientName, int clientID, double accountBalance) {
        this.clientName = clientName;
        this.clientID = clientID;
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return this.clientName;
    }

    public int getID() {
        return this.clientID;
    }

    public double getBalance() {
        return this.accountBalance;
    }

    public boolean getClosed() {
        return this.closed;
    }

    public void deposit(double depositAmount) {
        accountBalance = accountBalance + depositAmount;
    }

    public void withdraw(double withdrawalAmount) {
        accountBalance = accountBalance - withdrawalAmount;
    }

    public void closeAccount() {
        accountBalance = 0;
        closed = true;
    }

    public void transferTo(BankAccount toAccount, double amount) {
        //implement this method
        withdraw(amount);
        toAccount.deposit(amount);
    }
}
