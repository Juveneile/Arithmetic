import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        in.close();
        String[] strings = string.split(" ");
        int[] nums = new int[strings.length];
        int i=0;
        for(String str:strings){
            nums[i]=Integer.parseInt(str);
            i++;
        }
        List<List<Integer>> result = resultSum(nums);
        for(List<Integer> list : result){
            for(Integer value : list){
                System.out.print(value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> resultSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int one = 0; one < length; ++one) {
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }
            int three = length - 1;
            int target = -nums[one];
            for (int tow = one + 1; tow < length; ++tow) {
                if (tow > one + 1 && nums[tow] == nums[tow - 1]) {
                    continue;
                }
                while (tow < three && nums[tow] + nums[three] > target) {
                    --three;
                }
                if (tow == three) {
                    break;
                }
                if (nums[tow] + nums[three] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[one]);
                    list.add(nums[tow]);
                    list.add(nums[three]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
