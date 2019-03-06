package Algorithms.MissingNumber;

public class MissingNumber {


    //base case array of size 2
    //if numbers are not one apart, the number is missing
    //else search right and left combinations of the array

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5,6,7,8,10};
        int length = 10;
        System.out.println("Found missing number: " + findMissingNumber(arr,10));
    }

   public static int findMissingNumber(int[] arr, int length) {
        int currentSum = 0;
        for(int i=0;i<length-1;i++){
            currentSum+=arr[i];
        }
        int correctSum =  length*(length+1)/2;
        return correctSum - currentSum;
   }



}
