package ml.ledv.textanalyzerbascilv.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Implementation of {@link FileHandler} interface.
 *
 * @author Denis Lesheniuk
 * @version 1.0
 **/
public class FileHandlerImpl implements FileHandler{
    private boolean fileOk = false;
    /**
     * Extracts text from a file.
     * @param filePath is an absolute path
     * @return text in String format

     */
    public String textExtractor(String filePath) {
        String text = "";
        if(fileValidation(filePath)) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
                while (bufferedReader.ready())
                    text += bufferedReader.readLine() + "\n";
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
        return text;
    }

    /**
     * File validation
     * @param filePath is an absolute path
     * @return true if the file is validated, else @return false

     */
    private boolean fileValidation(String filePath){
        if(filePath.length() == 0) {
            System.out.println("Emtpy file path!");
            fileOk = false;
            return fileOk;
        }
        if(!filePath.endsWith(".txt")){
            System.out.println("Invalid file format!");
            fileOk = false;
            return fileOk;
        }
        fileOk = true;
        return fileOk;

    }

    public boolean isFileOk() {
        return fileOk;
    }
}
