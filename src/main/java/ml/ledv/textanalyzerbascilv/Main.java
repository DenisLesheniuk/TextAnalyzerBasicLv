package ml.ledv.textanalyzerbascilv;

import ml.ledv.textanalyzerbascilv.service.FileHandler;
import ml.ledv.textanalyzerbascilv.service.FileHandlerImpl;
import ml.ledv.textanalyzerbascilv.service.TextAnalizerImpl;
import ml.ledv.textanalyzerbascilv.service.TextAnalyzer;

public class Main {
    public static void main(String args []) {
        String path = "F://text2.txt";
        FileHandler fileHandler = new FileHandlerImpl();
        TextAnalyzer textAnalyzer = new TextAnalizerImpl();

        String text = fileHandler.textExtractor(path);
        System.out.println(textAnalyzer.topTenRepeatingWords(text));
    }
}
