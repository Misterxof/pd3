package util.parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Base class for parsers
 */
public abstract class BaseParser {
    protected Matcher textMatcher;
    protected final Pattern regexPattern = getRegexPattern();

    /**
     * The method returns regex pattern
     * @return regex pattern
     */
    protected abstract Pattern getRegexPattern();

    public BaseParser(){
        this("");
    }

    /**
     * Constructor for BaseParser class
     * @param text
     */
    public BaseParser(String text) {
        String filteredText = text.replaceAll("[ \t]+", " ");
        this.textMatcher = regexPattern.matcher(filteredText);
    }

    /**
     *  The method find the next subsequence of the input sequence that matches the pattern.
     * @return the next subsequence or null
     */
    public String findNext() {
        return textMatcher.find() ? textMatcher.group(0) : null;
    }
}
