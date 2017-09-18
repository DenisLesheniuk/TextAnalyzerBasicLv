package ml.ledv.textanalyzerbascilv.service;

/**
 * Simple File Handler
 *
 * @author Denis Lesheniuk
 * @version 1.1
 **/
public interface FileHandler {
    public String textExtractor(String filePath);
    public boolean isFileOk();
    public boolean fileValidation(String filePath);
};
