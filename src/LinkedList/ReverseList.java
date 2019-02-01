package LinkedList;

/**
 * 翻转一个链表
 */
public class ReverseList {

    public static void main(String args[]){
        Node head = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);

        Node h = head;
        while(h != null){
            System.out.print(h.getValue()+",");
            h = h.getNext();
        }

        h = reverse1(head);
        System.out.println(" ");

        while(h != null){
            System.out.print(h.getValue()+",");
            h = h.getNext();
        }
    }


    /**
     * 递归做法，从后往前递归
     * @param head
     * @return
     */
    private static Node reverse1(Node head){
        if(head == null || head.getNext() == null){
            return head;
        }

        Node reHead = reverse1(head.getNext());  //一直"递"到最后一个节点
        head.getNext().setNext(head);   //然后从最后一个节点向前"归"
        head.setNext(null);

        return reHead;      //反转后新链表的头结点
    }

    /**
     * 非递归做法
     * @param head
     * @return
     */
    private static Node reverse2(Node head){
        if(head == null){
            return head;
        }

        Node pre = head;    //上一个结点
        Node cur = head.getNext();  //当前结点
        Node tmp;   //临时结点，用于保存当前结点的下一个结点

        while(cur != null){
            tmp = cur.getNext();    //当前只指针的下一个结点
            cur.setNext(pre);   //当前指针的指针域翻转，指向前一个结点

            //指针后移
            pre = cur;
            cur = tmp;
        }
        head.setNext(null);

        return pre;
    }


    static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public void setValue(int value){
            this.value = value;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node next){
            this.next = next;
        }
    }
}
