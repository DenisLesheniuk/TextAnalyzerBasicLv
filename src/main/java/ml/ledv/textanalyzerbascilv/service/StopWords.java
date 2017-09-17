package ml.ledv.textanalyzerbascilv.service;

public class StopWords {
    FileHandler fileHandler;

    private String pronouns;
    private String prepositions;
    private String cojunctions;

    public StopWords(){
        this.fileHandler = new FileHandlerImpl();
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
