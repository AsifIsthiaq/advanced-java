package optional;

import java.util.Optional;

public class Person {
    private Optional<SmartPhone> smartPhone;

    public Person(){
        this.smartPhone = Optional.empty();
    }

    public Person(SmartPhone smartPhone) {
        this.smartPhone = Optional.ofNullable(smartPhone);
    }
    public Person(Optional<SmartPhone> smartPhone) {
        this.smartPhone = smartPhone;
    }

    public Optional<SmartPhone> getSmartPhone() {
        return smartPhone;
    }

    public void setSmartPhone(Optional<SmartPhone> smartPhone) {
        this.smartPhone = smartPhone;
    }
}
