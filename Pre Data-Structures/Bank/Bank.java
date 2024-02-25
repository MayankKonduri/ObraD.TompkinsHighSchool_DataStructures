import java.util.ArrayList;
public class Bank {
    private String bankName;
    private ArrayList<Account> accounts;

    public Bank(String name) {
        this.bankName = name;
        this.accounts = new ArrayList<>();
    }

    public boolean openAccount(long accountNumber, String customerName, double startingBalance) {
        if (startingBalance <= 0) {
            return false;
        }

        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return false;
            }
        }

        Account newAccount = new Account(accountNumber, customerName, startingBalance);
        accounts.add(newAccount);
        return true;
    }

    public double closeAccount(long accountNumber) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if (account.getAccountNumber() == accountNumber) {
                accounts.remove(i);
                return account.getBalance();
            }
        }
        return -1;
    }

    public void setName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return bankName;
    }

    public Account getAccount(long accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}