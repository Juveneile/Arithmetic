import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                grid[i][j] = in.nextInt();
            }
        }
        System.out.println(numIslands(grid));
    }

    public static int numIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public static void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid == null || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
}
