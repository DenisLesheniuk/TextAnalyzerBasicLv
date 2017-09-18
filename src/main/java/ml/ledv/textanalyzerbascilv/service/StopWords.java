package ml.ledv.textanalyzerbascilv.service;

/**
 * This class provides methods for receiving stop words in the format String.
 *
 * @author Denis Lesheniuk
 * @version 1.0
 * **/
public class StopWords {
    FileHandler fileHandler;

    private String pronouns;
    private String prepositions;
    private String cojunctions;

    public StopWords(){
        this.fileHandler = new FileHandlerImplForResources();
        this.pronouns = fileHandler.textExtractor("pronouns.txt");
        this.prepositions = fileHandler.textExtractor("prepositions.txt");
        this.cojunctions = fileHandler.textExtractor("conjunctions.txt");
    }

    public String getPronouns() {
        return pronouns;
    }

    public String getPrepositions() {
        return prepositions;
    }

    public String getCojunctions() {
        return cojunctions;
    }
}
