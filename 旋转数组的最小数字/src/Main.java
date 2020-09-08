/**
 * 二分查找
 *
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 0, 1};
        System.out.println(searchMin(nums));
    }

    private static int searchMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index1 = 0;
        int index2 = nums.length - 1;
        int indexMid = index1;
        while (nums[index1] >= nums[index2]) {
            //如果只有两个数了
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;

            // 出现无法判断的情况时只能使用顺序查找
            if (nums[index1] == nums[indexMid] && nums[indexMid] == nums[index2]) {
                return minInOrder(nums, index1, index2);
            }

            if (nums[indexMid] >= nums[index1]) {
                index1 = indexMid;
            } else if (nums[indexMid] <= nums[index2]) {
                index2 = indexMid;
            }
        }
        return nums[indexMid];
    }

    private static int minInOrder(int[] nums, int index1, int index2) {
        int result = nums[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > nums[i]) {
                result = nums[i];
            }
        }
        return result;
    }
}
