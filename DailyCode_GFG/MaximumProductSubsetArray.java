package DailyCode_GFG;
import java.util.Arrays;
import java.util.List;

//GFG :  https://www.geeksforgeeks.org/problems/maximum-product-subset-of-an-array/1
// QUestion: Maximum product subset of an array

public class MaximumProductSubsetArray {
        public static final long MOD = 1000000007;
        public long findMaxProduct(List<Integer> arr) {
            int n = arr.size();
            if (n == 0) return 0;

            long currentProduct = 1;
            boolean hasZero = false;
            int negativeCount = 0;
            int maxNegative = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                if (arr.get(i) == 0) {
                    hasZero = true;
                    continue;
                }
                if (arr.get(i) < 0) {
                    negativeCount++;
                    maxNegative = Math.max(maxNegative, arr.get(i));
                }
                currentProduct = (currentProduct * arr.get(i)) % MOD;
            }

            if (negativeCount % 2 != 0) {
                if (negativeCount == 1 && hasZero && negativeCount + (n - negativeCount) == 1) {
                    return 0;
                }
                currentProduct = (currentProduct / maxNegative) % MOD;
            }
            return currentProduct;
        }
    public static void main(String[] args) {
        MaximumProductSubsetArray solution = new MaximumProductSubsetArray();

        List<Integer> arr1 = Arrays.asList(-1, 0, -2, 4, 3);
        System.out.println(solution.findMaxProduct(arr1)); // Expected output: 24

        List<Integer> arr2 = Arrays.asList(-1, 0);
        System.out.println(solution.findMaxProduct(arr2)); // Expected output: 0

        List<Integer> arr3 = Arrays.asList(5);
        System.out.println(solution.findMaxProduct(arr3)); // Expected output: 5
    }

}
