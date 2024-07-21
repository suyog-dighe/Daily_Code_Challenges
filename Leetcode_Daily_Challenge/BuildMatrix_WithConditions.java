package Leetcode_Daily_Challenge;
import  java.util.*;

//Leetcode :- https://leetcode.com/problems/build-a-matrix-with-conditions/
// Question :- 2392. Build a Matrix With Conditions
public class BuildMatrix_WithConditions {
        public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
            List<Integer>[] rowGraph = new ArrayList[k + 1];
            for (int i = 1; i <= k; i++) {
                rowGraph[i] = new ArrayList<>();
            }
            for (int[] condition : rowConditions) {
                rowGraph[condition[0]].add(condition[1]);
            }

            List<Integer>[] colGraph = new ArrayList[k + 1];
            for (int i = 1; i <= k; i++) {
                colGraph[i] = new ArrayList<>();
            }
            for (int[] condition : colConditions) {
                colGraph[condition[0]].add(condition[1]);
            }

            int[] rowVisited = new int[k + 1];
            Deque<Integer> rowQueue = new LinkedList<>();
            for (int i = 1; i <= k; i++) {
                if (!topologicalSort(rowGraph, i, rowVisited, rowQueue)) {
                    return new int[0][0];
                }
            }

            int[] rowOrder = new int[k];
            int[] rowIndexMap = new int[k + 1];
            for (int i = 0; i < k; i++) {
                int node = rowQueue.pollLast();
                rowOrder[i] = node;
                rowIndexMap[node] = i;
            }

            int[] colVisited = new int[k + 1];
            Deque<Integer> colQueue = new LinkedList<>();
            for (int i = 1; i <= k; i++) {
                if (!topologicalSort(colGraph, i, colVisited, colQueue)) {
                    return new int[0][0];
                }
            }

            int[] colOrder = new int[k];
            int[] colIndexMap = new int[k + 1];
            for (int i = 0; i < k; i++) {
                int node = colQueue.pollLast();
                colOrder[i] = node;
                colIndexMap[node] = i;
            }

            int[][] matrix = new int[k][k];
            for (int i = 1; i <= k; i++) {
                matrix[rowIndexMap[i]][colIndexMap[i]] = i;
            }

            return matrix;
        }

        private boolean topologicalSort(List<Integer>[] graph, int node, int[] visited, Deque<Integer> stack) {
            if (visited[node] == 2) {
                return false; // cycle detected
            }
            if (visited[node] == 0) {
                visited[node] = 2;
                for (int neighbor : graph[node]) {
                    if (!topologicalSort(graph, neighbor, visited, stack)) {
                        return false;
                    }
                }
                visited[node] = 1;
                stack.add(node);
            }
            return true;
        }
    public static void main(String[] args) {
        BuildMatrix_WithConditions solution = new BuildMatrix_WithConditions();

        int k1 = 3;
        int[][] rowConditions1 = {{1, 2}, {3, 2}};
        int[][] colConditions1 = {{2, 1}, {3, 2}};
        int[][] result1 = solution.buildMatrix(k1, rowConditions1, colConditions1);
        for (int[] row : result1) {
            System.out.println(Arrays.toString(row));
        }

        int k2 = 3;
        int[][] rowConditions2 = {{1, 2}, {2, 3}, {3, 1}};
        int[][] colConditions2 = {{2, 1}, {3, 2}};
        int[][] result2 = solution.buildMatrix(k2, rowConditions2, colConditions2);
        for (int[] row : result2) {
            System.out.println(Arrays.toString(row));
        }
    }
}
