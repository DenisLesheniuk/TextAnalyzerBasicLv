package ml.ledv.textanalyzerbascilv.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Implementation of {@link FileHandler} interface.
 * This class provides methods for file processing.
 * Intended to extract text from files in the resources folder.
 *
 * @author Denis Lesheniuk
 * @version 1.1
 **/
public class FileHandlerImplForResources implements FileHandler {

    private boolean fileOk = false;
    /**
     * Extracts text from a file.
     * @param filePath is a relative path.
     * @return text in String format

     */
    public String textExtractor(String filePath) {
        StringBuilder textBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/" + filePath), "UTF-8"))) {
            while (bufferedReader.ready()) {
                textBuilder.append(bufferedReader.readLine()).append("/n");
            }

        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return textBuilder.toString();
    }

    /**
     * File validation
     * @param filePath is a relative path.
     * @return true if the file is validated, else @return false

     */
    public boolean fileValidation(String filePath){
        return fileOk;
    }


}
