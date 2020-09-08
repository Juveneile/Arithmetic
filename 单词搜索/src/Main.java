import java.util.Scanner;

/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        scanner.close();
        char[][] chars = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(chars, string));
    }

    public static boolean exist(char[][] chars, String string) {
        if (chars == null || chars.length == 0) {
            return false;
        }
        int rows = chars.length;
        int cols = chars[0].length;
        boolean[] flag = new boolean[rows * cols];
        //从每个位置开始遍历看是否包含此字符串
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (findChars(chars, string, i, j, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findChars(char[][] chars, String string, int i, int j, boolean[] flag, int index) {
        if (index == string.length()) {
            return true;
        }
        //边界条件
        if (i < 0 || i >= chars.length || j < 0 || j >= chars[0].length || chars[i][j] != string.charAt(index) || flag[i * chars[0].length + j]) {
            return false;
        }

        flag[i * chars[0].length + j] = true;

        if (findChars(chars, string, i + 1, j, flag, index + 1) || findChars(chars, string, i - 1, j, flag, index + 1)
                || findChars(chars, string, i, j - 1, flag, index + 1) || findChars(chars, string, i, j + 1, flag, index + 1)) {
            return true;
        }

        flag[i * chars[0].length + j] = false;

        return false;

    }
}
