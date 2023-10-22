package interviewproblems.morganstanley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * by adding removing or changing only one character
 * in one string check if matching two string is possible or not
 */

public class StringMatching {

    public static boolean isSingleEditAway(String str1, String str2) {
        if(str1==null || str2==null) return false;
        str1 = str1.trim().toLowerCase();
        str2 = str2.trim().toLowerCase();
        if(Math.abs(str1.length()-str2.length()) > 1) return false;
        // handle same length
        if(str1.length() == str2.length()){
            int i=0, misMatchCount=0;
            while(i<str1.length()){
                if(str1.charAt(i) != str2.charAt(i)) misMatchCount++;
                if(misMatchCount > 1) return false;
                i++;
            }
            return true;
        }
        // handle for length diff 1
        else{
            if(str2.length() > str1.length()){
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }
            int i=0,j=0,mismatch=0;
            while(i<str1.length() && j<str2.length()){
                if(str1.charAt(i)!=str2.charAt(j)){
                    mismatch++;
                    if(mismatch>1) return false;
                    i++;
                }
                else{
                    i++;
                    j++;
                }
            }
        }
        return true;
    }

    public static boolean isSingleEditAway_(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        if (len1 == len2) {
            int diffCount = 0;
            for (int i = 0; i < len1; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    diffCount++;
                }
                if (diffCount > 1) {
                    return false;
                }
            }
            return diffCount == 1;
        }

        if (len1 < len2) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (i != j) {
                    return false;
                }
                i++;
            } else {
                i++;
                j++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<String[]> testCases = new ArrayList<>();
        // Test Cases
        testCases.add(new String[]{"abcd", "abzcd", "true"}); // true by removing or adding z
        testCases.add(new String[]{"hello", "helle", "true"}); // Matching is possible by changing 'o' to 'e' in String 1.
        testCases.add(new String[]{"hello", "hell", "true"}); //  possible to match by a single operation add o.
        testCases.add(new String[]{"hello", "world", "false"}); // Not possible to match by a single operation (multiple differences).
        testCases.add(new String[]{"hello", "helloo", "true"}); // Matching is possible by removing one 'o' from String 2.
        testCases.add(new String[]{"hello", "helo", "true"}); // Matching is possible by adding 'l' to String 2.
        testCases.add(new String[]{"", "", "true"}); // Matching is possible (no operation needed).
        testCases.add(new String[]{"a", "b", "true"}); // Matching is possible by changing 'a' to 'b' in String 1.
        testCases.add(new String[]{null, "hello", "false"}); // Not possible (null string cannot be transformed into a non-null string).
        testCases.add(new String[]{"This is a long string with many characters.", "This is a long string with many characters!", "true"}); // Matching is possible by removing the trailing '!' from String 2.
        testCases.add(new String[]{"café", "cafe", "true"}); // Matching is possible by removing the accent ('é') from String 1.
        testCases.add(new String[] {"AbCdEfG", "AbCDefg", "true"}); // Matching is possible by changing 'G' to 'g' in String 1.
        testCases.add(new String[] {"hello, world!", "Hello world.", "false"}); // Not possible to match by a single operation (multiple differences).
        testCases.add(new String[] {"This is a complex example with many differences.", "This example is quite complicated.", "false"}); // Not possible to match by a single operation (multiple differences, including word removal and replacement).
        testCases.add(new String[] {"12345", "123456", "true"}); // Matching is possible by adding '6' to String 1.
        testCases.add(new String[] {"résumé", "resume", "false"});
        testCases.add(new String[] {"Hello, 😄!", "Hello, 😃!", "true"}); // Matching is possible by changing the emoji from '😃' to '😄' in String 2.
        testCases.add(new String[] {"leading spaces", "    leading spaces", "true"}); // Matching is possible by removing extra spaces and tabs from the beginning of String 2.
        testCases.forEach(s -> System.out.println(Arrays.toString(s)+" Output: "+ isSingleEditAway(s[0],s[1])));
        /*
        boolean result = isSingleEditAway_("abcd", "abzcd");
        if (result) {
            System.out.println("The two strings can be matched with a single operation.");
        } else {
            System.out.println("The two strings cannot be matched with a single operation.");
        }
        */
    }
}
