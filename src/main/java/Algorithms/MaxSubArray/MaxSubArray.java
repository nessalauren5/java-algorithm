package Algorithms.MaxSubArray;

public class MaxSubArray {

    public static void main(String[] args){
        int[] arr = {-1,1,18,10,3,-20,5,6};
        maxSubArraySum(arr);


           // System.out.print(result);

    }

    private static int findMaxSubArray(int[] arr) {
        int max_so_far = 0;
        int max_ending_here = 0;

        for(int i : arr){
           max_ending_here = i + max_ending_here;
           if(max_ending_here < 0){
               max_ending_here = 0; //reset end if less than 0
           }
           else if(max_so_far < max_ending_here){
               max_so_far = max_ending_here;
           }
        }
        return max_so_far;
    }

    public static void maxSubArraySum(int a[])
    {
        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0,start = 0,
                end = 0, s = 0;

        for (int i = 0; i < a.length; i++)
        {
            max_ending_here += a[i];

            if (max_so_far < max_ending_here)
            {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }

            if (max_ending_here < 0)
            {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum contiguous sum is "
                + max_so_far);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
}
