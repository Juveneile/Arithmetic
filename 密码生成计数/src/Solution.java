/**
 * @author hxxhk
 */
public class Solution {
    public static void main(String[] args) {
        int[] xa = {-1, 4, 10, 4};
        System.out.println(getHouses(2, xa));
    }

    public static int getHouses(int t, int[] xa) {

        // write code here
        if(xa == null){
            return 1;
        }
        if(xa.length<4){
            return 2;
        }
        int result = 0;
        int[] arr = new int[xa.length];
        for (int i = 0; i < xa.length; i++) {
            int left = xa[i]-xa[i+1]/2;
            int right = xa[i]+xa[i+1]/2;
            arr[i] = left;
            arr[i+1] = right;
            i++;
        }
        for(int i = 1;i+1<arr.length;i++){
            if(arr[i+1] - arr[i] > t){
                result+=2;
            }else if(arr[i+1] - arr[i] == t){
                result+=1;
            }
            i++;
        }
        return result+2;
    }
}
