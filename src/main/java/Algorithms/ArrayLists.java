package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Anagram. */
        Scanner sc = new Scanner(System.in);
        int numIntLines = sc.nextInt();
        ArrayList[] lines = new ArrayList[numIntLines];

        for(int i=0;i<numIntLines;i++){
            int numDigits = sc.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for(int j=0;j<numDigits;j++){
                line.add(sc.nextInt());
            }
            lines[i] = line;
        }
        int numQueries = sc.nextInt();
        for(int i=0;i<numQueries;i++){
            int lineNumber = sc.nextInt()-1;
            int pos = sc.nextInt()-1;
            if(lineNumber<lines.length){
                ArrayList<Integer> currentLine = lines[lineNumber];

                if(currentLine.size()>pos){
                    System.out.println(currentLine.get(pos));
                }else{
                    System.out.println("ERROR!");
                }
            }else{
                System.out.println("ERROR!");
            }
        }
    }
}
