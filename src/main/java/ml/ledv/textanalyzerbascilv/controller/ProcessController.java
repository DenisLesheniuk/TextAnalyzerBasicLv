package ml.ledv.textanalyzerbascilv.controller;

import ml.ledv.textanalyzerbascilv.service.FileHandler;
import ml.ledv.textanalyzerbascilv.service.FileHandlerImpl;
import ml.ledv.textanalyzerbascilv.service.TextAnalizerImpl;
import ml.ledv.textanalyzerbascilv.service.TextAnalyzer;

import java.util.List;
import java.util.Map;

/**
 *This is class controller that is an intermediary between the service and the view
 *
 * @author Denis Lesheniuk
 * @version 1.0
 **/

public class ProcessController {
    private FileHandler fileHandler;
    private boolean process = false;

    public ProcessController() {
        this.fileHandler = new FileHandlerImpl();
    }
/**
* The method first checks the validity of the path to the file, then performs text analysis.
 * The result is sent to stdout.
* @param path is an absolute path
*
* */
    public void doAnalize(String path){
        if(!fileHandler.fileValidation(path)){
            process = false;
            return;
        }

        System.out.println("Top-10 most common words: \n");
        process = true;
        String text = fileHandler.textExtractor(path);
        TextAnalyzer textAnalyzer = new TextAnalizerImpl();
        List<Map.Entry<String, Integer>> sortedReiting = textAnalyzer.topTenRepeatingWords(text);
        int count = 0;
        for(Map.Entry<String, Integer> word: sortedReiting){
            if(count == 10 && !word.getValue().equals(""))break;
            System.out.println("\t" + (count+1) + ":" + "\t" +  word.getKey());
            count++;
        }
        System.out.println("\n");
       System.out.println("Bracket Checker: " + textAnalyzer.bracketChecker(text));

    }

    public boolean isProcess() {
        return process;
    }
}
