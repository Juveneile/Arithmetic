import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        int upNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)-'A'>=0&&str.charAt(i)-'Z'<=0){
                upNum++;
            }
        }
        int downNum = str.length() - upNum;
        System.out.println(Math.abs(upNum - downNum)/2);
    }
}
