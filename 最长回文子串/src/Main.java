/**
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }

    /**
     * 思路
     * 动态规划
     * 如果dp[i + 1][j - 1] 为回文 且chars[i] == char[j] 则 dp[i][j]为回文
     *
     * @param str
     * @return
     */
    private static String longestPalindrome(String str) {
        int length = str.length();
        //如果只有一个字符或空
        if (length < 2) {
            return str;
        }
        //记录最大回文子串长度 1个字符也为回文
        int maxLength = 1;
        //记录最大回文子串起始位置
        int begin = 0;
        //状态转移方程，dp[i][j] 表示字符串从 i位到j位是否为回文字符串
        boolean[][] dp = new boolean[length][length];
        // i==j时必为回文  先初始化好
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        //将字符串转为字符数组，方便操作
        char[] chars = str.toCharArray();
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    //如果两边相等有三个字符，必为回文，就不用状态转移了
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return str.substring(begin, maxLength + begin);
    }
}
