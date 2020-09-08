import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        int sumPlantNum = 0;
        int aPlantNum = 0;
        int bPlantNum = 0;
        int inputNum = 0;
        Scanner scanner = new Scanner(System.in);
        while (inputNum == 0) {
            sumPlantNum = scanner.nextInt();
            aPlantNum = scanner.nextInt();
            bPlantNum = scanner.nextInt();
            inputNum++;
        }
        int[] plantListA = new int[aPlantNum];
        int[] plantListB = new int[bPlantNum];
        HashMap<Integer, Integer> mapA = new HashMap<>(aPlantNum);
        HashMap<Integer, Integer> mapB = new HashMap<>(bPlantNum);
        while (inputNum < 3) {
            if (inputNum == 1) {
                for (int i = 0; i < aPlantNum; i++) {
                    plantListA[i] = scanner.nextInt();
                }
                inputNum++;
            }
            if (inputNum == 2) {
                for (int i = 0; i < bPlantNum; i++) {
                    plantListB[i] = scanner.nextInt();
                }
                inputNum++;
            }
        }
        int onlyA = 0;
        int onlyB = 0;
        int aAndB = 0;
        for (int i = 0; i < bPlantNum; i++) {
            mapB.put((Integer) plantListB[i], 1);
        }
        for (int num : plantListA) {
            if (null != mapB.get(num) && mapB.get(num) == 1) {
                aAndB++;
            }
        }
        System.out.println((aPlantNum - aAndB)+" "+(bPlantNum-aAndB)+" "+aAndB);
    }
}
