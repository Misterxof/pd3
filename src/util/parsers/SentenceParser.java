package util.parsers;

import java.util.regex.Pattern;

/**
 * Class for parsing sentences
 */
public class SentenceParser extends BaseParser {

    /**
     * Constructor for class SentenceParser
     * @param text
     */
    public SentenceParser(String text) {
        super(text);
    }

    /**
     * The method returns regex pattern for sentence (words, signs)
     * @return regex pattern for sentence (words and signs)
     */
    @Override
    protected Pattern getRegexPattern() {
        return Pattern.compile("([ \t()\\[\\]{}\"'.?!,;:\\-()\\r\\n])" +
                "|" +
                "(([^ \t\\[\\]{}\"'.?!,;:\\-()\\r\\n]+?)\\b)");
    }
}
