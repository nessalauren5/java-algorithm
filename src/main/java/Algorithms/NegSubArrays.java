package Algorithms;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class NegSubArrays {




        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Anagram. */
            Scanner scan = new Scanner(System.in);
            int length = scan.nextInt();
            int[]arr = new int[length];

            for(int i=0;i<length;i++){
                arr[i] = scan.nextInt();
            }

            System.out.println(findNegSubArrays(arr));
        }

        public static int findNegSubArrays(int[] arr){
            int numNegative = 0;
            for(int startIndex = 0;startIndex<arr.length;startIndex++){
                for(int endIndex = startIndex;endIndex<arr.length;endIndex++){
                        if(sumArray(arr,startIndex,endIndex) <0){
                            numNegative++;
                        }
                }
            }
            return numNegative;
        }

        public static int sumArray(int[] arr,int start,int end){
            int sum = 0;
            for(int i=start;i<=end;i++){
                sum+=arr[i];
            }
            return sum;
        }



}
