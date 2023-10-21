package lamda.helping;
public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void applyMaintenanceFee(double fee) {
        balance -= fee;
    }

    @Override
    public String toString() {
        return "Account: " + accountNumber + ", Balance: $" + balance;
    }
}