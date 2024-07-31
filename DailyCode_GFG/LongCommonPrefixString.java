package DailyCode_GFG;

//GFG:- https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
//Question :- Longest Common Prefix of Strings
//Date:-31/07/2024
public class LongCommonPrefixString {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) {
            return "-1";
        }

        String prefix = arr[0];

        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "-1";
                }
            }
        }

        return prefix;
    }
}
