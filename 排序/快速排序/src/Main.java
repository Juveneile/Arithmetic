import java.util.Arrays;

/**
 * 快速排序
 * 不稳定 O(nlogn)
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {49, 38, 65, 97, 76, 13, 27};
        QSort(nums,0,nums.length-1);
        Arrays.stream(nums).forEach(value -> System.out.println(value));
    }

    private static void QSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivoLoc = partition(nums,left,right);
            QSort(nums,left,pivoLoc-1);
            QSort(nums,pivoLoc+1,right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        //找个基准值，默认为最左边
        int pivotKey = nums[left];
        while (left < right) {
            // 先从右边开始，找到右边比pivoKey小的数据的位置
            while (left < right && nums[right] >= pivotKey) {
                right--;
            }
            //交换两个数据
            nums[left] = nums[right];
            nums[right] = pivotKey;
            // 找到左边比pivoKey小的数据
            while (left < right && nums[left] <= pivotKey) {
                left++;
            }
            nums[right] = nums[left];
            nums[left] = pivotKey;
        }
        return left;
    }

}

