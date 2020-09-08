/**
 * @author hxxhk
 */
public class TreeDepth {
    public int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.getLeftNode());
        int right = treeDepth(root.getRightNode());
        return (left > right) ? (left + 1) : (right + 1);
    }
}
