package Algorithms;

public class OrderStatistics {


    public static void main(String[] args){
        int[] unsorted1 = {3,3,9,1,0};
        int[] unsorted2= {3};
        int[] unsorted3={-1,0,1,3,-5};

        System.out.println(findNthSmallest(unsorted1,3));
        System.out.println(findNthSmallest(unsorted2,3));
        System.out.println(findNthSmallest(unsorted3,1));
    }

    private static int findNthSmallest(int[] unsorted1, int i) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        while(start<i){
            min = findSmallest(unsorted1,start);
        }


        return min;
    }

    private static int findSmallest(int[] n, int index){
        int min = Integer.MAX_VALUE;
        for(int i=index;i<n.length;i++){
            if(n[i]<min){
                min = n[i];
            }
        }
        return min;
    }
}
