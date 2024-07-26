package Leetcode_Daily_Challenge;
import java.util.Arrays;

// Leetcode :- https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/?envType=daily-question&envId=2024-07-26
//Question:- 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
public class SmallestNeighborCity {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cities = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cities[i], Integer.MAX_VALUE / 2);
            cities[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            cities[u][v] = w;
            cities[v][u] = w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cities[i][j] = Math.min(cities[i][j], cities[i][k] + cities[k][j]);
                }
            }
        }
        int smallestCity = -1;
        int minCountCity = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && cities[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count < minCountCity || (count == minCountCity && i > smallestCity)) {
                minCountCity = count;
                smallestCity = i;
            }
        }
        return smallestCity;
    }

    public static void main(String[] args) {
        SmallestNeighborCity solution = new SmallestNeighborCity();

        // Test case 1
        int n1 = 4;
        int[][] edges1 = {{0, 1, 3}, {1, 2, 1}, {2, 3, 4}, {3, 0, 2}};
        int distanceThreshold1 = 4;
        System.out.println(solution.findTheCity(n1, edges1, distanceThreshold1)); // Expected output: 3

        // Test case 2
        int n2 = 5;
        int[][] edges2 = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int distanceThreshold2 = 2;
        System.out.println(solution.findTheCity(n2, edges2, distanceThreshold2)); // Expected output: 0

        // Add more test cases as needed
    }
}
