package optional;

import java.util.Optional;

public class EWallet {
    private Optional<String> accountNumber;

    public EWallet(){
        this.accountNumber = Optional.empty();
    }
    public EWallet(String accountNumber) {
        this.accountNumber = Optional.ofNullable(accountNumber);
    }

    public Optional<String> getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Optional<String> accountNumber) {
        this.accountNumber = accountNumber;
    }
}
