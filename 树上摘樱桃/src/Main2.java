import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int userNum = in.nextInt();
        int licheng = in.nextInt();
        int[] nums = new int[userNum-1];
        for (int i = 0 ;i<userNum-1;i++){
            nums[i] = in.nextInt();
        }
        in.close();
        if (licheng == 0){
            System.out.println(0);
        }else {
            System.out.println(licheng+1);
        }

    }
}
