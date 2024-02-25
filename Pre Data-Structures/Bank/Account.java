import java.util.ArrayList;

class Account {
    private long accountNumber;
    private String customerName;
    private double balance;

    public Account(long accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    public boolean deposit(double depositAmount) {
        if (depositAmount > 0) {
            balance += depositAmount;
            return true;
        }
        return false;
    }

   public boolean withdraw(double amount) {
    if (amount <= 0 || amount > balance) {
        return false;
    }
        balance -= amount;
    return true;
}

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getCustomerName() {
        return customerName;
    }
}
