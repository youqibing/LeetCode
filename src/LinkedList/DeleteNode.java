package LinkedList;

/**
 * 删除单链表中某个节点 p，假设链表的node的结构为：
 * static class Node{
 *     int value;
 *     Node next;
 * }
 *
 * 首先，这道题要考虑的是，这个P节点是未知节点(只知道value)，还是已知节点(value、next均知道)。
 *  如果是未知节点,那么根据链表的特性，我们只能遍历链表来找到P节点，之后找出P的前驱节点和后继节点，执行删除
 *  如果是已知节点，那么就可以采取《剑指offer》上面的解法，先找出P节点的后继节点q，然后将q的value值
 * 复制到p的value，然后让p的next指向q的next节点即可。
 */
public class DeleteNode {

    public static void main(String args[]){
        Node head = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);


        head.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);

        Node unkownNode = new Node(0);
        Node kownNode = n1;


        Node newHead = deleteUnkownNode(head, unkownNode);
        if(newHead != null) {
            System.out.println(newHead.value + "");
            while (newHead.next != null) {
                newHead = newHead.next;
                System.out.println(newHead.value + "");
            }
        }


        /*
        Node newUnHead = deleteKownNode(head, kownNode);
        if(newUnHead != null) {
            System.out.println(newUnHead.value + "");
            while (newUnHead.next != null) {
                newUnHead = newUnHead.next;
                System.out.println(newUnHead.value + "");
            }
        }
        */


    }



    public static Node deleteUnkownNode(Node head, Node unkownNode){
        if(head == null){
            return null;
        }

        Node cur = head;
        Node last = cur.next;

        if(head.value == unkownNode.value){     //如果头节点是需要删除的元素
            if(head.next != null) {     //链表中不止这一个元素
                Node h = head.next;
                head.next = null;
                return h;
            }else {     //说明链表中就一个元素
                head = null;
                return null;
            }

        }else {
            while(last != null){
                if(last.value == unkownNode.value){
                    if(last.next != null) {
                        cur.next = last.next;
                        last.next = null;
                        return head;
                    }else {
                        head.next = null;
                        last = null;
                        return head;
                    }
                }

                cur = cur.next;
                if(cur.next != null) {
                    last = cur.next;
                }else {
                    return head;
                }

            }
            return head;
        }
    }


    public static Node deleteKownNode(Node head, Node kownNode){
        if(head == null || kownNode == null){
            return null;
        }

        if(kownNode.next != null){
            Node temp = kownNode.next;
            kownNode.value = temp.value;
            kownNode.next = temp.next;
            temp = null;

            return head;
        }else {     //说明已知节点为最后一个节点,此时只能从头结点开始往后找，一直找到尾节点的前一个节点

            if(kownNode.value == head.value){   //本来已是最后一个节点，又发现与头结点的元素相当，说明链表就这一个节点
                head = null;
                return null;
            }

            Node pre = head;
            while(pre != null){
                if(pre.next.value == kownNode.value){
                    pre.next = null;
                }
                pre = pre.next;
            }
            return head;
        }

    }



    static class Node{
        private int value;
        private Node next;

        public Node(int value) {
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
