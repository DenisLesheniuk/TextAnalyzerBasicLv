package ml.ledv.textanalyzerbascilv.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class TextAnalizerImpl implements TextAnalyzer {

    private StopWords stopWords;

    public TextAnalizerImpl() {
        this.stopWords = new StopWords();
    }

    @Override
    public String topTenRepeatingWords(String text) {
        String cleaneText = excludeSpecifiedWords(text);
        String[] words = cleaneText.split("[^А-Яа-я+-]+");
        Map<String, Integer> reiting = new HashMap<>();
        for(String word: words){
            if(reiting.containsKey(word))
                reiting.put(word,  reiting.get(word) + 1);
                else if(word != null)reiting.put(word, 0);
        }
        System.out.println(reiting);
        return null;
    }

    @Override
    public String BracketChecker(String text) {
        return null;
    }
    /**
     * The method excludes from text a number of predefined words.
     * It depends on {@link StopWords} class, with the help of which, it receives the specified words in the string format.
     *@param text incoming text.
     *@return resultText processed text.
     * **/
    private String excludeSpecifiedWords(String text){
        String conjunctions = stopWords.getCojunctions();
        String prepositions = stopWords.getPrepositions();
        String pronouns = stopWords.getPronouns();

        String allStopWords = conjunctions + "\n" + prepositions + "\n" + pronouns;
        String [] allStopWordsArr = allStopWords.split("[^А-Яа-я+-]+");

        //get rid of duplicates
        Set<String> stopWordsWithoutDuplicates = new HashSet<>();
        for(String stopWord: allStopWordsArr){
            stopWordsWithoutDuplicates.add(stopWord);
        }

        String resultText = text;
        for(String stopWord: stopWordsWithoutDuplicates){
            resultText = Pattern.compile("\\b(" + stopWord + ")\\b", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE).matcher(resultText).replaceAll("");
        }
        return resultText;
    }
}
