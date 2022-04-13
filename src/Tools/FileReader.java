package Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {
    public String readFromFile(File file) {
        String returnString = "";
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                returnString = returnString + "\n" + line;
            }
        }
        catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        return returnString;
    }
}
