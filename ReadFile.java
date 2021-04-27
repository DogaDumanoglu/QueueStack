import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ReadFile {
    public static List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void readOperations(String path,OperationWriter queueWriter,OperationWriter stackWriter,OperationWriter queueOutWriter,OperationWriter stackOutWriter) throws IOException {
        /*reads the given operations*/
        List<String> lines = readFile(path);
        MyQueue queue=createQueue("queue.txt");
        MyStack stack=createStack("stack.txt");
        for (int i = 0; i < Objects.requireNonNull(lines).size(); i++) {
            String[] line =lines.get(i).split(" ");
            switch (line[1]) {
                case "removeGreater":
                    if(line[0].equals("Q")){
                        queue=QueueOperations.removeGreater(queue,Integer.parseInt(line[2]),queueOutWriter);
                    }
                    else{
                        StackOperations.removeGreater(stack,Integer.parseInt(line[2]),stackOutWriter);
                    }
                    break;
                case "calculateDistance":
                    if(line[0].equals("Q")){
                        QueueOperations.calculateDistance(queue,queueOutWriter);
                    }
                    else{
                        StackOperations.calculateDistance(stack,stackOutWriter);
                    }
                    break;
                case "addOrRemove":
                    if(line[0].equals("Q")){
                      QueueOperations.addOrRemove(queue,Integer.parseInt(line[2]),queueOutWriter);
                    }else{
                        StackOperations.addOrRemove(stack,Integer.parseInt(line[2]),stackOutWriter);}
                    break;
                case "reverse":
                    if(line[0].equals("Q")){
                        queue=QueueOperations.reverse(queue,Integer.parseInt(line[2]),queueOutWriter);
                    }else{
                        StackOperations.reverse(stack,Integer.parseInt(line[2]),stackOutWriter);}
                    break;
                case "sortElements":
                    if(line[0].equals("Q")){
                        queue=QueueOperations.sortElements(queue,queueOutWriter);
                    }else{
                        stack=StackOperations.sortElements(stack,stackOutWriter);}
                    break;
                case "distinctElements":
                    if(line[0].equals("Q")){
                        QueueOperations.distinctElements(queue,queueOutWriter);
                    }else{
                        StackOperations.distinctElements(stack,stackOutWriter);}
                    break;
            }

        }
        stackWriter.writeLine(stack.toString(stack));//writes new stack to stack.txt
        queueWriter.writeLine(queue.toString(queue));//writes new queue to queue.txt
    }

    public static MyQueue createQueue(String path){
        /*reads given queue file(queue.txt)*/
        MyQueue queue=new MyQueue();
        List<String> lines = readFile(path);
        String[] line= Objects.requireNonNull(lines).get(0).split(" ");
        for (String s : line) queue.enqueue(Integer.parseInt(s));/*stores numbers in the queue*/
        return queue;

    }

    public static MyStack createStack(String path){
        /*reads given stack file(stack.txt)*/
        MyStack stack= new MyStack();
        List<String> lines = readFile(path);
        String[] line= Objects.requireNonNull(lines).get(0).split(" ");
        ArrayList<String> reverse = new ArrayList<>(Arrays.asList(line));
        Collections.reverse(reverse);
        for (String s : reverse) stack.push(Integer.parseInt(s));/*stores numbers in the stack*/
        return stack;

    }
}