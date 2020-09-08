/**
 * 动态规划
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        System.out.println(getMaxValue(nums));
    }

    private static int getMaxValue(int[][] nums) {
        int rows = nums.length;
        int cols = nums[0].length;
        int[][] values = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (j - 1 == 0) {
                    values[i][j] = values[i - 1][j];
                } else if (i - 1 == 0) {
                    values[i][j] = values[i][j - 1];
                } else {
                    values[i][j] = Math.max(values[i - 1][j], values[i][j - 1]);
                }
                values[i][j] += nums[i - 1][j - 1];
            }
        }
        return values[rows][cols];
    }
}
