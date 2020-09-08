/**
 * 一个有负有正的连续数组，找出连续最大子数组
 * 时间复杂度为O(n)
 *
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatestSumOfSubArray(nums));
    }

    private static int findGreatestSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curSum = 0;
        int greatestSum = 0;
        for (int num : nums) {
            if (curSum <= 0) {
                curSum = num;
            } else {
                curSum += num;
            }
            if (curSum > greatestSum) {
                greatestSum = curSum;
            }

        }
        return greatestSum;
    }
}
