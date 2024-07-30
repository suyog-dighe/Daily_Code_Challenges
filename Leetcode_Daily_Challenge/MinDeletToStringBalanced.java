package Leetcode_Daily_Challenge;

//LeetCode:-  https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
//Question:- 1653. Minimum Deletions to Make String Balanced
//Date :- 30/07/2024

public class MinDeletToStringBalanced {
    public static int minimumDeletions(String s) {
        int res = 0;
        int c = 0;
        for (char x : s.toCharArray()) {
            if (x == 'b') {
                c += 1;
            } else if (c > 0) {
                res += 1;
                c -= 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    String str="aababbab";
        System.out.println(minimumDeletions(str));
    }
}
