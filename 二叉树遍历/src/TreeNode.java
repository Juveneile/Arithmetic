import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    /**
     * 左子树
     */
    private TreeNode left;

    /**
     * 右子树
     */
    private TreeNode right;
    /**
     * 节点值
     */
    private Object value;

    /**
     * 根节点
     */
    private TreeNode root;

    /**
     * @param value
     */
    public TreeNode(Object value) {
        this.value = value;
    }

    public TreeNode() {
    }

    /**
     * 创建二叉树
     * 先装数值，再按照完全二叉树方式分子树
     *
     * @param values
     */
    public void createTree(Object[] values) {
        List<TreeNode> list = new ArrayList<>();
        for (Object value : values) {
            list.add(new TreeNode(value));
        }
        //将第一个元素设置为根节点
        root = list.get(0);
        //利用完全二叉树构建 1 2 3 4 5
        for (int i = 0; i < list.size() / 2; i++) {
            if (i * 2 + 1 < list.size()) {
                list.get(i).setLeft(list.get(i * 2 + 1));
            }
            if (i * 2 + 2 < list.size()) {
                list.get(i).setRight(list.get(i * 2 + 2));
            }
        }
    }

    /**
     * 前序遍历 递归
     * @param root
     */
    public void preOrderTraverse1(TreeNode root){
        if(root != null){
            System.out.print(root.getValue()+"->");
            preOrderTraverse1(root.getLeft());
            preOrderTraverse1(root.getRight());
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.getLeft());
            System.out.print(root.getValue() + "->");
            inOrderTraverse(root.getRight());
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.getLeft());
            postOrderTraverse(root.getRight());
            System.out.print(root.getValue() + "->");
        }
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
