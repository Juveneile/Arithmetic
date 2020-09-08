/**
 * 二维数组中的查找
 *
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 7;
        System.out.println(twoArraySearch(nums, target));
    }

    private static boolean twoArraySearch(int[][] nums, int target) {
        if (nums != null && nums.length > 0 && nums[0].length > 0) {
            int rows = nums.length;
            int cols = nums[0].length;
            int row = 0, col = cols - 1;
            while (row < rows && col >= 0) {
                if (nums[row][col] == target) {
                    return true;
                } else if (nums[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }
        }
        return false;
    }
}
