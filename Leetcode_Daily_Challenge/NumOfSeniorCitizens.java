package Leetcode_Daily_Challenge;

//Leetcode:- https://leetcode.com/problems/number-of-senior-citizens/
//Question:- 2678. Number of Senior Citizens
//Date :- 01/08/2024
public class NumOfSeniorCitizens {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String s : details) {
            //convert it into numeric value
            int a1 = s.charAt(11) - '0';
            int a2 = s.charAt(12) - '0';
            //make 2-digit number
            int age = a1 * 10 + a2;
            //check stricktly greater than 60 age
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}
