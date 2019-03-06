package Algorithms;

public class Singleton implements Cloneable{

private static Singleton _instance_;

private Singleton(){
}

public static Singleton getInstance(){
    if(_instance_==null){
        _instance_=new Singleton();
    }
    return _instance_;
}
public static void sendMsg(){
    System.out.println("STATIC Sending!");
}

public void sendNonStatic(){System.out.println("REGULAR Sending!");}


public static void main(String[] args){
    Singleton t = new Singleton();
    Singleton l = Singleton.getInstance();

    t.sendNonStatic();
    l.sendNonStatic();
    Singleton.sendMsg();

}
}
