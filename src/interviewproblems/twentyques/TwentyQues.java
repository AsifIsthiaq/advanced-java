package interviewproblems.twentyques;

import java.util.*;
class A{
    @Override
    public int hashCode() {
        return 1;
    }
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
public class TwentyQues {
    public static void main(String[] args) {

        /*
        A a1 = new A();
        A a2 = new A();
        Map<A,String> hashMap = new HashMap<>();
        hashMap.put(a1,"a1");
        hashMap.put(a2,"a2");
        System.out.println(hashMap.get(a1));
         */

        /*
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("From Runnable");
            }
        };
        Thread t = new Thread(r){
            @Override
            public void run() {
                System.out.println("From Thread");
            }
        };
        t.start();
      */

        /*
        Set<Integer> treeSet  = new TreeSet<>();
        treeSet.add(20);
        treeSet.add(10);
        System.out.println("treeSet: "+treeSet);
        Set<Integer> hashSet  = new HashSet<>();
        hashSet.add(20);
        hashSet.add(10);
        System.out.println("hashSet: "+hashSet);
        Set<Integer> linkedHashSet  = new LinkedHashSet<>();
        linkedHashSet.add(20);
        linkedHashSet.add(10);
        System.out.println("linkedHashSet: "+linkedHashSet);
         */

        /*
        boolean b = true;
        if(b = false) System.out.println("A");
        else if(b) System.out.println("B");
        else System.out.println("C");
         */
    }
}
