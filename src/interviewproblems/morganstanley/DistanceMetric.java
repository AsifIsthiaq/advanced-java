package interviewproblems.morganstanley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Distance Metric
 * For each element in a given array, calculate the absolute value of Index differences between it and all other elements of the same value. Return the resulting values in an array. For example, if the array elements at indices 2 and 3 are equal, the distance metric for element 2 is |2-3| = 1. For element 3 it is |3-2|=1.
 * Example:
 * n=6 arr = [1, 2, 1, 1, 2, 3].
 * The element arr[0]= 1. Similar elements are at indices 2 and 3.
 * The distance metric for arr[0]= |0-2| +|0-3|=5
 * Result: [5,3,3,4,3,0]
 */
public class DistanceMetric {
    public static List<Long> getDistanceMetrics(List<Integer> arr) {
        List<Long> dMetric = new ArrayList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.size();i++){
            int key = arr.get(i);
            if(!map.containsKey(key)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key,list);
            }
            else map.get(key).add(i);
        }
        System.out.println(map);
        for(int i=0;i<arr.size();i++){
            long dis = 0;
            ArrayList<Integer> list = map.get(arr.get(i));
            for(int idx:list){
                if(i==idx) continue;
                dis += Math.abs(i-idx);
            }
            dMetric.add(dis);
        }
        return dMetric;
    }
//    public static List<Long> getDistanceMetricsN2(List<Integer> arr) {
//        List<Long> dMetric = new ArrayList<Long>();
//        for(int i=0;i<arr.size();i++){
//            long dis = 0;
//            for(int j=0;j<arr.size();j++){
//                if(i==j) continue;
//                if(arr.get(i) == arr.get(j)){
//                    dis += (long)Math.abs(i-j);
//                }
//            }
//            dMetric.add(dis);
//        }
//        return dMetric;
//    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(1);
            add(1);
            add(2);
            add(3);
        }};
        List<Long> result = getDistanceMetrics(arr);
        System.out.println("Test Case 1: ");
        result.forEach(System.out::println);
    }
}
