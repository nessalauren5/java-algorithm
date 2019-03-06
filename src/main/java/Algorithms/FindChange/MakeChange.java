package Algorithms.FindChange;

public class MakeChange {

   int[] coins = {2,3,5,6 };
    public int N = 10;
    int waysToMake = 0;

    public MakeChange(){
        waysToMake = makeChange(coins,N,coins.length);
    }

    private int makeChange(int[] coins, int N,int coinIndex) {

        if(N == 0){
            return 1; // we found a solution
        }

        if(N<0){
            return 0;//not a solution, has gone negative
        }

        else if(coinIndex<=0 && N>=1){
            return 0;
        }

        else{
            return makeChange(coins,N,coinIndex-1) + makeChange(coins, N-coins[coinIndex-1], coinIndex);
        }

    }

    public static void main(String[] args){
        MakeChange mc = new MakeChange();
        System.out.println(mc.waysToMake);
    }
}
