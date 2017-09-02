package Tree.BinaryTree;

import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree ,
 *          1
 *         / \
 *        2   4
 *       / \
 *      3   5
 *
 * return [1,2,3,5,4].
 *
 * Note: BTTraversal solution is trivial, could you do it iteratively?
 */
public class BTTraversal {
    BTNode root;

    public static void main(String args[]){
        BTTraversal traversal = new BTTraversal(init());
        iterativePostorderNormal(traversal.getRoot());
    }

    public BTTraversal(BTNode root) {
        this.root = root;
    }

    public BTNode getRoot() {
        return root;
    }

    /**构造树,先从创建叶子节点开始**/
    private static BTNode init(){
        BTNode n3 = new BTNode(3);
        BTNode n5 = new BTNode(5);
        BTNode n4 = new BTNode(4);
        BTNode n2 = new BTNode(2,n3,n5);
        BTNode n1 = new BTNode(1,n2,n4);

        return n1; // root
    }

    /**访问节点**/
    private static int getNode(BTNode node){
        System.out.print((int) node.getParent() + " ");
        return (int) node.getParent();
    }

    /**递归前序遍历**/
    private static void preOrder(BTNode node){
        if(node != null){
            getNode(node);
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**递归中序遍历**/
    private static void inOrder(BTNode node){
        inOrder(node.getLeft());
        getNode(node);
        inOrder(node.getRight());
    }

    /**递归后续遍历**/
    private static void postorder(BTNode node){
        inOrder(node.getLeft());
        inOrder(node.getRight());
        getNode(node);
    }


    /**非递归实现前序遍历**/
    private static void iterativePreorder(BTNode node){
        Stack<BTNode> stack = new Stack<>();
        if(node != null){
            stack.push(node);     //父母节点入栈(第一次调用就是根节点)

            while(!stack.empty()){
                node = stack.pop();     //父母节点出栈
                getNode(node);

                if(node.getRight() != null){    //一定记住是右孩子入栈
                    stack.push(node.getRight());
                }
                if(node.getLeft() != null){
                    stack.push(node.getLeft()); //左孩子再入栈
                }
            }
        }
    }

    /**非递归实现中序遍历**/
    private static void iterativeInorder(BTNode node){
        Stack<BTNode> stack = new Stack<>();

        if(node != null){

            while(!stack.empty() || node != null ){
                while(node != null){
                    stack.push(node);     //父母节点入栈
                    node = node.getLeft();      //遍历左子树
                }

                //左子树遍历完之后进入下边这个循环
                if(!stack.empty()){
                    node = stack.pop();
                    getNode(node);
                    node = node.getRight(); //遍历右子树,此时 node ！= null,又开始外层的循环
                }


            }
        }
    }


    /**
     * 非递归实现后序遍历，由于常规的实现方法比较麻烦，这里用了一种比较简便的方法：
     * 我们将前序遍历中"右孩子先入栈，做孩子后入栈"的顺序翻过来，即让左孩子先入栈，右孩子后入栈，
     * 得到的栈序列恰好为 后序遍历的逆序列，此时只要再用一个栈保存原栈的出栈序列(反过来)就行
     * @param node
     */
    private static void iterativePostorder(BTNode node){
        Stack<BTNode> stack1 = new Stack<>();
        Stack<BTNode> stack2 = new Stack<>();

        if(node != null){
            stack1.push(node);     //父母节点入栈(第一次调用就是根节点)

            while(!stack1.empty()){
                node = stack1.pop();     //父母节点出栈 (这里得出的是后序遍历的逆序列)
                stack2.push(node);      //用另一个栈来保存原栈的出栈序列，极为正序列

                if(node.getLeft() != null){
                    stack1.push(node.getLeft()); //这里走了捷径，让左孩子先入栈
                }

                if(node.getRight() != null){    //右孩子后入栈
                    stack1.push(node.getRight());
                }
            }
        }

        while(!stack2.empty()){
            BTNode n = stack2.pop();
            getNode(n);
        }
    }


    /**
     * 非递归实现后序遍历 的常规方法
     * @param node
     */
    private static void iterativePostorderNormal(BTNode node){
        Stack<BTNode> stack = new Stack<>();
        BTNode n = node;

        while(node != null){

            while(node.getLeft() != null){  //左子树不为空
                stack.push(node);   //父母节点入栈
                node = node.getLeft();
            }   //该循环结束的时,node.getLeft() = null,即此时node表示树最左端叶子

            //当前结点无右子节点(叶子节点)或者右子节点已经出栈(父母节点/非叶子节点,右孩子是后出栈的，故此时做孩子也已经出栈)
            while(node != null && (node.getRight() == null || node.getRight() == n)){
                getNode(node);
                n = node;   //记录上一个已经出栈的结点(用于判断非叶子节点的右孩子是否已出栈，如果是，那么本次输出的就是非叶子节点)

                if (!stack.empty()){
                    node = stack.pop();     //非叶子节点(父母节点)出栈
                }else {
                    return;     //从当前函数退出，退回到调用该函数处，并返回一个值 (这里返回的是空值)
                }
            }

            stack.push(node);   //非叶子节点(父母节点)又进栈
            node = node != null ? node.getRight() : null;   //处理(父母节点的)右子节点
        }
    }

}