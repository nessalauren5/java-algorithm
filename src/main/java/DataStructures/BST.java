package DataStructures;

import jdk.nashorn.internal.ir.BinaryNode;

import java.util.*;

public class BST {
    public BinaryNode root;

    public BST(){
    }

    public class BinaryNode{
        public BinaryNode left;
        public BinaryNode right;
        public int val;

        public BinaryNode(int v){
            val=v;
            left=null;
            right=null;
        }
    }

    public void addVal(int val){
       root = add(root,val);
    }

    private BinaryNode add(BinaryNode n ,int val){
        if(n==null){
            return new BinaryNode(val);
        }
        else if(val>n.val){
            n.right = add(n.right,val);
        }
        else if(val<n.val){
            n.left = add(n.left,val);
        }
        return n;
    }

    public void printTree(){
        print(root);
    }

    public void print(BinaryNode n){
        if(n!=null) {
            if (n.left != null) {
                print(n.left);
            }
            System.out.print(n.val);
            if (n.right != null) {
                print(n.right);
            }
        }

    }

    public static int numUniqueEmails(String[] emails) {
        HashSet<String>result = new HashSet<>();
        for(String email : emails){
            int localIndex = email.indexOf("@");
            String localName = email.substring(0,localIndex);
            String hostName = email.substring(localIndex,email.length());
            int plusIndex = localName.indexOf("+");
            if(plusIndex>=0){
                localName = localName.substring(0,plusIndex);
            }

            localName = localName.replaceAll("(\\.)","");
            result.add(localName+hostName);
        }
        return result.size();
    }

    public int findKthSmallest(int k){
        Stack<Integer> smallest = new Stack<>();
        String s;

        return findKthSmallest(k,root);
    }

    private int findKthSmallest(int k, BinaryNode node) {
       BinaryNode current = node;
       Stack<BinaryNode> nodesAscending = new Stack<>();


       while(!nodesAscending.empty()|| current!=null) {

            if(current!=null){
                nodesAscending.push(current);
                current = current.left;
            }
            else {
                current = nodesAscending.pop();
                k--;
                if (k == 0) return current.val;

                current=current.right;
            }
       }
       return -1;
    }

    public boolean search(int val){
        return searchRecursive(root,val);
    }

    private static boolean searchRecursive(BinaryNode current, int val) {
        if(current==null){
            return false;
        }
        else if(current.val==val){
            return true;
        }else if(val > current.val){
            return searchRecursive(current.right,val);
        }
        else{
            return searchRecursive(current.left,val);
        }
    }


    public int rangeSum(int L,int R){
        return recursiveSum(root,L,R);
    }

    public int recursiveSum(BinaryNode t, int L, int R){
        if (t==null || t.val<L || t.val>R){
            return 0;
        }
        else{
                   int leftSum = recursiveSum(t.left,L,R);
                   int rightSum = recursiveSum(t.right,L,R);

                   return t.val+  leftSum + rightSum;
        }
    }
    public static void main(String[] args){
        String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        numUniqueEmails(emails);
        BST bst = new BST();
        bst.addVal(7);
        bst.addVal(10);
        bst.addVal(3);
        bst.addVal(5);
        bst.addVal(15);
        bst.addVal(18);

       System.out.println(bst.rangeSum(7,15));


    }
}
