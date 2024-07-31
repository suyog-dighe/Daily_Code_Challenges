package Leetcode_Daily_Challenge;
import java.util.Arrays;

//Leetcode:- https://leetcode.com/problems/filling-bookcase-shelves/
//Question:- Filling Bookcase Shelves
//Date:- 31/07/2024
public class FillingBookcaseShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // Base case: no books require 0 height

        for (int i = 1; i <= n; ++i) {
            int total = 0;
            int max = 0;
            for (int j = i; j > 0; --j) {
                total += books[j - 1][0];
                if (total > shelfWidth) {
                    break;
                }
                max = Math.max(max, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + max);
            }
        }

        return dp[n];
    }
}
