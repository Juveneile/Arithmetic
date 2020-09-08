/**
 * 判断一个整数，变为二进制后1的个数
 * @author hxxhk
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(numberOf1(9));
    }
    private static int numberOf1(int num){
        int count = 0;
        while(num != 0){
            // 一个整数减去1，再和原来的整数做与运算，会把该整数最右边的1变成0
            // 1100  & 1011 = 1000
            //1000 & 0111 = 0000
            num = (num-1) & num;
            count++;
        }
        return count;
    }
}
