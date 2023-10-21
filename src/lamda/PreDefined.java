package lamda;
// if we import this then we don't need to declare explicitly the FI individually
//import java.util.function.Function;

import lamda.helping.BankAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * In Java, Function, Consumer, and Supplier
 * are functional interfaces provided by the java.util.function package.
 * They are used to represent different types of operations that can be performed using lambda expressions.
 * <p>
 * Function is a functional interface that represents a function that takes one argument and produces a result.
 * It has one abstract method named apply.
 * <p>
 * BiFunction is a functional interface that represents a function that takes two arguments and produces a result.
 * It has one abstract method named apply.
 * <p>
 * Consumer is a functional interface that represents an operation that takes a single input argument and returns no result.
 * It has one abstract method named accept.
 * <p>
 * BiConsumer is a functional interface that represents an operation that takes two arguments and returns no result.
 * It has one abstract method named accept.
 * <p>
 * Supplier is a functional interface that represents a supplier of results.
 * It has one abstract method named get and does not take any arguments.
 * <p>
 * Predicate is a functional interface that represents a condition that returns a boolean result.
 * It has one abstract method named test.
 * <p>
 * UnaryOperator takes one argument and produces a result of the same type.
 * BinaryOperator takes two arguments of the same type and produces a result of the same type.
 */

@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
}

@FunctionalInterface
interface BiFunction<T, U, R> {
    R apply(T t, U u);
}

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}

@FunctionalInterface
interface BiConsumer<T, U> {
    void accept(T t, U u);
}

@FunctionalInterface
interface Supplier<T> {
    T get();
}

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

public class PreDefined {
    static <T, R> R calculateArea(T n, Function<T, R> calArea) {
        return calArea.apply(n);
    }

    static <T, U, R> R findMid(T l, U r, BiFunction<T, U, R> find) {
        return find.apply(l, r);
    }

    static <T> T getRandomValues(Supplier<T> randFunc) {
        return randFunc.get();
    }

    public static void main(String[] args) {
        // Functional
        /*
        Suppose you want to calculate the area of a geometric shape, and you have different functions for each shape.
         */
        Function<Integer, Double> calSquareArea = a -> (double) a * a;
        Function<Double, Double> calCircleArea = r -> Math.PI * r * r;
        System.out.println("Square Area: " + calculateArea(5, calSquareArea));
        System.out.println("Circle Area: " + calculateArea(3.00, calCircleArea));
        // BiFunction
        System.out.println();
        BiFunction<Integer, Double, Double> find = (l, r) -> l + (r - l) / 2;
        System.out.println("Mid: " + findMid(1, 6.0, find));
        // Consumer
        System.out.println();
        BankAccount bc1 = new BankAccount("1", 1000.00);
        BankAccount bc2 = new BankAccount("2", 44000.00);
        List<BankAccount> bankAccounts = new ArrayList<BankAccount>() {{
            add(bc1);
            add(bc2);
            add(new BankAccount("2", 2000.00));
            add(new BankAccount("3", 3000.00));
        }};
        Consumer<BankAccount> deductFee = account -> account.applyMaintenanceFee(150.50);
        for (BankAccount bankAccount : bankAccounts) deductFee.accept(bankAccount);
        bankAccounts.forEach(bankAccount -> deductFee.accept(bankAccount));
        bankAccounts.forEach(deductFee::accept);
        bankAccounts.forEach(System.out::println);
        // BiConsumer
        System.out.println();
        // BiConsumer<BankAccount, Double> transferMoney = (dest, amount) -> bc2.transferFundsTo(dest, amount);
        BiConsumer<BankAccount, Double> transferMoney = bc2::transferFundsTo;
        transferMoney.accept(bc1,40000.00);
        System.out.println(bc1);
        System.out.println(bc2);
        // Supplier
        System.out.println();
        Supplier<Integer> randFunc = () -> new Random().nextInt(100);
        Supplier<Boolean> randFunc2 = () -> new Random().nextBoolean();
        System.out.println("Random Number: " + getRandomValues(randFunc));
        System.out.println("Random Bool: " + getRandomValues(randFunc2));
        // predicate
        System.out.println();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        Predicate<Integer> isOdd = (n) -> n % 2 == 1;
        List<Integer> evenNumbers = numbers.stream().filter(isEven::test).collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream().filter(n -> isOdd.test(n)).collect(Collectors.toList());
        evenNumbers.forEach(System.out::println);
        oddNumbers.forEach(System.out::println);
    }

}
