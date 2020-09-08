import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 *
 * @author hxxhk
 */
public class PrintFromTopToBottom {
    public void printFromTopToBottom(BinaryTreeNode root) {
        if (root == null) {
            System.out.println("树为空");
        } else {
            //使用队列来存储
            Queue<BinaryTreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (queue.size() != 0) {
                BinaryTreeNode node = queue.poll();
                System.out.print(node.getValue() + "->");
                if (node.getLeftNode() != null) {
                    queue.offer(node.getLeftNode());
                }
                if (node.getRightNode() != null) {
                    queue.offer(node.getRightNode());
                }
            }
        }
    }
}
