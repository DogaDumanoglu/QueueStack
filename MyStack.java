import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack {
    private ArrayList<Integer> stack =new ArrayList<>();

    public void push(int integer){
        /*adds an element to the top of the stack*/
        stack.add(0,integer);
    }

    public boolean isEmpty(){
        /*removes an element to the top of the stack*/
        return stack.size() == 0;
    }

    public int pop() {
        /*removes an element from the top of the stack*/
        if (!stack.isEmpty()) {
            int removed = stack.get(0);
            stack.remove(0);
            return removed;
        }
        throw new EmptyStackException();//if stack is Empty throws EmptyStackException
    }
    public String toString(MyStack stack){
        /*Returns the string of elements in the stack*/
        MyStack copyStack=StackOperations.copyStack(stack);
        StringBuilder str= new StringBuilder();
        while(StackOperations.size(copyStack)!=1)
        {
            str.append(copyStack.pop()).append(" ");}
        str.append(copyStack.pop());
        return str.toString();
    }


}
