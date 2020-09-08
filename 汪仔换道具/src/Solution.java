public class Solution {
    public static void main(String[] args) {

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回能交换奖品的最大数量
     * @param a int整型
     * @param b int整型
     * @param c int整型
     * @return int整型
     */
    public static int numberofprize (int a, int b, int c) {
        int result = 0;
        //找出三者中最小的
        int minValue = Math.min(Math.min(a,b),c);
        if(minValue == 0){
            if(a == 0){

            }
        }else {
            result += minValue;
           // numberofprize(a-minValue,b-minValue,c-minValue);
        }
        return result;
    }
}
