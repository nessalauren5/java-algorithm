package Algorithms;
import java.util.HashMap;

import java.util.Scanner;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        HashMap<Character, Integer> aMap = getMap(a.toLowerCase());
        HashMap<Character, Integer> bMap =  getMap(b.toLowerCase());
        return anagram(aMap,bMap);
    }
    public static boolean anagram(HashMap<Character, Integer> aMap,HashMap<Character, Integer> bMap){
        if(aMap.size()!=bMap.size()){
            return false;
        }
        else{
            for (char c:aMap.keySet()){
                int countA = aMap.get(c);
                int countB = bMap.get(c);
                if(countA!=countB){
                    return false;
                }
            }
        }
        return true;
    }
    public static HashMap<Character,Integer> getMap(String s){
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char a = s.charAt(i);

            if(!charMap.containsKey(a)){
                charMap.put(a,1);
            }
            else{
                int count = charMap.get(a);
                count++;
                charMap.put(a,count);
            }
        }
        return charMap;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }


}