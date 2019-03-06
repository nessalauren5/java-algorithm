package Algorithms;

public class SumDigits {

    private static int printSum(int n) {
            if(n>10) {
                return n % 10 + printSum(n / 10);
            }
            return n;
    }

    public static void main(String[] args){
        int n = 987;
       System.out.println(printSum(n));
    }
}
