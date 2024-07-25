package Leetcode_Daily_Challenge;
import java.util.*;

public class SortTheArray {
    public static int[] sortarray(int[]nums){
        Arrays.sort(nums);
        return nums;
    }
    public static void main(String[] args) {
        int[] num={5,1,3,9,4,2};
        System.out.println(sortarray(num));
    }
}
