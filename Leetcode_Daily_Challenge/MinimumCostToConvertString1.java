package Leetcode_Daily_Challenge;
import java.util.*;
public class MinimumCostToConvertString1 {
    private static final int CHAR_COUNT = 26;
    private static final int INF = Integer.MAX_VALUE / 2;
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {



        int[][] cg = dfs(original, changed, cost);
        opt(cg);
        return compute(source, target, cg);
    }

    private  static  int[][] dfs(char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[CHAR_COUNT][CHAR_COUNT];
        for (int[] row : graph) {
            Arrays.fill(row, INF);
        }
        for (int i = 0; i < CHAR_COUNT; i++) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }
        return graph;
    }

    private static void opt(int[][] graph) {
        for (int k = 0; k < CHAR_COUNT; k++) {
            for (int i = 0; i < CHAR_COUNT; i++) {
                if (graph[i][k] < INF) {
                    for (int j = 0; j < CHAR_COUNT; j++) {
                        if (graph[k][j] < INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
    }

    private static long compute(String source, String target, int[][] graph) {
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';
            if (sourceChar != targetChar) {
                if (graph[sourceChar][targetChar] == INF) {
                    return -1L;
                }
                totalCost += graph[sourceChar][targetChar];
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        String source = "abcd";
        String target = "bcda";
        char[] original = {'a', 'b', 'c', 'd'};
        char[] changed = {'b', 'c', 'd', 'a'};
        int[] cost = {1, 2, 3, 4};

        long result = minimumCost(source, target, original, changed, cost);
        System.out.println(result); // Output should be the minimum cost to transform source to target
    }
}
