import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter{

    public void writeToFile(String textToWrite) {
        try (java.io.FileWriter fw = new java.io.FileWriter("C:\\Users\\Colby\\Programming\\Java\\ItalianWedding\\src\\EndLabels.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(textToWrite);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
