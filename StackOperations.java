import java.io.IOException;
import java.util.Random;

public class StackOperations {
     public static void removeGreater(MyStack stack, int number,OperationWriter stackOutWriter) throws IOException {
         /*removes values from the file which are grater than given number& stack printed on the stackOut.txt.*/
          stackOutWriter.writeLine("After removeGreater "+number+":");//writes info to stackOut.txt.
          MyStack storeStack=new MyStack();
          while(!stack.isEmpty()){
               int smallerNumber=stack.pop();//we take a number.
               if(number>=smallerNumber){
                    storeStack.push(smallerNumber);//numbers grater than given number are deleted other ones stored.
               }
          }
         while(!storeStack.isEmpty()){
             stack.push(storeStack.pop());//we put remainders in the stack.
     }
         stackOutWriter.writeLine(stack.toString(stack));//writes current stack to stackOut.txt.
     }

    public static void calculateDistance(MyStack stack,OperationWriter stackOutWriter) throws IOException {
        /*finds the sum of the distances of all elements to other all elements in the current stack then results are printed on stack.txt.*/
        stackOutWriter.writeLine("After calculateDistance:");//writes info to stackOut.txt.
         MyStack copyStack = StackOperations.copyStack(stack);//we created a copy so that the contents of the stack are not deleted.
        int totalDistance = 0;
         while (!copyStack.isEmpty()) {
              int currentNumber = copyStack.pop();//takes the numbers from the copy stack one by one.
              MyStack storeStack = StackOperations.copyStack(copyStack);//We copied the current version of stack.
              while (!copyStack.isEmpty()) {
                   totalDistance += Math.abs(currentNumber - copyStack.pop());//we calculated the distance of current number with other all number elements which are left.
              }
              copyStack = storeStack;//copy stack is empty so we give it to current version(storeStack).
         }
        stackOutWriter.writeLine("Total distance="+totalDistance);//writes total distance to stackOut.txt.
    }

     public static void addOrRemove(MyStack stack,Integer number,OperationWriter stackOutWriter) throws IOException {
         /*if given number is positive it adds random number between 0-50 if given number is negative
        removes elements number of time.*/
          stackOutWriter.writeLine("After addOrRemove "+number+":");//writes info to stackOut.txt.
          Random rand=new Random();
         if(number<0){
               for(int i=0;i<Math.abs(number);i++){
                    stack.pop();
               }
         }
          else{
               for(int i=0;i<number;i++){
                    stack.push(rand.nextInt(49)+1);
               }
         }
         stackOutWriter.writeLine(stack.toString(stack));//writes current stack to stackOut.txt.
     }

    public static void reverse(MyStack stack, int n,OperationWriter stackOutWriter) throws IOException {
        /*reverses the queue first n number according to given number.*/
        stackOutWriter.writeLine("After reverse "+n+":");//writes info to stackOut.txt.
        MyQueue storeQueue=new MyQueue();
        int size=0;
        while(size<n) {
            storeQueue.enqueue(stack.pop());//we add numbers to queue because we dont want to change the order.
            size++;//we add first n number for reversing.
        }
        while (!storeQueue.isEmpty()){
            stack.push(storeQueue.dequeue());//when we add the stack again order turned to reverse
        }
        stackOutWriter.writeLine(stack.toString(stack));//writes current stack to stackOut.txt.
    }

    public static MyStack sortElements(MyStack stack,OperationWriter stackOutWriter) throws IOException {
        /*sorts all elements in the stack*/
         stackOutWriter.writeLine("After sortElements:");//writes info to stackOut.txt.
         MyStack sortStack=new MyStack();
         while(!stack.isEmpty()) {
             MyStack storeStack = new MyStack();
             int first = stack.pop();//we take the numbers one by one.
             while (!stack.isEmpty()) {
                 int second = stack.pop();
                 if ((first < second)) {
                     int max = second;
                     second = first;
                     first = max;
                 }
                 storeStack.push(second);//we kept the big ones to compare again.
             }
             sortStack.push(first);//we store the less ones.
             stack=storeStack;//stack is empty so we give it the bigger numbers to compare again.
         }
         stackOutWriter.writeLine(sortStack.toString(sortStack));//writes the sorted stack to stackOut.txt.
         return sortStack;
    }

     public static void distinctElements(MyStack stack,OperationWriter stackOutWriter) throws IOException {
         /*finds how many distinct elements in the stack*/
         stackOutWriter.writeLine("After distinctElements:");//writes info to stackOut.txt.
         MyStack distinctStack=new MyStack();// we created a copy so tat the contents of the queue are not deleted.
         MyStack copyStack=copyStack(stack);
         while(!copyStack.isEmpty()) {
             MyStack storeStack = new MyStack();
             int first = copyStack.pop();//we take a number.
             while (!copyStack.isEmpty()) {
                 int second = copyStack.pop();
                 if ((first !=second)) {//we compare first number to all numbers.
                     storeStack.push(second);//we stored not compared numbers so that same ones deleted.
                 }
             }
             distinctStack.push(first);//we stored compared numbers so that same ones deleted.
             copyStack = storeStack;//stack is empty so we give it not compared numbers for comparing again.
         }
         stackOutWriter.writeLine("Total distinct element="+size(distinctStack));//writes how many distinct element in stack to stackOut.txt.
     }


     public static MyStack copyStack(MyStack stack){
         /*This method creates a copy of the given stack.*/
          MyStack storeStack=new MyStack();
          MyStack copyStack=new MyStack();
          while(!stack.isEmpty()){
               storeStack.push(stack.pop());
          }
          while(!storeStack.isEmpty()){
              int number=storeStack.pop();
             stack.push(number);
             copyStack.push(number);
         }
          return copyStack;
     }
     public static int size(MyStack mystack){
         /*this method returns the size of given stack.*/
         MyStack copyStack=StackOperations.copyStack(mystack);
         int size=0;
         while(!copyStack.isEmpty()){
             copyStack.pop();
             size++;
         }
         return size;
     }


}
