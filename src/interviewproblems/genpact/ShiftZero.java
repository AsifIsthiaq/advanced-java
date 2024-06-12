package interviewproblems.genpact;

import java.util.Arrays;
import java.util.List;
// shift zero at the end maintaining order
public class ShiftZero {
    public static void main(String[] args) {
        int[] arr = {1,3,9,0,4,5,0,5,6,3,0,9};
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
