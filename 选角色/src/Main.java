import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int countCi = in.nextInt();
        while (countCi > 0) {
            System.out.println();
            int peopleNum = in.nextInt();
            int jueseNum = in.nextInt();
            int[] arrayOfpeopleWant = new int[peopleNum];
            int i = 0;
            while (i < peopleNum) {
                arrayOfpeopleWant[i] = in.nextInt();
                i++;
            }
            int j = 0;
            int[] arrayOfjueseNum = new int[jueseNum];
            while (j < jueseNum) {
                arrayOfjueseNum[j] = in.nextInt();
                j++;
            }
            Arrays.sort(arrayOfpeopleWant);
            Arrays.sort(arrayOfjueseNum);
            int[] result = new int[peopleNum];
            int k = 0;
            for (int h = 0; h < arrayOfpeopleWant.length; h++) {
                for (; k < arrayOfjueseNum.length; k++) {
                    if (arrayOfjueseNum[k] >= arrayOfpeopleWant[h]) {
                        result[h] = k;
                        break;
                    }
                }
            }

            Arrays.stream(result).forEach(value -> {
                if(value == 0){
                    System.out.print(0);
                }else {
                    System.out.print(arrayOfjueseNum.length-value);
                }
                System.out.print(" ");});
            countCi--;
        }
        in.close();
    }
}
