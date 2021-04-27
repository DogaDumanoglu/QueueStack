import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OperationWriter queueWriter=new OperationWriter("queue.txt");
        OperationWriter stackWriter=new OperationWriter("stack.txt");
        OperationWriter queueOutWriter=new OperationWriter("queueOut.txt");
        OperationWriter stackOutWriter=new OperationWriter("stackOut.txt");
        ReadFile.readOperations(args[0],queueWriter,stackWriter,queueOutWriter,stackOutWriter);
    }
}
