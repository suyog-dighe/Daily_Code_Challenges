package DailyCode_GFG;

//GFG :- https://www.geeksforgeeks.org/problems/edit-distance3702/1
//Question :-Edit Distance
//Date :- 02/08/2024
public class EditDistance {
    public int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // if str1 is empty, we need to insert all characters of str2
                } else if (j == 0) {
                    dp[i][j] = i; // if str2 is empty, we need to remove all characters of str1
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // if characters are the same, no operation is needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], // replace
                            Math.min(dp[i - 1][j], // remove
                                    dp[i][j - 1])); // insert
                }
            }
        }
        return dp[m][n];
    }
}
