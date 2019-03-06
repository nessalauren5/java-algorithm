package Algorithms.Knapsack;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class KnapSack {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        return findMaxNumToys(prices, prices.length, k);
    }

    private static int findMaxNumToysRecursive(int[] prices, int numItems, int price){
        if(numItems == 0 || price==0)return 0;
        else if(prices[numItems-1]>price){
            return findMaxNumToys(prices,numItems-1,price);
        }
        else{
            return max(1+ findMaxNumToys(prices,numItems-1,price-prices[numItems-1]),findMaxNumToys(prices,numItems-1,price));
        }

    }

    private static int findMaxNumToys(int[] prices, int numItems, int price){
        int[][]knapsack = new int[numItems+1][price+1];

        for(int i=0;i<=numItems;i++){ //0..numItems

            for(int p=0; p<=prices.length; p++){ //0..price
                if(i==0|| p==0) knapsack[i][p] = 0;
                else if(prices[i-1] <= price){
                    int included = prices[i-1] + knapsack[i-1][p-1];
                    int excluded = knapsack[i-1][p];
                    knapsack[i][p] = max( included,  excluded);

                    //K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
                }
                else{
                    knapsack[i][p] = knapsack[i-1][p];
                }
            }
        }
        return knapsack[numItems][price];
    }
    private static int max(int a, int b){
        return a > b ? a:b;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.print(result);
       // bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }
}
