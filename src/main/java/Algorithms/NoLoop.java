package Algorithms;

public class NoLoop {

    //print a pattern without using a loop

    public static void main(String[] args){
        int n = 16;
        printPattern(n);
       // n = 10;
        //printPattern(n);
    }

    private static void printPattern(int n){
        printPattern(n,n,true);
    }
    private static void printPattern(int n, int currentVal, boolean decreasing) {

        System.out.print(currentVal + " ");

        if(currentVal<=0){
            decreasing = false;
        }
        if(decreasing){
            currentVal-=5;

        }
        else{
            currentVal+=5;
        }


        if(n != currentVal){
            printPattern(n,currentVal,decreasing);
        }
        if(n==currentVal){
            System.out.println(currentVal + " ");
        }




    }
}
