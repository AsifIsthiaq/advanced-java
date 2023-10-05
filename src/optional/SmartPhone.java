package optional;

import java.util.Optional;

public class SmartPhone {
    private Optional<EWallet> eWallet;

    public SmartPhone(){
        this.eWallet = Optional.empty();
    }
    public SmartPhone(EWallet eWallet) {
        this.eWallet = Optional.ofNullable(eWallet);
    }

    public Optional<EWallet> geteWallet() {
        return eWallet;
    }

    public void seteWallet(Optional<EWallet> eWallet) {
        this.eWallet = eWallet;
    }
}
