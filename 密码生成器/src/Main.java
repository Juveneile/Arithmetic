import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int slotNum = -1;
        int computCount = -1;
        Scanner sc = new Scanner(System.in);

        while (computCount == -1) {
            slotNum = sc.nextInt();
            computCount = sc.nextInt();
            //System.out.println(slotNum);
            // System.out.println(computCount);
        }
        int i = 1;
        int[] soltArray = new int[slotNum];
        while (computCount >= i && sc.hasNext()) {
            int p = sc.nextInt();
            int h = sc.nextInt();
            for (; p <= h; p++, h--) {
                soltArray[p] = i;
                soltArray[h] = i;
            }
            i++;
            // Arrays.stream(soltArray).forEach(num -> System.out.println(num));
        }
        //Arrays.stream(soltArray).forEach(num -> System.out.println(num));
        sc.close();

        long resout = 0;
        for (int j = 0; j < slotNum; j++) {
            resout += j * soltArray[j];
        }
        System.out.println(Math.floorMod(resout,100000009));
    }
}
