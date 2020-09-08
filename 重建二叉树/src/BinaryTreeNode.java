import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树结构
 *
 * @author hxx
 */
public class BinaryTreeNode {
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;
    private BinaryTreeNode root;
    private Object value;

    public BinaryTreeNode(Object value) {
        this.value = value;
    }

    public BinaryTreeNode() {
    }

    /**
     * 创建二叉树
     * 输入完全二叉树序列，构建二叉树
     * 1 2 3 4 5
     *
     * @param values
     */
    public void createBinaryTree(Object[] values) {
        // 创建所有二叉树节点
        List<BinaryTreeNode> binaryTreeNodes = new ArrayList<>();
        for (Object value : values) {
            binaryTreeNodes.add(new BinaryTreeNode(value));
        }
        //设置根节点
        this.root = binaryTreeNodes.get(0);
        for (int i = 0; i < binaryTreeNodes.size() / 2; i++) {
            if (i * 2 + 1 < binaryTreeNodes.size()) {
                binaryTreeNodes.get(i).setLeftNode(binaryTreeNodes.get(i * 2 + 1));
            }
            if (i * 2 + 2 < binaryTreeNodes.size()) {
                binaryTreeNodes.get(i).setRightNode(binaryTreeNodes.get(i * 2 + 2));
            }
        }
    }

    /**
     * 前序遍历 递归
     *
     * @param rootNode
     */
    public void preOrderTraverse(BinaryTreeNode rootNode) {
        if (rootNode != null) {
            System.out.print(rootNode.getValue() + "->");
            preOrderTraverse(rootNode.getLeftNode());
            preOrderTraverse(rootNode.getRightNode());
        }
    }

    /**
     * 前序 非递归
     *
     * @param rootNode
     */
    public void preOrderTraverse2(BinaryTreeNode rootNode) {
        BinaryTreeNode node = rootNode;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.getValue() + "->");
                stack.push(node);
                node = node.getLeftNode();
            } else {
                node = stack.pop().getRightNode();
            }

        }

    }

    /**
     * 中序遍历
     *
     * @param rootNode
     */
    public void inOrderTraverse(BinaryTreeNode rootNode) {
        if (rootNode != null) {
            inOrderTraverse(rootNode.getLeftNode());
            System.out.print(rootNode.getValue() + "->");
            inOrderTraverse(rootNode.getRightNode());
        }
    }

    /**
     * 中序 非递归
     *
     * @param rootNode
     */
    public void inOrderTraverse2(BinaryTreeNode rootNode) {
        BinaryTreeNode node = rootNode;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLeftNode();
            } else {
                System.out.print(stack.peek().getValue() + "->");
                node = stack.pop().getRightNode();
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param rootNode
     */
    public void postOrderTraverse(BinaryTreeNode rootNode) {
        if (rootNode != null) {
            postOrderTraverse(rootNode.getLeftNode());
            postOrderTraverse(rootNode.getRightNode());
            System.out.print(rootNode.getValue() + "->");
        }
    }

    /**
     * 后序遍历
     */
    public void postOrderTraverse2(BinaryTreeNode rootNode){
        BinaryTreeNode cur, pre = null;

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(rootNode);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.getLeftNode() == null && cur.getRightNode() == null) || (pre != null && (pre == cur.getLeftNode()  || pre == cur.getRightNode()))) {
                System.out.print(cur.getValue() + "->");
                stack.pop();
                pre = cur;
            } else {
                if (cur.getRightNode()!= null) {
                    stack.push(cur.getRightNode());
                }
                if (cur.getLeftNode() != null) {
                    stack.push(cur.getLeftNode());
                }
            }
        }
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
