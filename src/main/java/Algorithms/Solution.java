package Algorithms;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static int substrIndex (String needle, String haystack) {
        // STUB.
        char[] needleArray = needle.toCharArray();
        char[] haystackArray = haystack.toCharArray();


        for(int i=0; i<haystackArray.length;i++){

            int start = i;

            for(int j=0;j<needleArray.length;j++){
                if(haystackArray[start+j]!=needleArray[j]){
                    break;
                }
                if(j==needleArray.length-1){
                    return start;
                }
            }

        }
        return -1;
    }



        public static TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder==null||inorder==null||preorder.length!=inorder.length) return null;
            else{
                return buildTreeRecursive(0,0,inorder.length,preorder, inorder);
            }
        }

        public static TreeNode buildTreeRecursive(int r, int start, int end, int[] preorder, int[] inorder){
            if(start>end||start<0) return null;
            else{

                TreeNode root = new TreeNode(preorder[r]);//root is first element
                System.out.println(root.val);
                int newIndex=-1;
                for(int i=start;i<end&&newIndex<0;i++){
                    if(inorder[i]==root.val){
                        newIndex=i;
                    }
                }
                int leftSize = newIndex-start;
                root.left = buildTreeRecursive(r+1,start,newIndex-1,preorder,inorder);
                root.right = buildTreeRecursive(r+leftSize+1,r+leftSize+1,end,preorder,inorder);
                return root;
            }
        }

    public static int[] sortArrayByParity(int[] A) {
        int evens=0;
        int odds = A.length-1;

        for(;evens<odds;evens++){
            if(A[evens]%2>0){
                int temp = A[evens];

                A[evens]=A[odds];
                A[odds]=temp;
                odds--;
            }
        }
        return A;
    }
    public static String decodeAtIndex(String S, int K) {

        String pattern = "(\\w)(\\d+)";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(S);

        while(m.find()){
            if(m.groupCount()==2) {
                String first = m.group(1);
                String count = m.group(2);
                System.out.println(first + " " + count);
            }
        }
        return pattern;
    }

    public static int minFlipsMonoIncr(String S) {
        return Math.min(flip(S,true),flip(S,false));
    }

    public static int flip(String S, boolean flipZeros){
        char opposite = flipZeros ? '0':'1';
        char[] asArr = S.toCharArray();
        int sum = 0;
        for(int i=0;i<asArr.length;i++){
            char current = asArr[i];
            if(current==opposite){
                sum++;
            }
        }
        return sum;
    }


    public static boolean isHappy(int n) {

            HashSet<Integer> testedNumbers = new HashSet<>();
            while(n>0){
                if(testedNumbers.isEmpty() || testedNumbers.contains(n)){
                    return false;
                }else{
                    testedNumbers.add(n);
                }
                int sum = 0;
                while(n>0){
                    int digit = n%10;
                    sum+= digit*digit;
                    n/=10;
                }
                if(sum==1)return true;
                else{
                    n=sum;
                }
            }
            return false;
        }
    public static int maxDepth(TreeNode root) {
        return findMaxDepth(root,1);
    }
    public static int findMaxDepth(TreeNode root, int level){
        if(root==null||(root.left==null&&root.right==null)){
            return level;
        }
        int left = 0;
        int right = 0;
        if(root.left!=null){
            left = findMaxDepth(root.left,level++);
        }
        if(root.right!=null){
            right = findMaxDepth(root.right,level++);
        }
        return Math.max(left,right);

    }

    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
    public static boolean isAlienSorted(String[] words, String order) {
        if(words==null||words.length<2) return true;
        else{
            HashMap<Character,Integer> orderMap = new HashMap<>();
            int i=0;
            for(char c : order.toCharArray()){
                orderMap.put(c,i);
                i++;
            }

            for(i=1;i<=words.length-1;i++){

                char[] a = words[i-1].toCharArray();
                char[] b = words[i].toCharArray();

                for(int j=0;j<a.length;j++){
                    if(j>=b.length) {return false;}
                    if(orderMap.get(a[j])>orderMap.get(b[j])){
                        return false;
                    }
                }
            }
        }
        return true;

    }
    public static void rotate(int[] nums, int k) {
        int i=0;
        int temp=nums[0];
        int numSwaps=0;
        while(numSwaps<nums.length){
            int newPosition = (i+k);
            if(newPosition>nums.length-1){
                newPosition%=(nums.length);
            }
            int swapped = nums[newPosition];
            nums[newPosition]=temp;
            temp = swapped;
            i=newPosition;
            numSwaps++;
        }

    }



    public static ListNode swapPairs(ListNode head) {
        /**
         First, we swap the first two nodes in the list, i.e. head and head.next;
         Then, we call the function self as swap(head.next.next) to swap the rest of the list following the first two nodes.
         Finally, we attach the returned head of the sub-list in step (2) with the two nodes swapped in step (1) to form a new linked list.
         **/
        return swapPairsRecursively(head);
    }
    public static ListNode swapPairsRecursively(ListNode head){
        if(head == null) return null;
        if(head.next==null) return head;

        ListNode second = head.next;
        ListNode third = second.next;
        second.next = head;
        head.next = swapPairsRecursively(third);
        head = second;
        return head;
    }


    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode result = swapPairs(head);

        while(result!=null){
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        }

}