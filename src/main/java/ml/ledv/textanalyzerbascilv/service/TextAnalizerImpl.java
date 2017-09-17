package ml.ledv.textanalyzerbascilv.service;

import java.util.HashMap;
import java.util.Map;

public class TextAnalizerImpl implements TextAnalyzer {

    @Override
    public String topTenRepeatingWords(String text) {

        String[] words = text.split("[^А-Яа-я+-]+");
        for(String w: words)System.out.println(w);
        Map<String, Integer> reiting = new HashMap<>();
        for(String word: words){
            if(reiting.containsKey(word))
                reiting.put(word,  reiting.get(word) + 1);
                else if(word != null)reiting.put(word, 0);
        }
        return null;
    }

    @Override
    public String BracketChecker(String text) {
        return null;
    }

    public String checkText(String text){

        return null;
    }
}
