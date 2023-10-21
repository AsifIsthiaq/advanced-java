package lamda;
// if we import this then we don't need to declare explicitly the FI individually
//import java.util.function.Function;

import lamda.helping.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * In Java, Function, Consumer, and Supplier
 * are functional interfaces provided by the java.util.function package.
 * They are used to represent different types of operations that can be performed using lambda expressions.
 * <p>
 * Function is a functional interface that represents a function that takes one argument and produces a result.
 * It has one abstract method named apply.
 * <p>
 * Consumer is a functional interface that represents an operation that takes a single input argument and returns no result.
 * It has one abstract method named accept.
 * <p>
 * Supplier is a functional interface that represents a supplier of results.
 * It has one abstract method named get and does not take any arguments.
 */

@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
}
@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}
@FunctionalInterface
interface Supplier<T> {
    T get();
}

public class PreDefined {
    static <T,R> R calculateArea(T n, Function<T,R> calArea){
        return calArea.apply(n);
    }

    static <T> T getRandomValues(Supplier<T> randFunc){
        return randFunc.get();
    }
    public static void main(String[] args) {
        // Functional
        /*
        Suppose you want to calculate the area of a geometric shape, and you have different functions for each shape.
         */
        Function<Integer, Double> calSquareArea = a -> (double)a * a;
        Function<Double, Double> calCircleArea = r -> Math.PI * r * r;
        System.out.println("Square Area: "+ calculateArea(5,calSquareArea));
        System.out.println("Circle Area: "+ calculateArea(3.00,calCircleArea));
        // Consumer
        System.out.println();
        List<BankAccount> bankAccounts = new ArrayList<BankAccount>(){{
            add(new BankAccount("1",1000.00));
            add(new BankAccount("2",2000.00));
            add(new BankAccount("3",3000.00));
        }};
        Consumer<BankAccount> deductFee = account -> account.applyMaintenanceFee(150.50);
        for (BankAccount bankAccount : bankAccounts) deductFee.accept(bankAccount);
        bankAccounts.forEach(bankAccount -> deductFee.accept(bankAccount));
        bankAccounts.forEach(deductFee::accept);
        bankAccounts.forEach(System.out::println);
        // Supplier
        System.out.println();
        Supplier<Integer> randFunc = () -> new Random().nextInt(100);
        Supplier<Boolean> randFunc2 = () -> new Random().nextBoolean();
        System.out.println("Random Number: "+ getRandomValues(randFunc));
        System.out.println("Random Bool: "+ getRandomValues(randFunc2));
    }

}
