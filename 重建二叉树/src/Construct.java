import java.util.*;

/**
 * 已知前序中序，构建二叉树
 * @author hxxhk
 */
public class Construct {
    public static void main(String[] args) {
        Integer[] perOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        //将数组转换为链表，方便增删
        LinkedList<Integer> perList = new LinkedList<Integer>(Arrays.asList(perOrder));

        //降低复杂度
        HashMap<Integer, Integer> inHashMap = new HashMap<>(inOrder.length);

        for (int i = 0; i < inOrder.length; i++) {
            inHashMap.put(inOrder[i],i);
        }
        constructCore(perList,inHashMap,0,inOrder.length-1);
    }

    /**
     * @param perList 前序链表
     * @param inHashMap  中序序列
     * @param start    中序序列开始下标
     * @param end      中序序列结束下标
     * @return
     */
    private static BinaryTreeNode constructCore(LinkedList<Integer> perList, HashMap<Integer, Integer> inHashMap, int start, int end) {
        //获取根节点值
        int rootValue = perList.removeFirst();
        //创建根节点
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        //获取根节点在中序序列中的下标
        int index = inHashMap.get(rootValue);
        //创建左子树
        if(start == index){
            //没有左子树
            root.setLeftNode(null);
        }else {
            root.setLeftNode(constructCore(perList,inHashMap,start,index-1));
        }

        //创建右子树
        if(end == index){
            root.setRightNode(null);
        }else {
            root.setRightNode(constructCore(perList,inHashMap,index+1,end));
        }

        //输出后序
        System.out.println(root.getValue());

        return root;
    }
}
