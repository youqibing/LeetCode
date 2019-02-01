package Tree.Problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CommonFather {

    public static void main(String args[]){
        // 形状普通的树
        //             1
        //           /   \
        //         2      3
        //        /     /    \
        //      4      5      6
        //     / \    / \    / | \
        //    7   8  9  10  11 12 13

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);


        n1.children.add(n2);
        n1.children.add(n3);

        n2.children.add(n4);

        n4.children.add(n7);
        n4.children.add(n8);

        n3.children.add(n5);
        n3.children.add(n6);

        n5.children.add(n9);
        n5.children.add(n10);

        n6.children.add(n11);
        n6.children.add(n12);
        n6.children.add(n13);

        //getChilderPath(n1, n6, n10);

        System.out.println(getChilderPath(n1, n6, n10).getValue());
    }

    private static TreeNode getChilderPath(TreeNode root, TreeNode p1, TreeNode p2){
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();

        getNodePath(root, p1, list, path1);
        System.out.println("");

        System.out.println("");
        getNodePath(root, p2, list, path2);
        System.out.println("");

        return getCommNode(path1, path2);
    }


    private static void getNodePath(TreeNode root, TreeNode traget, List<TreeNode> list, List<TreeNode> path){
        list.add(root);
        System.out.print(root.value+";");

        List<TreeNode> childer = root.children;

        /*
         * 其实这个不需要具体到某个孩子节点，只需要递归到目标子节点的父母节点即可
         * 当一个node没有childer时，自然会开始归
         */
        for(TreeNode node: childer){
            if(node == traget){
             path.addAll(list);
             break;
            }
            getNodePath(node, traget, list, path);      //递，相当于是遍历整个树
        }

        System.out.println("");
        System.out.print(list.get(list.size()-1).value+",");
        list.remove(list.size()-1);         //归，在归的过程中将刚才添加的元素删除
    }

    private static TreeNode getCommNode(List<TreeNode> path1, List<TreeNode> path2){

        TreeNode common = null;

        for(int i=0; i<path1.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
            common = path1.get(i);
        }
        return common;
    }


    private static class TreeNode{
        int value;

        List<TreeNode> children = new LinkedList<>();

        TreeNode(int value){
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }
}
