package Algorithms.Palindrome;

public class PaliFinder {

    public static String findLongestPalindrome(String s){
        int begIndex = 0;


        while(begIndex<s.length()-1){

            int endIndex = s.length()-1;

            for(int i= begIndex;endIndex>0;endIndex--){

                String curSubstring = s.substring(begIndex,endIndex);
                if(isPalindrome(curSubstring)){
                    return curSubstring;
                }
            }
            begIndex++;
        }
        return s;
    }
    public static boolean isPalindrome(String s){

        if(s.length()>=3){
            char[] strAsArray = s.toCharArray();
            int length = s.length()-1;
            int middle = length/2;
            for(int i=0;i<=middle;i++){
                if(strAsArray[i] != strAsArray[length-i]){
                    return false;
                }
                else if(i==middle+1){
                    return true;
                }

            }
        return true;
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(findLongestPalindrome(args[0]));
    }
}
