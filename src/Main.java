import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Employee {

    private String name;

    public Employee(String name) { // constructor
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee[ name=" + name + "] ";
    }

}

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        HashMap<Employee, String> hm=new HashMap<Employee, String>();
        hm.put(new Employee("a"), "emp1");
        hm.put(new Employee("b"), "emp2");
        hm.put(new Employee("a"), "emp1 OVERRIDDEN");

        System.out.println("HashMap's data> "+hm);
        System.out.println("HashMap's size> "+hm.size());
        System.out.println(hm.get(new Employee("a")));
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }
        //12#1713217998001#75#VQ
        //2###RS
//        System.out.println(getTypeAndDbid("12#1713217998001#75#VQ"));
//        System.out.println(getTypeAndDbid("2###RS"));

    }

    static Map<String, String> getTypeAndDbid(String str){
        String[] splitedStr = str.split("#");
        System.out.println(Arrays.toString(splitedStr));
        if(splitedStr.length == 4){
            String dbid = splitedStr[3].equals("RS") ? splitedStr[0]:splitedStr[2];
            return new HashMap<>(){{
                put("type",splitedStr[3]);
                put("dbid",dbid);
            }};
        }
        return null;
    }
}