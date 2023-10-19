package interviewproblems.morganstanley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A company is repainting its office – HackerRank Solution
 * https://copyassignment.com/a-company-is-repainting-its-office-hackerrank-solution/
 *Subarrays with a sum less than or equal to 7 are
 *
 * Length 1 – [2], [3], [5], [1], [1], [2], [1 ]
 * Length 2 – [2, 3], [5, 1], [1, 1], [1, 2], [2, 1]
 * Length 3 – [5, 1, 1], [1, 1, 2], [1,2,1]
 * Length 4 – [1, 1, 2, 1]
 *
 * [1, 1, 2, 1] is the largest subarray with a sum less than or equal to 7 and has a length of 4.
 */
public class DesignOffice {
    public static int maxPaints(int[] arr,int money) {
        int l=0,r=0,len=arr.length,cost=0,count=0,res=Integer.MIN_VALUE;
        while(l<len && len-l>res){
            r=l;
            cost=0;
            count=0;
            while(r<len && cost<=money){
                count++;
                cost += arr[r++];
            }
            res = Math.max(res,count);
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,5,1,1,2,1};
        int result = maxPaints(arr,7);
        System.out.println("Test Case 1: "+result);

    }
}
