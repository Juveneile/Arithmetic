import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String nan = in.nextLine();
        String[] nanStr = nan.split(" ");
        String mun = in.nextLine();
        String[] munStr = mun.split(" ");
        int num = in.nextInt();
        HashMap<Integer, Integer> mapleft = new HashMap<>();
        HashMap<Integer, Integer> mapright = new HashMap<>();
        int cun = num;
        while (cun > 0 && in.hasNextLine()) {
            int left = in.nextInt();
            int right = in.nextInt();
            mapleft.put(left, right);
            mapright.put(right, left);
            cun--;
        }
        in.close();
        int left = 0;
        int rigth = 0;
        for (HashMap.Entry<Integer, Integer> entry : mapleft.entrySet()) {
            left++;
        }
        for (HashMap.Entry<Integer, Integer> entry : mapright.entrySet()) {
            rigth++;
        }
        System.out.println(Math.min(rigth,left));
      //  System.out.println(Math.min(nanStr.length,munStr.length));
    }
}
