package ml.ledv.textanalyzerbascilv.service;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
 * This class provides methods for analyzing text
 *
 * @author Denis Lesheniuk
 * @version 1.0
 *
 * **/


public class TextAnalizerImpl implements TextAnalyzer {

    private StopWords stopWords;

    public TextAnalizerImpl() {
        this.stopWords = new StopWords();
    }
/**
 * The method counts duplicate words in the text,
 * and return the result in the form of a word usage rating.
 *
 * @param text is an incoming text for analyzing.
 * @return sorted rating List.
 * **/
    @Override
    public List <Map.Entry<String, Integer>> topTenRepeatingWords(String text) {
        String cleaneText = excludeSpecifiedWords(text);
        String[] words = cleaneText.split("[^А-Яа-я+-]+");
        Map<String, Integer> rating = new HashMap<>();
        for(String word: words){
            if(!word.equals("")&&!word.equals("-")) {
               //word = word.toLowerCase();
                if (rating.containsKey(word))
                    rating.put(word, rating.get(word) + 1);
                else rating.put(word, 0);
            }
        }
        List<Map.Entry<String, Integer>> sortedRating = rating.entrySet().stream()
                .sorted((e1, e2) -> -e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());


        return sortedRating;
    }
/**
 * The method used stack to check matching brackets
 * @param  text is an incoming text
 * @return result = correct/incorrect
 *
 * **/
    @Override
    public String bracketChecker(String text) {
        String result = "";
        boolean correctMark = true;
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0 ; i < text.length(); i++){
            correctMark = true;
            Character ch = text.charAt(i);

            switch (ch){
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case '}':
                case ')':
                case ']':
                    if(!stack.isEmpty()){
                        Character chr = stack.pop();
                        if(ch.equals('}') && !chr.equals('{') ||
                                ch.equals(')') && !chr.equals('(') ||
                                ch.equals('[') && !chr.equals(']'))
                                    result = "incorrect";
                                    correctMark = false;

                    }else{
                        result = "incorrect";
                        correctMark = false;
                    }
                    break;
                    default:
                        break;
            }
        }
        if(!stack.isEmpty()){
            result = "incorrect";
            correctMark = false;
        }

        if(correctMark) {
            result = "correct";
        }

        return result;
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
