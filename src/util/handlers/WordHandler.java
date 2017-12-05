package util.handlers;

import models.StringTokenFactories.BaseFactory;
import models.StringTokenFactories.WordFactory;

import java.util.regex.Pattern;

/***
 * Handler which works only with words
 */

public class WordHandler extends BaseHandler {

    /**
     * The method returns object of type WordFactory
     * @return new WordFactory object
     */
    @Override
    protected BaseFactory getFactory() {
        return new WordFactory();
    }

    /**
     * The method returns regex pattern
     * @return regex pattern
     */
    @Override
    protected Pattern getRegexPattern() {
        return Pattern.compile("([^ \t\\[\\]{}\"'.?!,;:\\-()\\r\\n]+?)\\b");
    }
}
