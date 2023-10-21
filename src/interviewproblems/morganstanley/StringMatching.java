package interviewproblems.morganstanley;

/**
 * by adding removing or changing only one character
 * in one string check if matching two string is possible or not
 */

public class StringMatching {

    public static boolean isSingleEditAway(String str1, String str2) {
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
        boolean result = isSingleEditAway("abcd", "abzcd");
        if (result) {
            System.out.println("The two strings can be matched with a single operation.");
        } else {
            System.out.println("The two strings cannot be matched with a single operation.");
        }
    }
}
