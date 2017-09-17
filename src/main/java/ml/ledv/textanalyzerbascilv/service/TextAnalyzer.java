package ml.ledv.textanalyzerbascilv.service;
/**
 * Text parser
 *
 * @author Denis Lesheniuk
 * @version 1.0*/

public interface TextAnalyzer {
    public String topTenRepeatingWords(String text);
    public String  BracketChecker(String text);
    public String checkText(String text);
}
