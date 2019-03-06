package Algorithms;

public class LongestCommonSubsequence {

    /**
     *
     * LCS Problem Statement: Given two sequences, find the length of longest subsequence
     * present in both of them. A subsequence is a sequence that appears in the same relative
     * order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”,
     * .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different
     * possible subsequences.
     */

    //caa
    //bcakfan

    //break into subproblems

    public static void main(String[] args){
        String s1 = "abcakdjbaodifahoihoasifih";
        String s2 = "oianosienoianfbaubvsdafsido";
//        String result = findLCS(s1,s2);
//        if(result!=null) {
//            System.out.println("Found LCS: " + result);
//            System.out.println("Length: " + result.length());
//        }
    }

    private static int findLCS(String s1, String s2) {
       return findLCS(s1,s2,"");
    }
    private static int findLCS(String s1, String s2,String lcs) {
        if(s1!=null && s2!=null && s1.length()>=1 && s2.length()>=1){

           if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)){
               return 1 + findLCS(s1.substring(0,s1.length()-2), lcs) + findLCS(s2.substring(0,s2.length()-2),lcs);
           }

        }else{

        }
        return 0;
    }

}
