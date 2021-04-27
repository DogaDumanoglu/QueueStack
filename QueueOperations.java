import java.io.IOException;
import java.util.Random;

public class QueueOperations {
    public static MyQueue removeGreater(MyQueue queue, int number,OperationWriter queueOutWriter) throws IOException {
        /*removes values from the file which are greater than given number& queue printed on the queueOut.txt.*/
        queueOutWriter.writeLine("After removeGreater "+number+":");//writes info to queueOut.txt.
        MyQueue storeQueue = new MyQueue();
        while (!queue.isEmpty()) {
            int smallerNumber = queue.dequeue();
            if (number >= smallerNumber) {
                storeQueue.enqueue(smallerNumber);//numbers grater than given number are deleted other ones stored.
            }
        }
        queueOutWriter.writeLine(queue.toString(storeQueue));//writes current queue to queueOut.txt.
        return storeQueue;
    }

    public static void calculateDistance (MyQueue queue,OperationWriter queueOutWriter) throws IOException {
        /*finds the sum of the distances of all elements to other all elements in the current queue then results are printed on queue.txt*/
        queueOutWriter.writeLine("After calculateDistance:");//writes info to queueOut.txt
        MyQueue copyQueue = QueueOperations.copyQueue(queue);//we created a copy so that the contents of the queue are not deleted.
        int totalDistance = 0;
        while (!copyQueue.isEmpty()){
            int number = copyQueue.dequeue();//takes the numbers from the copy queue one by one.
            MyQueue storeQueue= QueueOperations.copyQueue(copyQueue);//We copied the current version of copyQueue.
            while (!copyQueue.isEmpty()){
                totalDistance += Math.abs(number-copyQueue.dequeue());//we calculated distance of the number with other all number elements which are left.

            }
            copyQueue=storeQueue;}//copy queue is empty so we give it to current version(storeQueue).
        queueOutWriter.writeLine("Total distance="+totalDistance);//writes total distance to queueOut.txt.
    }

    public static void addOrRemove(MyQueue queue,int number,OperationWriter queueOutWriter) throws IOException {
        /*if given number is positive it adds random number between 0-50 if given number is negative
        removes elements number of time and queue printed on the queueOut.txt*/
        queueOutWriter.writeLine("After addOrRemove "+number+":");//writes info to queueOut.txt.
        Random rand=new Random();
        if(number<0){
            for(int i=0;i<Math.abs(number);i++){
                queue.dequeue();
            }
        }
        else{
            for(int i=0;i<number;i++){
                queue.enqueue(rand.nextInt(49)+1);
            }
        }
        queueOutWriter.writeLine(queue.toString(queue));//writes current queue to queueOut.txt.

    }

    public static MyQueue reverse(MyQueue queue,int n,OperationWriter queueOutWriter) throws IOException {
        /*reverses the first n elements of queue number according to given number and storeQueue printed on the queueOut.txt*/
        queueOutWriter.writeLine("After reverse "+n+":");//writes info to queueOut.txt.
        MyStack storeStack=new MyStack();
        MyQueue storeQueue=new MyQueue();
        int size=0;
        while(size<n) {
            storeStack.push(queue.dequeue());//the last number added to stack is top so queue reversed automatically.
            size++;//we add first n number for reversing.
        }
        while (!storeStack.isEmpty()){
            storeQueue.enqueue(storeStack.pop());//we created new queue to add numbers to front of queue.
        }
        while (!queue.isEmpty()) {
            storeQueue.enqueue(queue.dequeue());//we added the rest.
        }
        queueOutWriter.writeLine(storeQueue.toString(storeQueue));//writes current queue to queueOut.txt.
        return storeQueue;}

    public static MyQueue sortElements(MyQueue queue,OperationWriter queueOutWriter) throws IOException {
        /*sorts all elements in the queue and sort queue printed on the queueOut.txt*/
        queueOutWriter.writeLine("After sortElements:");//writes info to queueOut.txt.
        MyQueue sortQueue=new MyQueue();
        while(!queue.isEmpty()) {
            MyQueue storeQueue= new MyQueue();
            int first =queue.dequeue();//we take a number.
            while (!queue.isEmpty()) {
                int second = queue.dequeue();
                if ((first > second)) {
                    int max = second;
                    second = first;
                    first = max;
                }
                storeQueue.enqueue(second);//we kept the big ones to compare each other again.
            }
            sortQueue.enqueue(first);//we store the less ones.
            queue = storeQueue;//queue is empty so we give it the bigger numbers to compare again.
        }
        queueOutWriter.writeLine(sortQueue.toString(sortQueue));//writes sorted queue to queueOut.txt.
        return sortQueue;

    }
    public static void distinctElements(MyQueue queue,OperationWriter queueOutWriter) throws IOException {
        /*finds how many distinct elements in the queue.Results are printed on queueOut.txt*/
        queueOutWriter.writeLine("After distinctElements:");//writes queueOut.txt.
        MyQueue copyQueue=copyQueue(queue);//we created a copy so that the contents of the queue are not deleted.
        MyQueue distinctQueue=new MyQueue();
        while(!copyQueue.isEmpty()) {
            MyQueue storeQueue= new MyQueue();
            int first = copyQueue.dequeue();// we take a number.
            while (!copyQueue.isEmpty()) {
                int second = copyQueue.dequeue();
                if ((first !=second)) {//we compare first number to all other numbers.
                    storeQueue.enqueue(second);//we stored not compared numbers so that same ones deleted.
                }
            }
            distinctQueue.enqueue(first);//we store distinct ones in distinctQueue.
            copyQueue = storeQueue;//queue is empty so we give it not compared numbers for comparing again.
        }
        queueOutWriter.writeLine("Total distinct element="+size(distinctQueue));//writes how many distinct element in the queue.
    }

    public static MyQueue copyQueue(MyQueue queue) {
        /*This method creates a copy of the given queue.*/
        MyQueue storeQueue=new MyQueue();
        MyQueue copyQueue=new MyQueue();
        while(!queue.isEmpty()){
            storeQueue.enqueue(queue.dequeue());
        }
        while(!storeQueue.isEmpty()){
            int numbers=storeQueue.dequeue();
            copyQueue.enqueue(numbers);
            queue.enqueue(numbers);
        }
        return copyQueue;
    }
    public static int size(MyQueue myqueue){
        /*this method returns the size of given queue.*/
        MyQueue copyQueue=QueueOperations.copyQueue(myqueue);
        int size=0;
        while(!copyQueue.isEmpty()){
            copyQueue.dequeue();
            size++;
        }
        return size;
    }

}
