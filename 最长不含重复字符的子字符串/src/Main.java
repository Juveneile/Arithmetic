import java.util.HashMap;
import java.util.Map;

/**
 * "arabcacfr"
 * "acfr"
 *
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        String str = "arabcdacfr";
        System.out.println(longestSubStringWithoutDuplication2(str));
    }

    /**
     * 剑指offer48
     *
     * @param str
     * @return
     */
    private static int longestSubStringWithoutDuplication(String str) {
        if (str != null && str.length() > 0) {
            // 记录最长长度
            int maxLength = 0;
            // 记录当前长度
            int curLength = 0;
            //用map来判断此字符是否存在，如果存在就要更新他的位置
            Map<Character, Integer> map = new HashMap<>();
            //遍历一遍字符串
            for (int i = 0; i < str.length(); i++) {
                //如果字符不存在，则直接当前长度加1
                if (!map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), i);
                    curLength++;
                } else {
                    if ((i - map.get(str.charAt(i))) <= curLength) {
                        curLength = i - map.get(str.charAt(i));
                        map.put(str.charAt(i), i);
                    } else {
                        map.put(str.charAt(i), i);
                        curLength++;
                    }
                }
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
            }
            return maxLength;
        }
        return 0;
    }
    //滑动窗口
    private static String longestSubStringWithoutDuplication2(String str) {
        if (str != null && str.length() > 0) {
            // 记录最长长度
            int maxLength = 0;
            //滑动窗口位置
            int per = 0;
            String result = null;
            //用map来判断此字符是否存在，如果存在就要更新他的位置
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                if (!map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), i);
                } else {
                    if (map.get(str.charAt(i)) >= per) {
                        per = map.get(str.charAt(i)) + 1;
                    }
                    map.put(str.charAt(i), i);
                }
                if ((i - per + 1) > maxLength) {
                    maxLength = i - per + 1;
                    result = str.substring(per, i + 1);
                }
            }
            return result;
        }
        return str;
    }
}
