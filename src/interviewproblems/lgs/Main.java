package interviewproblems.lgs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {


        List<List<Integer>> listOfLists = new ArrayList<>();
        // Create inner lists and add them to the outer list
        List<Integer> innerList1 = new ArrayList<>();
        innerList1.add(20);
        innerList1.add(22);
        listOfLists.add(innerList1);

        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(4);
        innerList2.add(5);
        listOfLists.add(innerList2);

        List<Integer> innerList3 = new ArrayList<>();
        innerList3.add(6);
        innerList3.add(7);
        listOfLists.add(innerList3);

        System.out.println("Min Max From Coordinate List: ");
        System.out.println(Arrays.toString(minMaxFromListofCoordinates(listOfLists)));



        /*
        System.out.println("closestToZero!: ");
        System.out.println(closestToZero(asList()));
        System.out.println(closestToZero(Arrays.asList(new Double[]{7.0, -10.0, 13.0, 8.0, 4.0, -7.2, -12.0, -3.7, 3.5, -9.6, 6.5, -1.7, -6.2, 7.0})));
        System.out.println(closestToZero(Arrays.asList(new Double[]{5.0, 6.0, 7.0, 9.0 , 2.0, - 2.0})));
        */


        /*
        System.out.println("addExclamationMark!: ");
        System.out.println(
                addExclamationMark("Je suis Asif. Je suis Asif et toi!!! Comment Ca va! Ca va Bein!! Test Input.!"));
        */
    }

    /*
        Min Max From Coordinate List
        I:
                List<List<Integer>> listOfLists = new ArrayList<>();
        // Create inner lists and add them to the outer list
        List<Integer> innerList1 = new ArrayList<>();
        innerList1.add(20);
        innerList1.add(22);
        listOfLists.add(innerList1);

        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(4);
        innerList2.add(5);
        listOfLists.add(innerList2);

        List<Integer> innerList3 = new ArrayList<>();
        innerList3.add(6);
        innerList3.add(7);
        listOfLists.add(innerList3);

        System.out.println("Min Max From Coordinate List: ");
        System.out.println(Arrays.toString(minMaxFromListofCoordinates(listOfLists)));

        O:[4, 20, 5, 22]
     */
    public static int[] minMaxFromListofCoordinates(List<List<Integer>> listOfCoordinates) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (List<Integer> coordinates : listOfCoordinates) {
            if (minX > coordinates.get(0)) minX = coordinates.get(0);
            if (maxX < coordinates.get(0)) maxX = coordinates.get(0);
            if (minY > coordinates.get(1)) minY = coordinates.get(1);
            if (maxY < coordinates.get(1)) maxY = coordinates.get(1);
            /*
            for(int n:coordinates){
                System.out.println(n);
            }
            */
        }
        return new int[]{minX, maxX, minY, maxY};
    }

    /*
        find the closest value to zero from a collection of numbers
        If ts is empty, return 0 (zero). If two numbers are as close to zero, consider the positive number as the closest to zero (eg. if ts contains -5 and 5, return 5).
        I:closestToZero(Arrays.asList(new Double[]{7.0, -10.0, 13.0, 8.0, 4.0, -7.2, -12.0, -3.7, 3.5, -9.6, 6.5, -1.7, -6.2, 7.0}))
        O:-1.7
        I:closestToZero(Arrays.asList(new Double[]{5.0, 6.0, 7.0, 9.0 , 2.0, - 2.0}))
        O:2.0
     */
    public static double closestToZero(List<Double> list) {
        if (list.isEmpty()) return 0;
        Double min = 0.0;
        for (Double num : list) {
            if (min == 0.0) min = num;
            else if (Math.abs(min) == Math.abs(num) && num > 0) min = num;
            else if (Math.abs(min) > Math.abs(num)) min = num;
        }
        return min;
    }

    /*
        Add ! In group of ! + add ! Instead of .
        Input: "Je suis Asif. Je suis Asif et toi!!! Comment Ca va! Ca va Bein!! Test Input.!"
        Output: "Je suis Asif! Je suis Asif et toi!!!! Comment Ca va!! Ca va Bein!!! Test Input!!!"
    */
    public static String addExclamationMark(String str) {
        String result = "";
        int len = str.length(), i = 0;
        while (i < len) {
            if (str.charAt(i) == '.') {
                result += "!";
                i++;
            }
            if (str.charAt(i) == '!') {
                result += "!";
                result += str.charAt(i);
                i++;
            }
            while (i < len && str.charAt(i) == '!') {
                result += str.charAt(i);
                i++;
            }
            if (i < len) result += str.charAt(i);
            i++;
        }
        return result;
    }


}
