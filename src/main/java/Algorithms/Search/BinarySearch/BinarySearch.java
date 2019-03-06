package Algorithms.Search.BinarySearch;

public class BinarySearch {



    public static boolean containsInt(int n){
        int[] array = {1,1,1,2,3,4,5,5,6,7,8,9,10};
        return binarySearch(array,0,array.length,n);
    }
    public static boolean binarySearch(int[] array, int begIndex, int endIndex,int goal){
        if(begIndex<endIndex) {

            int middleIndex = (endIndex - begIndex) / 2 + begIndex;
            int middle = array[middleIndex];
            if (middle == goal) {
                return true;
            } else if (goal > middle) {
                return binarySearch(array, middleIndex+1, endIndex, goal);
            } else {
                return binarySearch(array, begIndex, middleIndex-1, goal);
            }

        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(containsInt(8) ? "Yes" : "No");
    }
}
