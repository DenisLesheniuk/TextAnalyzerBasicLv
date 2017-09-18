package ml.ledv.textanalyzerbascilv.service;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextAnalizerImpl implements TextAnalyzer {

    private StopWords stopWords;

    public TextAnalizerImpl() {
        this.stopWords = new StopWords();
    }

    @Override
    public List <Map.Entry<String, Integer>> topTenRepeatingWords(String text) {
        String cleaneText = excludeSpecifiedWords(text);
        String[] words = cleaneText.split("[^А-Яа-я+-]+");
        Map<String, Integer> reiting = new HashMap<>();
        for(String word: words){
            if(!word.equals("")&&!word.equals("-")) {
               //word = word.toLowerCase();
                if (reiting.containsKey(word))
                    reiting.put(word, reiting.get(word) + 1);
                else reiting.put(word, 0);
            }
        }
        List<Map.Entry<String, Integer>> sortedReiting = reiting.entrySet().stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());


        return sortedReiting;
    }

    @Override
    public String bracketChecker(String text) {
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
