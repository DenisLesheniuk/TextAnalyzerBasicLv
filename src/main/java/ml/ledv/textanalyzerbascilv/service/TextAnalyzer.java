package ml.ledv.textanalyzerbascilv.service;

import java.util.List;
import java.util.Map;

/**
 * Text parser
 *
 * @author Denis Lesheniuk
 * @version 1.0*/

public interface TextAnalyzer {
    public List<Map.Entry<String, Integer>> topTenRepeatingWords(String text);
    public String  BracketChecker(String text);
}
