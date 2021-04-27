import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyQueue {
    private ArrayList<Integer> queue =new ArrayList<>();

    public void enqueue(Integer added){
        /*adds an element to the rear of the queue*/
        queue.add(added);
    }

    public int dequeue(){
        /*removes an element to the front of the queue*/
        if(!queue.isEmpty()){
        return queue.remove(0);}
    throw new NoSuchElementException();//if queue is Empty throws EmptyStackException
    }

    public boolean isEmpty(){
        /*checks if it is empty*/
        return queue.size() == 0;
    }

    public String toString(MyQueue queue) {
        /*Returns the string of elements in the queue*/
        MyQueue copyQueue=QueueOperations.copyQueue(queue);
        StringBuilder str= new StringBuilder();
        while(QueueOperations.size(copyQueue)!=1){
            str.append(copyQueue.dequeue()).append(" ");}
        str.append(copyQueue.dequeue());
        return str.toString();
    }


}
