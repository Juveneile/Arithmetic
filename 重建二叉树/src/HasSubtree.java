/**
 * 判断树A中是否包含树B
 *
 * @author hxxhk
 */
public class HasSubtree {
    public static void main(String[] args) {
        Object[] valuesA = {1, 2, 3, 4, 5, 6, 7};
        Object[] valuesB = {2, 4, 5};
        BinaryTreeNode binaryTreeNodeA = new BinaryTreeNode();
        binaryTreeNodeA.createBinaryTree(valuesA);
        BinaryTreeNode binaryTreeNodeB = new BinaryTreeNode();
        binaryTreeNodeB.createBinaryTree(valuesB);

      /*  binaryTreeNodeA.preOrderTraverse(binaryTreeNodeA.getRoot());
        System.out.println();
        binaryTreeNodeB.preOrderTraverse(binaryTreeNodeB.getRoot());
        System.out.println();
        System.out.println(hasSubTree(binaryTreeNodeA.getRoot(), binaryTreeNodeB.getRoot()));*/

        binaryTreeNodeA.postOrderTraverse2(binaryTreeNodeA.getRoot());
    }

    private static boolean hasSubTree(BinaryTreeNode rootA, BinaryTreeNode rootB) {
        boolean result = false;
        if (rootA != null && rootB != null) {
            if (rootA.getValue().equals(rootB.getValue())) {
                result = doseTreeAHaveTreeB(rootA, rootB);
            }
            if (!result) {
                result = hasSubTree(rootA.getLeftNode(), rootB);
            }
            if (!result) {
                result = hasSubTree(rootA.getRightNode(), rootB);
            }
        }
        return result;
    }

    private static boolean doseTreeAHaveTreeB(BinaryTreeNode rootA, BinaryTreeNode rootB) {
        //先判断数B是不是到头了
        if (rootB == null) {
            return true;
        }
        if (rootA == null) {
            return false;
        }
        if (!rootA.getValue().equals(rootB.getValue())) {
            return false;
        }
        return doseTreeAHaveTreeB(rootA.getLeftNode(), rootB.getLeftNode()) && doseTreeAHaveTreeB(rootA.getRightNode(), rootB.getRightNode());
    }
}
