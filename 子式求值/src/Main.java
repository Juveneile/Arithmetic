import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] listA = new int[num];
        int i = 0;
        while (i < num) {
            listA[i] = scanner.nextInt();
            i++;
        }
        int[] listB = new int[num];
        int reslut = 0;
        for (int j = 1; j <= num; j++) {
            listB[j-1] = listA[j-1];
            for (int k = 1; k <= num; k++) {
                listB[j-1] = listB[j-1] ^ (j%k);
            }

        }
        reslut = listB[0];
        for(int j =1;j<num;j++){
            reslut ^= listB[j];
        }
        System.out.println(reslut);
    }
}
