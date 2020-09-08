/**
 * 剪绳子，给一段长度为n的绳子，把绳子剪为m段，每段绳子的长度的乘积最大
 *
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(7));
    }

    /**
     * 动态规划
     * @param length
     * @return
     */
    private static int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        int max = 0;

        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        max = products[length];
        return max;
    }


}
