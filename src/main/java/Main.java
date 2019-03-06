/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void findOccurences(int[] arr,int X){
        int count = 0;
        for(int i=0;i<arr.length && arr[i]<=X;i++){
            if(arr[i]==X){
                count++;
            }
        }
        System.out.println(count);
    }
    public static int[] parseLineToArray(String s){
        int[] numArr = new int[s.length()];
        Scanner sc = new Scanner(s);
        sc.useDelimiter(" ");

        for(int i=0;sc.hasNextInt();i++){
            numArr[i] = sc.nextInt();
        }
        return numArr;
    }
    public static void main (String[] args) throws IOException {
        try{
            Scanner sc = new Scanner(new File("./input.txt"));
            int numTestCases = sc.nextInt();


            while(sc.hasNextLine()){
                String s = sc.nextLine();
                int X = (int) s.charAt(s.length()-1);
                int[] arr = parseLineToArray(sc.next());
                findOccurences(arr,X);
            }
        }catch(FileNotFoundException e){

        }


    }
}