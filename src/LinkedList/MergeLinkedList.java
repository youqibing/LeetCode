package LinkedList;

public class MergeLinkedList {

    public static void main(String args[]) {
        Node head1 = new Node(0);
        Node n11 = new Node(2);
        Node n12 = new Node(4);
        Node n13 = new Node(6);
        Node n14 = new Node(8);
        Node n15 = new Node(10);
        Node n16 = new Node(12);

        head1.setNext(n11);
        n11.setNext(n12);
        n12.setNext(n13);
        n13.setNext(n14);
        n14.setNext(n15);
        n15.setNext(n16);

        Node head2 = new Node(1);
        Node n21 = new Node(3);
        Node n22 = new Node(5);
        Node n23 = new Node(7);
        Node n24 = new Node(9);

        head2.setNext(n21);
        n21.setNext(n22);
        n22.setNext(n23);
        n23.setNext(n24);


        Node newHead = merge(head1, head2);
        if(newHead != null) {
            System.out.println(newHead.value + "");
            while (newHead.next != null) {
                newHead = newHead.next;
                System.out.println(newHead.value + "");
            }
        }

    }

    public static Node merge(Node head1, Node head2){

        if(head1.next == null || head2.next == null){
            return null;
        }

        Node temp1 = head1;
        Node temp2 = head2;
        Node newNode = new Node();          //生成新链表的首节点
        Node newHead = newNode;

        while (temp1 != null && temp2 != null){
            if(temp1.value > temp2.value){
                newHead.setNext(temp2);
                temp2 = temp2.next;
            }else {
                newHead.setNext(temp1);
                temp1 = temp1.next;
            }

            newHead = newHead.next;
        }

        if(temp1 == null){  //如果head1已经遍历完，则临时指针直接指向剩余的temp2
            newHead.next = temp2;
        }

        if(temp2 == null){  //如果head2已经遍历完，则临时指针直接指向剩余的temp1
            newHead.next = temp1;
        }

        return newNode.next;
    }



    static class Node{
        private int value;
        private Node next;

        public Node() {
        }

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
