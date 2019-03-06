package DataStructures.Trie;

public class Trie {

    public static void main(String[] args){
        Node trie = new Node('*');
        trie.add("success");
        trie.add("soccer");
        trie.add("apple");
        trie.add("at");

        System.out.println(trie.containsWord("success") ? "true" : "false");
        System.out.println(trie.containsWord("app") ? "true" : "false");
        System.out.println(trie.findCount("a"));
    }
}
