package DataStructures.Trie;

import java.util.HashMap;

public class Node {

    public HashMap<Character, Node> children = new HashMap<>();
    public Character data;
    public boolean isCompleteWord;
    private int count=1;

    public Node(char c){
        this.data = c;
    }
    private Node getNode(char c){
        return children.get(c);
    }
    private void setNode(char c, Node n){
        children.put(c,n);
    }
    public void add(String s){
        add(s,0);
    }
    private void add(String s, int index){
        if(index == s.length()){
            this.isCompleteWord = true;
            return;
        }
        else{
            char c = s.charAt(index);
            Node child = getNode(c);
            if(!children.containsKey(c)){
                child = new Node(c);
                setNode(c,child);
            }

            child.add(s,index+1);
        }

    }
    public int findCount(String s){
        return findCount(s, 0);
    }
    private int findCount(String s , int index){
        if(index == s.length()) return children.size();

        Node child = getNode(s.charAt(index));
        if(child == null){
            return 0;
        }
        else{
            return child.findCount(s,index+1);
        }
    }
    public boolean containsWord(String s){
        return containsWord(s,0);
    }

    private boolean containsWord(String s, int index) {
        if(index == s.length()) return isCompleteWord;

        Node child = getNode(s.charAt(index));
        if(child == null){
            return false;
        }
        else{
            return child.containsWord(s,index+1);
        }
    }

    public int getCount() {
        return count;
    }

    public void incrCount(int count) {
        ++this.count;
    }
}
