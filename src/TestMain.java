import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
    /*
    1,3,9,0,4,5,0,5,6,3,0,9
        1,3,9,4,5,0,0,5,6,3,0,9
        1,3,9,4,5,5,0,0,6,3,0,9
     */
        List<Integer> list = Arrays.asList(1,3,9,0,4,5,0,5,6,3,0,9);
        int l=0,r=0;
        while(l<list.size() && r<list.size()){
            if(list.get(l) == 0){
                r =l+1;
                while(r<list.size() && list.get(r) == 0) r++;
                while(r<list.size() && list.get(r) != 0){
                    int temp = list.get(l);
                    list.set(l,list.get(r));
                    list.set(r, temp);
                    r++;
                    l++;
                }
            }
            else{
                l++;
            }
        }



        System.out.println(list);
    }
}




//class Employee {
//
//    private String name;
//
//    public Employee(String name) { // constructor
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee[ name=" + name + "] ";
//    }
//
//}


//public class Program1 {
//    public static void main(String...a){
//
//        HashMap<Employee, String> hm=new HashMap<Employee, String>();
//        hm.put(new Employee("a"), "emp1");
//        hm.put(new Employee("b"), "emp2");
//        hm.put(new Employee("a"), "emp1 OVERRIDDEN");
//
//        System.out.println("HashMap's data> "+hm);
//        System.out.println("HashMap's size> "+hm.size());
//        System.out.println(hm.get(new Employee("a")));
//
//    }
//}
//has context menu
//a:emp1 OVERRIDDEN, b:emp2
//2
//emp1 OVERRIDDEN
//
//
//class MyThread extends Thread {
//    MyThread() {
//        System.out.print("1 ");
//    }
//    public void run() {
//        System.out.print("2 ");
//    }
//}
//public class MyClass {
//    public static void main(String[] args) {
//        Thread thread1 = new MyThread() {
//            public void run() {
//                System.out.print("3 ");
//            }
//        };
//        thread1.start();
//    }
//}
//
///////
//
//
//class Employee
//{
//    int id;
//
//    String name;
//
//    int age;
//
//    String gender;
//
//    String department;
//
//    int yearOfJoining;
//
//    double salary;
//    // 1, "ASif", 20, "male",
//    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary)
//    {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.department = department;
//        this.yearOfJoining = yearOfJoining;
//        this.salary = salary;
//    }
//
//    public int getId()
//    {
//        return id;
//    }
//
//    public String getName()
//    {
//        return name;
//    }
//
//    public int getAge()
//    {
//        return age;
//    }
//
//    public String getGender()
//    {
//        return gender;
//    }
//
//    public String getDepartment()
//    {
//        return department;
//    }
//
//    public int getYearOfJoining()
//    {
//        return yearOfJoining;
//    }
//
//    public double getSalary()
//    {
//        return salary;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "Id : "+id
//                +", Name : "+name
//                +", age : "+age
//                +", Gender : "+gender
//                +", Department : "+department
//                +", Year Of Joining : "+yearOfJoining
//                +", Salary : "+salary;
//    }
//}

