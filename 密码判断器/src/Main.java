import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        //System.out.println(input);
        String[] values = input.split(" ");
        String regex = "^[a-z0-9A-Z!-/]+$";
        String regEx = "[`~!@#$%^&*+=.<>?]";
        Pattern p = Pattern.compile(regEx);
        for (String value : values) {
            if (value.length() >= 8 && value.length() <= 120) {
                if (value.matches(regex)) {
                    Matcher matcher = p.matcher(value);
                    if (matcher.find()) {
                        System.out.println(0);
                    } else {
                        System.out.println(2);
                    }
                } else {
                    System.out.println(2);
                }
            } else {
                System.out.println(1);
            }
        }
    }
}
