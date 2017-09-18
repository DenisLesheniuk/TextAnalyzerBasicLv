package ml.ledv.textanalyzerbascilv.service;

import java.io.*;

/**
 * Implementation of {@link FileHandler} interface.
 * This class provides methods for file processing and file validation.
 * @author Denis Lesheniuk
 * @version 1.1
 **/
public class FileHandlerImpl implements FileHandler {
    private boolean fileOk = false;

    /**
     * Extracts text from a file.
     *
     * @param filePath is an absolute path
     * @return text in String format
     */
    public String textExtractor(String filePath) {
        String text = "";
        if (fileValidation(filePath)) {
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
     *
     * @param filePath is an absolute path
     * @return true if the file is validated, else @return false
     */
    public boolean fileValidation(String filePath) {
        if (filePath.length() == 0) {
            System.out.println("Упс... Вы забыли ввести путь к файлу...\n");
            fileOk = false;
            return fileOk;
        }
        if (!filePath.endsWith(".txt")) {
            System.out.println("Неверный формат файла!!!\n");
            fileOk = false;
            return fileOk;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Не могу найти данный файл, попробуйте снова!!!\n");
            fileOk = false;
            return fileOk;
        }
        fileOk = true;
        return fileOk;

    }

}
