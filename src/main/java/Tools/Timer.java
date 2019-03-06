package Tools;

public class Timer {

    private long startTime=0;
    private long endTime=0;
    public Timer(){}

    public void startTimer(){
        startTime = System.nanoTime();
        System.out.println("Started timer.");
    }
    public void stopTimer(){
        endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Stopped execution: " + duration + " nano seconds.");
    }

}
