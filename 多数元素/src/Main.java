import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
        in.close();
        String[] strings = string.split(" ");
        long[] nums = new long[strings.length];
        int i=0;
        for(String str:strings){
            nums[i]=Long.parseLong(str);
            i++;
        }
        System.out.println(mostNum(nums));
    }

    public static long mostNum(long[] nums) {
        int count = 0;
        long tar = 0;
        for (long num : nums) {
            if (count == 0) {
                tar = num;
            }
            count += (num == tar) ? 1 : -1;
        }
        return tar;
    }
}
