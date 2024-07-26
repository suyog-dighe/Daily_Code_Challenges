package DailyCode_GFG;
import java.util.*;

//GFG :-  https://www.geeksforgeeks.org/problems/k-pangrams0909/1
// Question:-  K-Pangrams

public class K_Pangrams {
    boolean kPangram(String str, int k) {
        int n = 0;

        Set<Character> set = new HashSet<>(26);
        for (char c : str.toCharArray()) {
            if (c == ' ') continue;
            set.add(c);
            n++;
        }

        if (n < 26) return false;

        int unique = set.size();
        int need = 26 - unique;
        return need <= k;
    }

    public static void main(String[] args) {
        K_Pangrams solution = new K_Pangrams();

        // Test case 1
        String str1 = "the quick brown fox jumps over the lazy dog";
        int k1 = 0;
        System.out.println(solution.kPangram(str1, k1)); // Expected output: true

        // Test case 2
        String str2 = "aaaaaaaaaaaaaaaaaaaaaaaaaa";
        int k2 = 25;
        System.out.println(solution.kPangram(str2, k2)); // Expected output: true

        // Test case 3
        String str3 = "a b c d e f g h i j k l m";
        int k3 = 20;
        System.out.println(solution.kPangram(str3, k3)); // Expected output: false
    }
}
