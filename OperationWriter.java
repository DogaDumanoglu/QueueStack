import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OperationWriter {
    private boolean append;
    private String pathName;

    public OperationWriter(String pathName) {
        this.pathName = pathName;
    }

    public void writeLine(String str) throws IOException {
        /*prints the requested information to the file after each operation
        for stackOut & queueOut and finally prints stack & queue to their files*/
        File file = new File(pathName);
        FileWriter fileWriter = new FileWriter(file,append);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if(append){bWriter.write("\n");}
        bWriter.write(str);
        bWriter.close();
        append=true;
    }
}

