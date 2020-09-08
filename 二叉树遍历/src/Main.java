public class Main {
    public static void main(String[] args) {
        Object[] values = {1,2,3,4,5};
        TreeNode treeNode = new TreeNode();
        treeNode.createTree(values);
        treeNode.preOrderTraverse1(treeNode.getRoot());
    }
}
