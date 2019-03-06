package DataStructures.Heap;

public class Heap {

    private final int capacity = 10;
    private int size = 0;
    private int[] items = new int[capacity];

    public int peek(){
        if(size == 0) throw new IllegalStateException();
        else{
            return items[0];
        }
    }

    public int poll(){
        if(size == 0) throw new IllegalStateException();
        else{
            //restructure heap
            int item = items[0];
            items[0] = items[size-1];
            size--;
            heapifyDown();
            return item;
        }
    }

    public void add(int item){
        size++;
        items[size] = item;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size-1;

        while(hasParent(index) && parent(index)>items[index]){
            swapItems(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChild(index);
            if(hasRightChild(index) && rightChild(index) <leftChild(index)){
                smallerChildIndex = getRightChild(index);
            }

            if(items[index] < items[smallerChildIndex]){
                break;
            }
            else{
                swapItems(index,smallerChildIndex);
                index = smallerChildIndex ;
            }
        }

    }

    private int getLeftChild(int parentIndex){
        return parentIndex*2+1;
    }

    private int getRightChild(int parentIndex){
        return parentIndex*2+2;
    }

    private int getParentIndex(int parentIndex){
        return ((parentIndex - 1)/2);
    }

    private boolean hasLeftChild(int index){
        return getLeftChild(index)<size;
    }
    private boolean hasRightChild(int index){
        return getRightChild(index)<size;
    }
    private boolean hasParent(int index){
        return getParentIndex(index)>=0;
    }
    private int leftChild(int index){ return items[getLeftChild(index)];}
    private int rightChild(int index){return items[getRightChild(index)];}
    private int parent(int index){return  items[getParentIndex(index)];}

    public void swapItems(int index1, int index2){
        int temp1 = items[index1];
        items[index1] = items[index2];
        items[index2] = temp1;
    }
}
