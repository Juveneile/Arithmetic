/**
 * @author hxxhk
 */
public class Order {
    int findPosInInOrder(String str, String in, int position) {
        char c = str.charAt(position);
        int length = in.length();
        for (int i = 0; i < length; i++) {
            if (c == in.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 已知前序和中序，求后序
     *
     * @param preOrder
     * @param inOrder
     */
    void postOrder(String preOrder, String inOrder, int length) {
        if (1 == length) {
            System.out.println(inOrder);
            return;
        }
        if (0 == length) {
            return;
        }
        int index = findPosInInOrder(preOrder, inOrder, 0);
        String inOrder_left = inOrder.substring(0, index);
        String inOrder_right = inOrder.substring(index + 1);

        String preOrder_left = preOrder.substring(1, 1 + index);
        String preOrder_right = preOrder.substring(index + 1);

        postOrder(preOrder_left, inOrder_left, inOrder_left.length());
        postOrder(preOrder_right, inOrder_right, inOrder_right.length());

        System.out.println(preOrder.charAt(0));

    }

    /**
     * 已知后序、中序，求先序
     *
     * @param postOrder
     * @param inOrder
     * @param length
     */
    void preOrder(String postOrder, String inOrder, int length) {
        if (1 == length) {
            System.out.println(inOrder);
            return;
        }
        if (0 == length) {
            return;
        }
        int index = findPosInInOrder(postOrder, inOrder, postOrder.length() - 1);
        String inOrder_left = inOrder.substring(0, index);
        String inOrder_right = inOrder.substring(index + 1);

        String postOrder_left = postOrder.substring(0, index);
        String postOrder_right = postOrder.substring(index + 1, postOrder.length() - 1);

        System.out.println(postOrder.charAt(postOrder.length() - 1));
        preOrder(postOrder_left, inOrder_left, inOrder_left.length());
        preOrder(postOrder_right, inOrder_right, inOrder_right.length());


    }

    public static void main(String args[]) {
        Order order = new Order();
        String pre = "ABDEC";
        String in = "DBEAC";
        String post = "DEBCA";
        order.postOrder(pre, in, in.length());

        System.out.println("********************************");
        order.preOrder(post, in, in.length());
    }
}
