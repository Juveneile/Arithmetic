/**
 * 反转链表
 * @author hxxhk
 */
public class ReverseList {
    public ListNode reverseList (ListNode head) {
        if (head == null) {
            return head;
        }
        // 上一结点
        ListNode pre = head;
        // 当前结点
        ListNode cur = head.next;
        // 临时结点，用于保存当前结点的指针域（即下一结点）
        ListNode tmp;
        // 当前结点为null，说明位于尾结点
        while (cur != null) {
            tmp = cur.next;
            // 反转指针域的指向
            cur.next = pre;
            // 指针往下移动
            pre = cur;
            cur = tmp;
        }
        // 最后将原链表的头节点的指针域置为null，还回新链表的头结点，即原链表的尾结点
        head.next = null;
        return pre;
    }

}
