import Trie.TrieNode;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MaxOccurences {

    public PriorityQueue<TrieNode> topList;
    private int maxSize = 10;
    public MaxOccurences(int n){
        topList = new PriorityQueue<>(n);
        maxSize = n;
    }

    public MaxOccurences(){
        topList = new PriorityQueue<>(maxSize);
    }
    public TrieNode getMax(){
        return getOrderMax(1);
    }

    public TrieNode getOrderMax(int n){
        Iterator<TrieNode> it = topList.iterator();
        int index=1;
        TrieNode res = null;
        while(it.hasNext() && index<n) {
            res = it.next();
            index++;
        }
        return res;

    }

    public void add(TrieNode t){

    }
}
