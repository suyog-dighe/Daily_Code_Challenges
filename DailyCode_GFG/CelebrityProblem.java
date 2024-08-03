package DailyCode_GFG;

// GFG :- https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
// Question :- The Celebrity Problem
//Date :- 03/08/2024
public class CelebrityProblem {
    public int celebrity(int mat[][]) {
        int m=mat.length;
        int n=0;
        // Step 1: Find the celebrity
        for(int i=1;i<m;i++){
            if(mat[n][i]==1){
                n=i;
            }
        }
        //verify the celebrity
        for(int i=0;i<m;i++){
            if((i!=n) && (mat[n][i]==1 || mat[i][n]==0)){
                return -1;
            }
        }
        return n;
    }
}
