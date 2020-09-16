import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Stack<Object> stack = new Stack<Object>();
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str.replace(" ", "");
        str.replace("(", "");
        str.replace(")", "");
        char[] sarray = str.toCharArray();
        boolean temp = false;
        int fuhao = 0;
        int number = 0;
        for (int i = sarray.length - 1; i >= 0; i--) {
            try {
                if (sarray[i] >= '0' && sarray[i] <= '9') {
                    stack.push(sarray[i]);
                    number++;
                } else {
                    fuhao++;
                    double a = (double) stack.pop();
                    double b = (double) stack.pop();
                    double result = jisuan(a, b, sarray[i]);
                    stack.push(result);
                }
            } catch (Exception e) {
                temp = true;
            }
        }
        if (temp || !(number - 1 == fuhao) || stack.empty()) {
            System.out.println("ERROR");
        } else {
            double ans = (double) stack.pop();
            System.out.println(ans);
        }

    }

    public static double jisuan(double a, double b, String f) {
        switch (f) {
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "+":
                return a + b;
            case "-":
                return a - b;
        }
        return 0;
    }
}
