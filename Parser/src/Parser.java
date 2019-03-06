import Trie.TrieNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    private TrieNode wordTrie;
    private TrieNode bigramTrie;
    private PriorityQueue<Term> topWords;
    private PriorityQueue<Term> topBigrams;

    public int totalWordCount = 0;

    public Parser(String filePath) {
        wordTrie = new TrieNode();
        bigramTrie = new TrieNode();
        topBigrams = new PriorityQueue<>(10);
        topWords = new PriorityQueue<>(10);
        load(filePath);
        System.out.println("loaded.");
    }

    private void load(String filePath) {
        try {
            Stream<String> stream = Files.lines(Paths.get(filePath));
            stream.filter(s -> !s.isEmpty()).forEach(s -> addLine(s));
            stream.close();
        } catch (IOException e) {
            System.out.println("Error processing file: " + filePath);
            System.out.println(e.getMessage());
        }

    }

    private String[] parseLine(String line) {
        String temp = line.toLowerCase().replaceAll("[\\p{IsDigit}]|[\\p{Punct}]", "");
        return temp.trim().split(" ");
    }

    private void addLine(String line) {
        String[] lineAsArr = parseLine(line);
        String previous = null;
        for (int i = 0; i < lineAsArr.length; i++) {
            String current = lineAsArr[i];
            current.trim();

            if (isValid(current)) {
                totalWordCount++;
                if (previous != null) {
                    addBigram(previous + " " + current);
                }

                addWord(current);
                previous = current;
            } else {
                previous = null;
            }

        }

    }

    private void addWord(String current) {
        int count = wordTrie.add(current);
        addToTopList(current,count, topWords);
        // System.out.println("Added word:" + current + " with count: " + currentCount);
    }

    private void addToTopList(String current, int count, PriorityQueue<Term> minheap)
    {
        Term t = new Term(current,count);
        if(minheap.contains(t)){
            minheap.remove(t);
        }
        minheap.add(t);

        if(minheap.size()>10){
            minheap.poll();
        }
    }

    private void addBigram(String bigram) {
        int count = bigramTrie.add(bigram);
       addToTopList(bigram,count, topBigrams);
        //  System.out.println("Added bigram:" +previous+" "+ current + " with count: " + currentCount);
    }

    private boolean isValid(String word) {
        if (word == null || word.equals("")) {
            return false;
        }
        return true;
    }


    public String getNTopWord(int n) {
        return getTermByOrder(n, topWords);
    }

    private String getTermByOrder(int k, PriorityQueue<Term> heap) {

        Iterator<Term> it = heap.iterator();
        Term result = null;
        while (it.hasNext() && k > 0) {
            result = it.next();
            k--;
        }
        return result.word;
    }

    public String getNTopBigram(int n) {
        return getTermByOrder(n, topBigrams);
    }

    public int getWordCount(String word) {
        return wordTrie.findCount(word);
    }

    public int getBigramCount(String word1, String word2) {
        return bigramTrie.findCount(word1 + " " + word2);
    }


    //update different counts and completed variables for bigrams and unigrams

}
