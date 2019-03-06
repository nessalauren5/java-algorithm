package Algorithms.Sort.MergeSort;

public class MergeSort {

    public static void mergeSort(int[] arr){
        mergeSort(arr, new int[arr.length], 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {

        if(leftStart >= rightEnd){
            return;
        }else{
            int middle = (leftStart + rightEnd) / 2;
            mergeSort(arr, temp,leftStart,middle);
            mergeSort(arr,temp,middle+1,rightEnd);
            mergeHalves(arr,temp,leftStart,rightEnd);
        }
    }

    private static void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {

        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd+1;
        int size = rightEnd - leftStart + 1; // total number of elements to merge

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <=leftEnd && right <= rightEnd){
            if(arr[left] < arr[right]){
                temp[index] = arr[left];
                left++;
            }
            else{
                temp[index] = arr[right];
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left+1);
        System.arraycopy(arr, right, temp, index, rightEnd - right+1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);


    }

    public static void printarray(int[] arr){
        for(int i: arr){
            System.out.print( i + " ");
        }
    }

    public static void main(String[] args){
        int[] arr = {3, 5, 1, 2, 8, 3, 5, 8, 9, 10, 15, 41, 67, 89};
        mergeSort(arr);
        printarray(arr);
    }
}
