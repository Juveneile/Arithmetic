import java.util.*;

/**
 * @author hxxhk
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodeNum = in.nextInt();
        int bianNum = in.nextInt();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int num = 0;
        while (bianNum > 0 && in.hasNextInt()) {
           int person = in.nextInt();
           String locaton = in.next();
           int chiled = in.nextInt();
           if(map.containsKey(person)){
               map.get(person).add(chiled);
           }else {
               HashSet<Integer> set = new HashSet<>();
               set.add(chiled);
               map.put(person,set);
           }
           bianNum--;
        }
        in.close();
        for(HashMap.Entry<Integer, HashSet<Integer>> entry: map.entrySet())
        {
            boolean isExic = true;
            int cNum = 0;
            for(Integer value : entry.getValue()){
                if(map.containsKey(value)){
                    isExic = false;
                }
                cNum++;
            }
            if(isExic && cNum == 2){
                num++;
            }
            isExic = true;
            cNum = 0;
        }
        System.out.println(num);
    }
}
