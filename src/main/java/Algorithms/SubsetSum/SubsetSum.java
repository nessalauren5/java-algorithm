package Algorithms.SubsetSum;

import Tools.Timer;

import java.util.HashSet;

public class SubsetSum {
    //Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
    //Output:  True  //There is a subset (4, 5) with sum 9.

    public static void main(String[] args){
        Timer t = new Timer();
        t.startTimer();
        int[] numbers = {5,2,3,4,1};
        int sum = 10;
        int[] result = findSubset(numbers,sum);
        t.stopTimer();
        for(int i : result) System.out.print(i + " ");
    }


        private static int[] findSubset(int[] set, int sum) {
        HashSet<Integer> setOfNumbers = new HashSet<>();
        for(int i=0;i<set.length;i++){
            setOfNumbers.add(set[i]);
        }

        for(int i=0;i<set.length;i++){
            int currentNumber = set[i];
            setOfNumbers.remove(currentNumber);
            int numberNeeded = sum - set[i];
            if(setOfNumbers.contains(numberNeeded)){
                return new int[] {currentNumber,numberNeeded};
            }
            setOfNumbers.add(currentNumber);

        }
        return new int[]{};
    }
}
