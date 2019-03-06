package Algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CodeShare {

        // Complete the repeatedString function below.
        public static long repeatedString(String s, long n) {
            HashSet<Integer> aIndexes = new HashSet<>();

            long numAs=0;
            int length = s.length();
            char[] str = s.toCharArray();
            for(int i=0;i<str.length;i++){
                char c = str[i];
                if(c=='a'){
                    numAs++;
                    aIndexes.add(i);
                }
            }
            if(numAs==0)return 0;
            else if(length==1)return n;
            else if(length==n){return numAs;}
            if(n>length){
                 long repeats =  n/length;
                numAs*=repeats;
                long leftover = n%length;
                System.out.printf("%d %d ", repeats, leftover);
                for(int i=0;i<leftover;i++){
                    if(aIndexes.contains(i)){
                        numAs++;
                    }
                }
            }
            else if(n<length){
                numAs=0;
                for(int i=0;i<n;i++){
                    if(aIndexes.contains(i)){
                        numAs++;
                    }
                }
            }


        return numAs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

      System.out.println(result);

        scanner.close();
    }
}

