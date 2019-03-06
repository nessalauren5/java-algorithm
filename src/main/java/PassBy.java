import DataStructures.BST;

import java.util.ArrayList;
import java.util.List;

public class PassBy {

    public void passByValue(){}
    public static void passByReference(List<String> in){
        in.add("Vanessa");
    }

    public static void main(String[] args){
        List<List<String>> listOfLists = new ArrayList<>();
        List<String> empty = new ArrayList<>();
        passByReference(empty);
        System.out.println(empty);

    }
}
