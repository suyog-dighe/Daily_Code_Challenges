package Leetcode_Daily_Challenge;

//Leetcode:- https://leetcode.com/problems/make-two-arrays-equal-by-reversing-subarrays/?envType=daily-question&envId=2024-08-03
//Question :- 1460. Make Two Arrays Equal by Reversing Subarrays
//Date :- 03/08/2024
public class MakeTwoArrEqualByReverSubarray {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Arrays.sort(target);
        // Arrays.sort(arr);
        // boolean equal = Arrays.equals(target, arr);
        // if(equal){
        //     return true;
        // }
        // return false;

        int n = target.length, m = arr.length;

        if (n != m) return false;

        int[] equal = new int[1001];

        for (int i = 0; i < n; i++) {
            equal[target[i]]++;
            equal[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            if (equal[target[i]] != 0 || equal[arr[i]] != 0) {
                return false;
            }
        }

        return true;
    }
}