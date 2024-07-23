package Leetcode_Daily_Challenge;
import java.util.Arrays;

// Leetcode : https://leetcode.com/problems/sort-array-by-increasing-frequency/
// Question : 1636. Sort Array by Increasing Frequency

public class SortArrby_IncreaseFreq {
    public static int[] frequencySort(int[] nums) {
        int count[] = new int[201];
        for (int n : nums)  count[n + 100]++;
        int k = 0;
        for (int i = nums.length - 1; i >= 0;) {
            int m = 0, ind = -1;
            for (int j = 0; j < 201; j++) {
                if (count[j] > m) {
                    m = count[j];
                    ind = j;
                }
            }
            for (int j = 0; j < m; j++)  nums[i--] = ind - 100;
            count[ind] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] sortedNums = frequencySort(nums);
        System.out.println(Arrays.toString(sortedNums));
    }
}
