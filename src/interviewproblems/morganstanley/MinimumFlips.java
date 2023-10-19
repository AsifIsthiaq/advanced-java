package interviewproblems.morganstanley;

/**
 * Input: S = “01011”
 * Output: 3
 * Explanation:
 * Initial String – “00000”
 * Flip the 2nd bit – “01111”
 * Flip the 3rd bit – “01000”
 * Flip the 4th bit – “01011”
 * Total Flips = 3
 * Input: S = “01001”
 * Output: 3
 * Explanation:
 * Initial String – “00000”
 * Flip the 2nd bit – “01111”
 * Flip the 3rd bit – “01000”
 * Flip the 5th bit – “01001”
 * Total Flips = 3
 *
 *
 *
 */
public class MinimumFlips {
    public static int minFlips(String target)
    {
        char curr = '1';
        int count = 0;
        for(char ch:target.toCharArray()){
            if(ch==curr){
                count++;
                curr = curr == '1' ? '0':'1';
            }

        }
        return count;
    }

    public static void main(String args[])
    {

        String S = "01001";
        System.out.println(minFlips(S));
    }
}
