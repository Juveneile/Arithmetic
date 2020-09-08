/**
 * 剑指offer 63
 *
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(maxDiff(nums));
    }

    private static int maxDiff(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int maxDiff = 0;
        int curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(curMin > nums[i-1]){
                curMin = nums[i-1];
            }
            int curDiff = nums[i] - curMin;
            if (curDiff > maxDiff) {
                maxDiff = curDiff;
            }
        }
        return maxDiff;
    }
}
