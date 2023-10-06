package optional;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        EWallet eWallet = new EWallet("12345678");
        EWallet ew = new EWallet();
        EWallet eWalletNull = null;
        Optional<SmartPhone> smartPhone = Optional.of(new SmartPhone(eWallet));
        Optional<SmartPhone> smartPhoneWithNullEwallet = Optional.of(new SmartPhone(eWalletNull));
        Optional<SmartPhone> smartPhoneWithNoac = Optional.of(new SmartPhone(ew));
        Person p = new Person(); //need to initialize empty constructor for optional initiallization
        Person p1 = new Person(new SmartPhone()); //need to initialize empty constructor for optional initiallization
        Person completePerson = new Person(smartPhone);
        Person personWithSpNoEW = new Person(smartPhoneWithNullEwallet);
        Person personWithNoAccountNumber = new Person(smartPhoneWithNoac); //need to initialize empty constructor for optional initiallization

//        Optional<Person> person = Optional.of(new Person(smartPhone));
//        Optional<Person> personWithNullSp = Optional.of(new Person(smartPhoneWithNullEwallet));
        System.out.println(getEWalletAccountNumber(p));
        System.out.println(getEWalletAccountNumber(p1));
        System.out.println(getEWalletAccountNumber(null));

        System.out.println(getEWalletAccountNumber(personWithSpNoEW));
        System.out.println(getEWalletAccountNumber(completePerson));
        System.out.println(getEWalletAccountNumber(personWithNoAccountNumber));

        /*
        Expected Output
        --
        ==
        No Smart Phone
        --
        ==
        Has Smart Phone But No EWallet
        --
        No person
        --
        ==
        Has Smart Phone But No EWallet
        --
        ==
        12345678
        --
        ==
        Has SmartPhone & EWallet But No Account Number
         */
        System.out.println("----------flatmap---------------");
        System.out.println(getEWalletAccountNumberUsingFlatMap(p));
        System.out.println(getEWalletAccountNumberUsingFlatMap(p1));
        System.out.println(getEWalletAccountNumberUsingFlatMap(null));

        System.out.println(getEWalletAccountNumberUsingFlatMap(personWithSpNoEW));
        System.out.println(getEWalletAccountNumberUsingFlatMap(completePerson));
        System.out.println(getEWalletAccountNumberUsingFlatMap(personWithNoAccountNumber));
    }

    public static String getEWalletAccountNumberUsingFlatMap(Person person){
        // we use map to convert one data type to another
        // here we could use map but will will return Optional<Optional<String>> which results in more code
        // so we need to use flatmap so it will return Optional<String>
//        return Optional.ofNullable(person)
//                .flatMap(p -> p.getSmartPhone())
//                .flatMap(sp -> sp.geteWallet())
//                .flatMap(ew -> ew.getAccountNumber())
//                .orElse("Unable to get Account Number"); // here orElse is retriving the value from optional if the value is not present then it returns the default value.
        return Optional.ofNullable(person)
                .flatMap(Person::getSmartPhone)
                .flatMap(SmartPhone::geteWallet)
                .flatMap(EWallet::getAccountNumber)
                .orElse("Unable to get Account Number");
    }

    public static String getEWalletAccountNumber(Person person){
        System.out.println("--");
        Optional<Person> op = Optional.ofNullable(person);
        if(!op.isPresent()) return "No person";
//        op.ifPresent(p -> System.out.println("value present using ifpresent"));
//
//        if(op.isPresent()){
//            System.out.println("Value Persent");
//        }
//        else {
//            System.out.println("Value not present");
//        }

        System.out.println("==");
        // avabe if else sara amr r account number porjonto jauar sujog nai tai map or flatmap use korte hobe nested optional extract korar jonno
        Optional<SmartPhone> sp = op.get().getSmartPhone();
        if(sp.isPresent()){
            Optional<EWallet> ew = sp.get().geteWallet();
            if(ew.isPresent()){
                Optional<String> ac = ew.get().getAccountNumber();
                String accountNumber = ac.orElse("Has SmartPhone & EWallet But No Account Number");
                return accountNumber;
            }
            return "Has Smart Phone But No EWallet";
        }
        return "No Smart Phone";
        // return person.getSmartPhone().ifPresent().orElse("Something went Null");
        //return person.getSmartPhone().geteWallet().getAccountNumber();
    }
}