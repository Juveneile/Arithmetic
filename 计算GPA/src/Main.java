import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();
        String[] strings = str.split(" ");
        //int[] nums = new int[strings.length];
        float jidianSum = 0;
        for (String string : strings) {
            int num = Integer.parseInt(string);
            if (num >= 90 && num <= 100) {
                jidianSum += 4;
            } else if (num >= 80 && num < 90) {
                jidianSum += 3;
            } else if (num >= 75 && num < 80) {
                jidianSum += 2.1;
            } else if (num >= 70 && num < 75) {
                jidianSum += 1.7;
            } else if (num >= 65 && num < 70) {
                jidianSum += 1.3;
            } else if (num >= 60 && num < 65) {
                jidianSum += 1;
            }
        }
        System.out.println(jidianSum/strings.length);
    }
}
