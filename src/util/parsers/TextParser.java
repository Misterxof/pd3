package util.parsers;

import java.util.regex.Pattern;

/***
 * TextParser class for parsing text
 */
public class TextParser extends BaseParser {

    /**
     * Constructor for class TextParser
     * @param text
     */
    public TextParser(String text) {
        super(text);
    }

    @Override
    protected Pattern getRegexPattern() {
        /**
         * The method returns regex pattern for text (sentences and code blocks regular regex)
         * @return regex pattern for text
         */
        return Pattern.compile(
                "(<block>(.*?)</block>(\r\n)*)" +
                        "|" +
                        "((.+?)([.!?\\r\\n]+|$))", Pattern.DOTALL);
    }
}
