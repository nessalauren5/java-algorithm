public class Fibonnaci {
    protected static int[] fibs;
    public static void main(String[] args){
        //calculate digits of fibonnaci of a number
        fibonnaci(4);
    }

    public static void fibonnaci(int i) {
        fibs = new int[i+1];

        System.out.println(calcfibonnaci(i));
    }

    private static int calcfibonnaci(int i) {
        if(i == 0){
            return 0;
        }
        else if (i==1){
            return 1;
        }
        else if(fibs[i]>0){
            return fibs[i];
        }
        else{
            return calcfibonnaci(i-1) + calcfibonnaci(i-2);
        }

    }
}
