package LinkedList;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class kthLastNode {

    public static void main(String args[]) {
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

        int kthValue = kthLastNode(head, 2);
        System.out.println(kthValue + "");

    }


    public static int kthLastNode (Node head, int num){
        Node kthNode = head;
        Node lastNode = head;
        int step = 0;

        while(lastNode != null){
            if(step >= num){
                kthNode = kthNode.next;
            }

            step++;
            lastNode = lastNode.next;

        }
        return kthNode.value;
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
