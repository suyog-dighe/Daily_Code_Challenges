package DailyCode_GFG;
import java.util.ArrayList;
import java.util.Collections;

//GFG :-https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
//Question:-Rat in a Maze Problem - I
// Date:- 30/07/2024

public class RatInMaze {

    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        if (mat[0][0] == 0 || mat[mat.length - 1][mat.length - 1] == 0) {
            return result;
        }
        boolean[][] visited = new boolean[mat.length][mat.length];
        findPaths(mat, 0, 0, "", visited, result);
        Collections.sort(result);
        return result;
    }

    private static void findPaths(int[][] mat, int x, int y, String path, boolean[][] visited, ArrayList<String> result) {
        int n = mat.length;

        if (x == n - 1 && y == n - 1) {
            result.add(path);
            return;
        }

        if (isSafe(mat, x, y, visited)) {
            visited[x][y] = true;

            // Move Down
            findPaths(mat, x + 1, y, path + 'D', visited, result);

            // Move Left
            findPaths(mat, x, y - 1, path + 'L', visited, result);

            // Move Right
            findPaths(mat, x, y + 1, path + 'R', visited, result);

            // Move Up
            findPaths(mat, x - 1, y, path + 'U', visited, result);

            visited[x][y] = false;
        }
    }

    private static boolean isSafe(int[][] mat, int x, int y, boolean[][] visited) {
        int n = mat.length;
        return (x >= 0 && x < n && y >= 0 && y < n && mat[x][y] == 1 && !visited[x][y]);
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        int[][] mat2 = {
                {1, 0},
                {1, 0}
        };

        System.out.println(findPath(mat1)); // Output: [DDRDRR, DRDDRR]
        System.out.println(findPath(mat2)); // Output: []
    }
}

