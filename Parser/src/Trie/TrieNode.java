package Trie;

public class TrieNode{


    public TrieNode[] children;
    public Character data;
    public boolean isCompleteWord;
    private int count=1;

    public TrieNode(){
        isCompleteWord = false;
        children = new TrieNode[27];
    }

    public TrieNode(char c){
        this();
        this.data = c;

    }

    public int add(String s){
        return add(s,0);
    }
    public boolean containsWord(String s){
        return containsWord(s,0);
    }
    public int findCount(String s){
        return findCount(s, 0);
    }
    public int getCount() {
        return count;
    }

    public void incrCount(int count) {
        ++this.count;
    }

    /**private methods**/
    private int charToIndex(char c){
        int pos = (c - 'a');
        if(pos<0) {//this is not a letter
            if(c==' ')
                pos= 26;
            else{
                pos=-1;
            }
        }
        return pos;
    }
    private int add(String s, int index){
        if(index == s.length()){
            if(this.isCompleteWord){
               count++;
            }else {
                this.isCompleteWord = true;
            }
            return count;
        }
        else{
            char c = s.charAt(index);
            int nodeIndex = charToIndex(c);
            TrieNode child = children[nodeIndex];//getNode(c);
            if(child==null){
                child = new TrieNode(c);
                children[nodeIndex]=child;
            }

            return child.add(s,index+1);
        }

    }
    private TrieNode getNode(char c){
        int nodeIndex = charToIndex(c);
        return children[nodeIndex];
    }
    private int findCount(String s , int index){
        if(index == s.length()) return this.count;

        TrieNode child = children[charToIndex(s.charAt(index))];
        if(child == null){
            return 0;
        }
        else{
            return child.findCount(s,index+1);
        }
    }

    private boolean containsWord(String s, int index) {
        if(index == s.length()) return isCompleteWord;

        TrieNode child = getNode(s.charAt(index));
        if(child == null){
            return false;
        }
        else{
            return child.containsWord(s,index+1);
        }
    }

    public void print(){
        printTrie(this,2);
    }
    private void printTrie(TrieNode node, int offset) {
        if(node!=null&&node.data!=null) {
            System.out.printf(String.format("%" + offset + "s", node.data));
            // here you can play with the order of the children
            for (TrieNode child : node.children) {
                printTrie(child, offset + 2);
            }
        }
    }

}
